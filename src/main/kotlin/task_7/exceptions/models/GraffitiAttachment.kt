package task_7.exceptions.models

class GraffitiAttachment (
    override val id: Int,
    override val ownerId: Int,
    val url: String,
    val width: Int,
    val height: Int
) : Attachment(id, ownerId) {
    override val type: AttachmentType = AttachmentType.GRAFFITI
}