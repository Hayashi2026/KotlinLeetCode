import java.util.*

class ContainsDuplicateIII {

    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        val treeSet = TreeSet<Int>()
        for (i in 0 until nums.size) {
            if (i > k) {
                treeSet.remove(nums[i - k - 1])
            }
            val floor = treeSet.floor(nums[i])
            val ceiling = treeSet.ceiling(nums[i])
            if ((floor != null && nums[i].toLong() - floor <= t) || (ceiling != null && ceiling - nums[i].toLong() <= t)) {
                return true
            }
            treeSet.add(nums[i])
        }
        return false
    }

}

fun main(args: Array<String>) {
    val test = ContainsDuplicateIII()
    println(test.containsNearbyAlmostDuplicate(intArrayOf(1,5,9,1,5,9), 2, 3))
}