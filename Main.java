import java.util.Scanner;

public class Main {
    /*code forces /1/A Theatre Square
        一个广场，长宽分别为m和n，用长为a的正方体石板铺满，可以超出广场面积，石板不能破坏
     */
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        double m = scr.nextDouble();
        double n = scr.nextDouble();
        double a = scr.nextDouble();
        double w = m/a;
        double l = n/a;
        System.out.print(Math.ceil(w)*Math.ceil(l));
    }

    /*code forces

     */
//    public static void main(String[] args) {
//        Scanner scr = new Scanner(System.in);
//        int weight = scr.nextInt();
//        System.out.print(weight%2==0&&weight>2?"YES":"NO");
//    }

}
