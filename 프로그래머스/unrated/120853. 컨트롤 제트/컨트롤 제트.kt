class Solution {
fun solution(s: String): Int {
    var answer: Int = 0
    val stack = mutableListOf<Int>()

    s.split(" ").forEach {
        if(it == "Z") stack.removeLast()
        else stack.add(it.toInt())
    }

    stack.forEach { answer += it }

    return answer
}
}