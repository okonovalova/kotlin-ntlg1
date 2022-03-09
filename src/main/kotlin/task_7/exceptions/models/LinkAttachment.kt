package task_7.exceptions.models

class LinkAttachment (
    override val id: Int,
    override val ownerId: Int,
    val url: String,
    val title: String,
    val caption: String,
    val description: String
) : Attachment(id, ownerId) {
    override val type: AttachmentType = AttachmentType.LINK
}