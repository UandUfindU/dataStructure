package code_04_2_queue;

// 导入自定义的顺序表和有序顺序表类
import code_02_2_2.SeqList;
import code_02_2_3_insert.SortedSeqList;

public class PrimeRing {
    // 构造方法，接收一个整数max，用于生成一个包含1到max的素数环
    public PrimeRing(int max) {
        SortedSeqList<Integer> primeset = createPrime(max); // 创建一个包含所有小于等于max的素数的有序顺序表
        System.out.println("素数集合: " + primeset.toString());
        
        SeqList<Integer> ring = new SeqList<Integer>(max); // 创建一个顺序表，用于存储最终的素数环
        ring.insert(1); // 将1插入到环中作为起始元素

        Queue<Integer> que = new SeqQueue<Integer>(max); // 创建一个顺序队列，用于存储待检查的数字
        // 下面的代码行被注释掉了，它是创建一个链式队列的替代方案
        // Queue<Integer> que = new LinkedQueue<Integer>();
        for (int i = 2; i <= max; i++) // 初始化队列，将2到max的数字加入队列
            que.add(i);
        System.out.println("初始队列: " + que.toString());
 
        int i = 0;
        while (!que.isEmpty()) {
            int key = que.poll(); // 从队列中取出一个数字
            // 下面的代码行被注释掉了，它用于调试输出
            // System.out.print("取出的数字: " + k + "\t");
            if (primeset.contains(ring.get(i) + key)) { // 如果当前环的最后一个数字与取出的数字之和是素数
                i++;
                ring.insert(key); // 将取出的数字插入到环中
            } else {
                que.add(key); // 如果不是素数，则将数字重新加入队列
            }
            // 下面的代码行被注释掉了，它用于调试输出队列的状态
            // System.out.println("当前队列: " + que.toString());
        }
        System.out.println("1到" + max + "的素数环: " + ring.toString());
    }
    
    // 创建一个有序顺序表，包含从2到max的所有素数
    public SortedSeqList<Integer> createPrime(int max) {
        if (max <= 0)
            return null;
        SortedSeqList<Integer> primeset = new SortedSeqList<Integer>(max * 2); // 初始化有序顺序表，大小为max的两倍
        primeset.insert(2); // 插入第一个素数2
        for (int key = 3; key < max * 2; key += 2) { // 从3开始，只检查奇数
            int i = 0;
            while (i < primeset.size() && key % primeset.get(i) != 0) // 检查当前数字是否能被有序顺序表中的素数整除
                i++;
            if (i == primeset.size()) // 如果当前数字不能被任何素数整除，则它是一个素数
                primeset.insert(key); // 将素数插入到有序顺序表中
        }
        return primeset;
    }    
    
    public static void main(String args[]) {
         new PrimeRing(10); // 测试程序，生成一个包含1到10的素数环
    }
}

/*
以下是被注释掉的代码和输出示例，用于说明程序的行为
输出示例:
素数集合: SortedSeqList(2, 3, 5, 7, 11, 13, 17, 19) 
初始队列: SeqQueue(2,3,4,5,6,7,8,9,10)
1到10的素数环: SeqList(1, 2, 3, 4, 7, 10, 9, 8, 5, 6) 

素数集合: (2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37) 
初始队列: SeqQueue(2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
1到20的素数环: (1, 2, 3, 4, 7, 10, 13, 16, 15, 8, 9, 14, 17, 20, 11, 12, 19, 18*/