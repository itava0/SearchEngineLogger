package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            logAction("launch");
            while (true) {
                System.out.println("Enter a search term (X to exit):");
                String searchTerm = scanner.nextLine();
                if ("X".equalsIgnoreCase(searchTerm)) {
                    logAction("exit");
                    break;
                } else {
                    logAction("search : " + searchTerm);
                }
            }

        }
    }

    private static void logAction(String action) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true))) {
            writer.write(LocalDateTime.now() + " " + action);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the log file.");
            e.printStackTrace();
        }
    }
}
