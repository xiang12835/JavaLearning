public class IncreaseDecrease {
    public static void main(String[] args) {
        int a = 1;
        System.out.println("a++=" + a++);
        System.out.println("a=" + a);
        a = 1;
        System.out.println("++a=" + (++a));
        System.out.println("a=" + a);


        int b = 10;
        System.out.println("b--=" + b--);
        System.out.println("b=" + b);

        b = 10;
        System.out.println("--b=" + --b);
        System.out.println("b=" + b);


        // 解释：步骤分解
        a = 1;
        System.out.println("a++=" + a++);

        System.out.println("a++=" + a);
        a = a + 1;

        a = 1;

        System.out.println("++a=" + (++a));

        a = a + 1;
        System.out.println("++a=" + a);
    }
}
