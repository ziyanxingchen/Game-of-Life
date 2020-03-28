package Game;
import java.util.Random;
import java.util.Scanner;

    /*
    1.鐢熷懡灏忔父鎴忕殑閭诲眳涓轰笂涓嬪乏鍙冲拰鏂滃瑙掍竴鍏卞叓涓綅缃�;
    2.榛樿閫夋嫨8*8鐨勬牸瀛愩��
    3.灏嗛粯璁ょ殑鏍煎瓙鍒濆鍖栵紝骞舵墦鍗拌緭鍑�
    4.浣跨敤LifeGame涓殑鏂规硶鐢熸垚涓嬩竴杞殑鐘舵�侊紝骞舵墦鍗�
     */

public class Main {
    public static void main(String[] args) {
        String[][] map = new String[8][8];
        LifeGame me = new LifeGame();

        //瀵规墍鏈夋牸瀛愯繘琛屽垵濮嬪寲杈撳叆锛屾涓�0锛屾椿涓�1
        //闅忔満鐢熸垚鍚勪釜浣嶇疆鐨勯偦灞呮儏鍐�
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                int num = new Random().nextInt(2);
                if (num == 1)
                    map[i][j] = "鈼�";
                else if (num == 0)
                    map[i][j] = "鈼�";
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

