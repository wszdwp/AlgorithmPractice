package com.codingpan.amazon;

import java.awt.Point;
import java.util.Queue;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class GolfEvent {
    class Cell {
        int x = 0;
        int y = 0;
        int h = 0;

        Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {
        int r = forest.size();
        int c = forest.get(0).size();

        List<Cell> trees = getTreeCells(forest, r, c);
        int totalSteps = 0;
        int sx = 0;
        int sy = 0;
        for (int i = 0; i < trees.size(); i++) {
            Cell cell = trees.get(i);
            int tx = cell.x;
            int ty = cell.y;
            int steps = BFS(forest, sx, sy, tx, ty);
            if (steps == -1) return -1;

            forest.get(tx).set(ty, 1);
            totalSteps += steps;
            sx = tx;
            sy = ty;
        }

        return totalSteps;
    }

    private List<Cell> getTreeCells(List<List<Integer>> forest, int r, int c) {
        List<Cell> trees = new LinkedList<Cell>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int height = forest.get(i).get(j);
                if (height > 1) {
                    Cell cell = new Cell(i, j, height);
                    trees.add(cell);
                }
            }
        }

        Collections.sort(trees, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.h - o2.h;
            }
        });

        return trees;
    }

    private int BFS(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];

        final int ROWS = forest.size();
        final int COLS = forest.get(0).size();

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(sx, sy));
        int steps = 0;
        while (!queue.isEmpty()) {
            int nodesCount = queue.size();
            while (nodesCount > 0) {
                Point p = queue.poll();
                nodesCount--;
                int x = p.x;
                int y = p.y;
                if (x == tx && y == ty) return steps;

                for (int i = 0; i < 4; i++) {
                    int nx = x + DIRS[i][0];
                    int ny = y + DIRS[i][1];

                    if (nx < 0 || nx == ROWS || ny < 0 || ny == COLS
                            || forest.get(nx).get(ny) == 0
                            || visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
            steps++;
        }

        return -1;
    }
}
