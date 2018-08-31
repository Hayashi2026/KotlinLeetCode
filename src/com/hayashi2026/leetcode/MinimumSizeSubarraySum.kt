class MinimumSizeSubarraySum {

    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        var leftIndex = 0
        var minLength = Integer.MAX_VALUE
        var sum = 0
        for (i in 0 until nums.size) {
            sum += nums[i]
            while (sum >= s) {
                if (i - leftIndex + 1 < minLength) {
                    minLength = i - leftIndex + 1
                }
                sum -= nums[leftIndex]
                leftIndex++
            }
        }
        return if (minLength == Int.MAX_VALUE) 0 else minLength
    }
}

fun main(args: Array<String>) {
    val testArray = intArrayOf(2,3,1,2,4,3)
    val test = MinimumSizeSubarraySum()
    println(test.minSubArrayLen(7, testArray))
}