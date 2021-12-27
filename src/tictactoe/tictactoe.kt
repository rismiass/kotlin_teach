package tictactoe

import java.util.*


object tic_tac_toe_2 {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val toArray = Array(3) { CharArray(3) }
        for (i in 0..2) {
            for (j in 0..2) {
                toArray[i][j] = ' '
            }
        }
        outField(toArray)
        var quitt = " "
        while (quitt === " ") {
            println("Сделайте ход, ваша сторона - X")
            var x: Int
            var y: Int
            var flag = true
            val emptyCell = ' '
            var line: String
            while (flag == true) {
                flag = false
                line = scanner.nextLine()
                if (!line.substring(0, 1).intOrString() ||
                    !line.substring(2, 3).intOrString()
                ) {
                    println("Ты должен вводить только числа!")
                    flag = true
                    continue
                }
                x = line.substring(0, 1).toInt()
                y = line.substring(2, 3).toInt()
                if (x > 0 && x < 4 && y > 0 && y < 4) {
                    if (toArray[x - 1][y - 1] != ' ') {
                        println("Эта клетка занята! Выберите другую!")
                        flag = true
                        continue
                    } else {
                        toArray[x - 1][y - 1] = 'X'
                    }
                } else {
                    println("Координаты должны быть от одного до трёх!")
                    flag = true
                    continue
                }
            }
            var free_cells = false
            for (i in 0..2) {
                for (j in 0..2) {
                    if (toArray[i][j] == ' ') {
                        free_cells = true
                    }
                }
            }
            var win = getWin(toArray)
            if (win.length == 1) {
                quitt = win
                break
            }
            if (win.length == 0) {
                if (free_cells == false) {
                    quitt = "!"
                    break
                }
            }
            var e_x: Int
            var e_y: Int
            do {
                e_x = 1 + (Math.random() * 3).toInt()
                e_y = 1 + (Math.random() * 3).toInt()
            } while (toArray[e_x - 1][e_y - 1] != ' ')
            toArray[e_x - 1][e_y - 1] = 'O'
            outField(toArray)
            win = getWin(toArray)
            for (i in 0..2) {
                for (j in 0..2) {
                    if (toArray[i][j] == emptyCell) {
                        free_cells = true
                    }
                }
            }
            if (win.length == 1) {
                quitt = win
                break
            }
            if (win.length == 0 && !free_cells) {
                quitt = "!"
                break
            }

        }
        when (quitt) {
            "X" -> println("Победил X!")
            "O" -> println("Победил O!")
            "!" -> println("Ничья!")
        }
    }

    fun getWin(toArray: Array<CharArray>): String {
        var win = ""
        val emptyCell = ' '
        win = ""
        if (toArray[0][0] == toArray[1][1] && toArray[0][0] == toArray[2][2] && toArray[0][0] != emptyCell) {
            win = win + toArray[0][0]
        }
        if (toArray[0][2] == toArray[1][1] && toArray[0][2] == toArray[2][0] && toArray[0][2] != emptyCell) {
            win = win + toArray[0][0]
        }
        for (i in 0..2) {
            if (toArray[0][i] == toArray[1][i] && toArray[2][i] == toArray[0][i] && toArray[0][i] != emptyCell) {
                win = win + toArray[0][i]
            }
            if (toArray[i][0] == toArray[i][1] && toArray[i][2] == toArray[i][0] && toArray[i][0] != emptyCell) {
                win = win + toArray[i][0]
            }
        }
        return win
    }

    fun outField(toArray: Array<CharArray>) {
        println("---------")
        for (i in 0..2) {
            print("| " + toArray[i][0])
            print(" " + toArray[i][1])
            println(" " + toArray[i][2] + " |")
        }
        println("---------")
    }

    fun String.intOrString(): Boolean {
        val v = toIntOrNull()
        return when (v) {
            null -> false
            else -> true
        }
    }

}
