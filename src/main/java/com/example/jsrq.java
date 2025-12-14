package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * 日期计算类
 * 用于计算指定日期之后520个月和10000天的日期
 */
public class jsrq {

    /**
     * 主方法，获取用户输入的日期，计算并显示520个月和10000天之后的日期
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // 获取用户输入的日期
            System.out.println("请输入日期（格式：yyyy-MM-dd）：");
            String dateInput = scanner.nextLine();

            // 解析用户输入的日期
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate inputDate = LocalDate.parse(dateInput, formatter);

            // 计算520个月之后的日期
            LocalDate dateAfter520Months = inputDate.plusMonths(520);

            // 计算10000天之后的日期
            LocalDate dateAfter10000Days = inputDate.plusDays(10000);

            // 打印结果
            System.out.println("输入日期：" + inputDate.format(formatter));
            System.out.println("520个月之后的日期：" + dateAfter520Months.format(formatter));
            System.out.println("10000天之后的日期：" + dateAfter10000Days.format(formatter));
        } catch (Exception e) {
            System.out.println("日期格式错误，请输入正确的日期格式（yyyy-MM-dd）");
        }
    }
}
