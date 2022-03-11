package task_8.models

class AudioAttachment (
    override val id: Int,
    override val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String
) : Attachment(id, ownerId) {
    override val type: AttachmentType = AttachmentType.AUDIO
}