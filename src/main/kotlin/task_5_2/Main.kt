package task_5_2

import task_5_2.models.*

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
    val post1 = Post(
        0,
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

   val post2 : Post = WallService.add(post1)
    if (WallService.update(post2)) println("true") else println("false")


}
