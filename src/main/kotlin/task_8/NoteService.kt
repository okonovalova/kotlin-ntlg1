package task_8

import task_8.exceptions.NoteCommentNotFoundException
import task_8.exceptions.NoteNotFoundException
import task_8.models.Note
import task_8.models.NoteComment

object NoteService {
    var notes = mutableListOf<Note>()
        private set
    var noteComments = mutableListOf<NoteComment>()
        private set

    private var nextNoteId: Int = 1
        get() = field++

    private var nextNoteCommentId: Int = 1
        get() = field++

    /**Создает новую заметку у текущего пользователя.
     * @param title  Заголовок заметки.
     * @param text  Текст заметки.
     * @param privacy Уровень доступа к заметке.
     *
     *           Возможные значения:
     *          • 0 — все пользователи,
     *          • 1 — только друзья,
     *          • 2 — друзья и друзья друзей,
     *          • 3 — только пользователь.
     * @param commentPrivacy Уровень доступа к комментированию заметки.
     *
     *          Возможные значения:
     *          • 0 — все пользователи,
     *          • 1 — только друзья,
     *          • 2 — друзья и друзья друзей,
     *          • 3 — только пользователь.
     * @param privacyView Настройки приватности просмотра заметки в специальном формате.
     * @param privacyComment Настройки приватности комментирования заметки в специальном формате.
     * @return После успешного выполнения возвращает идентификатор созданной заметки (nid).
     */
    fun add(
        title: String,
        text: String,
        privacy: Int,
        commentPrivacy: Int,
        privacyView: String,
        privacyComment: String
    ): Int {
        val note = Note(
            nextNoteId,
            0,
            title,
            text,
            12312313,
            0,
            1,
            "fsdfsdf",
            privacyView,
            true,
            "dsfsdfds",
            privacy,
            commentPrivacy
        )
        notes.add(note)
        return notes.last().id
    }

    /**Добавляет новый комментарий к заметке.
     * @param noteId Идентификатор заметки.
     * @param ownerId Идентификатор владельца заметки.
     * @param replyTo Идентификатор пользователя, ответом на комментарий которого является добавляемый комментарий
     * (не передаётся, если комментарий не является ответом).
     * @param message Текст комментария.
     * @param guid Уникальный идентификатор, предназначенный для предотвращения повторной отправки одинакового
     * комментария.
     * @return После успешного выполнения возвращает идентификатор созданного комментария (cid).
     */
    fun createComment(noteId: Int, ownerId: Int, replyTo: Int, message: String, guid: String): Int {
        val noteComment = NoteComment(
            nextNoteCommentId,
            0,
            noteId,
            ownerId,
            12312132,
            message,
            replyTo,
            false
        )
        noteComments.add(noteComment)
        return noteComments.last().id
    }

    /**Удаляет заметку текущего пользователя. Также удаляет все комментарии удаляемой заметки
     * @param noteId Идентификатор заметки.
     * @return После успешного выполнения возвращает 1.
     */
    fun delete(noteId: Int): Int {
        val note: Note = notes.find { it.id == noteId } ?: throw NoteNotFoundException("no note with id")
        notes.remove(note)
        noteComments.forEach { if (it.nid == noteId) noteComments.remove(it) }
        return 1
    }

    /**Удаляет комментарий к заметке.
     * @param commentId Идентификатор комментария.
     * @param ownerId Идентификатор владельца заметки.
     * @return После успешного выполнения возвращает 1.
     */
    fun deleteComment(commentId: Int, ownerId: Int): Int {
        val noteComment: NoteComment =
            noteComments.find { it.id == commentId } ?: throw NoteCommentNotFoundException("no noteComment with id")
        val noteCommentIndex: Int = noteComments.indexOf(noteComment)
        noteComments[noteCommentIndex] = noteComment.copy(isDelete = true)
        return 1
    }

