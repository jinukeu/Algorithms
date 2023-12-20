import java.util.*

class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
    var answer = 0

    val q: Queue<Pair<String, Int>> = LinkedList()
    val visited = MutableList(words.size) { false }

    q.add(Pair(begin, 0))

    while (q.isNotEmpty()) {
        val (cur, cnt) = q.remove()
        if (cur == target) return cnt

        words.forEachIndexed { i, word ->
            if(visited[i].not()) {
                var diff = 0
                word.forEachIndexed { index, c -> if (c != cur[index]) diff+=1 }
                if(diff == 1) {
                    q.add(Pair(word, cnt + 1))
                    visited[i] = true
                }
            }
        }
    }

    return 0
}
}