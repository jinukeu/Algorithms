fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    backtracking(n, emptyList(), m)
}

fun backtracking(
    maxNum: Int,
    previous: List<Int>,
    numsLength: Int,
) {
    if (numsLength == previous.size) {
        println(previous.joinToString(" "))
    }

    for (i in 1 .. maxNum) {
        if (i !in previous) {
            backtracking(maxNum, previous + i, numsLength)
        }
    }
}