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

        //对所有格子进行初始化输入，死为0，活为1
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
        

        

    }
}

