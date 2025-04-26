import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val heights = Array(1001) { 0 }

    var maxHeight = 0
    var start = 1001
    var end = 0
    repeat(n) {
        val (l, h) = readln().split(" ").map { it.toInt() }
        heights[l] = h
        maxHeight = max(h, maxHeight)
        start = min(start, l)
        end = max(end, l)
    }

    var left = 0
    var leftHeight = heights[start]
    while (start < 1000) {
        leftHeight = max(leftHeight, heights[start])
        if (leftHeight == maxHeight) break

        left += leftHeight
        start += 1
    }

    var right = 0
    var rightHeight = heights[end]
    while (end > -1) {
        rightHeight = max(rightHeight, heights[end])
        if (rightHeight == maxHeight) break

        right += rightHeight
        end -= 1
    }

    println(left + right + (end - start + 1) * maxHeight)
}




