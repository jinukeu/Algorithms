class Solution {
fun solution(n: Int, a: Int, b: Int): Int {
    var answer = 1

    var ra = a
    var rb = b

    // 1. ra, rb 둘중 하나만 홀수
    // 2. 짝수인 것은 홀수보다 1이 커야함.

    var condition = true

    // ra 짝수, rb 홀수
    if(ra % 2 == 0 && rb % 2 == 1 && rb + 1 == ra) condition = false

    if(rb % 2 == 0 && ra % 2 == 1 && ra + 1 == rb) condition = false

    while (condition) {
        answer += 1
        if(ra % 2 == 0) {
            ra /= 2
        } else {
            ra = (ra + 1) / 2
        }

        if(rb % 2 == 0) {
            rb /= 2
        } else {
            rb = (rb + 1) / 2
        }

        // ra 짝수, rb 홀수
        if(ra % 2 == 0 && rb % 2 == 1 && rb + 1 == ra) condition = false

        if(rb % 2 == 0 && ra % 2 == 1 && ra + 1 == rb) condition = false


    }


    return answer
}
}