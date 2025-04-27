import kotlin.math.abs
import kotlin.math.min

var answer = Int.MAX_VALUE
var selectedIndexes = mutableListOf<Int>()
val ingredients = mutableListOf<Ingredient>()

fun main() {
    val n = readln().toInt()

    repeat(n) {
        val (s, b) = readln().split(" ").map { it.toInt() }
        ingredients.add(
            Ingredient(
                s = s,
                b = b,
            )
        )
    }

    backtracking(ingredients)
    println(answer)
}

fun backtracking(
    ingredients: List<Ingredient>,
) {
    if (selectedIndexes.isNotEmpty()) {
        var s = 0
        var b = 0
        for (i in selectedIndexes) {
            if (s == 0) {
                s = ingredients[i].s
            } else {
                s *= ingredients[i].s
            }
            b += ingredients[i].b
        }

        answer = min(answer, abs(s - b))
        if (selectedIndexes.size == ingredients.size) return
    }


    for (i in ingredients.indices) {
        if (i in selectedIndexes) continue
        selectedIndexes.add(i)
        backtracking(
            ingredients = ingredients,
        )
        selectedIndexes.removeLast()
    }
}

class Ingredient(
    val s: Int,
    val b: Int,
)