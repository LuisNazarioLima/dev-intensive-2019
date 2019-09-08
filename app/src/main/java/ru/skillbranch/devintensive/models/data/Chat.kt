package ru.skillbranch.devintensive.models.data

import androidx.annotation.VisibleForTesting
import ru.skillbranch.devintensive.extensions.shortFofmat
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.ImageMessage
import ru.skillbranch.devintensive.models.TextMessage
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class Chat(
    val id: String,
    val title: String,
    val members: List<User> = listOf(),
    var messages: MutableList<BaseMessage> = mutableListOf(),
    var isArchived: Boolean = false
) {
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun unreadableMessageCount(): Int {
        val unreaded = messages.count { it.isReaded == false }
        return unreaded
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun lastMessageDate(): Date? {
        val lastMessage = messages.lastOrNull()
        return lastMessage?.date ?: null
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun lastMessageShort(): Pair<String, String?> = when(val lastMessage = messages.lastOrNull()) {
    //fun lastMessageShort(): Pair<String, String> {
        is TextMessage -> lastMessage.text!! to lastMessage.from.firstName
        is ImageMessage -> "${lastMessage.from.firstName} - отправил фото" to lastMessage.from.lastName
        else -> "Сообщений ещё нет" to "@John_Doe"
        //TODO implement me домашка сделать обрезку символов
         //return "Сообщений ещё нет" to "@John_Doe"
    }

    private fun isSingle(): Boolean = members.size == 1
//1:55:46
    fun toChatItem(): ChatItem {
        return if (isSingle()) {
            val user = members.first()
            ChatItem(
                id,
                user.avatar,
                Utils.toInitials(user.firstName, user.lastName) ?: "??",
                "${user.firstName ?: ""} ${user.lastName ?: ""}",
                lastMessageShort().first,
                unreadableMessageCount(),
                lastMessageDate()?.shortFofmat(),
                user.isOnline
            )
        } else {
            ChatItem(
                id,
                null,
                "",
                title,
                lastMessageShort().first,
                unreadableMessageCount(),
                lastMessageDate()?.shortFofmat(),
                false,
                ChatType.GROUP,
                lastMessageShort().second
            )
        }
    }
}

enum class ChatType{
    SINGLE,
    GROUP,
    ARCHIVE
}
//01:55:46 конец


