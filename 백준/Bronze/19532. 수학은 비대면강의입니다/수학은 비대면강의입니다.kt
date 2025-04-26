fun main() {
    val inputs = readln().split(" ").map { it.toInt() }
    var a = inputs[0]
    var b = inputs[1]
    var c = inputs[2]
    var d = inputs[3]
    var e = inputs[4]
    var f = inputs[5]

    for(x in -999 .. 999) {
        for (y in -999 .. 999) {
            if ((a * x + b * y == c) && (d * x + e * y == f)) {
                print("$x $y")
                return
            }
        }
    }
}