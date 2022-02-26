package task_5_2.models

data class Reposts(
    //число пользователей, скопировавших запись;
    val count: Int,
    //наличие репоста от текущего пользователя (1 — есть, 0 — нет).
    val userReposted: Boolean
)