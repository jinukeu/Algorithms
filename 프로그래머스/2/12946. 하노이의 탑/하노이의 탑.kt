class Solution {
    fun solution(n: Int): Array<IntArray> {
        var answer = mutableListOf<IntArray>()
        hanoi(n, 1, 3, answer)
        return answer.toTypedArray()
    }
    
    fun hanoi(n: Int, from: Int, to: Int, array: MutableList<IntArray>) {
        if (n == 1) {
            array.add(intArrayOf(from, to))
            return
        }
        hanoi(n - 1, from, 6 - from - to, array)
        array.add(intArrayOf(from, to))
        hanoi(n - 1, 6 - from - to, to, array)
    }
}