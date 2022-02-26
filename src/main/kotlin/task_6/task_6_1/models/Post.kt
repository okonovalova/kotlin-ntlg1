package task_6.task_6_1.models

data class Post(
    //Идентификатор записи
    val id: Int,
    //Идентификатор владельца стены, на которой размещена запись
    val ownerId: Int,
    //Идентификатор автора записи (от чьего имени опубликована запись).
    val fromId: Int,
    //Идентификатор администратора, который опубликовал запись
    //(возвращается только для сообществ при запросе с ключом доступа администратора).
    //Возвращается в записях, опубликованных менее 24 часов назад.
    val createdBy: Int,
    //Время публикации записи в формате unixtime.
    val date: Int,
    //Текст записи.
    val text: String,
    //Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val replyOwnerId: Int,
    //Идентификатор записи, в ответ на которую была оставлена текущая.
    val replyPostId: Int,
    //1, если запись была создана с опцией «Только для друзей»
    val friendsOnly: Boolean,
    //Информация о комментариях к записи
    val comments: Comments?,
    //Источник материала
    val copyright: Copyright?,
    //Информация о лайках к записи
    val likes: Likes?,
    //Информация о репостах записи («Рассказать друзьям»)
    val reposts: Reposts?,
    //Информация о просмотрах записи. Объект с единственным полем:
    val views: Views?,
    //Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val postType: PostType,
    //Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
    val singerId: Int,
    //Информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может).
    val canPin: Boolean,
    //Информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может).
    val canDelete: Boolean,
    //Информация о том, может ли текущий пользователь редактировать запись (1 — может, 0 — не может).
    val canEdit: Boolean,
    //Информация о том, что запись закреплена.
    val isPinned: Boolean,
    //Информация о том, содержит ли запись отметку «реклама» (1 — да, 0 — нет).
    val markedAsAds: Boolean,
    //true, если объект добавлен в закладки у текущего пользователя.
    val is_favorite: Boolean,
    //Информация о записи VK Donut:
    val donut: Donut?,
    //Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
    val postponedId: Int
)

enum class PostType {
    POST,
    COPY,
    REPLY,
    POSTPONE,
    SUGGEST
}