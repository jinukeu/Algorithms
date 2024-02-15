import kotlin.math.*
import kotlin.collections.*

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = Int.MAX_VALUE
        val graph = MutableList(n + 1) { mutableListOf<Int>() }
        
        wires.forEach { (a, b) ->
            graph[a].add(b)
            graph[b].add(a)
        }
        
        /*
        * 1 -> 3
        * 2 -> 3
        * 3 -> 1, 2, 4
        * 4 -> 3, 5, 6, 7
        * 5 -> 4
        * 6 -> 4
        * 7 -> 4, 8, 9
        * 8 -> 7
        * 9 -> 7
        */
        
        wires.forEach { (a, b) ->
            var ac = 0
            var bc = 0
            
            val q = ArrayDeque<Int>()
            val visited = MutableList<Boolean>(n + 1) { false }
            visited[b] = true
            q.add(a)
            ac += 1
            while (q.isNotEmpty()) {
                val next = q.removeFirst()
                if (visited[next]) continue
                visited[next] = true
                graph[next].forEach { n ->
                    if (visited[n].not()) {
                        ac += 1
                        q.add(n)
                    } 
                }
            }
            
            val q2 = ArrayDeque<Int>()
            val visited2 = MutableList<Boolean>(n + 1) { false }
            visited2[a] = true
            q2.add(b)
            bc += 1
            while (q2.isNotEmpty()) {
                val next = q2.removeFirst()
                if (visited2[next]) continue
                visited2[next] = true
                graph[next].forEach { n ->
                    if (visited2[n].not()) {
                        bc += 1
                        q2.add(n)
                    } 
                }
            }
            
            //println("a = $a b = $b")
            //println("ac = $ac bc = $bc")
            //println("---")
            answer = min(abs(ac - bc), answer)
        }
        
        return answer
    }
}