package string

fun main() {
    val partitionLabels = `Partition Labels`()
    partitionLabels.partitionLabels("ababcbacadefegdehijhklij")
}

class `Partition Labels` {

    fun partitionLabels(S: String): List<Int> {
        val map = mutableMapOf<Char, IntArray>()
        for (i in 0 until S.length) {
            val c = map[S[i]]
            if (c == null) {
                map[S[i]] = intArrayOf(i, i)
            } else {
                map[S[i]] = intArrayOf(c[0], i)
            }
        }
        val arr = map.values.toMutableList()
        arr.sortWith(Comparator { a, b ->
            a[0] - b[0]
        })
        val intervals = mutableListOf<IntArray>()
        var start = arr[0][0]
        var end = arr[0][1]
        for (i in 0 until arr.size) {
            if (arr[i][0] > end) {
                intervals.add(intArrayOf(start, end))
                start = arr[i][0]
                end = arr[i][1]
            } else {
                end = Math.max(arr[i][1], end)
            }
        }
        intervals.add(intArrayOf(start, end))
        val res = mutableListOf<Int>()
        for (i in 0 until intervals.size) {
            res.add(intervals[i][1] - intervals[i][0] + 1)
        }
        return res.toList()
    }
}