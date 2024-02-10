import java.util.*

class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
    val indexs = mutableMapOf<String, Int>()

    players.forEachIndexed { index, s ->
        indexs[s] = index
    }

    callings.forEach { call ->
        val index = indexs[call]!!
        
        val front = players[index - 1]
        
        indexs[call] = index - 1
        indexs[front] = index
        
        players[index] = players[index - 1]
        players[index - 1] = call
    }

    return players
}
}
