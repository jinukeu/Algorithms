class Solution {
    var zero = 0
var one = 0

fun solution(arr: Array<IntArray>): IntArray {
    var answer: IntArray = intArrayOf()
    qud(arr, 0, arr[0].size, 0, arr.size)
    return intArrayOf(zero, one)
}

fun qud(arr:Array<IntArray>, startX: Int, endX: Int, startY: Int, endY: Int) {
    if(endX - startX == 1) {
        if(arr[startY][startX] == 0) zero += 1 else one += 1
        return
    }

    var tzero = 0
    var tone = 0

   for(x in startX until endX)
       for(y in startY until endY) {
           if(arr[y][x] == 0) tzero += 1 else tone += 1
       }

    if(tzero == (endX - startX) * (endY - startY)) {
        zero += 1
        return
    }

    if(tone == (endX - startX) * (endY - startY)) {
        one += 1
        return
    }

    for(nx in startX until endX step (endX - startX) / 2) {
        for(ny in startY until endY step (endX - startX) / 2) {
            qud(arr, nx, nx + (endX - startX) / 2, ny, ny + (endY - startY) / 2)
        }
    }
}
}