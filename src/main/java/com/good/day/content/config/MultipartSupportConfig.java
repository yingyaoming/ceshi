package com.good.day.content.config;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MultipartSupportConfig {
    public static MultipartFile getMultipartFile(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File does not exist or is invalid.");
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] content = new byte[(int) file.length()];
            fis.read(content);
            return null;
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert file to MultipartFile", e);
        }
    }

    private static String getContentType(File file) {
        // 这里可以根据文件扩展名或其他方式获取内容类型
        // 例如，使用 Apache Tika 库来检测文件类型
        // 这里简单返回 "application/octet-stream" 作为默认值
        return "application/octet-stream";
    }

    public static void main(String[] args) {
        File file = new File("path/to/your/file.txt");
        MultipartFile multipartFile = getMultipartFile(file);
        System.out.println("MultipartFile created: " + multipartFile.getOriginalFilename());
    }
}
