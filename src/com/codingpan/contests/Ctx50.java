package com.codingpan.contests;

import java.util.*;

public class Ctx50 {
    /**
     * uwi
     */
    public boolean validPalindrome(String S) {
        char[] s = S.toCharArray();
        if(ispal(s))return true;
        for(int i = 0, j = s.length-1;i < j;i++,j--){
            if(s[i] != s[j]){
                int n = s.length;
                {
                    char[] t = (S.substring(0, i) + S.substring(i+1)).toCharArray();
                    if(ispal(t))return true;
                }
                {
                    char[] t = (S.substring(0, j) + S.substring(j+1)).toCharArray();
                    if(ispal(t))return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean ispal(char[] a)
    {
        for(int i = 0, j = a.length-1;i < j;i++,j--){
            if(a[i] != a[j])return false;
        }
        return true;
    }

    //
    class MapSum {

        Map<String, Integer> map;

        /** Initialize your data structure here. */
        public MapSum() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int ret = 0;
            for(String key : map.keySet()){
                if(key.startsWith(prefix)){
                    ret += map.get(key);
                }
            }
            return ret;
        }
    }

    //
    public boolean checkValidString(String s) {
        char[] q = s.toCharArray();
        int[] dp = new int[300];
        dp[0] = 1;
        for(char c : q){
            int[] ndp = new int[300];
            if(c == '('){
                for(int i = 0;i < 299;i++){
                    ndp[i+1] = dp[i];
                }
            }else if(c == ')'){
                for(int i = 1;i < 300;i++){
                    ndp[i-1] = dp[i];
                }
            }else{
                for(int i = 0;i < 300;i++){
                    if(i+1 < 300)ndp[i+1] |= dp[i];
                    ndp[i] |= dp[i];
                    if(i-1 >= 0)ndp[i-1] |= dp[i];
                }
            }
            dp = ndp;
        }
        return dp[0] == 1;
    }

    //
//    public boolean judgePoint24(int[] nums) {
//        Arrays.sort(nums);
//        do{
//            if(go(nums))return true;
//        }while(nextPermutation(nums));
//        return false;
//    }

    boolean go(int[] a)
    {
        int[] ord = new int[3];
        for(int i = 0;i < 3;i++){
            ord[i] = i;
        }
        do{
            int[] b = new int[3];
            inner:
            do{
                int[] o = Arrays.copyOf(ord, 3);
                long[][] fs = new long[4][];
                for(int i = 0;i < 4;i++){
                    fs[i] = new long[]{a[i], 1};
                }
                for(int i = 0;i < 3;i++){
                    if(b[i] == 0){
                        fs[o[i]] = add(fs[o[i]], fs[o[i]+1]);
                    }else if(b[i] == 1){
                        fs[o[i]] = sub(fs[o[i]], fs[o[i]+1]);
                    }else if(b[i] == 2){
                        fs[o[i]] = mul(fs[o[i]], fs[o[i]+1]);
                    }else{
                        if(fs[o[i]+1][0] == 0)continue inner;
                        fs[o[i]] = div(fs[o[i]], fs[o[i]+1]);
                    }
                    for(int j = o[i]+1;j < 4-i-1;j++){
                        fs[j] = fs[j+1];
                    }
                    for(int j = i+1;j < 3;j++){
                        if(o[j] > o[i])o[j]--;
                    }
                }
                if(fs[0][0] == 24 && fs[0][1] == 1){
                    return true;
                }
            }while(inc(b, 4));
        }while(nextPermutation(ord));
        return false;
    }

    public long[] reduce(long[] f)
    {
        if(f[1] == 0) { // n/0
            f[0] = 1;
        }else if(f[0] == 0) { // 0/n
            f[1] = 1;
        }else {
            if(f[1] < 0) { // -a/-b ->a/b
                f[0] = -f[0];
                f[1] = -f[1];
            }
            long a = Math.abs(f[0]), b = f[1];
            while (b > 0) {
                long c = a;
                a = b;
                b = c % b;
            }
            f[0] /= a;
            f[1] /= a;
        }
        return f;
    }

    public long[] add(long[] a, long[] b){ return reduce(new long[]{a[0]*b[1]+a[1]*b[0], a[1]*b[1]}); }
    public long[] sub(long[] a, long[] b){ return reduce(new long[]{a[0]*b[1]-a[1]*b[0], a[1]*b[1]}); }
    public long[] mul(long[] a, long[] b){ return reduce(new long[]{a[0]*b[0], a[1]*b[1]}); }
    public long[] div(long[] a, long[] b){ return reduce(new long[]{a[0]*b[1], a[1]*b[0]}); }

    public boolean inc(int[] a, int base) {
        int n = a.length;
        int i;
        for (i = n - 1; i >= 0 && a[i] == base - 1; i--)
            ;
        if (i == -1)
            return false;

        a[i]++;
        Arrays.fill(a, i + 1, n, 0);
        return true;
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

    /**
     * Socyrus
     */
    char[] ops = new char[]{'+','-','*','/'};

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num: nums)
            list.add(1.0 * num);

        return search(list);
    }

    private boolean search(List<Double> list){
        if (list.size()==1){
            return list.get(0)==24.0;
        }

        List<Double> tmp = new ArrayList<>();
        for (int i=0; i<list.size(); i++)
            for (int j=0; j<list.size(); j++)
                if (i!=j){
                    for (char op: ops){
                        if ((op=='+' || op=='*') && (i>j)) continue;
                        if (op=='/' && list.get(j)==0.0) continue;
                        double res = 0.0;
                        switch(op){
                            case '+': res = list.get(i) + list.get(j);
                                break;
                            case '-': res = list.get(i) - list.get(j);
                                break;
                            case '*': res = list.get(i) * list.get(j);
                                break;
                            case '/': res = list.get(i) / list.get(j);
                                break;
                        }

                        tmp.clear();
                        tmp.add(res);
                        for (int k=0;k<list.size();k++)
                            if (k!=i && k!=j)
                                tmp.add(list.get(k));

                        boolean tmpRes = search(tmp);
                        if (tmpRes)
                            return true;
                    }
                }

        return false;
    }


}
