package com.hayashi2026.leetcode.bfs

import java.util.*
import kotlin.collections.HashSet

class `Word Ladder` {

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        var depth = 1
        val wordSet = HashSet(wordList)
        val markSet = hashSetOf<String>()
        val queue = LinkedList<String>()
        queue.add(beginWord)
        markSet.add(beginWord)
        while (!queue.isEmpty()) {
            val size = queue.size
            depth++
            for (k in 0 until size) {
                val head = queue.poll()
                for (i in 'a' until 'z') {
                    for (j in 0 until head.length) {
                        val nextWord = head.replaceRange(j, j + 1, i.toString())
                        if (wordSet.contains(nextWord) && !markSet.contains(nextWord)) {
                            if (nextWord == endWord) {
                                return depth
                            }
                            queue.offer(nextWord)
                            markSet.add(nextWord)
                        }
                    }
                }
            }
        }
        return 0
    }
}