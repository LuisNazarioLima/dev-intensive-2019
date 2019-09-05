package ru.skillbranch.devintensive.models.data

import ru.skillbranch.devintensive.extensions.humanizeDiff
import ru.skillbranch.devintensive.utils.Utils
import java.util.*
//видео 2:22:30
data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false
){
    var introBit:String = "tu tu t ut uut"

    fun toUserItem(): UserItem {
        val lastActivity = when{
            lastVisit == null -> "Ещё ни разу не заходил"
            isOnline -> "online"
            else -> "Последний раз был ${lastVisit.humanizeDiff()}"
        }

        return UserItem(
            id,
            "${firstName.orEmpty()} ${lastName.orEmpty()}",
            Utils.toInitials(firstName, lastName),
            avatar,
            lastActivity,
            false,
            isOnline
        )
    }

    constructor(id:String, firstName:String?, lastName:String?) : this( //видео 2:22:30 конец
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null,
        rating = 0,
        respect = 0,
        lastVisit = Date(),
        isOnline = false
    )

    constructor(id:String) : this(id, "John", "Doe")


    private fun getIntro()= """
        tu tut ututu
        tytytyt ttt
    """.trimIndent()

    fun printMe() = println("""
            id: $id
            firstName: $firstName
            lastName: $lastName
            avatar: $avatar
            rating: $rating
            respect: $respect
            lastVisit: $lastVisit
            isOnline: $isOnline
        """.trimIndent())

    companion object Factory {
        private var lastId: Int = -1
        fun makeUser(fullName: String?): User {
            lastId++

            val (firstName, lastName) = Utils.parseFullName(fullName)

            return User(
                id = "$lastId",
                firstName = firstName,
                lastName = lastName
            )
        }
    }

    data class Builder(
        var id: String = "",
        var firstName: String? = null,
        var lastName: String? = null,
        var avatar: String? = null,
        var rating: Int = 0,
        var respect: Int = 0,
        var lastVisit: Date? = null,
        var isOnline: Boolean = false) {

        fun id(id: String) = apply {this.id = id}
        fun firstName(firstName: String) = apply {this.firstName = firstName}
        fun lastName(lastName: String) = apply {this.lastName = lastName}
        fun avatar(avatar: String) = apply {this.avatar = avatar}
        fun rating(rating: Int) = apply {this.rating = rating}
        fun respect(respect: Int) = apply {this.respect = respect}
        fun lastVisit(lastVisit: Date) = apply {this.lastVisit = lastVisit}
        fun isOnline(isOnline: Boolean) = apply {this.isOnline = isOnline}
        fun build() = User(
            id,
            firstName,
            lastName,
            avatar,
            rating,
            respect,
            lastVisit,
            isOnline
        )
    }
}
