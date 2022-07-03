package ns.thkmmproject

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import ns.thkmmproject.model.SectionModel


class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }

    private val client = HttpClient()

    //testing
    suspend fun getHtml(): String {
        //val response = client.get("https://fakestoreapi.com/products/categories")
        //val response = client.get("https://fakestoreapi.com/carts")
        val response = client.get("http://192.168.12.169/projects/Hindu/mvp/project-root/public/api/sections")
        return response.bodyAsText()
    }

    //articles
    suspend fun getHomeArticles(): String {
       // val response = client.request("http://192.168.12.169/projects/Hindu/mvp/project-root/public/api/articles")
       // return response.bodyAsText()


        val response: HttpResponse = client.request("http://192.168.12.169/projects/Hindu/mvp/project-root/public/api/articles") {
            method = HttpMethod.Get
        }
        if (response.status.value in 200..299) {
            println("Successful response!")

        }
        return response.toString()
    }


    suspend fun getSectionList(): SectionModel {
        val section: SectionModel = client.get("http://192.168.12.169/projects/Hindu/mvp/project-root/public/api/sections").body()
        return section
    }

//    suspend fun getArticlesList(): ArticleData {
//        val articles = client.get("http://192.168.12.169/projects/Hindu/mvp/project-root/public/api/articles").body<ArticleData>()
//        println("First name: '${articles.articles[0].article_id}', last name: '${articles.articles[0].img_url}'")
//        return articles
//    }

}