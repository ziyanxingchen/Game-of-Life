package Game;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] map = new String[8][8];
        int[] status=new int[64];
        LifeGame me = new LifeGame();
        me.create(map,status);
        
        System.out.println("初始状态为：");
        me.newMap(map);
        
        System.out.println("===========");


        int n = 0;
        int num = 0;//记录变化的次数
        while (n == 0) {

            //用point数组，记录对应位置下一轮的状态，1下一代死，2下一代继续活，3下一代复活
            int[] point = me.check(map);

            //获得下一次变化后的图形
            map = me.change(map, point).clone();
            System.out.println("第" + (++num) + "次变化：");

            //打印出来
            me.newMap(map);
            System.out.println("===========");
            System.out.println("输入0继续进行下一步，输入其他数字退出。");
            n = new Scanner(System.in).nextInt();
        }
    }
}
