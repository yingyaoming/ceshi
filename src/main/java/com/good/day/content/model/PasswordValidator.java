package com.good.day.content.model;

import java.util.Scanner;
import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String password = scanner.nextLine();
            if (isValidPassword(password)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
        scanner.close();
    }

    private static boolean isValidPassword(String password) {
        // 检查长度是否超过8位
        if (password.length() <= 8) return false;

        // 检查是否包含至少三种类型的字符
        int charTypes = 0;
        if (password.matches(".*[a-z].*")) charTypes++;
        if (password.matches(".*[A-Z].*")) charTypes++;
        if (password.matches(".*\\d.*")) charTypes++;
        if (password.matches(".*[^a-zA-Z0-9].*")) charTypes++;
        if (charTypes < 3) return false;

        // 检查是否有长度大于2的子串重复
        for (int i = 0; i < password.length() - 2; i++) {
            String subStr = password.substring(i, i + 3);
            if (password.indexOf(subStr) != password.lastIndexOf(subStr)) {
                return false;
            }
        }

        return true;
    }
}