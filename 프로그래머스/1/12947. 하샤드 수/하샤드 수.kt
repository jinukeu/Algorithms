class Solution {
    fun solution(x: Int): Boolean {
        var answer = true
        val str = x.toString().split("").subList(1, x.toString().length + 1).map { it.toInt() }
        var num = 0
        str.forEach { num += it }
        return x % num == 0
    }
}