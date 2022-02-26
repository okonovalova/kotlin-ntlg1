package task_6.task_6_2.models

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