import kotlin.math.max

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { 0 }

    for (i in 1 .. n) {
        dp[i] = dp[i - 1] + nums[i - 1]
    }

    var m = Int.MIN_VALUE
    for (i in 0 .. n - k) {
        m = max(m, dp[i + k] - dp[i])
    }

    println(m)
}