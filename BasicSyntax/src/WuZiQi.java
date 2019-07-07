import java.util.Scanner;

/* 双人对战五子棋程序功能说明：

允许双人对战，可以输入每一方的名字

允许输入棋盘大小，棋盘应为方形。棋盘要大于5，小于100。超过100无法对齐

自动判断是否有人胜出。胜出规则为一方的棋子在横竖斜三个方向任意一个方向有五个棋子连在一起

双方轮流下子，先黑后白，轮流下子

每一方下完子后，输出整个棋盘内容，并提示对方下子的地方

不允许在已经下子的地方再下子

输出统计信息


详细：
画出来的棋盘大概是这样的，用不同的符号代表每个位子是黑方的子●，还是白方的子●，还是没有子（空格）
用tab(\t)制表符让字符对齐
输出行列，方便下子的时候输如下子的位置
对于刚刚下子的地方，用不同的符号代替，比如这个棋盘的第11行，第11列，就是一个实心的方框□，代表是白方刚刚下的子，如果是黑方刚刚下的子，则是用■表示

	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20
1	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	1
2	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	2
3	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	3
4	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	4
5	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	5
6	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	6
7	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	7
8	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	8
9	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	9
10	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	10
11	○	 	●	○	 	●	○	 	●	○	■	●	○	 	●	○	 	●	○	 	11
12	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	12
13	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	13
14	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	14
15	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	15
16	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	16
17	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	17
18	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	18
19	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	19
20	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	●	○	 	20
	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20


画这个棋盘的程序是WuZiQiHuaQiPan，里面涉及了两个新的小语法

1）创建数组和数组元素初始化合二为一：

char[] qiziJustMove = new char[]{'■', '□', ' '};

这种语法适合数组大小不是很大，而且明确的知道每个元素的值的情况。比如上面创建的这个数组。
qiziJustMove[0]就是字符■。

2）三元操作符。它是一个Java中略有争议的操作符，大家可以使用它，也可以用if-else实现相同的功能。
三元操作符的争议之处在于它的程序可读性略差
boolean表达式?表达式为true时，三元操作符的值:表达式为false时候，表达式的值。

比如3>2?1:0的值就是1，因为boolean表达式的值为true，所以三元表达式的值为冒号前面的值
比如3>2?1:0的值就是1，因为boolean表达式的值为true，所以三元表达式的值为冒号前面的值

 */


public class WuZiQi {
    public static void main(String[] args) {
        System.out.println("********************************************************");
        System.out.println("                   欢迎来到双人五子棋对战");
        System.out.println("********************************************************");
        Scanner in = new Scanner(System.in);

        // 代表不同的角色
        int black = 0;
        int white = 1;
        int empty = 2;

        int[] result = new int[2];

        // 不同的角色的不同的棋子字符
        char[] qizi = new char[3];
        qizi[0] = '●';
        qizi[1] = '○';
        qizi[2] = ' ';

        int[][] checkConnectedDirection = new int[][]{{1, 0}, {0, 1}, {1, 1}, {1, -1}};
        String[] direction = new String[]{"垂直", "水平", "斜向下", "斜向上"};

        // 刚刚下好的棋子，用不一样的图形提示
        // 这里使用了一种新的创建数组的语法，可以不显示的指定数组的大小，而是在一对打括号里按照顺序指定数组里的每个元素的值
        // 这样数组的创建和赋值就合二为一了。当然这样创建的数组大小也是不可变的，结果没有不同。
        char[] qiziJustMove = new char[]{'■', '□', ' '};

        boolean play = true;
        while (play) {
            System.out.println("请输入棋盘大小，棋盘要大于5，小于100");
            int size = in.nextInt();
            if (size < 5 || size >= 100) {
                System.out.println("qipandaxiaofeifa");
                continue;
            }

            int[][] qipan = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    qipan[i][j] = empty;
                }
            }

            String header = "\t";
            for (int j = 0; j < size; j++) {
                header += (j + 1) + "\t";
            }

            System.out.println("请输入黑方选手名字：");
            String blackName = "黑方：" + in.next();
            System.out.println("请输入白方选手名字：");
            String whiteName = "白方：" + in.next();

            String[] roleNames = new String[]{blackName, whiteName};

            System.out.println("欢迎黑方选手" + roleNames[black] + "和白方选手" + roleNames[white] + "开始对战五子棋");

            int currRole = black;

