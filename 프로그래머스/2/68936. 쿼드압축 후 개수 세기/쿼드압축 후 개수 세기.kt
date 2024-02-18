class Solution {
    var zero: Int = 0
var one: Int = 0

fun solution(arr: Array<IntArray>): IntArray {
    var answer: IntArray = intArrayOf()
    qud(0, arr.size, 0, arr.size, arr)
    return intArrayOf(zero, one)
}

fun qud(startI: Int, endI: Int, startJ: Int, endJ: Int, arr: Array<IntArray>) {
    if(endI - startI == 1) {
        if (arr[startI][startJ] == 1) one += 1
        else zero += 1
        return
    }

    var tempZero = 0
    for (i in startI until endI) {
        for (j in startJ until endJ) {
            if(arr[i][j] == 0) tempZero += 1
        }
    }

    // 1로 압축 가능함
    if (tempZero == 0) {
        one += 1
        return
    }

    if (tempZero == (endI - startI) * (endI - startI)) {
        zero += 1
        return
    }

    val d = (endI - startI) / 2
    qud(startI, startI + d, startJ, startJ + d, arr)
    qud(startI + d, endI, startJ, startJ + d, arr)
    qud(startI, startI + d, startJ + d, endJ, arr)
    qud(startI + d, endI, startJ + d, endJ, arr)
}

}