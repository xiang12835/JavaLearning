public class CodeBlock {
    public static void main(String[] args) {
        int outer = 100;

        {
            int inner = 10;
            System.out.println("outer变量的值是" + outer + "。inner变量的值是" + inner + "。"); // 外层代码块创建的变量对内层代码块可见
        }

//        System.out.println(inner); // 内层代码块中创建的变量对外层代码块不可见

        int a1 = 1;
        {
            int a2 = a1 + 1;
//            int a1; // 内层命名空间不可以重复定义外层代码块的变量
            {
                int a3 = a2 + 1; // 不同代码块可以定义相同的变量
            }
            {
                int a3 = a2 + 10; // 不同代码块可以定义相同的变量
            }
            System.out.println(a2);
        }
    }
}