            while (true) {

                int justMoveLine;
                int justMoveColumn;

                while (true) {
                    int lineToMove;
                    int columnToMove;
                    System.out.println(roleNames[currRole] + "下子。");
                    System.out.println("请输入落子的行：");
                    lineToMove = in.nextInt();
                    System.out.println("请输入落子的列：");
                    columnToMove = in.nextInt();
                    justMoveLine = lineToMove - 1;
                    justMoveColumn = columnToMove - 1;

                    if (justMoveLine < 0 || justMoveLine > size - 1) {
                        System.out.println("行" + lineToMove + "超出了棋盘范围");
                        continue;
                    }

                    if (justMoveColumn < 0 || justMoveColumn > size - 1) {
                        System.out.println("列" + columnToMove + "超出了棋盘范围");
                        continue;
                    }

                    if (qipan[justMoveLine][justMoveColumn] != empty) {
                        System.out.println("行" + lineToMove + "，列" + columnToMove + "处有子了");
                        continue;
                    }


                    System.out.println(roleNames[currRole] + "落子在：行" + lineToMove + "，列" + columnToMove);

                    break;
                }

                qipan[justMoveLine][justMoveColumn] = currRole;

                // 打印棋盘
                System.out.println(header);
                for (int i = 0; i < size; i++) {
                    String lineToPrint = "" + (i + 1) + "\t";
                    for (int j = 0; j < size; j++) {
                        char[] arrayToUse =
                                // Java中的三元操作符，?前面是一个boolean表达式，
                                // 如果boolean表达式的值为true，则这个表达式的值为冒号前面的值，
                                // 如果boolean表达式的值为false，则这个表达式的值为冒号后面的值
                                (i == justMoveLine && j == justMoveColumn) ? qiziJustMove : qizi;

                        lineToPrint += arrayToUse[qipan[i][j]] + "\t";
                    }
                    System.out.println(lineToPrint+ (i + 1));
                }
                System.out.println(header);


                // 只要从刚刚下子的地方检查是不是有五连子就可以了

                boolean outputDebug = false;

                boolean hasWinner = false;
                int currCheckCondition;
                // 我们要检查四个方向，分别为横，竖，斜上，斜下。四个方向对应的每个方向的索引delta在数组里保存
                for (int i = 0; i < checkConnectedDirection.length & (!hasWinner); i++) {

                    currCheckCondition = i;

                    if (outputDebug) {
                        System.out.println("检查方向为" + direction[i]);
                    }

                    int deltaLine = checkConnectedDirection[i][0];
                    int deltaColumn = checkConnectedDirection[i][1];
                    // 保存当前方向上有多少棋子相连
                    int totalConnected = 1;
                    // 对于每个方向，以当前落子点为起点，又有两个方向要检查。
                    // 以横着的方向为例子，横着要向前检查一次，如果遇到不是自己的子，或者到了棋盘边界，要再向后检查一次。
                    // 向前检查的时候，deltaLine为1，deltaColumn为0；
                    // 向后检查的时候，deltaLine为-1，deltaColumn为0；
                    for (int j = 0; j < 2 & (!hasWinner); j++) {
                        // 所以这里for循环两次，每次循环的时候，delta要乘以-1，代表变换检查的方向
                        // 比如水平方向，要检查两次，第一次是向左，第二次向右，两次的delta正好是*-1的关系
                        deltaLine *= -1;
                        deltaColumn *= -1;

                        // 把我们要检查的点恢复到刚刚下子的点
                        int lineToCheck = justMoveLine;
                        int columnToCheck = justMoveColumn;

                        if (outputDebug) {
                            System.out.println("line方向每次检查的变化为" + deltaLine);
                            System.out.println("column方向每次检查的变化为" + deltaColumn);
                        }

                        // 在个方向上，固定delta的情况下，查找有多少相连的子。
                        // 比如在水平方向，linedelta为1的情况下，检查有多少子相连
                        while (true) {
                            // 检查点根据delta进行变换
                            lineToCheck += deltaLine;
                            columnToCheck += deltaColumn;

                            boolean lineIndexOK = lineToCheck >= 0 && lineToCheck < size;
                            boolean columnIndexOK = columnToCheck >= 0 && columnToCheck < size;

                            if (outputDebug) {
                                System.out.println("line方向当前检查的位置为" + (lineToCheck + 1) + "。位置在棋盘内" + lineIndexOK);
                                System.out.println("column方向当前检查的位置为" + (columnToCheck + 1) + "。位置在棋盘内" + columnIndexOK);
                            }

                            if (lineIndexOK && columnIndexOK && qipan[lineToCheck][columnToCheck] == currRole) {
                                totalConnected++;

                                if (outputDebug) {
                                    System.out.println("在此位置找到相连的子，当前相连的子的数量为" + totalConnected);
                                }
                                if (totalConnected >= 5) {
                                    System.out.println(roleNames[currRole] + "胜出！五子相连方向为" + direction[currCheckCondition]);
                                    result[currRole]++;
                                    hasWinner = true;
                                    break;
                                }
                            } else {
                                if (outputDebug) {
                                    System.out.println("未找到相连的子，当前相连的子为" + totalConnected);
                                }
                                break;
                            }
                        }

                    }
                }

                if (hasWinner) {
                    break;
                }
                currRole = (currRole + 1) % 2;
            }
            System.out.println("********************************************************");
            System.out.println(roleNames[0] + "胜出" + result[0] + "次，" + roleNames[1] + "胜出" + result[1] + "次。");
            System.out.println("********************************************************");
            System.out.println("是否再来一盘？");
            play = in.nextBoolean();
        }
    }
}
