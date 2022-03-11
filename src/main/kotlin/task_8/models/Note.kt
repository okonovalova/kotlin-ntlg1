package task_8.models

data class Note (
        //Идентификатор заметки
        val id: Int,
        //Идентификатор владельца заметки
        val ownerId: Int,
        //Заголовок заметки
        val title: String,
        //Текст заметки.
        val text: String,
        //Дата создания заметки в формате Unixtime.
        val date: Int,
        //Количество комментариев.
        val comments: Int,
        //Количество прочитанных комментариев (только при запросе информации о заметке текущего пользователя).
        val readComments: Int,
        //URL страницы для отображения заметки.
        val viewUrl: String,
        //Настройки приватности комментирования заметки
        val privacyView: String,
        //Есть ли возможность оставлять комментарии
        val canComment: Boolean,
        //Тэги ссылок на wiki
        val textWiki: String,
        //уровень доступа к заметке (0 — все пользователи, 1 — только друзья, 2 — друзья и друзья друзей, 3 — только пользователь);
        val privacy: Int,
        //уровень доступа к комментированию заметки (0 — все пользователи, 1 — только друзья, 2 — друзья и друзья друзей, 3 — только пользователь);
        val commentPrivacy: Int,
)