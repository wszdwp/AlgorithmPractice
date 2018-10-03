package com.codingpan.amazon;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class OA201808 {

    /**
     * Created by Tian on 2017/8/6.
     */
    class Point {
        int x;
        int y;
        int val;
        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[][] maze1 = {{1,0,0,0,0},{1,1,1,1,1},{1,0,0,0,0},{0,0,9,0,0}};
        int[][] maze2 = {{1,0,0,0,0},{1,1,1,1,1},{1,0,0,0,1},{0,0,9,1,1}};
        int[][] maze3 = {{1,1,1,1},{1,0,0,0},{1,9,0,0}};
        int[][] maze4 = {{9}};
        int[][] maze5 ={{1,1,1,1,1,1},{1,1,1,1,0,0},{0,0,1,0,0,0},{1,1,1,1,1,1},{1,0,0,0,1,0},{1,1,1,0,9,0}};

        OA201808 mz = new OA201808();
        System.out.println(mz.maze(maze1, 0, 0));
        System.out.println(mz.maze(maze2, 0, 0));
        System.out.println(mz.maze(maze3, 0, 0));
        System.out.println(mz.maze(maze4, 0, 0));
        System.out.println(mz.maze(maze5, 0, 0));

        int[][] golf1 ={{1,1,0,2}, {3,1,1,1}};
        System.out.println(mz.golf(golf1, 0, 0));
    }

    public int golf(int[][] golf, int x, int y) {
        if (golf == null) return 0;
        // find all trees
        int n = golf.length;
        int m = golf[0].length;

        Map<Integer, Point> map = new TreeMap<Integer, Point>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (golf[i][j] > 1) {
                    map.put(golf[i][j], new Point(i, j, golf[i][j]));
                }
            }
        }
        Point lastpoint = null, point2;
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(0,0, golf[0][0]));
        queue.offer(new Point(0,m-1, golf[0][m-1]));
        queue.offer(new Point(n-1,0, golf[n-1][0]));
        queue.offer(new Point(n-1,m-1, golf[n-1][m-1]));

        int steps = 0;
        for (Point p : map.values()) {
            point2 = p;
            int step = bfs(golf, queue, point2);
            System.out.println(p.x + "-" + p.y + "-" + step);
            if (step == -1) return -1;
            steps += step;
            queue.clear();
            lastpoint = new Point(p.x, p.y, golf[p.x][p.y]);
            queue.offer(lastpoint);//new value
        }

        queue.clear();
        queue.offer(new Point(0,0, golf[0][0]));
        queue.offer(new Point(0,m-1, golf[0][m-1]));
        queue.offer(new Point(n-1,0, golf[n-1][0]));
        queue.offer(new Point(n-1,m-1, golf[n-1][m-1]));
        if (lastpoint != null) {
            int rest = bfs(golf, queue, lastpoint);
            if (rest > 0) {
                steps += rest;
            }
        }
        return steps;
    }

    private int bfs(int[][] matrix, Queue<Point> queue, Point target) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] visited = new boolean[n][m];
        int[] gx = {0, 0, 1, -1};
        int[] gy = {1, -1, 0, 0};

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                System.out.println(":" + p.val + "x" + p.x + "y" + p.y);
                if (p.val != 1) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = gx[k] + p.x;
                    int ny = gy[k] + p.y;
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m ||
                            visited[nx][ny] == true) {
                        continue;
                    }
                    if (nx == target.x && ny == target.y) {
                        matrix[nx][ny] = 1;//cut the tree;
                        return steps;
                    } else if (matrix[nx][ny] != 1) {
                        continue;
                    }
                    queue.offer(new Point(nx, ny, matrix[nx][ny]));
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }

    public boolean maze(int[][] maze, int x, int y) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }

        int n = maze.length;
        int m = maze[0].length;


        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(x, y, maze[x][y]));

        int[] gx = {0, 0 , 1, -1};
        int[] gy = {1,-1, 0, 0};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point p = queue.poll();
                if (p.val == 9) return true;
                if (p.val == 0) continue;

                for (int i = 0; i < 4; i++) {
                    int nx = gx[i] + p.x;
                    int ny = gy[i] + p.y;
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m ||
                            maze[nx][ny] <= 0) {
                        continue;
                    }
                    if (maze[nx][ny] == 9) return true;
                    queue.offer(new Point(nx, ny, maze[nx][ny]));
                    maze[nx][ny] = -1;
                }
            }
        }
        return false;
    }
}
