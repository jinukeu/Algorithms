class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
    var answer = intArrayOf()
    // 노란색을 먼저 그리고
    // 그 다음에 갈색을 그려보자.

    // 24 24
    // 노란색 :
    // 24 - 1줄
    // 12 - 2줄
    // 8 - 3줄
    // 6 - 4줄
    //
    for (width in 1 .. yellow) {
        if (yellow % width != 0) continue

        val height = yellow / width
        val brownCnt = (height + 2) * 2 + 2 * width
        if (brownCnt == brown) {
            return intArrayOf(height + 2, width + 2)
        }
    }


    return answer
}
}