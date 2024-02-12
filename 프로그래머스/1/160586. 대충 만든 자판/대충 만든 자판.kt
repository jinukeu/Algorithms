import kotlin.math.min


class Solution {
fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
    var answer = mutableListOf<Int>()

    val keyDict: MutableMap<Char, Int> = mutableMapOf()

    keymap.forEach { keys ->
        keys.forEachIndexed { index, key ->
            keyDict[key] = min(keyDict.getOrDefault(key, Int.MAX_VALUE), index + 1)
        }
    }

    targets.forEach { target ->
        var sum = 0
        for (c in target) {
            val v = keyDict[c]
            if (v == null) {
                sum = -1
                break
            }
            sum += v
        }
        answer.add(sum)
    }

    return answer.toIntArray()
}
}