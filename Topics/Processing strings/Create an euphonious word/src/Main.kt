fun main() {
    val word = readln()
    val vowels = "aeiouy"
    var countV = 0
    var countC = 0
    var count = 0
    for (i in word) {
        if (i in vowels) {
            countV++
            countC = 0
        } else {
            countC++
            countV = 0
        }
        if (countV >= 3 || countC >= 3) {
            count++
            countV = 1
            countC = 1
        }
    }
    println(count)

}