fun main() {
    val test = `Maximum Number of Visible Points`()
    println(test.visiblePoints(listOf(listOf(0,0), listOf(0,2)), 90,listOf(1,1)))
}


class `Maximum Number of Visible Points` {

    fun visiblePoints(points: List<List<Int>>, angle: Int, location: List<Int>): Int {
        val angles = mutableListOf<Double>()
        var same = 0
        for (point in points) {
            val dx = point[0] - location[0]
            val dy = point[1] - location[1]
            if (dx == 0 && dy == 0) {
                same++
            } else {
                val a = Math.atan2(dy.toDouble(), dx.toDouble()) * 180 / Math.PI
                angles.add((a + 360) % 360)
            }
        }
        angles.sort()
        var max = 0
        for (i in 0 until angles.size) {
            var j = 0
            while (angles[i] - angles[j] > angle) {
                j++
            }
            max = Math.max(max, i - j + 1)

        }
        return same + max
    }
}