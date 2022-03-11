package task_8.models

data class NoteComment (
    //идентификатор комментария
    val id: Int,
    //идентификатор автора комментария;
    val uid: Int,
    //идентификатор заметки
    val nid: Int,
    //идентификатор владельца заметки
    val oid: Int,
    //дата добавления комментария в формате unixtime
    val date: Int,
    //текст комментария
    val message: String,
    //идентификатор пользователя, в ответ на комментарий которого был оставлен текущий комментарий (если доступно).
    val replyTo: Int,
    val isDelete: Boolean
    )