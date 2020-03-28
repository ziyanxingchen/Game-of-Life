package Game;
import java.util.Random;
import java.util.Scanner;

     /*
    1.生命小游戏的邻居为上下左右和斜对角一共八个位置;
    2.默认选择8*8的格子。
    3.将默认的格子初始化，并打印输出
    4.使用LifeGame中的方法生成下一轮的状态，并打印
     */

public class Main {
    public static void main(String[] args) {
        String[][] map = new String[8][8];
        LifeGame me = new LifeGame();

        //对所有细胞进行初始化输入，死为0，活为1
        //随机生成各个位置的邻居情况
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                int num = new Random().nextInt(2);
                if (num == 1)
                    map[i][j] = "●";
                else if (num == 0)
                    map[i][j] = "○";
            }
        }
        System.out.println("初始状态为：");
        me.newMap(map);
        System.out.println("===========");

        int n = 0;
        int num = 0;//记录变化的次数
        while (n == 0) {

            //用point数组，记录对应位置下一轮的状态，1下一代死，2下一代继续活，3下一代复活
            int[] point = me.check(map, new int[64]);

            //获得下一次变化后的图形
            map = me.getNext(map, point).clone();

            System.out.println("第" + (++num) + "次变化：");

            //打印出来
            me.newMap(map);
            System.out.println("===========");

            System.out.println("输入0继续进行下一步，输入其他数字退出。");
            n = new Scanner(System.in).nextInt();
        }
    }
}

