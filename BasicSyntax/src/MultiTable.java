public class MultiTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            String line = "";
            for (int j = 1; j <= 9; j++) {
                if (i < j) {
                    break; // 使用break语句让输出的乘法表更简洁
                }
                line = line + j + "*" + i + "=" + (j * i) + "\t"; // 使用String变量，做String的加法
            }
            System.out.println(line);
        }

        System.out.println();

        for (int i = 1; i < 10; i++) {
            String line = "";
            for (int j = 1; j <= i; j++) {
                line = line + j + "*" + i + "=" + (j * i) + "\t";
            }
            System.out.println(line);
        }

    }
}
