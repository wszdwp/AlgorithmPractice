package com.codingpan.amazon;

import com.codingpan.leetcode.util.Utility;

import java.util.*;
import java.util.List;

public class AirFlightRouteSchedule {
    /**
     * A flight has maximum distance needs to be assigned one forward and one return route,
     * A route is {routeId, distanceOfRoute} structure
     * Given a list of forward routes and a list of return routes,
     * assign one forward and one return to given flight,achieve optimum schedule
     * the result returned is a list of {{forward_routeId, return_routeId}}
     *
     * A optimal route schedule has two conditions:
     * 1. sum of the forward and backward distance cannot exceeds limit of the flight distance
     * 2. no other other routes are better than the assigned routes pair
     *
     * one route can only be assigned one time
     *
     * eg1:
     * maxDistance: 20
     * forwardRoutes: {{1, 4}, {2, 8}, {3, 14}}
     * returnRoutes: {{1, 2}, {2, 9}, {3, 14}}
     * return {{1, 3}}
     *
     * eg1:
     * maxDistance: 20
     * forwardRoutes: {{1, 1}, {2, 7}, {3, 2}}
     * returnRoutes: {{1, 3}, {2, 9}, {3, 5}}
     * return
     * {{2, 1}, {1, 2}} or {{1, 1}, {2, 2}}
     *
     *
     *
     * @param maxDistance
     * @param forwardRoutes
     * @param returnRoutes
     * @return
     */
    public List<List<Integer>> scheduleRoute(int maxDistance,
                                             List<List<Integer>> forwardRoutes,
                                             List<List<Integer>> returnRoutes) {
        List<List<Integer>> res = new ArrayList<>();
        if (maxDistance <= 0) return res;

//        Collections.sort(forwardRoutes, new ListComparator());
//        Collections.sort(returnRoutes, new ListComparator());

        scheduleHelper(maxDistance, forwardRoutes, returnRoutes, 0, res);
        return res;
    }

    private List<List<Integer>> bruteForce(int maxD, List<List<Integer>> f, List<List<Integer>> r) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= maxD; i++) {
            List<Integer> one = findValidRoutePair(maxD, f, r);
            if (one != null) res.add(one);
        }

        return res;
    }

    private List<Integer> findValidRoutePair(int maxD, List<List<Integer>> f, List<List<Integer>> r) {
        List<Integer> routePair = new ArrayList<>();
        for (int i = 0; i < f.size(); i++) {
            for (int j = 0; j < r.size(); j++) {
                List<Integer> fRoute = f.get(i);
                List<Integer> rRoute = r.get(i);
                if (fRoute.get(1) + rRoute.get(1) <= maxD) {
                    routePair.add(fRoute.get(0));
                    routePair.add(rRoute.get(0));
                    return routePair;
                }
            }
        }
        return null;
    }


    private void scheduleHelper(int mD, List<List<Integer>> forwardRoutes, List<List<Integer>> returnRoutes,
                                int fStart,
                                List<List<Integer>> res) {
        if (fStart == forwardRoutes.size()) {
            return;
        } else {
            if (fStart < forwardRoutes.size()) {
                int i = fStart;
                for (int j = 0; j < returnRoutes.size(); j++) {
                    //StdOut.println("i, j " + i + ", " + j);
                    List<Integer> fRoute = forwardRoutes.get(i);
                    List<Integer> rRoute = returnRoutes.get(j);
                    int dist = fRoute.get(1) + rRoute.get(1);
                    if (mD >= dist) {
                        List<Integer> one = new ArrayList<>();
                        one.add(fRoute.get(0));
                        one.add(rRoute.get(0));
                        res.add(one);
                        scheduleHelper(mD - dist, forwardRoutes, returnRoutes, i+1, res);
                    }
                }
                scheduleHelper(mD, forwardRoutes, returnRoutes, i+1, res);
            }
        }
    }

    /**
     * reverse order list comparator
     */
    class ListComparator implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> l1, List<Integer> l2) {
            return l2.get(1) - l1.get(1);
        }
    }

    public static void main(String[] args) {
        AirFlightRouteSchedule solu = new AirFlightRouteSchedule();

        int maxDistance = 20;
        List<List<Integer>> forwardRoutes = new ArrayList<>();
        forwardRoutes.add(Arrays.asList(new Integer[]{1, 3}));
        forwardRoutes.add(Arrays.asList(new Integer[]{2, 6}));
        forwardRoutes.add(Arrays.asList(new Integer[]{3, 14}));

        List<List<Integer>> returnRoutes = new ArrayList<>();
        returnRoutes.add(Arrays.asList(new Integer[]{1, 2}));
        returnRoutes.add(Arrays.asList(new Integer[]{2, 9}));
        returnRoutes.add(Arrays.asList(new Integer[]{3, 14}));

//        int maxDistance = 20;
//        List<List<Integer>> forwardRoutes = new ArrayList<>();
//        forwardRoutes.add(Arrays.asList(new Integer[]{1, 1}));
//        forwardRoutes.add(Arrays.asList(new Integer[]{2, 7}));
//        forwardRoutes.add(Arrays.asList(new Integer[]{3, 2}));
//
//        List<List<Integer>> returnRoutes = new ArrayList<>();
//        returnRoutes.add(Arrays.asList(new Integer[]{1, 3}));
//        returnRoutes.add(Arrays.asList(new Integer[]{2, 9}));
//        returnRoutes.add(Arrays.asList(new Integer[]{3, 5}));

        List<List<Integer>> res = solu.scheduleRoute(maxDistance, forwardRoutes, returnRoutes);
        for (List<Integer> ans : res) {
            Utility.printList(ans);
        }

    }

}
