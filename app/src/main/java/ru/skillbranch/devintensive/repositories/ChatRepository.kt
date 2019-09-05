package ru.skillbranch.devintensive.repositories
//1:49:49
import androidx.lifecycle.MutableLiveData
import ru.skillbranch.devintensive.data.managers.CashManager
import ru.skillbranch.devintensive.models.data.Chat

object ChatRepository {
    private val chats = CashManager.loadChats()

    fun loadChats() : MutableLiveData<List<Chat>> {
        return chats
    }

    fun update(chat: Chat) {
        val copy = chats.value!!.toMutableList()
        val ind = chats.value!!.indexOfFirst { it.id == chat.id}
        if(ind == -1) return
        copy[ind] = chat
        chats.value = copy
    }

    fun find(chatId: String): Chat? {
        val ind = chats.value!!.indexOfFirst { it.id == chatId}
        return chats.value!!.getOrNull(ind)
    }
}
//1:49:49