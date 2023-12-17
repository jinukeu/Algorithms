import java.util.*

class Solution {
    fun solution(maps: Array<String>): IntArray {
    var answer = mutableListOf<Int>()
    val dir = listOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0),
    )

    val graph = maps.map { it.split("").filter { it != "" } }
    val c = graph[0].size
    val r = graph.size

    val visited = MutableList(r) { MutableList(c) { false } }

    for(i in 0 until r) {
        for(j in 0 until c) {
            if(visited[i][j] || graph[i][j] == "X") continue

            val q: Queue<IntArray> = LinkedList()
            q.add(intArrayOf(i, j))
            visited[i][j] = true
            var sum = 0
            while (q.isNotEmpty()) {
                val (ci, cj) = q.remove()
                sum += graph[ci][cj].toInt()

                for ((di, dj) in dir) {
                    val (ni, nj) = (ci + di to cj + dj)
                    if(ni in 0 until r && nj in 0 until c && graph[ni][nj] != "X" && visited[ni][nj].not()) {
                        q.add(intArrayOf(ni, nj))
                        visited[ni][nj] = true
                    }
                }
            }

            answer.add(sum)
        }
    }

    answer.sort()

    return if(answer.isEmpty()) intArrayOf(-1) else answer.toIntArray()
}
}