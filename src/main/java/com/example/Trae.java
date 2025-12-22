package com.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Trae {
    // 使用动态列表存储员工信息，便于添加新员工
    private List<String[]> employees = new ArrayList<String[]>() {{
        add(new String[]{"1001", "张三", "IT部", "13800138001"});
        add(new String[]{"1002", "李四", "人事部", "13800138002"});
        add(new String[]{"1003", "王五", "财务部", "13800138003"});
        add(new String[]{"1004", "赵六", "市场部", "13800138004"});
    }};
    
    // 员工判断方法
    public boolean isEmployee(String person) {
        // 这里可以根据实际需求进行员工判断逻辑的实现
        // 示例：假设员工名单存储在数组中
        // 员工编号和姓名对应关系
        // 格式：编号-姓名
        for (String[] employee : employees) {
            if (employee[1].equals(person)) {
                return true;
            }
        }
        return false;
    }
    
    // 重载方法：根据员工ID判断
    public boolean isEmployee(int employeeId) {
        for (String[] employee : employees) {
            if (employee[0].equals(String.valueOf(employeeId))) {
                return true;
            }
        }
        return false;
    }
    
    // 根据员工ID获取员工姓名
    public String getEmployeeNameById(int employeeId) {
        for (String[] employee : employees) {
            if (employee[0].equals(String.valueOf(employeeId))) {
                return employee[1];
            }
        }
        return null;
    }
    
    // 根据员工ID获取员工完整信息
    public String[] getEmployeeInfoById(int employeeId) {
        for (String[] employee : employees) {
            if (employee[0].equals(String.valueOf(employeeId))) {
                return employee;
            }
        }
        return null;
    }
    
    // 根据员工姓名获取员工完整信息
    public String[] getEmployeeInfoByName(String name) {
        for (String[] employee : employees) {
            if (employee[1].equals(name)) {
                return employee;
            }
        }
        return null;
    }
    
    // 添加新员工
    public boolean addEmployee(int employeeId, String name, String department, String phone) {
        // 检查员工是否已存在
        if (isEmployee(employeeId) || isEmployee(name)) {
            return false; // 员工已存在
        }
        
        // 添加新员工
        employees.add(new String[]{String.valueOf(employeeId), name, department, phone});
        return true;
    }
    
    // 新增方法：从控制台获取员工信息进行判断
    public void checkEmployeeFromConsole() {
        Scanner scanner = new Scanner(System.in);
        boolean continueChecking = true;
        
        while (continueChecking) {
            System.out.println("请选择查询方式:");
            System.out.println("1. 通过员工ID查询");
            System.out.println("2. 通过员工姓名查询");
            System.out.print("请输入选项(1或2): ");
            
            int choice = 0;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1 || choice == 2) {
                        break;
                    } else {
                        System.out.print("请输入有效选项(1或2): ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("输入无效，请输入数字(1或2): ");
                }
            }
            
            if (choice == 1) {
                System.out.print("请输入员工ID: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("输入无效，请输入一个数字!");
                    scanner.next(); // 清除无效输入
                }
                int id = scanner.nextInt();
                scanner.nextLine(); // 消费换行符
                
                if (isEmployee(id)) {
                    String[] info = getEmployeeInfoById(id);
                    if (info != null) {
                        System.out.println("ID为 " + id + " 的员工是本公司员工，姓名为: " + info[1] + 
                                         "，科室为: " + info[2] + "，电话号码为: " + info[3]);
                    } else {
                        System.out.println("ID为 " + id + " 的员工是本公司员工。");
                    }
                } else {
                    System.out.println("ID为 " + id + " 的员工不是本公司员工。");
                    System.out.print("是否要添加该员工到公司？(y/n): ");
                    String addChoice = scanner.nextLine();
                    if ("y".equalsIgnoreCase(addChoice)) {
                        System.out.print("请输入员工姓名: ");
                        String name = scanner.nextLine();
                        System.out.print("请输入员工科室: ");
                        String department = scanner.nextLine();
                        System.out.print("请输入员工电话: ");
                        String phone = scanner.nextLine();
                        if (addEmployee(id, name, department, phone)) {
                            System.out.println("员工 " + name + "(ID: " + id + ") 已成功添加到公司。");
                            // 输出新增员工的完整信息
                            String[] newEmployeeInfo = getEmployeeInfoById(id);
                            if (newEmployeeInfo != null) {
                                System.out.println("新增员工信息: ID=" + newEmployeeInfo[0] + 
                                                 ", 姓名=" + newEmployeeInfo[1] + 
                                                 ", 科室=" + newEmployeeInfo[2] + 
                                                 ", 电话=" + newEmployeeInfo[3]);
                            }
                        } else {
                            System.out.println("添加员工失败，员工可能已存在。");
                        }
                    }
                }
            } else { // choice == 2
                System.out.print("请输入员工姓名: ");
                String name = scanner.nextLine();
                if (isEmployee(name)) {
                    String[] info = getEmployeeInfoByName(name);
                    if (info != null) {
                        System.out.println("姓名为 " + name + " 的员工是本公司员工，ID为: " + info[0] + 
                                         "，科室为: " + info[2] + "，电话号码为: " + info[3]);
                    } else {
                        System.out.println("姓名为 " + name + " 的员工是本公司员工。");
                    }
                } else {
                    System.out.println("姓名为 " + name + " 的员工不是本公司员工。");
                    System.out.print("是否要添加该员工到公司？(y/n): ");
                    String addChoice = scanner.nextLine();
                    if ("y".equalsIgnoreCase(addChoice)) {
                        // 生成新的员工ID（简单实现）
                        int newId = 1005; // 实际应用中应该查找最大ID+1或使用其他策略
                        while (isEmployee(newId)) {
                            newId++;
                        }
                        System.out.print("请输入员工科室: ");
                        String department = scanner.nextLine();
                        System.out.print("请输入员工电话: ");
                        String phone = scanner.nextLine();
                        if (addEmployee(newId, name, department, phone)) {
                            System.out.println("员工 " + name + "(ID: " + newId + ") 已成功添加到公司。");
                            // 输出新增员工的完整信息
                            String[] newEmployeeInfo = getEmployeeInfoById(newId);
                            if (newEmployeeInfo != null) {
                                System.out.println("新增员工信息: ID=" + newEmployeeInfo[0] + 
                                                 ", 姓名=" + newEmployeeInfo[1] + 
                                                 ", 科室=" + newEmployeeInfo[2] + 
                                                 ", 电话=" + newEmployeeInfo[3]);
                            }
                        } else {
                            System.out.println("添加员工失败，员工可能已存在。");
                        }
                    }
                }
            }
            
            // 完成一轮查询后询问是否继续
            System.out.print("是否继续查询员工信息？(y/n): ");
            String continueChoice = scanner.nextLine();
            if (!"y".equalsIgnoreCase(continueChoice)) {
                continueChecking = false;
            }
        }
        
        scanner.close();
        System.out.println("感谢使用员工查询系统！");
    }
    
    // 主方法，程序入口
    public static void main(String[] args) {
        Trae trae = new Trae();
        trae.checkEmployeeFromConsole();
    }
}
