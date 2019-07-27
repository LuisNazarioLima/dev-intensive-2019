package ru.skillbranch.devintensive.models

import java.util.*

open class Builder_Test {
    var id: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var avatar: String? = null
    var rating: Int? = null
    var respect: Int? = null
    var lastVisit: Date? = null
    var isOnline: Boolean? = null
    //var build() : String? = null

    fun id(id: String) {
        this.id = id
    }

    fun getID(): String? {
        return this.id
    }

    fun firstName(firstName: String) {
        this.firstName = firstName
    }

    fun getfirstName(): String? {
        return this.firstName
    }

    fun lastName(lastName: String) {
        this.lastName = lastName
    }

    fun getlastName(): String? {
        return this.lastName
    }

    fun avatar(avatar: String) {
        this.avatar = avatar
    }

    fun getavatar(): String? {
        return this.avatar
    }

    fun rating(rating: Int) {
        this.rating = rating
    }

    fun getarating(): Int? {
        return this.rating
    }

    fun respect(respect: Int) {
        this.respect = respect
    }

    fun getrespect(): Int? {
        return this.respect
    }

    fun lastVisit(lastVisit: Date) {
        this.lastVisit = lastVisit
    }

    fun getlastVisit(): Date? {
        return this.lastVisit
    }

    fun isOnline(isOnline: Boolean) {
        this.isOnline = isOnline
    }

    fun getisOnline(): Boolean? {
        return this.isOnline
    }
}