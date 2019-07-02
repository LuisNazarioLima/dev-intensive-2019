package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils
import java.util.*
import ru.skillbranch.devintensive.models.UserView

fun User.toUserView() : UserView {
    val nickName = Utils.translitiration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if(lastVisit == null) "Ещё ни разу не был" else if(isOnline) "online" else "Последний рвз был: ${lastVisit.humanizeDiff()}"
    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickName,
        initials = initials,
        status = status
    )
}

