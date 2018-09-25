package com.hayashi2026.leetcode.dfs

class `Next Closest Time` {

//    fun nextClosestTime(time: String): String {
//        var minHour = Int.MAX_VALUE
//        var minMinute = Int.MAX_VALUE
//        val res = mutableListOf<String>()
//        dfs(time.removeRange(2, 3), StringBuilder(), res)
//        val hour = Integer.parseInt(time.substring(0, 2))
//        val minute = Integer.parseInt(time.substring(3))
//        for (r in res) {
//            val curHour = Integer.parseInt(r.substring(0, 2))
//            val curMinute = Integer.parseInt(r.substring(2))
//            if (curHour - hour >= 0) {
//                minHour = curHour - hour
//                minMinute = curMinute - minute
//            }
//        }
//    }
//
//    fun dfs(s: String, solution: StringBuilder, res: MutableList<String>) {
//        if (solution.length == 4) {
//            var hours = solution.substring(0, 2)
//            if (hours[0] == '0') {
//                hours = solution.substring(1, 2)
//            }
//            var minutes = solution.substring(2)
//            if (minutes[0] == '0') {
//                minutes = solution.substring(3)
//            }
//            if (Integer.parseInt(hours) in 0..23 && Integer.parseInt(minutes) in 0..59) {
//                res.add(solution.toString())
//            }
//            return
//        }
//        for (i in 0 until 4) {
//            solution.append(s[i])
//            dfs(s, solution, res)
//            solution.deleteCharAt(solution.lastIndex)
//        }
//    }
}