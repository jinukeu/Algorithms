import java.util.*
import kotlin.math.abs
import kotlin.math.min

class Solution {
fun solution(n: Int, wires: Array<IntArray>): Int {
    var answer: Int = Int.MAX_VALUE

    wires.forEach { (ra, rb) ->
        val graph = MutableList(n + 1) { mutableListOf<Int>() }

        wires.forEach { (a, b) ->
            graph[a].add(b)
            graph[b].add(a)
        }

        graph[ra].remove(rb)
        graph[rb].remove(ra)

        val visited = MutableList(n + 1) { false }
        val pq: Queue<Int> = LinkedList<Int>()

        pq.add(ra)
        visited[ra] = true
        var c = 1

        while (pq.isNotEmpty()) {
            val n = pq.poll()
            graph[n].forEach {
                if(visited[it].not()) {
                    c += 1
                    visited[it] = true
                    pq.add(it)
                }
            }
        }


        answer = min(answer, abs(n - c - c))

//        println("$ra $rb 끊음")
//        graph.forEach { println(it) }
//        println("${c} - ${n - c} =  ${abs(n - c - c)}")
//        println("---")


    }
        return answer
}
}