package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{

        if (fullName.isNullOrBlank()) return null to null

        var parts : List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun translitiration(payload: String, divider:String = " "): String {
        var nickNew:String?
        nickNew = payload
        nickNew = nickNew.replace("а", "a")
        nickNew = nickNew.replace("б", "b")
        nickNew = nickNew.replace("в", "v")
        nickNew = nickNew.replace("г", "g")
        nickNew = nickNew.replace("д", "d")
        nickNew = nickNew.replace("е", "e")
        nickNew = nickNew.replace("ё", "e")
        nickNew = nickNew.replace("ж", "zh")
        nickNew = nickNew.replace("з", "z")
        nickNew = nickNew.replace("и", "i")
        nickNew = nickNew.replace("й", "i")
        nickNew = nickNew.replace("к", "k")
        nickNew = nickNew.replace("л", "l")
        nickNew = nickNew.replace("м", "m")
        nickNew = nickNew.replace("н", "n")
        nickNew = nickNew.replace("о", "o")
        nickNew = nickNew.replace("п", "p")
        nickNew = nickNew.replace("р", "r")
        nickNew = nickNew.replace("с", "s")
        nickNew = nickNew.replace("т", "t")
        nickNew = nickNew.replace("у", "u")
        nickNew = nickNew.replace("ф", "f")
        nickNew = nickNew.replace("х", "h")
        nickNew = nickNew.replace("ц", "c")
        nickNew = nickNew.replace("ч", "ch")
        nickNew = nickNew.replace("ш", "sh")
        nickNew = nickNew.replace("щ", "sh'")
        nickNew = nickNew.replace("ъ", "")
        nickNew = nickNew.replace("ы", "i")
        nickNew = nickNew.replace("ь", "")
        nickNew = nickNew.replace("э", "e")
        nickNew = nickNew.replace("ю", "yu")
        nickNew = nickNew.replace("я", "ya")

        nickNew = nickNew.replace("А", "A")
        nickNew = nickNew.replace("Б", "B")
        nickNew = nickNew.replace("В", "V")
        nickNew = nickNew.replace("Г", "G")
        nickNew = nickNew.replace("Д", "D")
        nickNew = nickNew.replace("Е", "E")
        nickNew = nickNew.replace("Ё", "E")
        nickNew = nickNew.replace("Ж", "ZH")
        nickNew = nickNew.replace("З", "Z")
        nickNew = nickNew.replace("И", "I")
        nickNew = nickNew.replace("Й", "I")
        nickNew = nickNew.replace("К", "K")
        nickNew = nickNew.replace("Л", "L")
        nickNew = nickNew.replace("М", "M")
        nickNew = nickNew.replace("Н", "N")
        nickNew = nickNew.replace("О", "O")
        nickNew = nickNew.replace("П", "P")
        nickNew = nickNew.replace("Р", "R")
        nickNew = nickNew.replace("С", "S")
        nickNew = nickNew.replace("Т", "T")
        nickNew = nickNew.replace("У", "U")
        nickNew = nickNew.replace("Ф", "F")
        nickNew = nickNew.replace("Х", "H")
        nickNew = nickNew.replace("Ц", "C")
        nickNew = nickNew.replace("Ч", "CH")
        nickNew = nickNew.replace("Ш", "SH")
        nickNew = nickNew.replace("Щ", "SH'")
        nickNew = nickNew.replace("Ъ", "")
        nickNew = nickNew.replace("Ы", "I")
        nickNew = nickNew.replace("Ь", "")
        nickNew = nickNew.replace("Э", "E")
        nickNew = nickNew.replace("Ю", "YU")
        nickNew = nickNew.replace("Я", "YA")

        nickNew = nickNew.replace(" ", "_")
        nickNew = nickNew.replace(divider, "_")

        return nickNew
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var a:String
        var b:String

        if (firstName.isNullOrBlank() and lastName.isNullOrBlank()) throw return null

        if (firstName.isNullOrBlank()) a = "" else a = firstName.substring(0,1).toUpperCase()
        if (lastName.isNullOrBlank()) b = "" else b = lastName.substring(0,1).toUpperCase()

        return a + b
    }
}