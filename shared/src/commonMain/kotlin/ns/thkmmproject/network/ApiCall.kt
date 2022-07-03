package ns.thkmmproject.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.*
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.json.Json
import ns.thkmmproject.model.*
import ns.thkmmproject.util.Constants


class ApiCall {
    private val client = HttpClient()

    suspend fun getList(): String {
        val response =
            client.request("http://192.168.12.169/projects/Hindu/mvp/project-root/public/api/sections")
        return response.bodyAsText()
    }

    /**
     * Section API call
     */
    suspend fun getSectionModel(): SectionModel {
        val sectionModels: SectionModel
        coroutineScope {
            val client = HttpClient() {
                install(ContentNegotiation) {
                    json(Json {
                        prettyPrint = true
                        isLenient = true
                    })
                }
            }
            sectionModels =
                client.get("http://192.168.12.169/projects/Hindu/mvp/project-root/public/api/sections")
                    .body()
            println("$sectionModels")
        }
        return sectionModels
    }

    /**
     * Article API call
     */
    @OptIn(InternalAPI::class)
    suspend fun getArticleModel(sectionId: String?,propertyId: String?): MutableList<SectionListItem> {
        var recyclerItemList = mutableListOf<SectionListItem>()

        var requestBody = ""
        var isHomePageRequest = false;

        // This If condition is for Other sections apart of Home.
        // In Home Request Body is not required, so based on that we are distinguishing
        if(!sectionId.isNullOrEmpty() || !propertyId.isNullOrEmpty()) {
            requestBody = "{\n" +
                    "    \"section_id\": $sectionId,\n" +
                    "    \"article_id\": false,\n" +
                    "    \"property_id\" :\"$propertyId\"\n" +
                    "}"
            isHomePageRequest = false;
        } else {
            isHomePageRequest = true
        }


        val articleModel: ArticleModel

        coroutineScope {
            val client = HttpClient() {
                install(ContentNegotiation) {
                    json(Json {
                        prettyPrint = true
                        isLenient = true
                    })
                }
            }

            articleModel =
                client.post("http://192.168.12.169/projects/Hindu/mvp/project-root/public/api/articles") {
                    body = requestBody
                }.body()
            println("$articleModel")

            // To add search view on first or [0] index
            // This is only required in HomePage
            if(isHomePageRequest) {
                recyclerItemList.add(SectionListItem(Constants.VIEW_TYPE_SEARCH))
                recyclerItemList.add(SectionListItem(Constants.VIEW_TYPE_ADS))
                recyclerItemList.add(SectionListItem(Constants.VIEW_TYPE_WIDGETS_HORIZONTAL))
                recyclerItemList.add(SectionListItem(Constants.VIEW_TYPE_WIDGETS_VERTICAL))
                recyclerItemList.add(SectionListItem(Constants.VIEW_TYPE_SUBSECTION))
            }

            // Adding other listing items and assigning their respective ViewTYPE
            articleModel.data.forEachIndexed { index, item ->
                println("index = $index, item = $item ")
                var viewType = -1;
                if (index == 0 && isHomePageRequest) {
                    viewType = Constants.VIEW_TYPE_HOME_TOP_BANNER
                } else {
                    viewType = Constants.VIEW_TYPE_ARTICLE_LIST
                }

                val listItem = SectionListItem(viewType);
                listItem.singleRowItem = item
                recyclerItemList.add(listItem)
            }

        }
        return recyclerItemList
    }

    /**
     * Article API call
     */
    @OptIn(InternalAPI::class)
    suspend fun getWidgetArticleModel(sectionId: String?,propertyId: String?): WidgetsModel {

        val requestBody = "{\n" +
                    "    \"section_id\": false,\n" +
                    "    \"article_id\": false,\n" +
                    "    \"property_id\" :\"$propertyId\"\n" +
                    "}"

        val widgetsModel: WidgetsModel
        coroutineScope {
            val client = HttpClient() {
                install(ContentNegotiation) {
                    json(Json {
                        prettyPrint = true
                        isLenient = true
                    })
                }
            }

            widgetsModel =
                client.post("http://192.168.12.169/projects/Hindu/mvp/project-root/public/api/articles") {
                    body = requestBody
                }.body()
            println("$widgetsModel")

        }
        return widgetsModel
    }

    @OptIn(InternalAPI::class)
    suspend fun getArticlePage1(num:String) : ArticleModel {


        val requestBody ="{\n" +
                "    \"section_id\": false,\n" +
                "    \"article_id\": false,\n" +
                "    \"property_id\" :\"$num\"\n" +
                "}"
        val articleModels : ArticleModel
        coroutineScope {
            val client = HttpClient() {
                install(ContentNegotiation) {
                    json(Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    })
                }
            }
            articleModels = client.post{
                url("http://192.168.12.169/projects/Hindu/mvp/project-root/public/api/articles")
                body = requestBody
            }.body()
            println("$articleModels")
        }
        return articleModels
    }

}