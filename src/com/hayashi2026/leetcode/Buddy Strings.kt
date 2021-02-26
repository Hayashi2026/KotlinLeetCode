fun main() {
//    val test = `Buddy Strings`()
//    test.buddyStrings("aa", "aa")

    val scores = intArrayOf(1, 2, 3)
    val ages = intArrayOf(4, 5, 6)
    val players = scores.zip(ages) { a, b -> intArrayOf(a, b) }
    players
    println(players::class.simpleName)
    for (i in players) {
        println(i.joinToString(","))
    }

}

class `Buddy Strings` {

    fun buddyStrings(A: String, B: String): Boolean {
        if (A.length != B.length) {
            return false
        }
        val set = mutableSetOf<Char>()
        for (c in A) set.add(c)
        if (A == B && set.size < A.length) {
            return true
        }
        val list = mutableListOf<Int>()
        for (i in 0 until A.length) {
            if (A[i] != B[i]) {
                list.add(i)
            }
        }
        return list.size == 2 && A[list[0]] == B[list[1]] && A[list[1]] == B[list[0]]
    }


}