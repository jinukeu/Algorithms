import kotlin.math.ceil


class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
    var answer: IntArray = intArrayOf()
    // Pair first : 들어온 시각 second : 누적 시간
    val dict = mutableMapOf<Int, Pair<Int, Int>>()
    val defaultTime = fees[0]
    val defaultFee = fees[1]
    val timeUnit = fees[2]
    val fee = fees[3]

    records.map { it.split(" ") }.forEach { (t, num, command) ->
        val time = run {
            val (h, m) = t.split(":").map { it.toInt() }
            h * 60 + m
        }

        if (command == "IN") {
            val info = dict.getOrPut(num.toInt()) { Pair(time, 0) }
            dict[num.toInt()] = Pair(time, info.second)
        } else {
            val (inTime, totalTime) = dict.getOrPut(num.toInt()) { Pair(time, 0) }
            dict[num.toInt()] = Pair(-1, totalTime + time - inTime)
        }
    }

    return dict.keys.toMutableList().sorted().map {
        var totalTime = dict[it]!!.second
        if (dict[it]!!.first != -1) {
            totalTime += (23 * 60 + 59) - dict[it]!!.first
        }
        val add = if (totalTime - defaultTime > 0) ceil((totalTime - defaultTime) / timeUnit.toFloat()).toInt() * fee else 0
        defaultFee + add
    }.toIntArray()
}
}