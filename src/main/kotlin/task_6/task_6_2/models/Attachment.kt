package task_6.task_6_2.models

abstract class Attachment(
    open val id: Int,
    open val ownerId: Int
) {
    abstract val type: AttachmentType
}

sealed class AttachmentType() {
    object VIDEO : AttachmentType()
    object PHOTO : AttachmentType()
    object AUDIO : AttachmentType()
    object GRAFFITI : AttachmentType()
    object LINK : AttachmentType()
}