package Maze;

public class MyStack {
    // 定义栈的最大容量
    private final static int MAXSIZE = 10;
    // 栈顶指针，用于追踪栈顶元素的位置
    private int top;
    // 存储迷宫对象的数组
    private Maze[] mazes;
 
    // 获取指定索引处的迷宫对象
    public Maze getMazes(int i) {
        return mazes[i];
    }
 
    // 设置迷宫数组
    public void setMazes(Maze[] mazes) {
        this.mazes = mazes;
    }
 
    // 获取栈顶指针的位置
    public int getTop() {
        return top;
    }
 
    // 设置栈顶指针的位置
    public void setTop(int top) {
        this.top = top;
    }
 
    // 构造方法，初始化栈
    public MyStack(){
        top = -1;               // 初始化栈顶指针为-1，表示栈为空
        mazes = new Maze[MAXSIZE]; // 创建一个迷宫数组，大小为最大容量
    }
    // 判断栈是否为空
    public boolean isEmpty(){
        if (top == -1){
            return true; // 如果栈顶指针为-1，则栈为空
        }
        return false; // 否则，栈不为空
    }
    // 判断栈是否已满
    public boolean isFull(){
        if (top == MAXSIZE - 1){ // 栈满的条件是栈顶指针等于最大容量减1
            return true; // 如果栈满，则返回true
        }
        return false; // 否则，返回false
    }
    // 出栈操作
    public void pop(){
        if (!isEmpty()) { // 如果栈不为空，则执行出栈操作
            top--; // 将栈顶指针减1，表示移除栈顶元素
        }
    }
    // 入栈操作
    public void push(Maze maze){
        if (!isFull()) { // 如果栈未满，则执行入栈操作
            top++; // 将栈顶指针加1，指向新的栈顶位置
            mazes[top] = maze; // 将迷宫对象存入栈顶位置
        }
    }
 
    // 打印栈内容
    public void printStack(){
        for (int i = 0; i <= top; i++){ // 遍历栈中的所有元素
            System.out.println("(" + mazes[i].getX() + "," + mazes[i].getY() + ")"); // 打印每个迷宫对象的坐标
        }
    }
}
