class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0
 
        for(i in 0 until nums.size) {
            for(j in i + 1 until nums.size) {
                for(l in j + 1 until nums.size) {
                    if(isSosu(nums[i] + nums[j] + nums[l])) {
                        answer += 1
                    }
                }
            }
        }

        return answer
    }
    
    fun isSosu(n: Int): Boolean {
        for(i in 2 until n) {
            if(n % i == 0) return false
        }
        return true
    }
}