class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val clotheMap = mutableMapOf<String, Int>()
        
        clothes.forEach { clothe -> 
            clotheMap[clothe[1]] = run {
                if (clotheMap[clothe[1]] == null) 1
                else clotheMap[clothe[1]]!! + 1
            }
        }
        
        println(clotheMap)
        
        clotheMap.values.forEach { v -> 
            answer *= (v + 1)
        }
        
        return answer - 1
    }
}