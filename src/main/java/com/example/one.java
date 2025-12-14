package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * 时间差计算程序主类。
 * <p>
 * 该类提供一个命令行交互界面，允许用户输入一个过去的日期，
 * 然后计算并输出从该日期到当前时间的详细时间差（包括年、月、日、时、分、秒）以及多种单位下的总计。
 * </p>
 */
public class one {

    /**
     * 程序入口点。
     * <p>
     * 主要功能如下：
     * <ul>
     *   <li>通过控制台读取用户输入的年、月、日信息。</li>
     *   <li>构建起始日期，并获取当前系统时间。</li>
     *   <li>使用ChronoUnit工具类计算两个时间之间的差值（以不同时间单位表示）。</li>
     *   <li>将总天数粗略换算成年、月、日格式进行展示。</li>
     *   <li>按指定格式输出时间差结果及多个维度的总计统计。</li>
     * </ul>
     * 注意事项：
     * <ul>
     *   <li>年月日的换算是基于简化的平均值（一年=365天，一月=30天），并非精确的日历计算。</li>
     *   <li>所有计算均基于本地系统时间。</li>
     * </ul>
     *
     * @param args 命令行参数数组（本程序未使用）
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // 获取用户输入的完整日期
            System.out.print("请输入年份: ");
            int year = scanner.nextInt();

            System.out.print("请输入月份: ");
            int month = scanner.nextInt();

            System.out.print("请输入日期: ");
            int day = scanner.nextInt();

            // 定义起始日期：用户输入的完整日期
            LocalDate startDate = LocalDate.of(year, month, day);

            // 获取当前日期时间
            LocalDateTime startDateTime = startDate.atStartOfDay();
            LocalDateTime currentDateTime = LocalDateTime.now();

            // 获取当前日期
            LocalDate currentDate = LocalDate.now();

            // 计算精确的时间差
            long totalDays = ChronoUnit.DAYS.between(startDateTime, currentDateTime);
            long totalHours = ChronoUnit.HOURS.between(startDateTime, currentDateTime);
            long totalMinutes = ChronoUnit.MINUTES.between(startDateTime, currentDateTime);
            long totalSeconds = ChronoUnit.SECONDS.between(startDateTime, currentDateTime);

            // 分离出时分秒的小数部分用于显示
            long hoursPart = totalHours % 24;
            long minutesPart = totalMinutes % 60;
            long secondsPart = totalSeconds % 60;

            // 将总天数粗略转换为年月日形式（非精确计算）
            long years = totalDays / 365;
            long remainingDays = totalDays % 365;
            long months = remainingDays / 30;
            long days = remainingDays % 30;

            // 输出详细的年月日时分秒时间差
            System.out.println("从" + year + "年" + month + "月" + day + "日到今天(" + currentDate + ")的时间差：");
            System.out.println(years + "年 " + months + "月 " + days + "日 " +
                             hoursPart + "时 " + minutesPart + "分 " + secondsPart + "秒");

            // 输出多种单位的总计统计
            System.out.println("总计: " + years + "年");
            System.out.println("总计: " + (years * 12 + months) + "月");
            System.out.println("总计: " + totalDays + "天");
            System.out.println("总计: " + totalHours + "小时");
        }
    }
}
