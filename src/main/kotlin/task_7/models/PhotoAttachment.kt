package task_7.models

class PhotoAttachment(
    override val id: Int,
    override val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val width: Int,
    val height: Int,
) : Attachment(id, ownerId) {
    override val type: AttachmentType = AttachmentType.PHOTO
}