import java.util.*

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
    var answer = 0
    // 1. 남은 큐 중에서 제일 큰 놈을 찾는다.
    // 2. 제일 큰 놈이 나오면 remove 아니면 add한다.
    // 3. remove 되었을 때 원하는 location에 있으면

    val loq: Queue<Int> = LinkedList()
    loq.addAll(List(priorities.size) { it })

    val prq: Queue<Int> = LinkedList()
    prq.addAll(priorities.toList())

    while (true) {
        val m = prq.maxOf { it }
        val n = prq.remove()
        val l = loq.remove()

        if(m != n) {
            prq.add(n)
            loq.add(l)
        } else {
            answer += 1
            if (l == location) return answer
        }
    }
}
}