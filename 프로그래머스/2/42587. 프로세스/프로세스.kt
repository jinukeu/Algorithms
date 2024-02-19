import kotlin.collections.ArrayDeque

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
    var answer = 0

    val que = ArrayDeque<Int>()
    que.addAll(priorities.toList())

    var loc = location

    while (true) {
        val now = que.removeFirst()
        loc -= 1
        
        if (que.isEmpty()) {
            return ++answer
        }

        // 원하는 값인 경우
        if(loc == -1) {
            // 원하는 값이고 사용 가능한 경우
            if (now >= que.maxOf { it }) {
                answer += 1
                return answer
            }

            // 원하는 값이 나왔는데, 사용할 수 없는 경우
            if (now < que.maxOf { it }) {
                que.add(now)
                loc = que.size - 1
                continue
            }
        }
        // 원하는 값이 아닌 경우
        else {
            // 사용 가능한 경우
            if (now >= que.maxOf { it }) {
                answer += 1
                continue
            }

            // 사용할 수 없는 경우
            if (now < que.maxOf { it }) {
                que.add(now)
                continue
            }
        }

    }

    return answer
}
}