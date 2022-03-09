package task_7

import task_7.exceptions.PostNotFoundException
import task_7.models.*
import kotlin.random.Random

object WallService {
    private var posts = emptyArray<Post>()
    var comments = emptyArray<Comment>()
        private set

    private var nextPostId: Int = 1
        get() = field++
    private var nextCommentId: Int = 1
        get() = field++

    fun add(post: Post): Post {
        posts += post.copy(id = WallService.nextPostId)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val searchResult: Post? = posts.find { it.id == post.id }
        if (searchResult != null) {
            val newPost = post.copy(
                text = "Update text",
                replyPostId = Random.nextInt(),
                friendsOnly = false,
                commentsInfo = CommentsInfo(
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
                attachments = mutableListOf<Attachment>().apply {
                    post.attachments?.let { this.addAll(it) }
                    this.add(VideoAttachment(2, 1, "название1", "описание1", 12, 1010000101))
                },
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
            val searchIndex: Int = WallService.posts.indexOf(searchResult)
            WallService.posts[searchIndex] = newPost
            return true
        } else {
            return false
        }
    }

    fun createComment(comment: Comment) {
        posts.find { it.id == comment.postId } ?: throw PostNotFoundException("no post with id")
        comments += comment.copy(id = WallService.nextCommentId)
    }
}