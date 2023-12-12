class Solution {
    fun solution(left: Int, right: Int): Int {
    var answer: Int = 0
    
    for(i in left .. right) {
        if(d(i)) answer += i else answer -= i
    }
    
    return answer
}

fun d(n: Int): Boolean {
    var a = 0
    for(i in 1 .. n) {
        if(n % i == 0) a++
    }
    
    return a % 2 == 0
}
}