package ns.thkmmproject.model
import kotlinx.serialization.Serializable

@Serializable
data class SectionModel(
    val status : Boolean,
    val data : ArrayList<Databean>
)

@Serializable
data class Databean (
    var section_id: String,
    var name : String,
    var sub_sections : ArrayList<SubDataBean>
)

@Serializable
data class SubDataBean (
    val section_id: String,
    val name : String
)
