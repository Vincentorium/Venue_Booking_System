package com.itp4511.utils;


/**

 */

import java.util.*;
/**


 */
public class Utility {
    //静态属性。。。
    private static Scanner scanner = new Scanner(System.in);


    /**
     *
     * @return 1——5
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);//
            c = str.charAt(0);//
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4' && c != '5') {
                System.out.print("选择错误，请重新输入：");
            } else break;
        }
        return c;
    }

    /**
     *
     * @return
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);//
        return str.charAt(0);
    }
    /**
     *
     * @param defaultValue
     * @return
     */

    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);//
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /**
     *
     * @return
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, false);//
            try {
                n = Integer.parseInt(str);//将字符串转换成整数
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    /**
     *
     * @param defaultValue
     * @return
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, true);
            if (str.equals("")) {
                return defaultValue;
            }

            //异常处理...
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 功
     * @param limit
     * @return
     */

    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     *
     * @param limit
     * @param defaultValue
     * @return
     */

    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("")? defaultValue : str;
    }


    /**
     *
     *
     * @return
     */
    public static char readConfirmSelection() {
        System.out.println("请输入你的选择(Y/N): 请小心选择");
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    /**
     *
     * @param limit
     * @param blankReturn
     *
     *	 。
     * @return
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {


        String line = "";


        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }


            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不能大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }
}
