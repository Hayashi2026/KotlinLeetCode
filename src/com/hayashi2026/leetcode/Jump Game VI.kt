import java.util.*
import kotlin.Comparator

fun main() {
    val test = `Jump Game VI`()
    println(test.maxResult(intArrayOf(1,-1,-2,4,-7,3), 2))
}

class `Jump Game VI` {

    fun maxResult(nums: IntArray, k: Int): Int {
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        val queue = PriorityQueue<Int>(Comparator { a, b ->
            b - a
        })
        queue.offer(dp[0])
        for (i in 1 until nums.size) {
            val pre = queue.peek()
            dp[i] = pre + nums[i]
            if (queue.size == k) {
                queue.poll()
            }
            queue.offer(dp[i])
        }
        return dp[nums.size - 1]
    }
}