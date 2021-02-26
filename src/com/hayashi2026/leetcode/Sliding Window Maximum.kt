import java.util.*

fun main() {
    val test = `Sliding Window Maximum`()
    test.maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7), 3)
}

class `Sliding Window Maximum` {

    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val deque = LinkedList<Int>()
        for (i in 0 until k) {
            while (deque.isNotEmpty() && nums[deque.last] < nums[i]) {
                deque.removeLast()
            }
            deque.offerLast(i)
        }
        val res = IntArray(nums.size - k + 1)
        res[0] = nums[deque.first]
        for (i in k until nums.size) {
            if (deque.first == i - k) deque.removeFirst()
            while (deque.isNotEmpty() && nums[deque.last] < nums[i]) {
                deque.removeLast()
            }
            deque.offerLast(i)
            res[i - k + 1] = nums[deque.first]
        }
        return res
    }
}