fun main() {
    val ticket = readln()
    if (ticket.substring(0..2).sumOf { it.digitToInt() } == ticket.substring(3).sumOf { it.digitToInt() }) {
        println("Lucky")
    } else {
        println("Regular")
    }
}