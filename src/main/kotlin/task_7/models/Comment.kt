package task_7.models

data class Comment (
    //идентификтатор комментария
    val id: Int,
    //идентификатор поста, к которому прикреплен комментарий
    val postId: Int,
    //индентификтаор автора комментария
    val fromId: Int,
    //Дата создания комментария в формате Unixtime
    val date: Int,
    //Текст комментария
    val text: String,
    //Информация о VK Donut.
    val donut: Donut?,
    //медиавложения
    val attachments: List<Attachment>?

)