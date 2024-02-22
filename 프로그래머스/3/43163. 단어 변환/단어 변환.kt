class Solution {
fun solution(begin: String, target: String, words: Array<String>): Int {
    val word = words.toMutableSet()
    val que = ArrayDeque<Pair<String, Int>>()
    que.add(Pair(begin, 1))

    while (que.isNotEmpty()) {
        val (n, cnt) = que.removeFirst()
        word.remove(n)
        if (n == target) return cnt - 1

        word.toList().forEach { w ->
            if(canChange(n, w)) {
                que.add(Pair(w, cnt + 1))
            }
        }
    }

    return 0
}

fun canChange(n: String, w: String): Boolean {
    var strangeCnt = 0
    for (i in n.indices) {
        if (n[i] != w[i]) strangeCnt += 1
    }
    
    return strangeCnt == 1
}
}