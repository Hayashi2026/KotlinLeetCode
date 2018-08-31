class ContainsDuplicateIII {

    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        var leftIndex = 0
        for (rightIndex in k until nums.size) {
            if (nums[rightIndex] - nums[leftIndex] == t) {
                return true
            }
            leftIndex++
        }
        return false
    }
}

fun main(args: Array<String>) {
    val data = intArrayOf(1,0,1,1)
    val test = ContainsDuplicateIII()
    println(test.containsNearbyAlmostDuplicate(data,1, 2))
}