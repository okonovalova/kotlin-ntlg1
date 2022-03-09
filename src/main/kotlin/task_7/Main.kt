package task_7

import task_7.models.*

fun main(){
    val post = Post(
        0,
        2,
        3,
        4,
        1644747109,
        "text",
        5,
        6,
        true,
        CommentsInfo(
            3,
            true,
            true,
            true,
            true
        ),
        Copyright(
            85,
            "Copyright_link",
            "Copyright_name",
            "Copyright_type"
        ),
        Likes(
            5,
            true,
            true,
            true
        ),
        Reposts(
            2,
            true
        ),
        Views(5),
        PostType.POST,
        listOf(VideoAttachment(1,1,"название", "описание", 12, 1010000101)),
        6,
        true,
        true,
        true,
        true,
        true,
        true,

        Donut(
            true,
            15,
            "text",
            true,
            EditMode.ALL),
        15
    )
    WallService.add(post)

    val comment = Comment(2,3,1,1644747109,"Some text",null,null)

    WallService.createComment(comment)
}
