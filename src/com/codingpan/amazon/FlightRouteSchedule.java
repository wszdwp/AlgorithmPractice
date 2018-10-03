package com.codingpan.amazon;

import edu.princeton.cs.algs4.StdOut;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class FlightRouteSchedule {
    // simple version
    public List<List<Point>> scheduleAirRoute(int maxD, int[] f, int[] r) {
        List<List<Point>> res = new ArrayList<>();
        helper(maxD, f, r, 0, new ArrayList<Point>(), res);
        return res;
    }

    private void helper(int maxD, int[] f, int[] r, int fStart, List<Point> route, List<List<Point>> res) {
        if (maxD <= 0) {
            res.add(new ArrayList<>(route));
            return;
        } else {
            if (fStart < f.length) {
                int i = fStart;
                for (int j = 0; j < r.length; j++) {
                    int dist = f[i] + r[j];
                    if (maxD >= dist) {
                        route.add(new Point(f[i], r[j]));
                        helper(maxD-dist, f, r, i, route, res);
                    }
                }
                helper(maxD, f, r, i+1, route, res);
            }
        }
    }


    public static void main(String[] args) {
        FlightRouteSchedule solu = new FlightRouteSchedule();

        int maxD = 20;
        int[] f = {3, 6, 14};
        int[] r = {2, 9, 14};
        List<List<Point>> res = solu.scheduleAirRoute(maxD, f, r);
        for (List<Point> route : res) {
            for (Point p : route) {
                StdOut.print("(" + p.x + ", " + p.y + ")");
            }
            StdOut.println();
        }
    }
}
