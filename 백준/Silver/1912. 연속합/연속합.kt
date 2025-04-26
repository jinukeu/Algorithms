import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }
    val prefix = Array(n + 1) { 0 }

    for (i in 1 .. n) {
        prefix[i] = max(prefix[i - 1] + nums[i - 1], nums[i - 1])
    }

    println(prefix.drop(1).max())
}