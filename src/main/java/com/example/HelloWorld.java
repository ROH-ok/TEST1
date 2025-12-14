package com.example;

import java.util.Scanner;
import java.time.Year;

public class HelloWorld {
    private static final String SUCCESS_MESSAGE = "成功";
    private static final String FAILURE_MESSAGE = "失败";
    private static final String TARGET_VALUE = "A";

    public static void main(String[] args) {
        //创建一个数组 将输入的5个数循环存储在数组中
        // 然后写一个if判断  如果数组中有A 并且当前年份是2025年时 打印成功 否则打印失败
        try (Scanner scanner = new Scanner(System.in)) {
            String[] inputs = new String[5];

            // 增加输入提示
            System.out.println("请输入5个值（每行一个）：");

            for (int i = 0; i < 5; i++) {
                if (scanner.hasNextLine()) {
                    inputs[i] = scanner.nextLine();
                }
            }

            int currentYear = Year.now().getValue();
            int targetIndex = -1;
            for (int i = 0; i < inputs.length; i++) {
                if (TARGET_VALUE.equals(inputs[i])) {
                    targetIndex = i;
                    break;
                }
            }

            if (targetIndex != -1 && currentYear == 2025) {
                System.out.println(SUCCESS_MESSAGE + "，数组中第" + (targetIndex + 1) + "位为A");
            } else {
                System.out.println(FAILURE_MESSAGE);
            }
        }
    }
}
