package com.codingpan.leetcode.passedOJ;

public class LC1033MovingStonesUntilConsecutive {
    /**
     * hree stones are on a number line at positions a, b, and c.
     *
     * <p>Each turn, let's say the stones are currently at positions x, y, z with x < y < z. You pick
     * up the stone at either position x or position z, and move that stone to an integer position k,
     * with x < k < z and k != y.
     *
     * <p>The game ends when you cannot make any more moves, ie. the stones are in consecutive
     * positions.
     *
     * <p>When the game ends, what is the minimum and maximum number of moves that you could have
     * made? Return the answer as an length 2 array: answer = [minimum_moves, maximum_moves] Example
     * 1:
     *
     * <p>Input: a = 1, b = 2, c = 5 Output: [1, 2] Explanation: Move stone from 5 to 4 then to 3, or
     * we can move it directly to 3. Example 2:
     *
     * <p>Input: a = 4, b = 3, c = 2 Output: [0, 0] Explanation: We cannot make any moves.
     *
     * <p>Note:
     *
     * <p>1 <= a <= 100 1 <= b <= 100 1 <= c <= 100 a != b, b != c, c != a
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int[] numMovesStones(int a, int b, int c) {
        // idea 1
        // start range: z - x, end range 2, -> maxsteps = z - x - 2
        // min steps
        // case 0. xyz...., 0 step (z - x == 2)
        // case 1. xy.....z, x.....yz..., 1 step (y - x = 1 or z - y = 1)
        // case 2. x.y......z, x..y.z..., 1 step (y - x = 2 or z - y = 2) for x..y.z, we can move x in
        // between y and z with 1 step
        // case 3. x....y.....z, 2 steps
        int x = getMin(a, b, c);
        int z = getMax(a, b, c);
        int y = a + b + c - x - z;
        if (x + 2 == z) {
            return new int[]{0, 0};
        } // case 0
        if (y - x <= 2 || z - y <= 2) return new int[]{1, z - x - 2}; // case 1, 2
        return new int[]{2, z - x - 2}; // case 3
    }

    private int getMin(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

    private int getMax(int a, int b, int c) {
        int max = Math.max(a, b);
        return Math.max(max, c);
    }

    // idea 2
    // start from 2 stones case
    // min / max steps
    // case 0. xy......, {0, 0} step
    // case 1. x.....y.., {1, y - x - 1} step
    // expand to 3 stones case
    // find continous size<=3 holes,

    // ideas from lee215 https://www.youtube.com/watch?v=Gwp8hL2F6c0
}
