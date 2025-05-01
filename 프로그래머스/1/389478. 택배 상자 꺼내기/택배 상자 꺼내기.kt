import kotlin.math.max

class Solution {
    fun solution(n: Int, w: Int, num: Int): Int {
        var answer: Int = 1

        val boxes = mutableListOf<List<Int>>()

        var i = 1
        var si = 0
        var sj = 0
        var start = 1
        var end = start + w
        while(true) {
            val line = if (i % 2 == 1) {
                (start until end).toList()
            } else {
                ((end- 1) downTo  start).toList()
            }

            boxes.add(line)
            if (num in line) {
                si = i - 1
                sj = line.indexOf(num)
            }
            if (end - w >= n) break

            start += w
            end += w
            i += 1
        }

        boxes.forEach {
            println(it)
        }

        for (j in si + 1 until boxes.size) {
            if (boxes[j][sj] <= n) answer += 1
        }

        println(answer)

        return answer
    }
}