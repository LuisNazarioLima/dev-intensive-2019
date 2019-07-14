package ru.skillbranch.devintensive.models

class Bender(var status: Status = Status.NORMAL, var question: Question = Question.NAME) {
var wrongAnswer: Short = 0

    fun askQuestion(): String = when (question) {
        Question.NAME -> Question.NAME.question
        Question.PROFESSION -> Question.PROFESSION.question
        Question.MATERIAL -> Question.MATERIAL.question
        Question.BDAY -> Question.BDAY.question
        Question.SERIAL -> Question.SERIAL.question
        Question.IDLE -> Question.IDLE.question
    }

    fun listenAnswer(answer: String): Pair<String, Triple<Int, Int, Int>> {
        if (!question.validation(answer).second) {
            return "${question.validation(answer).first}\n${question.question}" to status.color
        }
        return if(question.answers.contains(answer)) {
                question = question.nextQuestion()
                "Отлично - ты справился\n${question.question}" to status.color
            } else {
                wrongAnswer++
                if (wrongAnswer == 3.toShort()) {
                    status = Status.NORMAL
                    question = Question.NAME
                    wrongAnswer = 0.toShort()
                    "Это неправильный ответ. Давай все по новой\n${question.question}" to status.color
                } else {
                    status = status.nextStatus()
                    "Это неправильный ответ\n${question.question}" to status.color
                }
            }
        }

    enum class Status(val color: Triple<Int, Int, Int>){
        NORMAL(Triple(255, 255, 255)),
        WARNING(Triple(255, 120, 0)),
        DANGER(Triple(255, 60, 60)),
        CRITICAL(Triple(255, 0, 0));

        fun nextStatus(): Status {
            return if(this.ordinal < values().lastIndex) {
                values()[this.ordinal + 1]
            } else {
                values()[0]
            }
        }
    }

    enum class Question(val question: String, val answers: List<String>){
        NAME("Как меня зовут?", listOf("Бендер", "Bender")) {
            override fun nextQuestion(): Question = PROFESSION

            override fun validation(input: String): Pair<String, Boolean> {
                return if (input.substring(0,1) != input.substring(0,1).toUpperCase()) {
                    "Имя должно начинаться с заглавной буквы" to false
                } else {
                    "" to true
                }
            }
        },
        PROFESSION("Назови мою профессию?", listOf("сгибальщик", "bender")){
            override fun nextQuestion(): Question = MATERIAL
            override fun validation(input: String): Pair<String, Boolean> {
                return if (input.substring(0,1) != input.substring(0,1).toLowerCase()) {
                    "Профессия должна начинаться со строчной буквы" to false
                } else {
                    "" to true
                }
            }
        },
        MATERIAL("Из чего я сделан?", listOf("металл", "дерево", "metal", "iron", "wood")){
            override fun nextQuestion(): Question = BDAY
            override fun validation(input: String): Pair<String, Boolean> {
                var errorExist: Boolean = false
                for (char in input) {
                    errorExist = when (char){
                        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> true
                        else -> false
                    }
                    if (errorExist) {
                        break
                    }
                }
                return if (errorExist) {
                    "Материал не должен содержать цифр" to false
                } else {
                    "" to true
                }
            }
        },
        BDAY("Когда меня создали?", listOf("2993")){
            override fun nextQuestion(): Question = SERIAL
            override fun validation(input: String): Pair<String, Boolean> {
                var errorExist: Boolean = false
                for (char in input) {
                    errorExist = when(char) {
                        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> false
                        else -> true
                    }
                    if (errorExist) {
                        break
                    }
                }
                return if (errorExist) {
                    "Год моего рождения должен содержать только цифры" to false
                } else {
                    "" to true
                }
            }
        },
        SERIAL("Мой серийный номер?", listOf("2716057")){
            override fun nextQuestion(): Question = IDLE
            override fun validation(input: String): Pair<String, Boolean> {
                var errorExist: Boolean = false
                if (input.length != 7) {
                    return "Серийный номер содержит только цифры, и их 7" to false
                }
                for (char in input) {
                    errorExist = when(char) {
                        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> false
                        else -> true
                    }
                    if (errorExist) {
                        break
                    }
                }
                return if (errorExist) {
                    "Серийный номер содержит только цифры, и их 7" to false
                } else {
                    "" to true
                }
            }
        },
        IDLE("На этом все, вопросов больше нет", listOf()){
            override fun nextQuestion(): Question = IDLE
            override fun validation(input: String): Pair<String, Boolean> {
                return "" to true
            }
        };

        abstract fun nextQuestion(): Question
        abstract fun validation(input: String): Pair<String, Boolean>
    }
}