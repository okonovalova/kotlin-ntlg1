package task_8.models

class VideoAttachment(
    override val id: Int,
    override val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val date: Int
) : Attachment(id, ownerId) {
    override val type: AttachmentType = AttachmentType.VIDEO
}