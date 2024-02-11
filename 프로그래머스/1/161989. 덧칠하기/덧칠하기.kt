class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
    var answer: Int = 0
    val sectionList = section.toMutableList()

    while (sectionList.isNotEmpty()) {
        val start = sectionList[0]
        answer += 1
        for(i in start until start + m) {
            if (i in sectionList) sectionList.remove(i)
        }

    }

    return answer
}
}