package ns.thkmmproject.model
import kotlinx.serialization.Serializable
import ns.thkmmproject.util.Constants

@Serializable
data class WidgetsModel (
	val status: Boolean?,
	val data: MutableList<ArticleItemWidgets>
)

@Serializable
data class ArticleItemWidgets (
	//viewtype for vertical & Horizontal widgets
	var viewType: Int = Constants.VIEW_TYPE_WIDGETS_VERTICAL,

	val article_id: String?,
	val property: String?,
	val premium: String?,
	val img_url: String?,
	val location: String?,
	val title: String?,
	val section: String?,
	val created_at: String?,
	val description: String?,
	val section_id: String?
)