    /**Редактирует заметку текущего пользователя.
     * @param noteId Идентификатор заметки.
     * @param title Заголовок заметки.
     * @param text Текст заметки.
     * @param privacy Уровень доступа к заметке.
     *
     *          Возможные значения:
     *          • 0 — все пользователи,
     *          • 1 — только друзья,
     *          • 2 — друзья и друзья друзей,
     *          • 3 — только пользователь.
     * @param commentPrivacy Уровень доступа к комментированию заметки.
     *
     *          Возможные значения:
     *          • 0 — все пользователи,
     *          • 1 — только друзья,
     *          • 2 — друзья и друзья друзей,
     *          • 3 — только пользователь.
     * @param privacyView Настройки приватности просмотра заметки в специальном формате.
     * @param privacyComment Настройки приватности комментирования заметки в специальном формате.
     * @return После успешного выполнения возвращает 1.
     */
    fun edit(
        noteId: Int,
        title: String,
        text: String,
        privacy: Int,
        commentPrivacy: Int,
        privacyView: String,
        privacyComment: String
    ): Int {
        val note: Note = notes.find { it.id == noteId } ?: throw NoteNotFoundException("no note with id")
        val noteIndex: Int = notes.indexOf(note)
        notes[noteIndex] = note.copy(
            title = title,
            text = text,
            privacyView = privacyView,
            privacy = privacy,
            commentPrivacy = commentPrivacy
        )
        return 1
    }

    /**Редактирует указанный комментарий у заметки.
     * @param commentId Идентификатор комментария.
     * @param ownerId Идентификатор владельца заметки.
     * @param message Новый текст комментария.
     * @return После успешного выполнения возвращает 1.
     */
    fun editComment(commentId: Int, ownerId: Int, message: String): Int {
        val noteComment: NoteComment =
            noteComments.find { it.id == commentId } ?: throw NoteCommentNotFoundException("no noteComment with id")
        val noteCommentIndex: Int = noteComments.indexOf(noteComment)
        noteComments[noteCommentIndex] = noteComment.copy(message = message)
        return 1
    }

    /**Возвращает список заметок, созданных пользователем.
     * @param noteIds Идентификаторы заметок, информацию о которых необходимо получить.
     * @param userId Идентификатор пользователя, информацию о заметках которого требуется получить.
     * @param offset Смещение, необходимое для выборки определенного подмножества заметок.
     * @param count Количество заметок, информацию о которых необходимо получить.
     * @param sort Сортировка результатов (0 — по дате создания в порядке убывания,
     * 1 - по дате создания в порядке возрастания).
     * @return После успешного выполнения возвращает список объектов заметок.
     */
    fun getNote(noteIds: String, userId: Int, offset: Int, count: Int, sort: Int): List<Note> {
        return notes.filter { it.ownerId == userId }
    }

    /**Возвращает заметку по её id.
     * @param noteId идентификатор заметки.
     * @param ownerId идентификатор владельца заметки.
     * (работает, только если запрашиваются заметки текущего пользователя).
     * @return После успешного выполнения возвращает объект Заметка
     */
    fun getById(noteId: Int, ownerId: Int): Note {
        return notes.find { it.id == noteId } ?: throw NoteNotFoundException("no note with id")
    }

    /**Возвращает список комментариев к заметке.
     * @param noteId Идентификатор заметки.
     * @param ownerId Идентификатор владельца заметки.
     * @param sort Сортировка результатов (0 — по дате добавления в порядке возрастания, 1 — по дате добавления в порядке убывания).
     * @param offset Смещение, необходимое для выборки определенного подмножества комментариев.
     * @param count Количество комментариев, которое необходимо получить.
     */
    fun getComments(noteId: Int, ownerId: Int, sort: Int, offset: Int, count: Int): List<NoteComment> {
        notes.find { it.id == noteId } ?: throw NoteNotFoundException("no note with id")
        return noteComments.filter { it.nid == noteId }
    }

    /**Восстанавливает удалённый комментарий
     * @param commentId Идентификатор удаленного комментария.
     * @param ownerId Идентификатор владельца заметки.
     * @return После успешного выполнения возвращает 1.
     */
    fun restoreComment(commentId: Int, ownerId: Int): Int {
        val noteComment: NoteComment =
            noteComments.find { it.id == commentId } ?: throw NoteCommentNotFoundException("no noteComment with id")
        val noteCommentIndex: Int = noteComments.indexOf(noteComment)
        noteComments[noteCommentIndex] = noteComment.copy(isDelete = false)
        return 1
    }
}