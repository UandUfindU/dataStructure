package Maze;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入迷宫的行列数（m * n）:");
//        int m = scanner.nextInt();
//        int n = scanner.nextInt();
//        Maze[][] mazes = new Maze[m][n];

//    	System.out.println("请输入迷宫的路径");
//        for (int i=0;i<m;i++){
//            for (int j=0;j<n;j++){
//                mazes[i][j] = new Maze(i,j,scanner.nextInt());
//            }
//        }
        Maze[][] mazes = new Maze[][]{
                {new Maze(0,0,0),new Maze(0,1,1),new Maze(0,2,0)},
                {new Maze(1,0,0),new Maze(1,1,0),new Maze(1,2,0)},
                {new Maze(2,0,1),new Maze(2,1,0),new Maze(2,2,0)}
        };
        MazeGame mazeGame = new MazeGame(mazes);
        mazeGame.start();
    }
}