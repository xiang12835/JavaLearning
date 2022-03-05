public class StringVariable {
    public static void main(String[] args) {
        int a = 10;
        String str = "a的值是";
        str = str + a;
        System.out.println(str); // 改变其值要用赋值语句

        String s2 = "a的值是";
        System.out.println(str + a);
        System.out.println(s2); // String 的加法不会改变原 String 变量的值，
    }
}
