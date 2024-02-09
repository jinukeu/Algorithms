class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
    val answer = mutableListOf<Int>()
    val dict = mutableMapOf<String, Int>()
    
    for(i in 0 until name.size) {
        dict[name[i]] = yearning[i]
    }
    
    photo.forEach { p ->
        var s = 0
        p.forEach { 
            s += dict[it] ?: 0
        }
        answer.add(s)
    }
    
    
    
    return answer.toIntArray()
}
}