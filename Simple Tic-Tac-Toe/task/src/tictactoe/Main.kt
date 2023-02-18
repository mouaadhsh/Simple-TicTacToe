package tictactoe

//import kotlin.math.abs
fun gameNotFinished(matrix: MutableList<MutableList<Char>>): Boolean {
    for (i in matrix.indices) {
        if (' ' in matrix[i].joinToString("")) {
            return true
        }
    }
    return false
}

//fun impossibleGame(matrix: MutableList<MutableList<Char>>, symbols: String): Boolean {
//    var occX = 0
//    var occO = 0
//    if (playerWin(matrix, 'X') && playerWin(matrix, 'O')) {
//        return true
//    }
//    for (i in symbols) if (i == 'X') {
//        occX++
//    }
//    for (i in symbols) if (i == 'O') {
//        occO++
//    }
//    if (abs(occX - occO) >= 2) {
//        return true
//    }
//    return false
//}

fun playerWin(matrix: MutableList<MutableList<Char>>, player: Char): Boolean {
    if (matrix[0][0] == player && matrix[1][1] == player && matrix[2][2] == player || matrix[0][2] == player && matrix[1][1] == player && matrix[2][0] == player) {
        return true
    }
    for (i in matrix.indices) {
        if (matrix[i] == MutableList(3) { player }) {
            return true
        }

    }
    label@ for (i in matrix.indices) {
        for (j in matrix.indices) {
            if (matrix[j][i] != player) {
                continue@label
            }
        }
        return true
    }
    return false
}

fun display(matrix: MutableList<MutableList<Char>>) {
    println("---------")
    for (i in matrix.indices) println("| " + matrix[i].joinToString(" ") + " |")
    println("---------")
}

fun swap(player: Char): Char {
    when (player) {
        'X' -> return 'O'
        'O' -> return 'X'
    }
    return ' '
}

fun main() {

    val matrix = MutableList(3) { MutableList(3) { ' ' } }
    var player = 'X'
    display(matrix)
    do {
        val coordinate = readln().split(" ")
        try {
            if (matrix[coordinate[0].toInt() - 1][coordinate[1].toInt() - 1] == 'X' || matrix[coordinate[0].toInt() - 1][coordinate[1].toInt() - 1] == 'O')
                println("This cell is occupied! Choose another one!")
            else {
                matrix[coordinate[0].toInt() - 1][coordinate[1].toInt() - 1] = player
                player = swap(player)
                display(matrix)
            }
        } catch (e: NumberFormatException) {
            println("You should enter numbers!\n")
        } catch (e: IndexOutOfBoundsException) {
            println("Coordinates should be from 1 to 3!")
        }
        if (playerWin(matrix, swap(player))) {
            println("${swap(player)} wins")
            return
        }
    } while (gameNotFinished(matrix))
    println("Draw")
}