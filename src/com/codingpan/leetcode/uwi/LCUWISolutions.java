package com.codingpan.leetcode.uwi;

import com.codingpan.leetcode.util.ListNode;
import com.codingpan.leetcode.util.TreeNode;

import java.util.*;

public class LCUWISolutions {
    //Context 100

    /**
     * 1
     * @param a
     * @return
     */
    public boolean isMonotonic(int[] a) {
        int n = a.length;
        {
            boolean ok = true;
            for(int i = 0;i < n-1;i++){
                if(a[i] > a[i+1])ok = false;
            }
            if(ok)return true;
        }
        {
            boolean ok = true;
            for(int i = 0;i < n-1;i++){
                if(a[i] < a[i+1])ok = false;
            }
            if(ok)return true;
        }
        return false;
    }

    /**
     * 2
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(1);
        dfs(root, dummy);
        return dummy.right;
    }

    TreeNode dfs(TreeNode root, TreeNode p)
    {
        if(root == null)return p;
        p = dfs(root.left, p);
        TreeNode c = new TreeNode(root.val);
        p.right = c;
        p = c;
        p = dfs(root.right, p);
        return p;
    }

    /**
     * 3
     * @param a
     * @return
     */
    public int subarrayBitwiseORs(int[] a) {
        int n = a.length;
        int[] next = new int[31];
        Arrays.fill(next, n);
        int[] u = new int[33*n];
        int p = 0;
        long[] t = new long[31];
        for(int i = n-1;i >= 0;i--){
            for(int j = 0;j < 31;j++){
                if(a[i]<<~j<0){
                    next[j] = i;
                }
                t[j] = (long)next[j]<<32|j;
            }
            Arrays.sort(t);
            u[p++] = a[i];
            int b = 0;
            for(int j = 0;j < 31;){
                int k = j;
                if(t[j]>>>32 == n)break;
                while(k < 31 && t[k]>>>32==t[j]>>>32){
                    b |= 1<<(int)t[k];
                    k++;
                }
                u[p++] = b;
                j = k;
            }
        }
        Arrays.sort(u, 0, p);
        int ct = 0;
        for(int i = 0;i < p;i++){
            if(i == 0 || u[i-1] != u[i])ct++;
        }
        return ct;
    }

    /**
     * 4
     * @param S
     * @param K
     * @return
     */
    public String orderlyQueue(String S, int K) {
        int n = S.length();
        if(K >= 2){
            char[] s = S.toCharArray();
            Arrays.sort(s);
            return new String(s);
        }else{
            String ret = S;
            for(int i = 0;i < n;i++){
                String T = S.substring(i) + S.substring(0, i);
                if(T.compareTo(ret) < 0){
                    ret = T;
                }
            }
            return ret;
        }
    }

    //Contest 84
    //[lc823 FindAndReplaceString](https://leetcode.com/contest/weekly-contest-84/problems/find-and-replace-in-string/)
    class Datum
    {
        int pos;
        String src;
        String targ;
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        int m = indexes.length;
        Datum[] ds = new Datum[m];
        for(int i = 0;i < m;i++){
            Datum d = new Datum();
            d.pos = indexes[i];
            d.src = sources[i];
            d.targ = targets[i];
            ds[i] = d;
        }
        Arrays.sort(ds, new Comparator<Datum>() {
            public int compare(Datum a, Datum b) {
                return a.pos - b.pos;
            }
        });

        for(int i = m-1;i >= 0;i--){
            Datum d = ds[i];
            if(S.substring(d.pos, d.pos + d.src.length()).equals(d.src)){
                S = S.substring(0, d.pos) + d.targ + S.substring(d.pos + d.src.length());
            }
        }
        return S;
    }


