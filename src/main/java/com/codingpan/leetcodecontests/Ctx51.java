package com.codingpan.leetcodecontests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ctx51 {
  /**
   * uwi
   *
   * @param ops
   * @return
   */
  public int calPoints(String[] ops) {
    int[] stack = new int[20000];
    int p = 0;
    for (String s : ops) {
      if (s.equals("C")) {
        if (p > 0) p--;
      } else if (s.equals("D")) {
        if (p - 1 < 0) continue;
        stack[p] = stack[p - 1] * 2;
        p++;
      } else if (s.equals("+")) {
        if (p - 2 < 0) continue;
        stack[p] = stack[p - 1] + stack[p - 2];
        p++;
      } else {
        int val = Integer.parseInt(s);
        stack[p++] = val;
      }
    }
    int ret = 0;
    for (int i = 0; i < p; i++) {
      ret += stack[i];
    }
    return ret;
  }

  //
  public String nextClosestTime(String time) {
    int my = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));

    int mind = 9999;
    String best = "~";
    for (int i = 0; i < 5; i++) {
      if (i == 2) continue;
      for (int j = 0; j < 5; j++) {
        if (j == 2) continue;
        int h = (time.charAt(i) - '0') * 10 + time.charAt(j) - '0';
        if (h >= 24) continue;
        for (int k = 0; k < 5; k++) {
          if (k == 2) continue;
          for (int l = 0; l < 5; l++) {
            if (l == 2) continue;
            int m = (time.charAt(k) - '0') * 10 + time.charAt(l) - '0';
            if (m >= 60) continue;
            int t = 60 * h + m;
            int d = t - my;
            if (d <= 0) d += 1440;
            if (d < mind) {
              mind = d;
              best = String.format("%02d:%02d", h, m);
            }
          }
        }
      }
    }
    return best;
  }

  //
  int n = 10000;

  public int[] findRedundantConnection(int[][] edges) {
    upper = new int[n];
    Arrays.fill(upper, -1);
    for (int[] e : edges) {
      if (union(e[0], e[1])) {
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
    for (int u : upper) if (u < 0) ct++;
    return ct;
  }

  //
  public int kEmptySlots(int[] flowers, int k) {
    LST lst = new LST(30000);
    int day = 1;
    for (int v : flowers) {
      int ne = lst.next(v);
      int pr = lst.prev(v);
      if (ne != -1 && ne - v - 1 == k) {
        return day;
      }
      if (pr != -1 && v - pr - 1 == k) {
        return day;
      }
      lst.set(v);
      day++;
    }
    return -1;
  }

  public class LST {
    public long[][] set;
    public int n;
    //	    	public int size;

    public LST(int n) {
      this.n = n;
      int d = 1;
      for (int m = n; m > 1; m >>>= 6, d++)
        ;

      set = new long[d][];
      for (int i = 0, m = n >>> 6; i < d; i++, m >>>= 6) {
        set[i] = new long[m + 1];
      }
      //	    		size = 0;
    }

    // [0,r)
    public LST setRange(int r) {
      for (int i = 0; i < set.length; i++, r = r + 63 >>> 6) {
        for (int j = 0; j < r >>> 6; j++) {
          set[i][j] = -1L;
        }
        if ((r & 63) != 0) set[i][r >>> 6] |= (1L << r) - 1;
      }
      return this;
    }

    // [0,r)
    public LST unsetRange(int r) {
      if (r >= 0) {
        for (int i = 0; i < set.length; i++, r = r + 63 >>> 6) {
          for (int j = 0; j < r + 63 >>> 6; j++) {
            set[i][j] = 0;
          }
          if ((r & 63) != 0) set[i][r >>> 6] &= ~((1L << r) - 1);
        }
      }
      return this;
    }

    public LST set(int pos) {
      if (pos >= 0 && pos < n) {
        //	    			if(!get(pos))size++;
        for (int i = 0; i < set.length; i++, pos >>>= 6) {
          set[i][pos >>> 6] |= 1L << pos;
        }
      }
      return this;
    }

    public LST unset(int pos) {
      if (pos >= 0 && pos < n) {
        //	    			if(get(pos))size--;
        for (int i = 0; i < set.length && (i == 0 || set[i - 1][pos] == 0L); i++, pos >>>= 6) {
          set[i][pos >>> 6] &= ~(1L << pos);
        }
      }
      return this;
    }

    public boolean get(int pos) {
      return pos >= 0 && pos < n && set[0][pos >>> 6] << ~pos < 0;
    }

    public int prev(int pos) {
      for (int i = 0; i < set.length && pos >= 0; i++, pos >>>= 6, pos--) {
        int pre = prev(set[i][pos >>> 6], pos & 63);
        if (pre != -1) {
          pos = pos >>> 6 << 6 | pre;
          while (i > 0) pos = pos << 6 | 63 - Long.numberOfLeadingZeros(set[--i][pos]);
          return pos;
        }
      }
      return -1;
    }

    public int next(int pos) {
      for (int i = 0; i < set.length && pos >>> 6 < set[i].length; i++, pos >>>= 6, pos++) {
        int nex = next(set[i][pos >>> 6], pos & 63);
        if (nex != -1) {
          pos = pos >>> 6 << 6 | nex;
          while (i > 0) pos = pos << 6 | Long.numberOfTrailingZeros(set[--i][pos]);
          return pos;
        }
      }
      return -1;
    }

    private int prev(long set, int n) {
      long h = Long.highestOneBit(set << ~n);
      if (h == 0L) return -1;
      return Long.numberOfTrailingZeros(h) - (63 - n);
    }

    private int next(long set, int n) {
      long h = Long.lowestOneBit(set >>> n);
      if (h == 0L) return -1;
      return Long.numberOfTrailingZeros(h) + n;
    }

    @Override
    public String toString() {
      List<Integer> list = new ArrayList<Integer>();
      for (int pos = next(0); pos != -1; pos = next(pos + 1)) {
        list.add(pos);
      }
      return list.toString();
    }

    /** cchao */
    //        class MinWindowSubString {
    //            bool v[128];
    //            string ret;
    //            bool f(int &a, int &b) {
    //                b += 1;
    //                if (b == 60) {
    //                    b = 0;
    //                    a += 1;
    //                    if (a == 24) {
    //                        a = 0;
    //                    }
    //                }
    //                char s[22];
    //                sprintf(s, "%02d:%02d", a, b);
    //                ret = string(s);
    //                for (char c : ret) if (!v[c]) return false;
    //                return true;
    //            }
    //            public:
    //            string nextClosestTime(string time) {
    //                memset(v, 0, sizeof v);
    //                for (char c : time) v[c] = true;
    //                int a = stoi(time.substr(0, 2));
    //                int b = stoi(time.substr(3, 2));
    //                while (!f(a, b));
    //                return ret;
    //            }
    //        };

    /** lympanda */
    //        int p[3000];
    //
    //        class MinWindowSubString {
    //            public:
    //            vector<int> findRedundantConnection(vector<vector<int> >& edges) {
    //                int i,j,k,n,x,y,tmp;
    //                vector<int> ans;
    //                n=edges.size();
    //                for (i=0;i<3000;i++)
    //                    p[i]=i;
    //                for (i=0;i<n;i++)
    //                {
    //                    x=edges[i][0];
    //                    y=edges[i][1];
    //                    if (p[x]==p[y]) return edges[i];
    //                    tmp=p[y];
    //                    for (j=0;j<3000;j++)
    //                        if (p[j]==tmp) p[j]=p[x];
    //                }
    //                return ans;
    //            }
    //        };

    /** lucasjl */
    //        class MinWindowSubString {
    //            public:
    //            int kEmptySlots(vector<int>& flowers, int k) {
    //                int n = flowers.size();
    //                set<int> s;//({0, n + 1});
    //                for (int i = 0; i < n; ++i) {
    //                    auto rsp = s.insert(flowers[i]);
    //                    if (!rsp.second) return -1;
    //                    auto itr = rsp.first;
    //                    if (itr != s.begin() && itr != s.end() &&
    //                            flowers[i] - *prev(itr) - 1 == k || *next(itr) - flowers[i] - 1 ==
    // k)
    //                    return i + 1;
    //                }
    //                return -1;
    //            }
    //        };

  }
}
