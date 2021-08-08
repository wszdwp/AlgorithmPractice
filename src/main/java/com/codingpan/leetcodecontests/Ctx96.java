package com.codingpan.leetcodecontests;

import java.util.Arrays;

public class Ctx96 {
    // cai_lw
//    int projectionArea(vector<vector<int>>& a) {
//        int n=a.size(),m=a[0].size(),ans=0;
//        vector<int> x(n,0),y(m,0);
//        for(int i=0;i<n;i++)
//            for(int j=0;j<m;j++){
//                if(a[i][j]>0)ans++;
//                x[i]=max(x[i],a[i][j]);
//                y[j]=max(y[j],a[i][j]);
//            }
//        for(int i=0;i<n;i++)ans+=x[i];
//        for(int i=0;i<m;i++)ans+=y[i];
//        return ans;
//    }

    // lc882
//    const int INF=1111111111;
//
//    struct Rec{
//        int i;
//        int d;
//        Rec(){}
//        Rec(int i,int d):i(i),d(d){}
//        bool operator<(const Rec& other) const {
//            return d>other.d;
//        }
//    };
//
//    class MinWindowSubString {
//        vector<vector<pair<int,int>>> edg;
//        int n;
//        vector<int> dijkstra(){
//            vector<int> dis(n,INF);
//            vector<bool> fix(n);
//            priority_queue<Rec> pq;
//            dis[0]=0;
//            pq.push(Rec(0,0));
//            while(!pq.empty()){
//                int u=pq.top().i;
//                pq.pop();
//                if(fix[u])continue;
//                fix[u]=true;
//                for(auto p:edg[u]){
//                    int v=p.first,w=p.second;
//                    if(dis[u]+w<dis[v]){
//                        dis[v]=dis[u]+w;
//                        pq.push(Rec(v,dis[v]));
//                    }
//                }
//            }
//            return dis;
//        }
//        public:
//        int reachableNodes(vector<vector<int>>& edges, int M, int N) {
//            n=N;
//            edg=vector<vector<pair<int,int>>>(n);
//            for(auto &e:edges){
//                edg[e[0]].push_back({e[1],e[2]+1});
//                edg[e[1]].push_back({e[0],e[2]+1});
//            }
//            auto dis=dijkstra();
//            int ans=0;
//            for(int i=0;i<n;i++)
//                if(dis[i]<=M)ans++;
//            for(auto &e:edges){
//                int l=M-dis[e[0]],r=M-dis[e[1]];
//                ans+=min(e[2],max(l,0)+max(r,0));
//            }
//            return ans;
//        }
//    };

    // igronemyk
//    public:
//    int reachableNodes(vector<vector<int>>& v, int m, int n) {
//        vector<int> dis(n, -1);
//        vector<vector<int>> hv(n, vector<int>());
//        vector<bool> vis(n, 0);
//        vector<int> ll(v.size(), 0), rr(v.size(), 0);
//        int ans = 0;
//        dis[0] = 0;
//        for (int i = 0; i < v.size(); i++) {
//            hv[v[i][0]].push_back(i);
//            hv[v[i][1]].push_back(i);
//        }
//        while (1) {
//            int tmp = -1;
//            for (int i = 0; i < n; i++)
//                if (!vis[i] && dis[i] != -1 && (tmp == -1 || dis[i] < dis[tmp]))
//                    tmp = i;
//            if (tmp == -1)
//                break;
//            vis[tmp] = 1;
//            for (int i : hv[tmp]) {
//                int to = v[i][0] == tmp ? v[i][1] : v[i][0];
//                int dd = dis[tmp] + v[i][2] + 1;
//                if (dis[to] == -1 || dd < dis[to])
//                    dis[to] = dd;
//            }
//        }
//        for (int i = 0; i < n; i++)
//            if (vis[i] && dis[i] <= m) {
//                ans++;
//                for (int j : hv[i])
//                    if (i == v[j][0])
//                        ll[j] = m - dis[i];
//                    else
//                        rr[j] = m - dis[i];
//            }
//        for (int i = 0; i < v.size(); i++)
//            ans += min(v[i][2], ll[i] + rr[i]);
//        return ans;
//    }



