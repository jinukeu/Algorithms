import kotlin.math.max
import kotlin.math.min

class Solution {
fun solution(wallpaper: Array<String>): IntArray {
    var answer: IntArray = intArrayOf()

    val graph = mutableListOf<List<String>>()

    wallpaper.forEach {
        graph.add(it.split("").subList(1, it.length + 1))
    }

    var (li, lj) = (0 to 0)
    var (mi, mj) = (Int.MAX_VALUE to Int.MAX_VALUE)

    graph.forEachIndexed { i, strings ->
        strings.forEachIndexed { j, s ->
            if(s == "#") {
                li = max(li, i)
                lj = max(lj, j)

                mi = min(mi, i)
                mj = min(mj, j)
            }
        }
    }

    answer = answer.plus(mi).plus(mj).plus(li + 1).plus(lj + 1)

    return answer
}
}