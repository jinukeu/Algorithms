class Solution {
    fun solution(elements: IntArray): Int {
    var answer = mutableSetOf<Int>()

    for (st in elements.indices) {
        var t = elements[st]
        answer.add(t)
        var end = st + 1
        while (end % elements.size != st) {
            t += elements[end % elements.size]
            answer.add(t)
            end++
        }
    }

    return answer.size
}
}