val ingredients = mutableListOf<Ingredient>()
val selectedIndexes = mutableListOf<Int>()
var answer: String = ""
var minCost = Int.MAX_VALUE

var mp: Int = 0
var mf: Int = 0
var ms: Int = 0
var mv: Int = 0

fun main() {
    val n = readln().toInt()
    val inputs = readln().split(" ").map { it.toInt() }

    mp = inputs[0]
    mf = inputs[1]
    ms = inputs[2]
    mv = inputs[3]

    repeat(n) {
        val (p, f, s, v, cost) = readln().split(" ").map { it.toInt() }
        ingredients.add(
            Ingredient(
                p, f, s, v, cost
            )
        )
    }

    backtracking(-1)

    if (minCost == Int.MAX_VALUE) {
        println(-1)
    } else {
        println(minCost)
        println(answer)
    }
}

fun backtracking(previous: Int) {
    if (selectedIndexes.isNotEmpty()) {
        var (sp, sf, ss, sv, sc) = listOf(0,0,0,0,0)

        for (i in selectedIndexes) {
            val ingredient = ingredients[i]
            sp += ingredient.p
            sf += ingredient.f
            ss += ingredient.s
            sv += ingredient.v
            sc += ingredient.cost
        }

        if (sp >= mp && sf >= mf && ss >= ms && sv >= mv && sc < minCost) {
            answer = selectedIndexes.sorted().map { it + 1 }.joinToString(" ")
            minCost = sc
        }
    }

    for (i in previous + 1 ..< ingredients.size) {
        if (i in selectedIndexes) continue
        selectedIndexes.add(i)
        backtracking(i)
        selectedIndexes.removeLast()
    }
}

data class Ingredient(
    val p: Int,
    val f: Int,
    val s: Int,
    val v: Int,
    val cost: Int,
)