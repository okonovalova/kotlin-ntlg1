package task_5_1

import task_5_1.models.*

fun main(){
    val post = Post(
        1,
        2,
        3,
        4,
        1644747109,
        "text",
        5,
        6,
        true,
        Comments(
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
}
