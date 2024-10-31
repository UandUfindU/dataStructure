package Maze;

public class MazeGame {
    private Maze[][] mazes;
    public MazeGame(Maze[][] mazes){
        this.mazes = mazes;
    }
 
    public void start(){
        int startX = 0;
        int startY = 0;
        MyStack stack = new MyStack();
        mazeGamePrint();  //输出迷宫
        if (mazes[startX][startY].getValue() == 0){              // 入口是否为0
            stack.push(mazes[startX][startY]);
            mazes[startX][startY].setValue(2);                  //将以走过的路径置为2
        }else{
            System.out.println("no way");
            return ;
        }
        if(road(stack)){    //如果走到出口了 
            stack.printStack();  //输出栈内所有走过的坐标
            mazeGamePrint();    //输出迷宫
        }else{  //如果无路可选，则输出no way
            System.out.println("no way！");
            mazeGamePrint();
        }
    }
 
    private boolean road(MyStack stack) {
        while(!stack.isEmpty()){
            int temp = stack.getTop();                              //栈顶元素
            int startX = stack.getMazes(temp).getX();
            int startY = stack.getMazes(temp).getY();
            if (startX == mazes.length-1 && startY == mazes[0].length-1){       //到达终点
                System.out.println("路径走过的坐标");
                return true;
            }else if (hasRoad(stack,startX,startY)){       //没有到达终点 且有路可走
                if(startY<mazes[0].length-1 && mazes[startX][startY+1].getValue() == 0){       //向下
	                stack.push(mazes[startX][startY+1]);
	                mazes[startX][startY+1].setValue(2);
                } else if (startX < mazes.length-1 && mazes[startX+1][startY].getValue() == 0){       //向右
                    stack.push(mazes[startX+1][startY]);
                    mazes[startX+1][startY].setValue(2);
                }else if (startY > 0 && mazes[startX][startY-1].getValue() == 0){       //向上
                    stack.push(mazes[startX][startY-1]);
                    mazes[startX][startY-1].setValue(2);
                } else if (startX > 0 && mazes[startX-1][startY].getValue() == 0){   //向左
                    stack.push(mazes[startX-1][startY]);
                    mazes[startX-1][startY].setValue(2);
                }
            }else{  //没路可走，退一步
                stack.pop();
                mazes[startX][startY].setValue(-1);
            }
        }
        return false;
    }
 
    private boolean hasRoad(MyStack stack,int startX,int startY) {
        if (startY<mazes[0].length-1 && mazes[startX][startY+1].getValue() == 0 ||
                startX < mazes.length-1 && mazes[startX+1][startY].getValue() == 0 ||
                startX > 0 && mazes[startX-1][startY].getValue() == 0 ||
                startY > 0 && mazes[startX][startY-1].getValue() == 0){
            return true;
        }
        return false;
    }
 
    public void mazeGamePrint(){
        for (int i=0;i<mazes.length;i++){
            for (int j=0;j<mazes[0].length;j++){
                System.out.print(mazes[i][j].getValue()+" ");
            }
            System.out.println();
        }
    }
}