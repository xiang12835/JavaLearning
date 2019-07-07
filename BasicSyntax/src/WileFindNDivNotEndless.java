public class WileFindNDivNotEndless {
    /* 一个看似死循环却不是死循环的例子

    - 用 while 找出 5个能被 2,000,000,000整除的数
    - 程序最终还是结束了，但是结果并不是我们想要的
    - 原因：正数的加法溢出

     */
    public static void main(String[] args) {
        int n = 5;

        int dividend = 100;
        int divisor = 2000000000;

        int found = 0;
        while (found < n) {
            if (dividend % divisor == 0) {
                System.out.println(dividend + "可以整除" + divisor + "。商是" + dividend / divisor);
                found++;
            }
            dividend++;
        }

    }
}
