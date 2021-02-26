fun main() {
    val test = `Next Greater Element III`()
    println(test.nextGreaterElement(1999999999))
}

class `Next Greater Element III` {

    fun nextGreaterElement(n: Int): Int {
        val chars = n.toString().toCharArray()
        val nums = IntArray(chars.size)
        for (i in 0 until chars.size) {
            nums[i] = (chars[i] - '0').toInt()
        }
        var target = -1
        for (i in nums.size - 1 downTo 1) {
            if (nums[i - 1]  < nums[i]) {
                target = i - 1
                break
            }
        }
        if (target == -1) {
            return -1
        }
        var swapIndex = target
        for (i in target + 1 until nums.size) {
            if (nums[i] > nums[target]) {
                if (nums[swapIndex] == nums[i]) {
                    break
                }
                swapIndex = i
            } else {
                break
            }
        }
        swap(nums, target, swapIndex)
        reverse(nums, swapIndex + 1)
        var res = 0L
        for (i in 0 until nums.size) {
            res = res * 10 + nums[i]
        }
        return res.toInt()
    }

    fun swap(nums: IntArray, a: Int, b: Int) {
        val tmp = nums[a]
        nums[a] = nums[b]
        nums[b] = tmp
    }

    fun reverse(nums: IntArray, start: Int) {
        var left = start
        var right = nums.size - 1
        while (left < right) {
            val tmp = nums[left]
            nums[left] = nums[right]
            nums[right] = tmp
            left++
            right--
        }
    }
}