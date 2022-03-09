package task_7.exceptions.models

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