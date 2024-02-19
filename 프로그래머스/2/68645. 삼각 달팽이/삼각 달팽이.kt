class Solution {
fun solution(n: Int): IntArray {
    var answer: IntArray = intArrayOf()

    /**
     * 1
     * 2 9
     * 3 10 8
     * 4 5 6 7
     */

    /**
     * 밑으로 내려갈 때는 i += 1
     * 옆으로 갈 때는 j += 1
     * 위로 올라갈 때는 i -= 1, j -= 1
     */

    /**
     * 1. 일단 전부 0인 배열을 만든다.
     * 2. 아래로 내려간다.
     */

    val graph = mutableListOf<MutableList<Int>>()

    repeat(n) {
        graph.add(MutableList(it + 1) { 0 })
    }

    var (ci, cj) = (0 to 0)
    var v = 1
    var dir = Direction.DOWN
    var nextDirCnt = 0

    while (true) {
        if (ci < 0 || ci >= graph.size || cj < 0 || cj >= graph[ci].size || graph[ci][cj] != 0) {
            ci -= dir.di
            cj -= dir.dj
            dir = nextDir(dir)
            nextDirCnt += 1
        } else if (graph[ci][cj] == 0) {
            graph[ci][cj] = v++
            nextDirCnt = 0
        }

        ci += dir.di
        cj += dir.dj

        if (nextDirCnt == 3) return graph.flatMap { it }.toIntArray()
    }
}

enum class Direction(val di: Int, val dj: Int) {
    DOWN(1, 0), RIGHT(0, 1), UP(-1, -1)
}

fun nextDir(dir: Direction): Direction = when (dir) {
    Direction.DOWN -> Direction.RIGHT
    Direction.RIGHT -> Direction.UP
    Direction.UP -> Direction.DOWN
}
}