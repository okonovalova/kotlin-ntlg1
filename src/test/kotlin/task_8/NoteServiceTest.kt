package task_8

import org.junit.Test

import org.junit.Assert.*
import task_8.exceptions.NoteCommentNotFoundException
import task_8.exceptions.NoteNotFoundException

class NoteServiceTest {

    @Test
    fun add() {
        NoteService.notes.clear()
        val expectedResult = 1
        NoteService.add("note1", "noteText", 1, 1, "privacyView", "privacyComment")
        val actualResult = NoteService.notes.size
        assertEquals(actualResult, expectedResult)
    }

    @Test
    fun createComment() {
        NoteService.notes.clear()
        NoteService.noteComments.clear()
        val expectedResult = 1
        val addedNoteId = NoteService.add("note1", "noteText", 1, 1, "privacyView", "privacyComment")
        NoteService.createComment(addedNoteId, 1, 1, "message", "guid")
        val actualResult = NoteService.noteComments.size
        assertEquals(actualResult, expectedResult)
    }

    @Test
    fun deleteSuccessful() {
        NoteService.notes.clear()
        val expectedResult = 0
        val addedNoteId = NoteService.add("note1", "noteText", 1, 1, "privacyView", "privacyComment")
        NoteService.delete(addedNoteId)
        val actualResult = NoteService.notes.size
        assertEquals(actualResult, expectedResult)
    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteUnsuccessful() {
        NoteService.notes.clear()
        val expectedResult = 0
        val addedNoteId = NoteService.add("note1", "noteText", 1, 1, "privacyView", "privacyComment")
        NoteService.delete(addedNoteId + 1)
        val actualResult = NoteService.notes.size
        assertEquals(actualResult, expectedResult)
    }

    @Test
    fun deleteCommentSuccessful() {
        NoteService.notes.clear()
        NoteService.noteComments.clear()
        val expectedResult = 1
        val ownerId = 1
        val addedNoteId = NoteService.add("note1", "noteText", 1, 1, "privacyView", "privacyComment")
        val addedCommentId = NoteService.createComment(addedNoteId, ownerId, 1, "message", "guid")
        val actualResult = NoteService.deleteComment(addedCommentId, ownerId)
        assertEquals(actualResult, expectedResult)
    }

    @Test(expected = NoteCommentNotFoundException::class)
    fun deleteCommentUnsuccessful() {
        NoteService.notes.clear()
        NoteService.noteComments.clear()
        val expectedResult = 1
        val ownerId = 1
        val addedNoteId = NoteService.add("note1", "noteText", 1, 1, "privacyView", "privacyComment")
        val addedCommentId = NoteService.createComment(addedNoteId, ownerId, 1, "message", "guid")
        val actualResult = NoteService.deleteComment(addedCommentId + 1, ownerId)
        assertEquals(actualResult, expectedResult)
    }

    @Test
    fun editSuccessful() {
        NoteService.notes.clear()
        val privacy = 1
        val commentPrivacy = 1
        val privacyView = "privacyView"
        val privacyComment = "privacyComment"
        val addedNoteId = NoteService.add("note1", "noteText", privacy, commentPrivacy, privacyView, privacyComment)

        val expectedResult = 1
        val actualResult =
            NoteService.edit(addedNoteId, "newTitle", "newText", privacy, commentPrivacy, privacyView, privacyComment)
        assertEquals(actualResult, expectedResult)
    }

    @Test(expected = NoteNotFoundException::class)
    fun editUnsuccessful() {
        NoteService.notes.clear()
        val privacy = 1
        val commentPrivacy = 1
        val privacyView = "privacyView"
        val privacyComment = "privacyComment"
        val addedNoteId = NoteService.add("note1", "noteText", privacy, commentPrivacy, privacyView, privacyComment)

        val expectedResult = 1
        val actualResult = NoteService.edit(
            addedNoteId + 1,
            "newTitle",
            "newText",
            privacy,
            commentPrivacy,
            privacyView,
            privacyComment
        )
        assertEquals(actualResult, expectedResult)
    }

    @Test
    fun editCommentSuccessful() {
        NoteService.notes.clear()
        NoteService.noteComments.clear()
        val ownerId = 1

        val expectedResult = 1

        val addedNoteId = NoteService.add("note1", "noteText", 1, 1, "privacyView", "privacyComment")
        val addedCommentId = NoteService.createComment(addedNoteId, ownerId, 1, "message", "guid")
        val actualResult = NoteService.editComment(addedCommentId, ownerId, "newMesssage")

        assertEquals(actualResult, expectedResult)
    }

    @Test(expected = NoteCommentNotFoundException::class)
    fun editCommentUnsuccessful() {
        NoteService.notes.clear()
        NoteService.noteComments.clear()
        val ownerId = 1

        val expectedResult = 1

        val addedNoteId = NoteService.add("note1", "noteText", 1, 1, "privacyView", "privacyComment")
        val addedCommentId = NoteService.createComment(addedNoteId, ownerId, 1, "message", "guid")
        val actualResult = NoteService.editComment(addedCommentId + 1, ownerId, "newMesssage")

        assertEquals(actualResult, expectedResult)
    }

    @Test
    fun getNote() {
        NoteService.notes.clear()
        val expectedResult = 2
        NoteService.add("note1", "noteText", 1, 1, "privacyView", "privacyComment")
        NoteService.add("note2", "noteText", 1, 1, "privacyView", "privacyComment")
        val notes = NoteService.getNote("111", 0, 1, 1, 1)
        val actualResult = notes.size
        assertEquals(actualResult, expectedResult)
    }

    @Test
    fun getByIdSuccessful() {
        NoteService.notes.clear()
        val addedNoteId = NoteService.add("note1", "noteText", 1, 1, "privacyView", "privacyComment")
        val expectedResult = NoteService.notes.find { it.id == addedNoteId }
        val actualResult = NoteService.getById(addedNoteId, 0)
        assertEquals(actualResult, expectedResult)
    }

    @Test(expected = NoteNotFoundException::class)
    fun getByIdUnsuccessful() {
        NoteService.notes.clear()
        val addedNoteId = NoteService.add("note1", "noteText", 1, 1, "privacyView", "privacyComment")
        val expectedResult = NoteService.notes.find { it.id == addedNoteId }
        val actualResult = NoteService.getById(addedNoteId + 1, 0)
        assertEquals(actualResult, expectedResult)
    }

    @Test
    fun getCommentsSuccessful() {
        NoteService.notes.clear()
        NoteService.noteComments.clear()
        val ownerId = 1

        val expectedResult = 2

        val addedNoteId1 = NoteService.add("note1", "noteText1", 1, 1, "privacyView", "privacyComment")
        val addedNoteId2 = NoteService.add("note2", "noteText2", 1, 1, "privacyView", "privacyComment")
        NoteService.createComment(addedNoteId1, ownerId, 1, "message1", "guid")
        NoteService.createComment(addedNoteId2, ownerId, 1, "message2", "guid")
        NoteService.createComment(addedNoteId2, ownerId, 1, "message3", "guid")
        val commentsToNote2 = NoteService.getComments(addedNoteId2, ownerId, 1, 1, 1)

        val actualResult = commentsToNote2.size

        assertEquals(actualResult, expectedResult)
    }

    @Test(expected = NoteNotFoundException::class)
    fun getCommentsUnsuccessful() {
        NoteService.notes.clear()
        NoteService.noteComments.clear()
        val ownerId = 1

        val expectedResult = 2

        val addedNoteId1 = NoteService.add("note1", "noteText1", 1, 1, "privacyView", "privacyComment")
        val addedNoteId2 = NoteService.add("note2", "noteText2", 1, 1, "privacyView", "privacyComment")
        NoteService.createComment(addedNoteId1, ownerId, 1, "message1", "guid")
        NoteService.createComment(addedNoteId2, ownerId, 1, "message2", "guid")
        NoteService.createComment(addedNoteId2, ownerId, 1, "message3", "guid")
        val commentsToNote2 = NoteService.getComments(addedNoteId2 + 1, ownerId, 1, 1, 1)

        val actualResult = commentsToNote2.size

        assertEquals(actualResult, expectedResult)
    }

    @Test
    fun restoreCommentSuccessful() {
        NoteService.notes.clear()
        NoteService.noteComments.clear()
        val ownerId = 1
        val expectedResult = 1

        val addedNoteId = NoteService.add("note1", "noteText1", 1, 1, "privacyView", "privacyComment")

        val noteCommentId = NoteService.createComment(addedNoteId, ownerId, 1, "message3", "guid")
        NoteService.deleteComment(noteCommentId, ownerId)

        val actualResult = NoteService.restoreComment(noteCommentId, ownerId)

        assertEquals(actualResult, expectedResult)
    }

    @Test(expected = NoteCommentNotFoundException::class)
    fun restoreCommentUnsuccessful() {
        NoteService.notes.clear()
        NoteService.noteComments.clear()
        val ownerId = 1
        val expectedResult = 1

        val addedNoteId = NoteService.add("note1", "noteText1", 1, 1, "privacyView", "privacyComment")

        val noteCommentId = NoteService.createComment(addedNoteId, ownerId, 1, "message3", "guid")
        NoteService.deleteComment(noteCommentId, ownerId)

        val actualResult = NoteService.restoreComment(noteCommentId + 1, ownerId)

        assertEquals(actualResult, expectedResult)
    }
}