package task_7.models

data class CommentsInfo(
    //количество комментариев;
    val count: Int,
    //информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может);
    val canPost: Boolean,
    // информация о том, могут ли сообщества комментировать запись;
    val groupsCanPost: Boolean,
    //может ли текущий пользователь закрыть комментарии к записи;
    val canClose: Boolean,
    //может ли текущий пользователь открыть комментарии к записи.
    val canOpen: Boolean
)