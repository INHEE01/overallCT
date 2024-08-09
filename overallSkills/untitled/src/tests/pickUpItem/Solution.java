package tests.pickUpItem;

import java.util.*;

class Solution {
    // 2D character array to represent the map or grid, with a maximum size of 101x101
    static char map[][] = new char[101][101];
    /**
     * The solution method that takes the rectangle coordinates and the start and item positions.
     * It returns the shortest path from the start position (X, Y) to the item position (itemX, itemY).
     *
     * @param rectangle Array of rectangles defined by two diagonal points (x1, y1) and (x2, y2)
     * @param X         The starting X-coordinate
     * @param Y         The starting Y-coordinate
     * @param itemX     The X-coordinate of the item
     * @param itemY     The Y-coordinate of the item
     * @return          The shortest path length from (X, Y) to (itemX, itemY)
     */
    public int solution(int[][] rectangle, int X, int Y, int itemX, int itemY) {
        // Loop through each rectangle and draw it on the map by marking the boundary and inside
        for(int i = 0; i < rectangle.length; i++) {
            int y1 = rectangle[i][1];
            int x1 = rectangle[i][0];
            int y2 = rectangle[i][3];
            int x2 = rectangle[i][2];
            draw(y1 * 2, x1 * 2, y2 * 2, x2 * 2);
        }

        // Perform BFS to find the shortest path from the start to the item position
        return bfs(Y * 2, X * 2, itemY * 2, itemX * 2);
    }

    /**
     * Performs Breadth-First Search (BFS) to find the shortest path in the grid.
     *
     * @param Y        The starting Y-coordinate (doubled)
     * @param X        The starting X-coordinate (doubled)
     * @param findY    The target Y-coordinate (doubled)
     * @param findX    The target X-coordinate (doubled)
     * @return         The shortest path length divided by 2 to account for the doubling
     */
    public static int bfs(int Y, int X, int findY, int findX) {
        // Direction vectors for moving up, down, left, and right
        int yy[] = {-1, 1, 0, 0};
        int xx[] = {0, 0, -1, 1};

        // Queue for BFS, storing the current position and path length
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{Y, X, 0});

        // Visited array to keep track of visited positions
        boolean visited[][] = new boolean[101][101];

        // BFS loop
        while(!queue.isEmpty()) {
            Integer temp[] = queue.poll();
            int prevY = temp[0];
            int prevX = temp[1];
            int count = temp[2];

            // If we reached the target position, return the path length divided by 2
            if(prevY == findY && prevX == findX)
                return count / 2;

            // Explore all four possible directions
            for(int i = 0; i < 4; i++) {
                int nextY = prevY + yy[i];
                int nextX = prevX + xx[i];

                // Skip if the position is out of bounds or already visited or not on the boundary
                if(nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map[0].length)
                    continue;
                if(visited[nextY][nextX] == true || map[nextY][nextX] != '2')
                    continue;

                // Mark as visited and add to the queue with the incremented path length
                visited[nextY][nextX] = true;
                queue.add(new Integer[]{nextY, nextX, count + 1});
            }
        }

        return 0;
    }

    /**
     * Draws the rectangle on the grid, marking the boundary with '2' and the inside with '1'.
     *
     * @param y1  The starting Y-coordinate of the rectangle (doubled)
     * @param x1  The starting X-coordinate of the rectangle (doubled)
     * @param y2  The ending Y-coordinate of the rectangle (doubled)
     * @param x2  The ending X-coordinate of the rectangle (doubled)
     */
    public static void draw(int y1, int x1, int y2, int x2) {
        for(int i = y1; i <= y2; i++) {
            for(int j = x1; j <= x2; j++) {
                // Skip if the current cell is already marked as inside
                if(map[i][j] == '1') continue;

                // Mark the inside of the rectangle with '1'
                map[i][j] = '1';

                // Mark the boundary of the rectangle with '2'
                if(i == y1 || i == y2 || j == x1 || j == x2)
                    map[i][j] = '2';
            }
        }
    }
}