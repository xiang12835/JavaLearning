public class ParentOprt {
    public static void main(String[] args) {
        int a = 10;
        int b = 88;
        boolean c = ((a + b) * a - 9 * (a + b)) == (a + b); // 小括号运算符内可以包含任何运算符，决定运算符的顺序

        System.out.println(c);
    }
}
