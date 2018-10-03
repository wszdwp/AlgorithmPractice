package com.codingpan.gg2018Autumn;

import java.util.*;

public class GG2018Autumn {

    /**
     * contest 85
     * [839. Similar String Groups](https://leetcode.com/problems/similar-string-groups/description/)
     * Two strings X and Y are similar if we can swap two letters (in different positions) of X,
     * so that it equals Y.
     * For example, "tars" and "rats" are similar (swapping at positions 0 and 2),
     * and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts"
     *
     * Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.
     * Notice that "tars" and "arts" are in the same group even though they are not similar.
     * Formally, each group is such that a word is in the group if and only if it is similar to
     * at least one other word in the group.
     * We are given a list A of strings.  Every string in A is an anagram of every other string in A.
     *
     * How many groups are there?

     * Example 1:
     * Input: ["tars","rats","arts","star"]
     * Output: 2
     * Note:
     * A.length <= 2000
     * A[i].length <= 1000
     * A.length * A[i].length <= 20000
     * All words in A consist of lowercase letters only.
     * All words in A have the same length and are anagrams of each other.
     * The judging time limit has been increased for this question.
     * @param
     * @return
     */
    class SimilarStringGroup {
        public int numSimilarGroups(String[] A) {
            int n = A.length;
            DJSet ds = new DJSet(n);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (ok(A[i], A[j])) {
                        ds.union(i, j);
                    }
                }
            }
            return ds.count();
        }

        public boolean ok(String a, String b) {
            int diff = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    diff++;
                }
            }
            return diff <= 2;
        }

        class DJSet {
            public int[] upper;

            public DJSet(int n) {
                upper = new int[n];
                Arrays.fill(upper, -1);
            }

            public int root(int x) {
                return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
            }

            public boolean equiv(int x, int y) {
                return root(x) == root(y);
            }

            public boolean union(int x, int y) {
                x = root(x);
                y = root(y);
                if (x != y) {
                    if (upper[y] < upper[x]) {
                        int d = x;
                        x = y;
                        y = d;
                    }
                    upper[x] += upper[y];
                    upper[y] = x;
                }
                return x == y;
            }

            public int count() {
                int ct = 0;
                for (int u : upper)
                    if (u < 0)
                        ct++;
                return ct;
            }
        }
    }

    /**
     * contest 79
     * [bus route]
     *
     * uwi
     */
    class BusRoute {
        public int numBusesToDestination(int[][] routes, int S, int T) {
            if(S == T)return 0;

            int n = routes.length;
            List<Set<Integer>> sets = new ArrayList<>();
            for(int i = 0;i < n;i++){
                Set<Integer> set = new HashSet<>();
                for(int v : routes[i]){
                    set.add(v);
                }
                sets.add(set);
            }

            boolean[][] g = new boolean[n][n];
            for(int i = 0;i < n;i++){
                inner:
                for(int j = 0;j < n;j++){
                    if(i == j)continue;
                    for(int v : routes[i]){
                        if(sets.get(j).contains(v)){
                            g[i][j] = true;
                            continue inner;
                        }
                    }
                }
            }

            int[] d = new int[n];
            Queue<Integer> q = new ArrayDeque<>();
            Arrays.fill(d, 99999999);
            for(int i = 0;i < n;i++){
                if(sets.get(i).contains(S)){
                    q.add(i);
                    d[i] = 0;
                }
            }

            while(!q.isEmpty()){
                int cur = q.poll();
                for(int i = 0;i < n;i++){
                    if(g[cur][i] && d[i] > d[cur] + 1){
                        d[i] = d[cur] + 1;
                        q.add(i);
                    }
                }
            }

            int ret = 99999999;
            for(int i = 0;i < n;i++){
                if(sets.get(i).contains(T)){
                    ret = Math.min(ret, d[i]);
                }
            }

            if(ret > 99990000){
                return -1;
            }
            return ret+1;
        }

    }

    /**
     * ctx 64
     * [753 cracking the safe]
     * User Accepted: 67
     * User Tried: 117
     * Total Accepted: 67
     * Total Submissions: 301
     * Difficulty: Hard
     *
     * There is a box protected by a password. The password is n digits,
     * where each letter can be one of the first k digits 0, 1, ..., k-1
     *
     * You can keep inputting the password, the password will automatically be matched against
     * the last n digits entered.
     *
     * For example, assuming the password is "345", I can open it when I type "012345",
     * but I enter a total of 6 digits.
     *
     * Please return any string of minimum length that is guaranteed to open the box after the entire string is inputted.
     *
     * Example 1:
     * Input: n = 1, k = 2
     * Output: "01"
     * Note: "10" will be accepted too.
     *
     * Example 2:
     * Input: n = 2, k = 2
     * Output: "00110"
     *
     * Note: "01100", "10011", "11001" will be accepted too.
     * Note:
     * n will be in the range [1, 4].
     * k will be in the range [1, 10].
     * k^n will be at most 4096.
     */
    class CrackingSafe {    //uwi
        int n, k;
        int[] a;
        StringBuilder sb = new StringBuilder();

        void db(int t, int p)
        {
            if(t > n){
                if(n % p == 0){
                    for(int i = 1;i <= p;i++){
                        sb.append(a[i]);
                    }
                }
            }else{
                a[t] = a[t-p];
                db(t+1, p);
                for(int j = a[t-p] + 1;j < k;j++){
                    a[t] = j;
                    db(t+1, t);
                }
            }
        }

        public String crackSafe(int n, int k) {
            a = new int[n*k];
            this.n = n; this.k = k;
            if(k == 1){
                sb.append("0");
            }else{
                db(1, 1);
            }
            for(int i = 0;i < n-1;i++){
                sb.append(0);
            }

            return sb.toString();
        }
    }

    /**
     * ctx 51
     * [684. Redundant Connection]
     */
    class RedundantConnection {
        int n = 10000;

        public int[] findRedundantConnection(int[][] edges) {
            upper = new int[n];
            Arrays.fill(upper, -1);
            for(int[] e : edges){
                if(union(e[0], e[1])){
                    return e;
                }
            }
            return null;
        }

        public int[] upper;

        public int root(int x) {
            return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
        }

        public boolean equiv(int x, int y) {
            return root(x) == root(y);
        }

        public boolean union(int x, int y) {
            x = root(x);
            y = root(y);
            if (x != y) {
                if (upper[y] < upper[x]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                upper[x] += upper[y];
                upper[y] = x;
            }
            return x == y;
        }

        public int count() {
            int ct = 0;
            for (int u : upper)
                if (u < 0)
                    ct++;
            return ct;
        }
    }

    /**
     * ctx 17
     * [mazeIII]
     */

    class MazeIII {
        private class State implements Comparable<State> {
            int r;
            int c;
            int dir;
            int distance;
            String path;

            public State(int r, int c, int dir, int distance, String path) {
                this.r = r;
                this.c = c;
                this.dir = dir;
                this.distance = distance;
                this.path = path;
            }

            @Override
            public int compareTo(State o) {
                if (this.distance != o.distance) {
                    return Integer.compare(this.distance, o.distance);
                }

                return this.path.compareTo(o.path);
            }
        }

        private int[] DIR_R = {-1, 0, 1, 0};
        private int[] DIR_C = {0, 1, 0, -1};
        private char[] DIR_NAME = {'u', 'r', 'd', 'l'};

        public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
            int n = maze.length;
            int m = maze[0].length;
            int[][][] visited = new int[4][n][m];

            PriorityQueue<State> q = new PriorityQueue<State>();
            int r = ball[0];
            int c = ball[1];
            for (int i = 0; i < 4; i++) {
                int tr = r + DIR_R[i];
                int tc = c + DIR_C[i];
                if (tr >= 0 && tr < n && tc >= 0 && tc < m && maze[tr][tc] == 0) {
                    q.add(new State(tr, tc, i, 1, new String("" + DIR_NAME[i])));
                    visited[i][tr][tc] = 1;
                }
            }

            while (!q.isEmpty()) {
                State s = q.poll();
                if (s.r == hole[0] && s.c == hole[1]) {
                    return s.path;
                }

                int tr = s.r + DIR_R[s.dir];
                int tc = s.c + DIR_C[s.dir];
                if (tr >= 0 && tr < n && tc >= 0 && tc < m && maze[tr][tc] == 0) {
                    if (visited[s.dir][tr][tc] == 0) {
                        q.add(new State(tr, tc, s.dir, s.distance + 1, s.path));
                        visited[s.dir][tr][tc] = 1;
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        tr = s.r + DIR_R[i];
                        tc = s.c + DIR_C[i];
                        if (tr >= 0 && tr < n && tc >= 0 && tc < m && maze[tr][tc] == 0) {
                            if (visited[i][tr][tc] == 0) {
                                q.add(new State(tr, tc, i, s.distance + 1, s.path + DIR_NAME[i]));
                                visited[i][tr][tc] = 1;
                            }
                        }
                    }
                }
            }

            return "impossible";
        }
    }

    /**
     * Ctx 8
     * [418 Sentence Screen Fitting]()
     */
    public class SentenceScreenFitting { // jiaqiyang
        public int wordsTyping(String[] sentence, int rows, int cols) {
            int num = 0;
            int res = 0;
            int index = 0;
            for (int i = 0; i < rows; i++) {
                while (index + sentence[num].length() <= cols) {
                    index += sentence[num].length() + 1;
                    num++;
                    if (num == sentence.length) {
                        num = 0;
                        res++;
                    }
                }
                index = 0;
            }
            return res;
        }
    }

    /**
     * [134 gas station]
     */


    /**
     * contest 12
     * [471 Encode String with Shortest Length]()
     * Given a non-empty string, encode the string such that its encoded length is the shortest.

     * The encoding rule is: k[encoded_string], where the encoded_string inside
     * the square brackets is being repeated exactly k times.
     *
     * Note:
     * k will be a positive integer and encoded string will not be empty or have extra space.
     * You may assume that the input string contains only lowercase English letters.
     * The string's length is at most 160.
     * If an encoding process does not make the string shorter, then do not encode it.
     * If there are several solutions, return any of them is fine.
     *
     * Example 1:
     * Input: "aaa"
     * Output: "aaa"
     * Explanation: There is no way to encode it such that it is shorter than the input string, so we do not encode it.
     *
     * Example 2:
     * Input: "aaaaa"
     * Output: "5[a]"
     * Explanation: "5[a]" is shorter than "aaaaa" by 1 character.
     *
     * Example 3:
     * Input: "aaaaaaaaaa"
     * Output: "10[a]"
     * Explanation: "a9[a]" or "9[a]a" are also valid solutions,
     * both of them have the same length = 5, which is the same as "10[a]".
     *
     * Example 4:
     * Input: "aabcaabcd"
     * Output: "2[aabc]d"
     * Explanation: "aabc" occurs twice, so one answer can be "2[aabc]d".
     * Example 5:
     * Input: "abbbabbbcabbbabbbc"
     * Output: "2[2[abbb]c]"
     * Explanation: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded to "2[abbb]c"
     *
     * so one answer can be "2[2[abbb]c]".
     *  题解
     * dp[i][j] = string from index i to index j in encoded form.
     *
     * We can write the following formula as
     * dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j]) or
     * if we can find some pattern in string from i to j which will result in more less length.
     * Time Complexity = O(n^3)
     */

    class EncodeShortestString {
        private String[][] dp = new String[200][200];

        private boolean check(String input, int from, int to, int length) {
            String prevString = null;
            for (int i = from; i <= to; i += length) {
                StringBuilder builder = new StringBuilder();
                for (int j = i; j < i + length; j++)
                    builder.append(input.charAt(j));
                if (prevString == null)
                    prevString = builder.toString();
                else {
                    String s = builder.toString();
                    if (prevString.equals(s) == false)
                        return false;
                }
            }
            return true;
        }

        private String solve(String input, int from, int to) {
            int tot = to - from + 1;
            if (tot <= 4)
                return input.substring(from, to + 1);
            else {
                if (dp[from][to] != null)
                    return dp[from][to];

                // use this string
                int i;
                String ans = input;
                // divided into two string
                for (i = from; i < to; i++) {
                    String temp = solve(input, from, i) + solve(input, i + 1, to);
                    if (temp.length() < ans.length())
                        ans = temp;
                }
                for (int length = 1; length <= tot - 1; length++) {
                    if (tot % length == 0 && check(input, from, to, length)) {
                        // 以length为长度单位
                        String temp = (tot / length) + "[" + solve(input, from, from + length - 1) + "]";
                        if (temp.length() < ans.length())
                            ans = temp;
                    }
                }

                return dp[from][to] = ans;
            }
        }

        public String encode(String s) {

            if (s.isEmpty())
                return "";

            int length = s.length();
            for (int i = 0; i < length; i++)
                for (int j = 0; j < length; j++)
                    dp[i][j] = null;

            return solve(s, 0, s.length() - 1);

        }

        // top 1 c++ solu
        //    class Solution {
        //        public:
        //        string dp[166][166];
        //        string f(int x) {
        //            string res;
        //            while (x > 0) {
        //                res += (char)(x % 10 + '0');
        //                x /= 10;
        //            }
        //            reverse(res.begin(), res.end());
        //            return res;
        //        }
        //        string encode(string s) {
        //            if (s.length() == 0) {
        //                return s;
        //            }
        //            int len = (int)s.length();
        //            for (int l = 1; l <= len; ++l) {
        //                for (int i = 0; i + l - 1 < len; ++i) {
        //                    int j = i + l - 1;
        //                    dp[i][j] = s.substr(i, j - i + 1);
        //                    for (int k = i; k < j; ++k) {
        //                        if (dp[i][j].length() > dp[i][k].length() + dp[k + 1][j].length()) {
        //                            dp[i][j] = dp[i][k] + dp[k + 1][j];
        //                        }
        //                    }
        //                    for (int p = 1; p < l; ++p) {
        //                        if (l % p != 0) {
        //                            continue;
        //                        }
        //                        bool ok = true;
        //                        for (int k = 0; k + p < l && ok; ++k) {
        //                            ok &= s[i + k] == s[i + k + p];
        //                        }
        //                        if (ok) {
        //                            if (dp[i][j].length() > f(l / p).length() + 2 + dp[i][i + p - 1].length()) {
        //                                string tmp = f(l / p);
        //                                tmp += "[";
        //                                tmp += dp[i][i + p - 1];
        //                                tmp += "]";
        //                                dp[i][j] = tmp;
        //
        //                            }
        //                        }
        //                    }
        //                }
        //            }
        //            return dp[0][len - 1];
        //        }
        //    } f;
    }

    /**
     * ctx 57
     * [candy crush]
     */
    class CandyCrush {
        public int[][] candyCrush(int[][] board) {
            int n = board.length, m = board[0].length;
            while(true){
                int[][] mark = new int[n][m];
                for(int j = 0;j < m;j++){
                    int rep = 0;
                    for(int i = 0;i < n;i++){
                        if(board[i][j] == 0)continue;
                        if(i > 0 && board[i][j] == board[i-1][j]){
                            rep++;
                            if(rep == 3){
                                mark[i-2][j] = mark[i-1][j] = 1;
                            }
                            if(rep >= 3){
                                mark[i][j] = 1;
                            }
                        }else{
                            rep = 1;
                        }
                    }
                }
                for(int i = 0;i < n;i++){
                    int rep = 0;
                    for(int j = 0;j < m;j++){
                        if(board[i][j] == 0)continue;
                        if(j > 0 && board[i][j] == board[i][j-1]){
                            rep++;
                            if(rep == 3){
                                mark[i][j-2] = mark[i][j-1] = 1;
                            }
                            if(rep >= 3){
                                mark[i][j] = 1;
                            }
                        }else{
                            rep = 1;
                        }
                    }
                }

                boolean some = false;
                for(int i = 0;i < n;i++){
                    for(int j = 0;j < m;j++){
                        if(mark[i][j] == 1){
                            board[i][j] = 0;
                            some = true;
                        }
                    }
                }
                if(!some)break;

                for(int j = 0;j < m;j++){
                    int to = n-1;
                    for(int i = n-1;i >= 0;i--){
                        if(board[i][j] > 0){
                            board[to][j] = board[i][j];
                            if(to > i)board[i][j] = 0;
                            to--;
                        }
                    }
                }
            }

            return board;
        }
    }


}
