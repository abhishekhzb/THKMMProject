package ns.thkmmproject.model

class SectionListItem constructor(viewType: Int) {
    val viewType: Int
    lateinit var singleRowItem : ArticleItem
    lateinit var widgetsModel: WidgetsModel


    init {
        this.viewType = viewType
    }
}

