package simplebot

import java.util.*


object Mains {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        println("Привет! Меня зовут Юля.")
        println("Я была сделана в 2021 году.")
        println("Пожалуйста, напиши мне своё имя.")
        val name = scanner.nextLine()
        println("Какое у тебя отличное имя - $name!")
        println("Дай угадаю твой возраст.")
        println("Напиши остатки деления твоего возраста на 3, 5 и 7")
        val remainder3 = scanner.nextInt()
        val remainder5 = scanner.nextInt()
        val remainder7 = scanner.nextInt()
        val age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
        println("Твой возраст равен $age; что за хорошее время, чтобы начать программировать!")
        println("Теперь я докажу вам, что могу считать до любого числа, которое вы хотите.")
        var number = scanner.nextInt()
        for (i in 0..number) {
            println("$i!")
        }
        println("Готово, хорошего дня!")
        println("Давайте проверим ваши знания в области программирования.")
        println("Почему мы используем методы?")
        println("1. Чтобы повторить утверждение несколько раз.")
        println("2. Разбить программу на несколько небольших подпрограмм.")
        println("3. Чтобы определить время выполнения программы.")
        println("4. Прервать выполнение программы.")
        number = scanner.nextInt()
        while (number != 2) {
            println("Пожалуйста, попробуй ещё.")
            number = scanner.nextInt()
        }
        println("Поздравляю, хорошего дня!")
    }
}