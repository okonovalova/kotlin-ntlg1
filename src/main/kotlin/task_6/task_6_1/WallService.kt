package task_6.task_6_1

import task_5_2.WallService
import task_6.task_6_1.models.*
import kotlin.random.Random

object WallService {
    private var posts = emptyArray<Post>()
    private var nextId: Int = 1
        get() = field++

    fun add(post: Post): Post {
        posts += post.copy(id = task_6.task_6_1.WallService.nextId)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val searchResult: Post? = posts.find { it.id == post.id }
        if (searchResult != null) {
            val newPost = post.copy(
                text = "Update text",
                replyPostId = Random.nextInt(),
                friendsOnly = false,
                comments = Comments(
                    3,
                    true,
                    true,
                    true,
                    true
                ),
                copyright = Copyright(
                    86,
                    "Copyright_link",
                    "Copyright_name",
                    "Copyright_type"
                ),
                likes = Likes(
                    6,
                    true,
                    true,
                    true
                ),
                reposts = Reposts(
                    3,
                    true
                ),
                views = Views(6),
                postType = PostType.POST,
                singerId = Random.nextInt(),
                canPin = false,
                canDelete = false,
                canEdit = false,
                isPinned = false,
                markedAsAds = false,
                is_favorite = false,
                donut = Donut(
                    true,
                    15,
                    "text",
                    true,
                    EditMode.ALL
                ),
                postponedId = Random.nextInt()
            )
            val searchIndex: Int = posts.indexOf(searchResult)
            posts[searchIndex] = newPost
            return true
        } else {
            return false
        }
    }
}