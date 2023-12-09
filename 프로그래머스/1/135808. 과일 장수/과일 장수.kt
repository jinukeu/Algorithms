class Solution {
fun solution(k: Int, m: Int, score: IntArray): Int {
    var answer: Int = 0

    score.sort()
    val rs = score.toMutableList()

    while (rs.size >= m) {
        val temp = mutableListOf<Int>()
        repeat(m) {
            temp.add(rs.removeLast())
        }
        answer += temp.minOf { it } * m
    }

    return answer
}
}