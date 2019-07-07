public class BooleanOper {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;

        System.out.println(a && b); // 推荐
        System.out.println(a & b);
        System.out.println(a || b); // 推荐
        System.out.println(a | b);

        System.out.println(a || (10 / 0 > 1)); // "||" 短路
        System.out.println(a | (10 / 0 > 1)); // "|" 不短路
    }
}
