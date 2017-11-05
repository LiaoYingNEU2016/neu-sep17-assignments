package midterm;

import java.util.ArrayList;
import java.util.Arrays;

public class Cell {
    int x, y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }

}

class q5{
    int[][] maze = {
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 1, 1},
    };
    int m = maze.length;
    int n = maze[0].length;
    ArrayList<Cell> result = new ArrayList<>();

    boolean findPath(int maze[][], int x, int y){

        if (x == m - 1 && y == n - 1){
            result.add(new Cell(m-1,n-1));
            return true;
        }
        if (isVaild(maze, x, y) == true){
            result.add(new Cell(x,y));

            if (findPath(maze, x + 1, y)){
                return true;
            }
            if (findPath(maze, x, y + 1)){
                return true;
            }
            result.remove(result.size()-1);

        }
        return false;
    }
    boolean isVaild(int maze[][], int x, int y){
        return (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 1);
    }

    public static void main(String[] args) {
        q5 t = new q5();
        t.findPath(t.maze,0,0);
        System.out.println(Arrays.toString(new ArrayList[]{t.result}));
    }
}





