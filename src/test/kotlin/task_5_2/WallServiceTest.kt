package task_5_2

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import task_5_2.models.*

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
        assertFalse(WallService.update(post))
    }
}