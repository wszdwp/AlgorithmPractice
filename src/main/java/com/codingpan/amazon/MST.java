package com.codingpan.amazon;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MST {
    /**
     * 第二题：城市建路题。题目意思是有一定数量的城市，城市之间已经有了一些道路。 还有一些可以供选择的道路来建设。每个新建的道路有 cost。问如果要连接所有的城市，新建路的最小的 cost
     * 是多少。举个栗子： Input 如下： numTotalAvailableCities = 6 numTotalAvailableRoads = 3 roadsAvailable =
     * [[1, 4], [4, 5], [2, 3]] numNewRoadsConstruct = 4 costNewRoadsConstruct = [[1, 2, 5], [1, 3,
     * 10], [1, 6, 2], [5, 6, 5]]
     *
     * <p>Output 应该是： 7 解释：numTotalAvailableCities = 6 意思是城市的编号从 1 到 6。基于提供的 roadsAvailable list, 这 6
     * 个城市中 已经形成了三个岛， 分别为 [1, 4, 6], [2, 3] 和 [6]。 现在要从 costNewRoadsConstruct list 中选一些路来建使得所有的城市都被连接。
     * 这个例子中，显然要选择[1, 2, 5] 和 [1, 6, 2] 这两条路。 总的 cost 就是 5 + 2 = 7。
     *
     * <p>解题思路： 这是个最小生成树（MST）问题。但要注意整个图中已经有一些边了，不是从0开始的最小生成树。 具体来说，可以先Union-Find所有已经有的路 in
     * roadsAvailable list， 然后把所有可以建的路 in costNewRoadsConstruct list 按照 cost 排序放入 min-heap。 然后每次从
     * min-heap 中拿出最小 cost 的路来接着 Union-Find整个图。每次需要Union的时候，累积目前为止的 cost。 当总的 edges 数目等于总的 vertices
     * 数目减 1 时， 整个图就被构建成了一颗树。这时输入累积的cost作为输出。
     *
     * <p>注意： 这个题不太容易过所有的 com.codingpan.test case （目前有19个test cases），因为有些坑需要避免。 1.
     * 城市的ID是从1开始，不是从0开始。所以UnionFind的时候要多注意。 2. 输入的roadsAvailable list 和 costNewRoadsConstruct list
     * 互相之间可能有重复。所以不要在算Graph中的 edges 数目的时候要格外注意。
     *
     * @param numTotalAvailableCities
     * @param numTotalAvailableRoads
     * @param roadsAvailable
     * @param numNewRoadsConstruct
     * @param costNewRoadsConstruct
     * @return
     */
    public int getMinimunCostToConstruct(
            int numTotalAvailableCities,
            int numTotalAvailableRoads,
            List<List<Integer>> roadsAvailable,
            int numNewRoadsConstruct,
            List<List<Integer>> costNewRoadsConstruct) {
        int totalCost = 0;
        UF uf = new UF(numTotalAvailableCities);
        for (List<Integer> roads : roadsAvailable) {
            uf.union(roads.get(0) - 1, roads.get(1) - 1);
        }
        Collections.sort(
                costNewRoadsConstruct,
                new Comparator<List<Integer>>() {
                    @Override
                    public int compare(List<Integer> o1, List<Integer> o2) {
                        return o1.get(2) - o2.get(2);
                    }
                });

        for (int i = 0; i < numNewRoadsConstruct; i++) {
            List<Integer> newRoad = costNewRoadsConstruct.get(i);
            int city1 = newRoad.get(0) - 1;
            int city2 = newRoad.get(1) - 1;
            int cost = newRoad.get(2);
            if (uf.connected(city1, city2)) continue;
            if (uf.count == 1) break;
            uf.union(city1, city2);
            totalCost += cost;
        }

        return totalCost;
    }

    class UF {
        private int[] id;
        private int[] size;
        private int count;

        public UF(int N) {
            this.count = N;
            id = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
                size[i] = 1;
            }
        }

        public int count() {
            return count;
        }

        public boolean connected(int a, int b) {
            return root(a) == root(b);
        }

        public void union(int a, int b) {
            int rootA = root(a);
            int rootB = root(b);
            if (rootA == rootB) return;

            id[b] = rootA;
            size[a] += size[b];
            count--;
        }

        private int root(int a) {
            while (a != id[a]) {
                id[a] = id[id[a]]; // improvement 2
                a = id[a];
            }
            return a;
        }
    }

    private static List<List<Integer>> arrayToList(int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] one : arr) {
            List<Integer> aList = new ArrayList<>();
            for (int o : one) {
                aList.add(o);
            }
            list.add(aList);
        }
        return list;
    }

    public static void main(String[] args) {
        MST solu = new MST();
        int numTotalAvailableCities = 6;
        int numTotalAvailableRoads = 3;
        int[][] roadsAvailable = {
                {1, 4},
                {4, 5},
                {2, 3}
        };
        int numNewRoadsConstruct = 4;
        int[][] costNewRoadsConstruct = {
                {1, 2, 5},
                {1, 3, 10},
                {1, 6, 2},
                {5, 6, 5}
        };

        int cost =
                solu.getMinimunCostToConstruct(
                        numTotalAvailableCities,
                        numTotalAvailableRoads,
                        arrayToList(roadsAvailable),
                        numNewRoadsConstruct,
                        arrayToList(costNewRoadsConstruct));

        StdOut.println(cost);
    }
}
