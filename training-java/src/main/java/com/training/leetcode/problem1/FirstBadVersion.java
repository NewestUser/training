package com.training.leetcode.problem1;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately,
 * the latest version of your product fails the quality check. Since each version is developed based on
 * the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the
 * following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to
 * find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1, bad = 1
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * 1 <= bad <= n <= 231 - 1
 */
public class FirstBadVersion {

    private final int badVersion;

    public FirstBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    public int firstBadVersion(int n) {
        return checkRangeRecursive(1, n);
//        return checkRangeIterative(1, n);
    }

    private int checkRangeRecursive(long start, long end) {
        if (start == end) {
            if (isBadVersion((int) start)) {
                return (int) start;
            }
            return -1;
        }

        if (end - start == 1) {
            if (isBadVersion((int) start)) {
                return (int) start;
            } else if (isBadVersion((int) end)) {
                return (int) end;
            } else {
                return -1;
            }
        }

        // 1 2 3 -> (3 - 1 + 2) / 2 = 2 -> offset
        // 1 2 3 4 5 -> (5 - 1 + 2) / 2 = 3 -> offset
        // 1 2 3 4 5 6 7 -> (7 - 1 + 2) / 2 = 4 -> offset
        // 1 2 3 4 -> (4 - 1 + 2) / 2 = 2 -> offset
        // 1 2 3 4 5 6 -> (6 - 1 + 2) / 2 = 3 -> offset
        // 2 3 4 5 6 7 -> (7 - 2 + 2) / 2 = 3 -> offset
        // 3 4 5 -> (5 - 3 + 2) / 2 = 2 -> offset

        // compute the offset for the middle item to be checked
        // we add 2 because while computing the offset we count the first and last items
        // offset needs to be of type long because it can overflow because of + 2
        long offset = (end - start + 2) / 2;
        long mid = (start + offset - 1); // we subtract 1 because the offset includes the start item (it is 1 based and not 0 based)

        if (isBadVersion((int) mid)) {
            return checkRangeRecursive(start, mid);
        } else {
            return checkRangeRecursive(mid, end);
        }
    }

    private int checkRangeIterative(long start, long end) {
        long nextStart = start;
        long nextEnd = end;

        while (true) {
            if (nextStart == nextEnd) {
                if (isBadVersion((int) nextStart)) {
                    return (int) nextStart;
                }
                return -1;
            }

            if (nextEnd - nextStart == 1) {
                if (isBadVersion((int) nextStart)) {
                    return (int) nextStart;
                } else if (isBadVersion((int) nextEnd)) {
                    return (int) nextEnd;
                } else {
                    return -1;
                }
            }

            long offset = (nextEnd - nextStart + 2) / 2;
            int mid = (int) (nextStart + offset - 1);

            if (isBadVersion(mid)) {
                nextEnd = mid;
            } else {
                nextStart = mid;
            }
        }
    }

    private boolean isBadVersion(int n) {
        return n >= badVersion;
    }

}
