import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Solution {
    fun solution(board: Array<String>): Int {
    var answer: Int = 0
    val graph = board.map {
        it.split("").filter { it != "" }
    }


    var ri: Int = 0
    var rj: Int = 0

    for(i in graph.indices) {
        for (j in graph[i].indices) {
            if (graph[i][j] == "R") {
                ri = i
                rj = j
            }
        }
    }

    val que = ArrayDeque<IntArray>()
    que.add(intArrayOf(ri, rj, 0))

    val dir = listOf(
        listOf(0, 1),
        listOf(0, -1),
        listOf(1, 0),
        listOf(-1, 0),
    )

    val visited = List(graph.size) { MutableList(graph[0].size) { false } }
    visited[ri][rj] = true

    while (que.isNotEmpty()) {
        val (ci, cj, cnt) = que.removeFirst()

//        for(i in graph.indices) {
//            for (j in graph[i].indices) {
//                if (i == ci && j == cj) {
//                    print("C" + " ")
//                } else {
//                    print(graph[i][j] + " ")
//                }
//            }
//            println()
//        }
//        println()

        if (graph[ci][cj] == "G") return cnt

        for ((di, dj) in dir) {
            var (ni, nj) = (ci + di to cj + dj)
            // 처음부터 길이 막혀있는 경우
            if (ni < 0 || ni >= graph.size || nj < 0 || nj >= graph[0].size) continue
            if (graph[ni][nj] == "D") continue
            // if (visited[ni][nj]) continue

            ni = ci
            nj = cj

            // D 또는 길이 막힐때까지 계속 이동
            while (true) {
                ni += di
                nj += dj

                if (ni < 0 || ni >= graph.size || nj < 0 || nj >= graph[0].size) break
                if (graph[ni][nj] == "D") break
            }

            if (visited[ni - di][nj - dj]) continue

            que.add(intArrayOf(ni - di, nj - dj, cnt + 1))
            visited[ni - di][nj - dj] = true
        }
    }

    return -1
}
}
