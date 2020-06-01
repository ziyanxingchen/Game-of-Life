package Game;

import java.util.Random;

public class LifeGame {

   public String[][] create(String[][] map,int[] status){
	   //String[][] map = new String[8][8];
	   int n=0;
	   for (int i = 0; i < 8; i++) {
           for (int j = 0; j < 8; j++) {
               status[n] = new Random().nextInt(2);
               if (status[n] == 1)
                   map[i][j] = "●";
               else if (status[n] == 0)
                   map[i][j] = "○";
               n++;
           }
       }
	   return map;	   
   }

    //该方法检测所有位置，并返回对应位置的point数组
    //用point数组，记录对应位置下一轮的状态，1下一代死，2下一代继续活，3下一代复活
    public int[] check(String[][] map) {
        int n = 0;
        int point[] = new int[64];
        //统计周围邻居的情况
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //用life变量记录周围活着的邻居个数
                int life = 0;
                //1.判断正下方的位置
                if (i + 1 < 8 && map[i + 1][j].equals("●")) {
                    life++;
                }
                //2.判断右下位置
                if (i + 1 < 8 && j + 1 < 8 && map[i + 1][j + 1].equals("●")) {
                    life++;
                }
                //3.判断左下位置
                if (i + 1 < 8 && j - 1 >= 0 && map[i + 1][j - 1].equals("●")) {
                    life++;
                }
                //4.判断右侧位置
                if (j + 1 < 8 && map[i][j + 1].equals("●")) {
                    life++;
                }
                //5.判断左侧位置
                if (j - 1 >= 0 && map[i][j - 1].equals("●")) {
                    life++;
                }
                //6.判断正上方位置
                if (i - 1 >= 0 && map[i - 1][j].equals("●")) {
                    life++;
                }
                //7.判断右上位置
                if (i - 1 >= 0 && j + 1 < 8 && map[i - 1][j + 1].equals("●")) {
                    life++;
                }
                //8.判断左上位置
                if (i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j - 1].equals("●")) {
                    life++;
                }
                //用一个数组，记录对应位置下一轮的状态，1下一代死，2下一代继续活，3下一代复活
                if (map[i][j].equals("●")) {
                    if (life == 1)
                        point[n] = 1;
                    else if (life == 2 || life == 3)
                        point[n] = 2;
                   else if (life >= 4)
                        point[n] = 1;
                } else {
                    if (life == 3)
                        point[n] = 3;
                }                
                n++;
            }
        }
        return point;
    }

    public String[][] change(String[][] map, int[] point) {
        int n = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //变更状态
                if (point[n] == 1)
                    map[i][j] = "○";
                if (point[n] == 3)
                    map[i][j] = "●";
                n++;
            }
        }
        return map;
    }

    public void newMap(String[][] map){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 7)
                    System.out.println(map[i][j] + " ");
                else
                    System.out.print(map[i][j] + " ");
            }
        }
    }
}
