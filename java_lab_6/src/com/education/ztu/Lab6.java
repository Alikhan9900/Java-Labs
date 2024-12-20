package com.education.ztu;

import java.io.*;
import java.util.zip.*;
import java.nio.file.*;
import java.util.regex.*;

public class Lab6 {

    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("[a-zA-Z0-9_]{1,20}")) {
                throw new WrongLoginException("Login не відповідає вимогам.");
            }
            if (!password.matches("[a-zA-Z0-9_]{1,20}") || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password не відповідає вимогам або не співпадає з confirmPassword.");
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Помилка: " + e.getMessage());
            return false;
        }
    }


    public static void writeReport(String content, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(content);
        writer.close();
    }

    public static String readReport(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }


    public static void copyFile(String sourcePath, String destPath) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destPath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }


    public static void modifyFile(String filePath, long position, String text) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            raf.seek(position);
            raf.write(text.getBytes());
        }
    }


    public static void manageFiles(String directoryPath) throws IOException {
        File innerDir = new File(directoryPath + "/inner_directory");
        if (innerDir.mkdir()) {
            System.out.println("Папка створена: " + innerDir.getAbsolutePath());
        }

        File file1 = new File(innerDir, "file1.txt");
        File file2 = new File(innerDir, "file2.txt");
        file1.createNewFile();
        file2.createNewFile();

        file1.delete();
        File renamedDir = new File(directoryPath + "/renamed_inner_directory");
        innerDir.renameTo(renamedDir);

        File parentDir = new File(directoryPath);
        for (File file : parentDir.listFiles()) {
            System.out.println(file.getName() + (file.isDirectory() ? " (папка)" : " (файл)") + ", розмір: " + file.length() + " байт");
        }
    }


    public static void archiveFiles(String directoryPath, String zipFilePath) throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath))) {
            Files.walk(Paths.get(directoryPath)).filter(Files::isRegularFile).forEach(path -> {
                try (FileInputStream fis = new FileInputStream(path.toFile())) {
                    ZipEntry entry = new ZipEntry(path.getFileName().toString());
                    zos.putNextEntry(entry);
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        zos.write(buffer, 0, bytesRead);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args) {

        try {
            String directoryPath = "./directory_for_files";
            new File(directoryPath).mkdir();

            System.out.println("Перевірка логіну: " + checkCredentials("valid_login", "password123", "password123"));

            String reportPath = directoryPath + "/report.txt";
            writeReport("Звіт про покупки", reportPath);
            System.out.println(readReport(reportPath));

            String copyPath = directoryPath + "/copy.txt";
            copyFile(reportPath, copyPath);

            modifyFile(copyPath, 10, "Додатковий текст");

            manageFiles(directoryPath);

            String zipPath = directoryPath + "/archive.zip";
            archiveFiles(directoryPath, zipPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class WrongLoginException extends Exception {
    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException(String message) {
        super(message);
    }
}
