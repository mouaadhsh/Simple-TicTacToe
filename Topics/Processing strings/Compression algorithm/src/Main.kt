fun main() {
    val dna = readln()
    var i = 0
    if (dna.isNotEmpty()) {
        while (i <= dna.length - 1) {
            print("${dna[i]}${occ(dna.substring(i, dna.length))}")
            i += occ(dna.substring(i))
        }
    }
}

fun occ(dna: String): Int {
    var count = 1
    for (j in 0..dna.length - 2) {
        if (dna[j] == dna[j + 1]) {
            count++
        } else {
            break
        }
    }
    return count
}