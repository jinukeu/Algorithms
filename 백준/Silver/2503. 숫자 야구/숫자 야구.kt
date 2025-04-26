fun main() {
    val n = readln().toInt()
    val hints = Array<List<Int>>(n) { emptyList() }

    repeat(n) {
        hints[it] = readln().split(" ").map { it.toInt() }
    }

    var answer = 0

    for (i in 100 .. 999) {
        val first = i / 100
        val second = i / 10 % 10
        val third = i % 10

        if (second == 0 || third == 0) continue

        val containSameNumber = setOf(first, second, third).size != 3
        if (containSameNumber) continue

        var hintCorrectCount = 0
        for ((hint, hs, hb) in hints) {
            val hintFirst = hint / 100
            val hintSecond = hint / 10 % 10
            val hintThird = hint % 10

            var s = 0
            var b = 0
            if (first == hintFirst) {
                s += 1
            }

            if (second == hintSecond) {
                s += 1
            }

            if (third == hintThird) {
                s += 1
            }

            if (first in listOf(hintSecond, hintThird)) {
                b += 1
            }

            if (second in listOf(hintFirst, hintThird)) {
                b += 1
            }

            if (third in listOf(hintSecond, hintFirst)) {
                b += 1
            }

            if (s == hs && b == hb) {
                hintCorrectCount += 1
            }
        }

        if (hintCorrectCount == n) {
            answer += 1
        }
    }

    println(answer)
}