    ///Contest 81
    //[lc821](https://leetcode.com/contest/weekly-contest-81/problems/shortest-distance-to-a-character/)
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] a = new int[n];
        Arrays.fill(a, 9999999);
        for(int i = 0;i < n;i++){
            if(S.charAt(i) == C){
                a[i] = 0;
            }
        }
        for(int i = 1;i < n;i++){
            a[i] = Math.min(a[i], a[i-1] + 1);
        }
        for(int i = n-2;i >= 0;i--){
            a[i] = Math.min(a[i], a[i+1] + 1);
        }
        return a;
    }

    //[lc822](https://leetcode.com/contest/weekly-contest-81/problems/card-flipping-game/)
    public int flipgame(int[] fronts, int[] backs) {
        int n = fronts.length;
        outer:
        for(int i = 1;i <= 2000;i++){
            boolean ok = false;
            for(int j = 0;j < n;j++){
                if(fronts[j] == i){
                    if(backs[j] == i)continue outer;
                }
                if(backs[j] == i || fronts[j] == i)ok = true;
            }
            if(ok)return i;
        }
        return 0;
    }

    //[lc820](https://leetcode.com/contest/weekly-contest-81/problems/short-encoding-of-words/)
    public int minimumLengthEncoding(String[] words) {
        int n = words.length;
        boolean[] sup = new boolean[n];
        long[] hs = new long[n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < words[i].length();j++){
                hs[i] = hs[i]<<5|words[i].charAt(j)-'a'+1;
            }
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(i != j){
                    if(hs[i] == hs[j]){
                        if(i < j){
                            sup[j] = true;
                        }
                    }else{
                        if(words[i].length() > words[j].length()
                                && (hs[i]&(1L<<words[j].length()*5)-1) == hs[j]){
                            sup[j] = true;
                        }
                    }
                }
            }
        }
        int ret = 0;
        for(int i = 0;i < n;i++){
            if(!sup[i]){
                ret += words[i].length() + 1;
            }
        }
        return ret;
    }

    //[lc823](https://leetcode.com/contest/weekly-contest-81/problems/binary-trees-with-factors/)
    public int numFactoredBinaryTrees(int[] a) {
        Arrays.sort(a);
        a = uniq(a);
        int n = a.length;
        int mod = 1000000007;

        long[] dp = new long[n];
        long ret = 0;
        for(int i = 0;i < n;i++){
            int p = i-1;
            for(int j = 0;j < i;j++){
                if(a[i] % a[j] == 0){
                    while(p >= 0 && a[p] > a[i] / a[j])p--;
                    if(p >= 0 && a[p] == a[i] / a[j]){
                        dp[i] += dp[j] * dp[p];
                        dp[i] %= mod;
                    }
                }
            }
            dp[i]++;
            dp[i] %= mod;
            ret += dp[i];
        }
        return (int)(ret%mod);
    }

    int[] uniq(int[] a) {
        int n = a.length;
        int p = 0;
        for(int i = 0;i < n;i++) {
            if(i == 0 || a[i] != a[i-1])a[p++] = a[i];
        }
        return Arrays.copyOf(a, p);
    }


    /// Contest 80
    //[lc819](https://leetcode.com/contest/weekly-contest-80/problems/most-common-word/)
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] sp = paragraph.trim().split(" +");
        Map<String, Integer> ct = new HashMap<>();
        for(String s : sp){
            s = s.toLowerCase();
            while(s.length() > 0 && !(
                    s.charAt(s.length()-1) >= 'a' &&
                            s.charAt(s.length()-1) <= 'z')){
                s = s.substring(0, s.length()-1);
            }
            if(s.length() == 0)continue;
            if(!ct.containsKey(s)){
                ct.put(s, 0);
            }
            ct.put(s, ct.get(s) + 1);
        }
        for(String b : banned){
            ct.remove(b);
        }
        int max = -1;
        String best = null;
        for(String k : ct.keySet()){
            if(ct.get(k) > max){
                max = ct.get(k);
                best = k;
            }
        }
        return best;
    }

    //[lc817](https://leetcode.com/contest/weekly-contest-80/problems/linked-list-components/)
    public int numComponents(ListNode head, int[] G) {
        boolean[] hit = new boolean[10005];
        for(int v : G)hit[v] = true;

        int rep = 0;
        int con = 0;
        while(head != null){
            if(hit[head.val]){
                if(rep == 0)con++;
                rep++;
            }else{
                rep = 0;
            }

            head = head.next;
        }
        return con;
    }

    //[lc816](https://leetcode.com/contest/weekly-contest-80/problems/ambiguous-coordinates/)
    public List<String> ambiguousCoordinates(String S) {
        S = S.substring(1, S.length()-1);
        int n = S.length();
        List<String> ret = new ArrayList<>();
        for(int i = 1;i <= n-1;i++){
            List<String> va = valids(S.substring(0, i));
            List<String> vb = valids(S.substring(i, n));
            for(String a : va){
                for(String b : vb){
                    ret.add("(" + a + ", " + b + ")");
                }
            }
        }
        return ret;
    }

    List<String> valids(String s)
    {
        List<String> ret = new ArrayList<>();
        if(valid(s))ret.add(s);
        for(int i = 1;i < s.length();i++){
            String t = s.substring(0, i) + "." + s.substring(i);
            if(valid(t))ret.add(t);
        }
        return ret;
    }

    boolean valid(String s)
    {
        if(s.lastIndexOf("-") > 0)return false;
        if(s.equals("-0"))return false;
        if(s.startsWith("-")){
            s = s.substring(1);
        }
        if(s.length() == 0)return false;
        if(s.indexOf(".") < 0){
            if(s.length() > 1 && s.startsWith("0"))return false;
            return true;
        }else{
            String[] sp = s.split("\\.");
            if(sp.length < 2)return false;
            if(sp[0].length() == 0)return false;
            if(sp[0].length() > 1 && sp[0].startsWith("0"))return false;
            if(sp[1].endsWith("0"))return false;
            return true;
        }
    }

    //[lc818](https://leetcode.com/contest/weekly-contest-80/problems/race-car/)
    int o, z, u;

    int code(int x, int y)
    {
        return (x+z)*u+(y+o);
    }

    // 8128083783063552028
    public int racecar(int target) {
        o = 500;
        z = 14;
        int no = 10000;
        int[][] dp = new int[z*2+1][o+no+1];
        for(int i = 0;i < z*2+1;i++)Arrays.fill(dp[i], Integer.MAX_VALUE / 3);
        u = o+no+1;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(code(1, 0));
        dp[1+z][0+o] = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            int x = cur / u - z, y = cur % u - o;
            int dx = x > 0 ? 1<<x-1 : -(1<<-x-1);
            {
                int ny = y + dx;
                if(ny >= -o && ny <= no){
                    int nx = x > 0 ? x + 1 : x - 1;
                    if(nx >= -z && nx <= z){
                        if(dp[nx+z][ny+o] > dp[x+z][y+o] + 1){
                            dp[nx+z][ny+o] = dp[x+z][y+o] + 1;
                            q.add(code(nx, ny));
                        }
                    }
                }
            }
            {
                int nx = x > 0 ? -1 : 1;
                int ny = y;
                if(dp[nx+z][ny+o] > dp[x+z][y+o] + 1){
                    dp[nx+z][ny+o] = dp[x+z][y+o] + 1;
                    q.add(code(nx, ny));
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 0;i < z*2+1;i++){
            ret = Math.min(ret, dp[i][target+o]);
        }

//	        long h = 0;
//	        for(int j = 0;j <= 10000;j++){
//	        	int u = Integer.MAX_VALUE;
//		        for(int i = 0;i < z*2+1;i++){
//		        	u = Math.min(u, dp[i][j+o]);
//		        }
//		        h = h * 1000000009 + u;
//	        }
//	        tr(h);
        return ret;
    }

    /// contest 79
    //[lc812](https://leetcode.com/contest/weekly-contest-79/problems/largest-triangle-area/)
    public double largestTriangleArea(int[][] points) {

        int n = points.length;
        double max = 0;
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                for(int k = j+1;k < n;k++){
                    max = Math.max(max, areaPoly2(points[i], points[j], points[k]));
                }
            }
        }
        return max/2;
    }

    public long areaPoly2(int[]... co)
    {
        int n = co.length;
        long s = 0;
        for(int i = 0, j = 1;i < n;i++,j++){
            if(j == n)j = 0;
            s += (long)co[i][0]*co[j][1]-(long)co[j][0]*co[i][1];
        }
        return Math.abs(s);
    }

    //[lc814](https://leetcode.com/contest/weekly-contest-79/problems/binary-tree-pruning/)
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root);
    }

    TreeNode dfs(TreeNode cur)
    {
        if(cur == null)return null;
        boolean hasone = false;
        if(cur.left != null){
            cur.left = dfs(cur.left);
            if(cur.left != null)hasone = true;
        }
        if(cur.right != null){
            cur.right = dfs(cur.right);
            if(cur.right != null)hasone = true;
        }
        if(hasone || cur.val == 1){
            return cur;
        }else{
            return null;
        }
    }

    //[lc813](https://leetcode.com/contest/weekly-contest-79/problems/largest-sum-of-averages/)
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[] dp = new double[n+1];
        Arrays.fill(dp, Double.NEGATIVE_INFINITY);
        dp[0] = 0;
        double ret = 0;
        for(int i = 0;i < K;i++){
            double[] ndp = new double[n+1];
            Arrays.fill(ndp, Double.NEGATIVE_INFINITY);
            for(int j = 0;j < n;j++){
                double s = 0;
                for(int k = j;k < n;k++){
                    s += A[k];
                    ndp[k+1] = Math.max(ndp[k+1], dp[j] + s/(k-j+1));
                }
            }
            ret = Math.max(ret, ndp[n]);
            dp = ndp;
        }
        return ret;
    }

    //[lc815](https://leetcode.com/contest/weekly-contest-79/problems/bus-routes/)
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

    ///contest 78
    //[lc811](https://leetcode.com/contest/weekly-contest-78/problems/subdomain-visit-count/)
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String cpd : cpdomains){
            String[] sp = cpd.split(" ");
            String d = sp[1];
            String[] dsp = d.split("\\.");
            String ld = "";
            for(int i = dsp.length-1;i >= 0;i--){
                if(i == dsp.length-1){
                    ld = dsp[i];
                }else{
                    ld = dsp[i] + "." + ld;
                }
                if(map.containsKey(ld)){
                    map.put(ld, map.get(ld) + Integer.parseInt(sp[0]));
                }else{
                    map.put(ld, Integer.parseInt(sp[0]));
                }
            }
        }
        List<String> ret = new ArrayList<>();
        for(String key : map.keySet()){
            ret.add(map.get(key) + " " + key);
        }
        return ret;
    }

    //[lc809](https://leetcode.com/contest/weekly-contest-78/problems/expressive-words/)
    public int expressiveWords(String S, String[] words) {
        int[][] fs = tof(S);
        int ct = 0;
        outer:
        for(String w : words){
            int[][] f = tof(w);
            if(fs.length != f.length)continue;
            for(int i = 0;i < f.length;i++){
                if(fs[i][0] != f[i][0])continue outer;
                if(fs[i][1] >= 3){
                    if(f[i][1] <= fs[i][1]){
                    }else{
                        continue outer;
                    }
                }else{
                    if(f[i][1] == fs[i][1]){
                    }else{
                        continue outer;
                    }
                }
            }
            ct++;
        }
        return ct;
    }

    int[][] tof(String s)
    {
        int n = s.length();
        int[][] ret = new int[n][];
        int p = 0;
        for(int i = 0;i < n;i++){
            if(i == 0 || s.charAt(i) != s.charAt(i-1)){
                ret[p++] = new int[]{s.charAt(i), 1};
            }else{
                ret[p-1][1]++;
            }
        }
        return Arrays.copyOf(ret, p);
    }

    //[lc808](https://leetcode.com/contest/weekly-contest-78/problems/soup-servings/)
    public double soupServings(int N) {
        if(N == 0)return 0.5;
        if(N >= 10000)return 1.;
        int n = (N+24)/25;
        double[] dp = new double[n+1];
        dp[n] = 1;
        double P = 0;
        for(int i = 0;i <= n/2+1;i++){
            for(int j = 0;j <= n;j++){
                for(int k = 1;k <= 4;k++){
                    int b = 2*n-4*(i+1)-(j-k);
                    if(j-k <= 0){
                        if(b <= 0){
                            P += dp[j]/4/2;
                        }else{
                            P += dp[j]/4;
                        }
                    }else if(b <= 0){
                    }else{
                        dp[j-k] += dp[j]/4;
                    }
                }
                dp[j] = 0;
            }
        }
        return P;
    }

    //[lc810](https://leetcode.com/contest/weekly-contest-78/problems/chalkboard-xor-game/)
    public boolean xorGame(int[] nums) {
        int x = 0;
        for(int v : nums)x ^= v;
        return x == 0 || nums.length % 2 == 0;
    }

    ///contest 77
    //[lc806](https://leetcode.com/contest/weekly-contest-77/problems/number-of-lines-to-write-string/)
    public int[] numberOfLines(int[] widths, String S) {
        int cur = 0;
        int line = 0;
        for(int i = 0;i < S.length();i++){
            int my = widths[S.charAt(i)-'a'];
            if(cur + my > 100){
                cur = 0;
                line++;
            }
            cur += my;
        }
        return new int[]{line+1, cur};
    }

    //[lc804](https://leetcode.com/contest/weekly-contest-77/problems/unique-morse-code-words/)
    String[] T = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
    };
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for(String w : words){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i < w.length();i++){
                sb.append(T[w.charAt(i)-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    //[lc807](https://leetcode.com/contest/weekly-contest-77/problems/max-increase-to-keep-city-skyline/)
    public int maxIncreaseKeepingSkyline(int[][] a) {
        int n = a.length, m = a[0].length;
        int[] mr = new int[n];
        for(int i = 0;i < n;i++){
            int max = 0;
            for(int j = 0;j < m;j++){
                max = Math.max(max, a[i][j]);
            }
            mr[i] = max;
        }
        int[] mc = new int[m];
        for(int i = 0;i < m;i++){
            int max = 0;
            for(int j = 0;j < n;j++){
                max = Math.max(max, a[j][i]);
            }
            mc[i] = max;
        }
        int ans = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                ans += Math.min(mr[i], mc[j]) - a[i][j];
            }
        }
        return ans;
    }

    //[lc805](https://leetcode.com/contest/weekly-contest-77/problems/split-array-with-same-average/)
    public boolean splitArraySameAverage(int[] a) {
        int n = a.length;
        int s = 0;
        for(int v : a){
            s += v;
        }
        int m = (300001>>>6)+1;
        long[][] dp = new long[n+1][m];
        dp[0][0] = 1;
        for(int i = 0;i < n;i++){
            for(int j = i;j >= 0;j--){
                or(dp[j], 0, 300000-a[i], dp[j+1], a[i]);
            }
        }
        for(int i = 1;i <= n-1;i++){
            // a/i = (s-a)/(n-i)
            // a(n-i) = (s-a)i
            // an = si
            // a = si/n
            if((long)s * i % n == 0){
                int b = s*i / n;
                if(dp[i][b>>>6]<<~b<0)return true;
            }
        }
        return false;
    }

    public void or(long[] from, int fl, int fr, long[] to, int tl)
    {
        if(!(fl >= 0 && fl < from.length<<6))throw new RuntimeException();
        if(!(fr >= 0 && fr <= from.length<<6))throw new RuntimeException();
        if(!(tl >= 0 && tl < to.length<<6))throw new RuntimeException();
        if(!(tl+(fr-fl) >= 0 && tl+(fr-fl) <= to.length<<6))throw new RuntimeException();
        if(fl >= fr)return;

        int tr = tl+(fr-fl);
        for(int l1 = fl, l2 = Math.min(fr, (fl>>>6)+1<<6), r1 = tl, r2 = Math.min(tr, (tl>>>6)+1<<6);l1 < fr;){
            if(l2-l1 <= r2-r1){
                long f = from[l2-1>>>6]<<-l2>>>-l2+l1;
                to[l2-l1+r1-1>>>6] |= f<<r1;
                r1 += l2-l1;
                l1 = l2;
                l2 = Math.min(fr, (l1>>>6)+1<<6);
                if(r2 - r1 == 0){
                    r2 = Math.min(tr, (r1>>>6)+1<<6);
                }
            }else{
                long f = from[r2-r1+l1-1>>>6]<<-(r2-r1+l1)>>>-(r2-r1+l1)+l1;
                to[r2-1>>>6] |= f<<r1;
                l1 += r2-r1;
                r1 = r2;
                r2 = Math.min(tr, (r1>>>6)+1<<6);
                if(l2 - l1 == 0){
                    l2 = Math.min(fr, (l1>>>6)+1<<6);
                }
            }
        }
    }

    ///contest 76 (missing)


    ///contest 75
    //[lc796](https://leetcode.com/contest/weekly-contest-75/problems/rotate-string/)
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length())return false;
        return (A+A).indexOf(B) >= 0;
    }

    //[lc797](https://leetcode.com/contest/weekly-contest-75/problems/all-paths-from-source-to-target/)
    List<List<Integer>> ret;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ret = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, graph, path);
        return ret;
    }

    void dfs(int cur, int[][] g, List<Integer> path)
    {
        path.add(cur);
        if(cur == g.length-1){
            ret.add(new ArrayList<>(path));
        }else{
            for(int e : g[cur]){
                dfs(e, g, path);
            }
        }
        path.remove(path.size()-1);
    }

    //[lc799](https://leetcode.com/contest/weekly-contest-75/problems/champagne-tower/)
    public double champagneTower(int poured, int qr, int qg) {
        double[][] dp = new double[100][100];
        dp[0][0] = poured;
        for(int i = 0;i < 100;i++){
            for(int j = 0;j <= i;j++){
                if(dp[i][j] > 1){
                    if(i < 99){
                        dp[i+1][j] += (dp[i][j] - 1)/2;
                        dp[i+1][j+1] += (dp[i][j] - 1)/2;
                    }
                    dp[i][j] = 1;
                }
            }
        }
        return dp[qr][qg];
    }

    //[lc798](https://leetcode.com/contest/weekly-contest-75/problems/smallest-rotation-with-highest-score/)
    public int bestRotation(int[] a) {
        int n = a.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(100000, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return -((x[0]-x[1]) - (y[0]-y[1]));
            }
        });
        for(int i = 0;i < n;i++){
            pq.add(new int[]{a[i], i});
        }
        boolean[] less = new boolean[n];

        int best = -1;
        int arg = -1;
        int all = n;
        for(int i = 0;i < n;i++){
            while(!pq.isEmpty()){
                if(pq.peek()[0]-pq.peek()[1] > -i){
                    less[pq.poll()[1]] = true;
                    all--;
                }else{
                    break;
                }
            }
            if(all > best){
                best = all;
                arg = i;
            }

            if(less[i]){
                less[i] = false;
            }
            all++;
            pq.add(new int[]{a[i]-n, i});
        }
        // 0-0 2-1 3-2
        // 0-3 2-4 3-2
        return arg;
    }

    /// contest 74
    //[lc794](https://leetcode.com/contest/weekly-contest-74/problems/valid-tic-tac-toe-state/)
    public boolean validTicTacToe(String[] board) {
        char[] map = new char[9];
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                map[i*3+j] = board[i].charAt(j);
            }
        }
        int ox = 0;
        for(int i = 0;i < 9;i++){
            if(map[i] != ' ')ox++;
        }

        int[] ord = new int[9];
        for(int i = 0;i < 9;i++)ord[i] = i;
        outer:
        do{
            for(int j = 0;j < ox;j++){
                if(map[ord[j]] != (j%2 == 0 ? 'X' : 'O')){
                    continue outer;
                }
            }
            char[] t = new char[9];
            Arrays.fill(t, ' ');
            for(int j = 0;j < ox-1;j++){
                t[ord[j]] = map[ord[j]];
                if(end(t))continue outer;
            }
            return true;
        }while(nextPermutation(ord));
        return false;
    }

    int[][] q = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    boolean end(char[] t)
    {
        for(int[] o : q){
            if(t[o[0]] != ' ' && t[o[0]] == t[o[1]] && t[o[1]] == t[o[2]])return true;
        }
        return false;
    }

    public boolean nextPermutation(int[] a) {
        int n = a.length;
        int i;
        for (i = n - 2; i >= 0 && a[i] >= a[i + 1]; i--)
            ;
        if (i == -1)
            return false;
        int j;
        for (j = i + 1; j < n && a[i] < a[j]; j++)
            ;
        int d = a[i];
        a[i] = a[j - 1];
        a[j - 1] = d;
        for (int p = i + 1, q = n - 1; p < q; p++, q--) {
            d = a[p];
            a[p] = a[q];
            a[q] = d;
        }
        return true;
    }

    //[lc792](https://leetcode.com/contest/weekly-contest-74/problems/number-of-matching-subsequences/)
    public int numMatchingSubseq(String S, String[] words) {
        char[] s = S.toCharArray();
        int[][] next = makeFatNext(s, 'a', 'z');
        int ret = 0;
        outer:
        for(String w : words){
            int pos = 0;
            for(char c : w.toCharArray()){
                pos = next[c-'a'][pos];
                if(pos > s.length)continue outer;
            }
            ret++;
        }
        return ret;
    }

    public int[][] makeFatNext(char[] s, char inf, char sup)
    {
        int n = s.length;
        int[][] next = new int[sup-inf+1][n+1];
        for(int i = 0;i < sup-inf+1;i++)next[i][n] = n+1;
        for(int i = s.length-1;i >= 0;i--){
            for(int j = 0;j < sup-inf+1;j++)next[j][i] = next[j][i+1];
            next[s[i]-inf][i] = i+1;
        }
        return next;
    }

    //[lc795](https://leetcode.com/contest/weekly-contest-74/problems/number-of-subarrays-with-bounded-maximum/)
    public int numSubarrayBoundedMax(int[] a, int L, int R) {
        int n = a.length;
        return count(a, R) - count(a, L-1);
    }

    int count(int[] a, int R)
    {
        int my = 0, ret = 0;
        for(int v : a){
            if(v <= R){
                my++;
            }else{
                my = 0;
            }
            ret += my;
        }
        return ret;
    }

    //[lc793](https://leetcode.com/contest/weekly-contest-74/problems/preimage-size-of-factorial-zeroes-function/)
    public int preimageSizeFZF(int K) {
        return (int)(count(K) - count(K-1));
    }
    public long count(int n)
    {
        long low = -1, high = 5000000000L;
        while(high - low > 1){
            long h = high+low>>1;
            long s = 0;
            for(long k = h/5;k > 0;k /= 5)s += k;
            if(s <= n){
                low = h;
            }else{
                high = h;
            }
        }
        return low+1;
    }

    ///contest 73
    //[lc788](https://leetcode.com/contest/weekly-contest-73/problems/rotated-digits/)
    public int rotatedDigits(int N) {
        int ret = 0;
        outer:
        for(int i = 1;i <= N;i++){
            char[] s = Integer.toString(i).toCharArray();
            boolean ok = false;
            for(char c : s){
                if(c == '0' || c == '1' || c == '8'){
                    continue;
                }
                if(c == '2' || c == '5' || c == '6' || c == '9'){
                    ok = true;
                    continue;
                }
                continue outer;
            }
            if(ok)ret++;
        }
        return ret;
    }

    //[lc789](https://leetcode.com/contest/weekly-contest-73/problems/escape-the-ghosts/)
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int d = Math.abs(target[0]) + Math.abs(target[1]);
        for(int[] g : ghosts){
            if(Math.abs(g[0]-target[0])+Math.abs(g[1]-target[1]) <= d){
                return false;
            }
        }
        return true;
    }

    //[lc791](https://leetcode.com/contest/weekly-contest-73/problems/custom-sort-string/)
    public String customSortString(String S, String T) {
        char[] t = T.toCharArray();
        int[] f = new int[26];
        for(char c : t){
            f[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < S.length();i++){
            for(int j = 0;j < f[S.charAt(i)-'a'];j++){
                sb.append(S.charAt(i));
            }
            f[S.charAt(i)-'a'] = 0;
        }
        for(int i = 0;i < 26;i++){
            for(int j = 0;j < f[i];j++){
                sb.append((char)('a'+i));
            }
        }
        return sb.toString();
    }

    //[lc790](https://leetcode.com/contest/weekly-contest-73/problems/domino-and-tromino-tiling/)
    public int numTilings(int n) {
        int mod = 1000000007;
        long[] dp = new long[4];
        dp[0] = 1;
        for(int i = 0;i < n;i++){
            long[] ndp = new long[4];
            // ||
            ndp[3] += dp[0];
            // |
            ndp[1] += dp[2];
            ndp[2] += dp[1];
            // none
            ndp[0] += dp[3];
            // -
            ndp[0] += dp[0];

            ndp[1] += dp[0];
            ndp[2] += dp[0];
            ndp[3] += dp[1];
            ndp[3] += dp[2];

            for(int j = 0;j < 4;j++){
                dp[j] = ndp[j] % mod;
            }
        }
        return (int)dp[0];
    }

    ///contest 72
    //[lc784](https://leetcode.com/contest/weekly-contest-72/problems/letter-case-permutation/)
    public List<String> letterCasePermutation(String S) {
        List<String> a = new ArrayList<>();
        dfs(S.toCharArray(), 0, a);
        return a;
    }

    void dfs(char[] s, int pos, List<String> a)
    {
        if(pos == s.length){
            a.add(new String(s));
            return;
        }
        dfs(s, pos+1, a);
        if(s[pos] >= 'A' && s[pos] <= 'Z' ||
                s[pos] >= 'a' && s[pos] <= 'z'){
            s[pos] ^= 32;
            dfs(s, pos+1, a);
        }
    }

    //[lc785](https://leetcode.com/contest/weekly-contest-72/problems/is-graph-bipartite/)
    public boolean isBipartite(int[][] g) {
        int n = g.length;
        int[] color = new int[n];
        for(int i = 0;i < n;i++){
            if(color[i] == 0){
                color[i] = 1;
                if(!dfs(i, color, g))return false;
            }
        }
        return true;
    }

    boolean dfs(int cur, int[] color, int[][] g)
    {
        for(int e : g[cur]){
            if(color[e] == 0){
                color[e] = -color[cur];
                if(!dfs(e, color, g))return false;
            }else if(color[e] == color[cur]){
                return false;
            }
        }
        return true;
    }

    //[lc787](https://leetcode.com/contest/weekly-contest-72/problems/cheapest-flights-within-k-stops/)
    public int findCheapestPrice(int n, int[][] es, int src, int dst, int K) {
        long[] ds = new long[n];
        Arrays.fill(ds, Long.MAX_VALUE / 2);
        ds[src] = 0;
        long ans = ds[dst];
        for(int i = 0;i < K+1;i++){
            long[] nds = new long[n];
            Arrays.fill(nds, Long.MAX_VALUE / 2);
            for(int[] e : es){
                nds[e[1]] = Math.min(nds[e[1]], ds[e[0]] + e[2]);
            }
            ds = nds;
            ans = Math.min(ans, ds[dst]);
        }
        return ans < Integer.MAX_VALUE ? (int)ans : -1;
    }

    //[lc786](https://leetcode.com/contest/weekly-contest-72/problems/k-th-smallest-prime-fraction/)
    public int[] kthSmallestPrimeFraction(int[] a, int K) {
        Arrays.sort(a);
        double low = 0, high = 1;
        int n = a.length;
        for(int rep = 0;rep < 50;rep++){
            double x = low + (high-low)/2;
            long num = 0;
            for(int i = 0;i < n;i++){
                int ind = Arrays.binarySearch(a, (int)(x*a[i]));
                if(ind < 0)ind = -ind-2;
                num += ind+1;
            }
            if(num >= K){
                high = x;
            }else{
                low = x;
            }
        }

        for(double eps = 1e-14;;eps *= 10){
            for(int i = 0;i < n;i++){
                double ln = high * a[i];
                for(int j = 0;j < i;j++){
                    if(Math.abs(ln-a[j]) < eps){
                        return new int[]{a[j], a[i]};
                    }
                }
            }
        }
    }

    ///Contest 71
    //[lc783](https://leetcode.com/contest/weekly-contest-71/problems/minimum-distance-between-bst-nodes/)
    List<Integer> list = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        dfs71(root);
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < list.size()-1;i++){
            min = Math.min(min, list.get(i+1) - list.get(i));
        }
        return min;
    }

    void dfs71(TreeNode root)
    {
        if(root != null){
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }

    //[lc781](https://leetcode.com/contest/weekly-contest-71/problems/rabbits-in-forest/)
    public int numRabbits(int[] a) {
        int[] f = new int[1000];
        for(int v : a){
            f[v]++;
        }
        int ret = 0;
        for(int i = 0;i <= 999;i++){
            ret += (f[i]+i)/(i+1)*(i+1);
        }
        return ret;
    }

    //[lc780](https://leetcode.com/contest/weekly-contest-71/problems/reaching-points/)
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        return dfs(sx, sy, tx, ty);
    }

    boolean dfs(long sx, long sy, long tx, long ty)
    {
        if(tx < sx || ty < sy)return false;
        if(sy == ty && (tx-sx) % sy == 0)return true;
        if(sx == tx && (ty-sy) % sx == 0)return true;
        if(tx < ty){
            return dfs(sx, sy, tx, ty % tx);
        }else{
            return dfs(sx, sy, tx % ty, ty);
        }
    }

    //[lc782](https://leetcode.com/contest/weekly-contest-71/problems/transform-to-chessboard/)
    public int movesToChessboard(int[][] board) {
        int one = count(board);
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board.length;j++){
                board[i][j] ^= 1;
            }
        }
        int two = count(board);
        if(one == -1)return two;
        if(two == -1)return one;
        return Math.min(one, two);
    }

    public int count(int[][] a)
    {
        int n = a.length;
        int one = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                one += a[i][j];
            }
        }
        if(one != n*n/2+(n%2))return -1;

        int[] ls = new int[n];
        int p = 0;
        for(int i = 0;i < n;i++){
            int ch = 0;
            for(int j = 0;j < n;j++){
                if((i+j&1) != (a[i][j]^1)){
                    ch |= 1<<j;
                }
            }
            ls[p++] = ch;
        }
        int[] vs = Arrays.copyOf(ls, n);
        Arrays.sort(vs);
        if(vs[0] == vs[n-1]){
            return Integer.bitCount(vs[0]) % 2 == 0 ? Integer.bitCount(vs[0])/2 : -1;
        }

        for(int i = 0;i < n;i++){
            if(!(vs[i] == vs[0] || vs[i] == vs[n-1]))return -1;
        }
        if(vs[0]+vs[n-1] != (1<<n)-1)return -1;

        int ret = 999999;
        for(int f : new int[]{vs[0], vs[n-1]}){
            int bal = 0;
            int cum = 0;
            for(int j = 0;j < n;j++){
                if(ls[j] == f){
                    bal += j % 2 == 0 ? 1 : -1;
                    cum += j % 2;
                }
            }
            if(bal == 0 && Integer.bitCount(f^(1<<n)-1) % 2 == 0){
                ret = Math.min(ret, Integer.bitCount(f^(1<<n)-1) / 2 + cum);
            }
        }
        return ret == 999999 ? -1 : ret;
    }

    ///context 70
    //[lc779](https://leetcode.com/contest/weekly-contest-70/problems/k-th-symbol-in-grammar/)
    public int kthGrammar(int N, int K) {
        return Integer.bitCount(K-1)%2;
    }

    //[lc778] hidden
    public TreeNode[] splitBST(TreeNode root, int V) {
        return split(root, V);
    }

    TreeNode[] split(TreeNode root, int v)
    {
        if(root == null)return new TreeNode[]{null, null};

        if(root.val <= v){
            TreeNode[] res = split(root.right, v);
            root.right = res[0];
            res[0] = root;
            return res;
        }else{
            TreeNode[] res = split(root.left, v);
            root.left = res[1];
            res[1] = root;
            return res;
        }
    }

    //[lc777](https://leetcode.com/contest/weekly-contest-70/problems/swap-adjacent-in-lr-string/)
    public boolean canTransform(String start, String end) {
        if(!start.replace("X", "").equals(end.replace("X", "")))return false;
        int n = start.length();
        int p = 0;
        for(int i = 0;i < n;i++){
            if(start.charAt(i) != 'X'){
                while(p < n && end.charAt(p) == 'X'){
                    p++;
                }
                if(start.charAt(i) == 'R'){
                    if(i > p)return false;
                }else{
                    if(i < p)return false;
                }
                p++;
            }
        }
        return true;
    }

    //[lc778](https://leetcode.com/contest/weekly-contest-70/problems/swim-in-rising-water/)
    public int swimInWater(int[][] a) {
        int n = a.length, m = a[0].length;
        DJSet ds = new DJSet(n*m);
        int[] dr = { 1, 0, -1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        for(int i = 0;;i++){
            for(int j = 0;j < n;j++){
                for(int k = 0;k < m;k++){
                    if(a[j][k] == i){
                        for(int u = 0;u < 4;u++){
                            int nj = j + dr[u], nk = k + dc[u];
                            if(nj >= 0 && nj < n && nk >= 0 && nk < m &&
                                    a[nj][nk] <= i){
                                ds.union(j*m+k, nj*m+nk);
                            }
                        }
                    }
                }
            }
            if(ds.equiv(0, (n-1)*m+m-1))return i;
        }
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
