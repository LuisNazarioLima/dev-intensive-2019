//видео 2:46:05
package ru.skillbranch.devintensive.repositories

import ru.skillbranch.devintensive.data.managers.CashManager
import ru.skillbranch.devintensive.models.data.Chat
import ru.skillbranch.devintensive.models.data.User
import ru.skillbranch.devintensive.models.data.UserItem
import ru.skillbranch.devintensive.utils.DataGenerator

object GroupRepository {
    fun loadUsers(): List<User> = DataGenerator.stabUsers
    fun createChat(items: List<UserItem>) {
        val ids = items.map{it.id}
        val users = CashManager.findUsersByIds(ids)
        val title = users.map{it.firstName}.joinToString(", ")
        val chat = Chat(CashManager.nextChatId(), title, users)
        CashManager.insertChat(chat)
    }
}
//видео 2:46:05 конец