    // uwi
    public int projectionArea(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ret = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] > 0)ret++;
            }
        }
        for(int i = 0;i < n;i++){
            int max = 0;
            for(int j = 0;j < m;j++){
                max = Math.max(max, grid[i][j]);
            }
            ret += max;
        }
        for(int i = 0;i < m;i++){
            int max = 0;
            for(int j = 0;j < n;j++){
                max = Math.max(max, grid[j][i]);
            }
            ret += max;
        }
        return ret;
    }

    public int numRescueBoats(int[] a, int limit) {
        Arrays.sort(a);
        int n = a.length;
        int p = 0;
        int ct = 0;
        for(int i = n-1;i >= p;i--){
            if(p < i && a[i] + a[p] <= limit){
                p++;
            }
            ct++;
        }
        return ct;
    }

    public String decodeAtIndex(String S, int K) {
        char[] s = S.toCharArray();
        int n = s.length;
        long[] dp = new long[n+1];
        for(int i = 0;i < n;i++){
            if(s[i] >= '2' && s[i] <= '9'){
                dp[i+1] = dp[i] * (s[i]-'0');
            }else{
                dp[i+1] = dp[i] + 1;
            }
        }
        K--;
        for(int i = n-1;i >= 0;i--){
            K %= dp[i+1];
            if(K+1 == dp[i+1] && !(s[i] >= '2' && s[i] <= '9')){
                return "" + s[i];
            }
        }
        return null;
    }

    public int reachableNodes(int[][] edges, int M, int n) {
        int m = edges.length;
        int[] from = new int[m];
        int[] to = new int[m];
        int[] ws = new int[m];
        for(int i = 0;i < m;i++){
            from[i] = edges[i][0];
            to[i] = edges[i][1];
            ws[i] = edges[i][2]+1;
        }
        int[][][] g = packWU(n, from, to, ws);

        long[] td = dijkl(g, 0);

        int ret = 0;
        for(int i = 0;i < m;i++){
            long l = td[from[i]];
            long r = td[to[i]];
            long w = ws[i];
            if(l > M && r > M)continue;

            // l+k = r+(w-k)
            // k = (r-l+w)/2
            long ll = (r-l+w)/2;
            // [0,ll], [ll+1,w]
            if(l > M){
            }else if(l+ll <= M){
                ret += ll+1;
            }else{
                ret += M-l+1;
            }
            long rr = (w-(ll+1));
            if(r > M){
            }else if(r+rr <= M){
                ret += rr+1;
            }else{
                ret += M-r+1;
            }

            if(l <= M)ret--;
            if(r <= M)ret--;
//	        	tr(from[i], to[i], l, r, w, ret);
            // 012345678765
        }

        for(int i = 0;i < n;i++){
            if(td[i] <= M)ret++;
        }

        return ret;
    }

    int[][][] packWU(int n, int[] from, int[] to, int[] w) {
        int[][][] g = new int[n][][];
        int[] p = new int[n];
        for (int f : from)
            p[f]++;
        for (int t : to)
            p[t]++;
        for (int i = 0; i < n; i++)
            g[i] = new int[p[i]][2];
        for (int i = 0; i < from.length; i++) {
            --p[from[i]];
            g[from[i]][p[from[i]]][0] = to[i];
            g[from[i]][p[from[i]]][1] = w[i];
            --p[to[i]];
            g[to[i]][p[to[i]]][0] = from[i];
            g[to[i]][p[to[i]]][1] = w[i];
        }
        return g;
    }

    long[] dijkl(int[][][] g, int from)
    {
        int n = g.length;
        long[] td = new long[n];

        Arrays.fill(td, Long.MAX_VALUE / 2);
        MinHeapL q = new MinHeapL(n);
        q.add(from, 0);
        td[from] = 0;

        while(q.size() > 0){
            int cur = q.argmin();
            q.remove(cur);

            for(int[] e : g[cur]){
                int next = e[0];
                long nd = td[cur] + e[1];
                if(nd < td[next]){
                    td[next] = nd;
                    q.update(next, nd);
                }
            }
        }

        return td;
    }

    class MinHeapL {
        public long[] a;
        public int[] map;
        public int[] imap;
        public int n;
        public int pos;
        public long INF = Long.MAX_VALUE;

        public MinHeapL(int m)
        {
            n = Integer.highestOneBit((m+1)<<1);
            a = new long[n];
            map = new int[n];
            imap = new int[n];
            Arrays.fill(a, INF);
            Arrays.fill(map, -1);
            Arrays.fill(imap, -1);
            pos = 1;
        }

        public long add(int ind, long x)
        {
            int ret = imap[ind];
            if(imap[ind] < 0){
                a[pos] = x; map[pos] = ind; imap[ind] = pos;
                pos++;
                up(pos-1);
            }
            return ret != -1 ? a[ret] : x;
        }

        public long update(int ind, long x)
        {
            int ret = imap[ind];
            if(imap[ind] < 0){
                a[pos] = x; map[pos] = ind; imap[ind] = pos;
                pos++;
                up(pos-1);
            }else{
                a[ret] = x;
                up(ret);
                down(ret);
            }
            return x;
        }

        public long remove(int ind)
        {
            if(pos == 1)return INF;
            if(imap[ind] == -1)return INF;

            pos--;
            int rem = imap[ind];
            long ret = a[rem];
            map[rem] = map[pos];
            imap[map[pos]] = rem;
            imap[ind] = -1;
            a[rem] = a[pos];
            a[pos] = INF;
            map[pos] = -1;

            up(rem);
            down(rem);
            return ret;
        }

        public long min() { return a[1]; }
        public int argmin() { return map[1]; }
        public int size() {	return pos-1; }

        private void up(int cur)
        {
            for(int c = cur, p = c>>>1;p >= 1 && a[p] > a[c];c>>>=1, p>>>=1){
                long d = a[p]; a[p] = a[c]; a[c] = d;
                int e = imap[map[p]]; imap[map[p]] = imap[map[c]]; imap[map[c]] = e;
                e = map[p]; map[p] = map[c]; map[c] = e;
            }
        }

        private void down(int cur)
        {
            for(int c = cur;2*c < pos;){
                int b = a[2*c] < a[2*c+1] ? 2*c : 2*c+1;
                if(a[b] < a[c]){
                    long d = a[c]; a[c] = a[b]; a[b] = d;
                    int e = imap[map[c]]; imap[map[c]] = imap[map[b]]; imap[map[b]] = e;
                    e = map[c]; map[c] = map[b]; map[b] = e;
                    c = b;
                }else{
                    break;
                }
            }
        }
    }



}
