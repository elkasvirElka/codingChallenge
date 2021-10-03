package edu.elvira.codingchallenge

class CodingChallenges {

    class Solution {

        /***
         * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
         * represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
         * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

        Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
        and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

        Return intervals after the insertion.

        Example 1:

        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
        Output: [[1,5],[6,9]]
         */
        fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
            val newIntervalAdded = intervals.toMutableList()
            newIntervalAdded.add(newInterval)
            return merge(newIntervalAdded.toTypedArray())
        }

        /**
         *
         * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
         * and return an array of the non-overlapping intervals that cover all the intervals in the input.
        Example 1:

        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
         */
        //n squared or nlogn
        fun merge(intervals: Array<IntArray>): Array<IntArray> {
            var sortedIntervals = intervals.sortedWith(compareBy { it.first() }).toMutableList()
            var index = 0
            try {
                while (index < sortedIntervals.size) {

                    val newInterval = newItemIfNeeded(sortedIntervals, index)
                    if (newInterval != null) {
                        sortedIntervals.add(index, newInterval)
                    } else {
                        index++
                    }
                }

            } catch (ex: Exception) {

            }

            return sortedIntervals.toTypedArray()
        }

        fun newItemIfNeeded(sortedIntervals: MutableList<IntArray>, index: Int): IntArray? {
            sortedIntervals.forEachIndexed { i, data ->
                if (index >= i)
                    return@forEachIndexed
                val currentItem = sortedIntervals.get(index)
                if (currentItem[1] >= data[0]) {
                    sortedIntervals.removeAt(index)
                    sortedIntervals.removeAt(i - 1)
                    return intArrayOf(currentItem[0], maxOf(data[1], currentItem[1]))
                } else {
                    return null
                }
            }
            return null
        }
    }

    class BattleTask{
        /**
         * Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.

        Battleships can only be placed horizontally or vertically on board. In other words,
        they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size.
        At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).
         */
        fun countBattleships(board: Array<CharArray>): Int {
            val dictionary = ArrayList<IntArray>()
            board.forEachIndexed { index, charArray ->
                charArray.forEachIndexed { i, item ->
                    if (item.equals('X')) {
                        dictionary.add(intArrayOf(i, index))
                    }
                }
            }

            return 0
        }

        fun getNumOfBattleship(dictionary: ArrayList<IntArray>){
            //go and check if for xi, yj we have some X on xi+1 OR on yj+ 1
        }
    }
}
