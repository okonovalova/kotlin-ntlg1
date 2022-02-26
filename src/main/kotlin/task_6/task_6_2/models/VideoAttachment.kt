package task_6.task_6_2.models

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