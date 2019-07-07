package ru.skillbranch.devintensive.extensions

fun String.truncate(value: Int = 16): String {
    var newLine: String = this
    newLine = trimEnd()
    if (newLine.length <= value) {return newLine}
    else {
        return newLine.substring(0, value).trimEnd() + "..."
    }
}

fun String.stripHtml(): String {
    var oldLine = this
    var newLine: String = ""
    var flagEndOfHTML: Boolean = false
    var flagOfDoubleSpace: Boolean = false
    var flagEscape: Boolean = false

    oldLine = oldLine.replace("'", "")
    oldLine = oldLine.replace("\n", "")

    for (char in oldLine) {
        if (char.toString() == "<") {
            flagEndOfHTML = false
            continue
        }
        if (char.toString() == ">") {
            flagEndOfHTML = true
            continue
        }
        if ((char.toString() == " ") && flagOfDoubleSpace) {
            continue
        } else {
            flagOfDoubleSpace =  true
        }

        if ((char.toString() != " ") && flagOfDoubleSpace) {
            flagOfDoubleSpace =  false
        }

        if (char.toString() == "&") {
            flagEscape =  true
            continue
        }

        if (flagEscape) {
            if (char.toString() == ";") {
                flagEscape = false
                continue
            } else {
                continue
            }
        }

        //if (char.toString() == "'" || char.toString() == "\"") { continue }

        if (flagEndOfHTML) {newLine += char}

    }
    newLine = newLine.replace("  ", " ")
    return newLine
}