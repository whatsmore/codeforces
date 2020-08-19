import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    /*code forces 1363/C Game On Leaves
        给出一颗不循环的无向无根树和一个特殊数字，每次去掉一个叶子点和这个点所连接的边，输出点到特殊数字的人，先手为Ayush，后手Ashish
        测试用例1：
            输入：1//表示一个测试用例
                 3 1//表示有3个节点和特殊数字为1
                 2 1//表示节点2和节点1有一条边
                 3 1//表示节点3和节点1有一条边
             输出：
                 Ashish//后手胜利
        测试用例2：
            输入：1
                 3 2
                 2 1
                 3 1
             输出：
                 Ayush
     */
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int testCount = scr.nextInt();
        for (int i = 0; i < testCount; i++) {
            System.out.println(gameOnLeaves(scr) ? "Ayush" : "Ashish");
        }
    }

    static boolean gameOnLeaves(Scanner scr) {
        int pointCount = scr.nextInt();
        int specialNums = scr.nextInt();
        int notSpecialEdges = 0;
        int specialEdges = 0;
        for (int i = 1; i <= pointCount - 1; i++) {
            int from = scr.nextInt();
            int to = scr.nextInt();
            if (from != specialNums && to != specialNums) {
                notSpecialEdges++;
            } else {
                specialEdges++;
            }
        }
        return specialEdges <= 1 || !((notSpecialEdges + specialEdges) % 2 == 0);
    }
    /*code forces 1395/B Boboniu Plays Chess
        在一个n*m的地图内，给出开始坐标，用车的走法走遍全地图。
            测试用例1：
                输入：
                    3 3 2 2//边长为3*3，开始坐标为2,2（实际上为数组int[1][1]）
                输出：
                    2 2
                    1 2
                    1 3
                    2 3
                    3 3
                    3 2
                    3 1
                    2 1
                    1 1
            测试用例1：
                输入：
                    3 4 2 2
                输出：
                    2 2
                    2 1
                    2 3
                    2 4
                    1 4
                    3 4
                    3 3
                    3 2
                    3 1
                    1 1
                    1 2
                    1 3
     */
//    public static void main(String[] args) {
//        Scanner scr = new Scanner(System.in);
//        int rows = scr.nextInt();
//        int columns = scr.nextInt();
//        int Sx = scr.nextInt() - 1;
//        int Sy = scr.nextInt() - 1;
//        int[] position = new int[]{Sx,Sy};
//        while (position[0] >= 0) {
//            print(position);
//            position = move(position, Position.LEFT);
//        }
//        position[0] = Sx + 1;
//        while (position[0] < rows) {
//            print(position);
//            position = move(position, Position.RIGHT);
//        }
//        position = move(position, Position.LEFT);
//        position[1] = Sy-1;
//        boolean inLeft = false;
//        Position p = Position.UP;
//        while (position[1] < columns) {
//            if (inLeft) {
//                while (position[0] < rows) {
//                    print(position);
//                    position = move(position, Position.RIGHT);
//                }
//                position = move(position, Position.LEFT);
//            } else {
//                while (position[0] >= 0) {
//                    print(position);
//                    position = move(position, Position.LEFT);
//                }
//                position = move(position, Position.RIGHT);
//            }
//            inLeft = !inLeft;
//            if (position[1] == 0) {
//                position[1] = Sy;
//                p = Position.DOWN;
//            }
//            position = move(position, p);
//        }
//
//    }
//    static int[] move(int[] ps,Position p) {
//        return move(ps[0],ps[1],p);
//    }
//    static int[] move(int x, int y,Position p) {
//        switch (p){
//            case UP:
//                return new int[]{x,y-1};
//            case DOWN:
//                return new int[]{x,y+1};
//            case LEFT:
//                return new int[]{x-1,y};
//            case RIGHT:
//                return new int[]{x+1,y};
//        }
//        return new int[]{x,y};
//    }
//
//    public enum Position {
//        UP, DOWN, LEFT, RIGHT
//    }
//
//    static void print(int[] position) {
//        print(position[0],position[1]);
//    }
//
//    static void print(int x, int y) {
//        System.out.println((x+1) + " " + (y+1));
//    }

    /*code forces 1399/C Boats Competition
            给出一批数字，任意两个数字的值相加组成一个组，问最多能有几个组同时存在（即最多有几个组能值相等）
            测试用例：
            1 2 2 1 1 2 //3
            6 6 6 6 6 6 6 8 //3
            1 //0
     */
//    public static void main(String[] args) {
//        Scanner scr = new Scanner(System.in);
//        int n = scr.nextInt();
//        for (int i = 0; i < n; i++) {
//            int numCount = Integer.valueOf(scr.next());
//            int[] nums = new int[numCount];
//            for (int j = 0; j < numCount; j++) {
//                nums[j] = scr.nextInt();
//            }
//
//            System.out.println(getMaxCount(nums));
//        }
//    }
//
//    static int getMaxCount(int[] nums) {
//        int maxResult = 0;
//        int min = nums[0], max = nums[0];
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int thisN : nums) {
//            min = thisN < min ? thisN : min;
//            max = thisN > max ? thisN : max;
//            map.put(thisN, map.getOrDefault(thisN, 0) + 1);
//        }
//        Integer[] keys =  map.keySet().toArray(new Integer[0]);
//        Arrays.sort(keys);
//        for (int sum = 2 * min; sum <= 2 * max; sum++) {
//            int thisResult = 0;
//            for (int key : keys) {
//                if (sum < 2*key) {
//                    break;
//                } else if (2 * key == sum) {
//                    thisResult += map.get(key) / 2;
//                    break;
//                } else if (map.containsKey(sum - key)) {
//                    thisResult += Math.min(map.get(key), map.get(sum - key));
//                }
//
//            }
//            maxResult = Math.max(thisResult, maxResult);
//        }
//        return maxResult;
//    }

    /*code forces 71/A Way Too Long Words
        一个单词超过10个字符的话，则将中间的字符用数字展示，如：localization->l10n；internationalization->i18n
     */
//    public static void main(String[] args) {
//        Scanner scr = new Scanner(System.in);
//        int n = scr.nextInt();
//        for (int i=0;i<n;i++){
//            String s = scr.next();
//            System.out.println(s.length()>10?s.substring(0,1)+(s.length()-2)+s.substring(s.length()-1):s);
//        }
//    }

//    /*code forces /1/A Theatre Square
//        一个广场，长宽分别为m和n，用长为a的正方体石板铺满，可以超出广场面积，石板不能破坏
//     */
//    public static void main(String[] args) {
//        Scanner scr = new Scanner(System.in);
//        double m = scr.nextDouble();
//        double n = scr.nextDouble();
//        double a = scr.nextDouble();
//        double w = m/a;
//        double l = n/a;
//        System.out.print(Math.ceil(w)*Math.ceil(l));
//    }

    /*code forces

     */
//    public static void main(String[] args) {
//        Scanner scr = new Scanner(System.in);
//        int weight = scr.nextInt();
//        System.out.print(weight%2==0&&weight>2?"YES":"NO");
//    }

}
