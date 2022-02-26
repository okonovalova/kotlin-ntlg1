package task_6.task_6_1.models

data class Donut(
    //запись доступна только платным подписчикам VK Donut;
    val isDonut: Boolean,
    //время, в течение которого запись будет доступна только платным подписчикам VK Donut;
    val paidDuration: Int,
    //заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи.
    val placeholder: String,
    //можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut;
    val canPublishFreeCopy: Boolean,
    //edit_mode (string) — информация о том, какие значения VK Donut можно изменить в записи. Возможные значения:
    //all — всю информацию о VK Donut.
    //duration — время, в течение которого запись будет доступна только платным подписчикам VK Donut.
    val editMode: EditMode
)

enum class EditMode {
    ALL,
    DURATION
}