class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
    val graph = MutableList(n + 1) { mutableListOf<Int>() }
    val count = MutableList(n + 1) { 0 }

    edge.forEach { (a, b) ->
        graph[a].add(b)
        graph[b].add(a)
    }

    val stack = mutableListOf(1)

    while (stack.isNotEmpty()) {
        val node = stack.removeFirst()
        for(next in graph[node]) {
            if(count[next] != 0 || next == 1) continue
            count[next] = count[node] + 1
            stack.add(next)
        }
    }
    
    val m = count.maxOf { it }
    count.count{ it == m}
    return count.count { it == m}
}
}