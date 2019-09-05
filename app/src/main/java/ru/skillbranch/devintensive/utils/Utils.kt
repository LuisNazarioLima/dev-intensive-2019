package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{

        if (fullName.isNullOrBlank()) return null to null

        var parts : List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        var nickNew: String = ""

        if (payload.isBlank()) {
            return ""
        } else {
            for (char in payload) {
                nickNew += when (char.toString()) {
                        "а" -> "a"
                        "б" -> "b"
                        "в" -> "v"
                        "г" -> "g"
                        "д" -> "d"
                        "е" -> "e"
                        "ё" -> "e"
                        "ж" -> "zh"
                        "з" -> "z"
                        "и" -> "i"
                        "й" -> "i"
                        "к" -> "k"
                        "л" -> "l"
                        "м" -> "m"
                        "н" -> "n"
                        "о" -> "o"
                        "п" -> "p"
                        "р" -> "r"
                        "с" -> "s"
                        "т" -> "t"
                        "у" -> "u"
                        "ф" -> "f"
                        "х" -> "h"
                        "ц" -> "c"
                        "ч" -> "ch"
                        "ш" -> "sh"
                        "щ" -> "sh'"
                        "ъ" -> ""
                        "ы" -> "i"
                        "ь" -> ""
                        "э" -> "e"
                        "ю" -> "yu"
                        "я" -> "ya"
                        "А" -> "A"
                        "Б" -> "B"
                        "В" -> "V"
                        "Г" -> "G"
                        "Д" -> "D"
                        "Е" -> "E"
                        "Ё" -> "E"
                        "Ж" -> "ZH"
                        "З" -> "Z"
                        "И" -> "I"
                        "Й" -> "I"
                        "К" -> "K"
                        "Л" -> "L"
                        "М" -> "M"
                        "Н" -> "N"
                        "О" -> "O"
                        "П" -> "P"
                        "Р" -> "R"
                        "С" -> "S"
                        "Т" -> "T"
                        "У" -> "U"
                        "Ф" -> "F"
                        "Х" -> "H"
                        "Ц" -> "C"
                        "Ч" -> "CH"
                        "Ш" -> "SH"
                        "Щ" -> "SH'"
                        "Ъ" -> ""
                        "Ы" -> "I"
                        "Ь" -> ""
                        "Э" -> "E"
                        "Ю" -> "YU"
                        "Я" -> "YA"
                        " " -> divider
                    else -> char
                }
            }
            //nickNew = nickNew.replace(divider, "_")
            return nickNew
        }
    }

    fun toInitials(firstName: String?, lastName: String?): String {
        var a:String
        var b:String

        if (firstName.isNullOrBlank() and lastName.isNullOrBlank()) throw return ""

        if (firstName.isNullOrBlank()) a = "" else a = firstName.substring(0,1).toUpperCase()
        if (lastName.isNullOrBlank()) b = "" else b = lastName.substring(0,1).toUpperCase()

        return a + b
    }

    fun validationUrl(url: String) : Boolean{
        if (url.substringAfterLast("/") == "join") {return false}
        if (url.substringAfterLast("/") == "login") {return false}
        if (url.substringAfterLast("/") == "security") {return false}
        if (url.substringAfterLast("/") == "customer-stories") {return false}
        if (url.substringAfterLast("/") == "nonprofit") {return false}
        if (url.substringAfterLast("/") == "pricing") {return false}
        if (url.substringAfterLast("/") == "marketplace") {return false}
        if (url.substringAfterLast("/") == "events") {return false}
        if (url.substringAfterLast("/") == "trending") {return false}
        if (url.substringAfterLast("/") == "collections") {return false}
        if (url.substringAfterLast("/") == "topics") {return false}
        if (url.substringAfterLast("/") == "events") {return false}
        if (url.substringAfterLast("/") == "features") {return false}
        if (url.substringAfterLast("/") == "enterprise") {return false}

        val regex = Regex(pattern = "(http)?(s)?(://)?(www.)?github.com/([a-zA-Z0-9]*(-)?[a-zA-Z0-9]{2,}[^/])")
        return regex.matches(url)
    }
}