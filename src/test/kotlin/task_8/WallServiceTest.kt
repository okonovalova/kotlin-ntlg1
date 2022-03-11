package task_8

import org.junit.Test

import org.junit.Assert.*
import task_8.exceptions.PostNotFoundException
import task_8.models.*

class WallServiceTest {

    @Test
    fun add() {
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
            attachments = null,
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
        val addedPost = WallService.add(post)
        assertNotEquals(post.id, addedPost.id)
    }

    @Test
    fun updateSuccessful() {
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
        val addedPost = WallService.add(post)
        assertTrue(WallService.update(addedPost))
    }

    @Test
    fun updateUnsuccessful() {
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
        assertFalse(WallService.update(post))
    }

    @Test
    fun createCommentSuccessful() {
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
        val comment = PostComment(1,1,1,1644747109,"Some text",null,null)
        val expectedResult = WallService.comments.size + 1
        WallService.createComment(comment)
        val actualResult = WallService.comments.size

        assertEquals(expectedResult,actualResult)
    }

    @Test (expected = PostNotFoundException::class)
    fun createCommentUnsuccessful() {
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

        val comment = PostComment(2,0,1,1644747109,"Some text",null,null)

        WallService.createComment(comment)
    }
}