package com.hayashi2026.leetcode.binarysearch;

public class SearchInASortedArrayOfUnknownSize {

    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 0;
        while (reader.get(end) < target) {
            end++;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int value = reader.get(mid);
            if (value < target) {
                start = mid + 1;
            } else if (value > target) {
                end = mid - 1;
            } else {
                return value;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }

    static class ArrayReader {
        public int get(int i) {
            return 0;
        }
    }
}
