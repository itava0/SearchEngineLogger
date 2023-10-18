package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            logAction("launch"); // Log that the search engine is launched.
            while (true) {
                System.out.println("Enter a search term (X to exit):");
                String searchTerm = scanner.nextLine();
                if ("X".equalsIgnoreCase(searchTerm)) {
                    logAction("exit"); // Log that the search engine is exiting.
                    break; // Exit the program.
                } else {
                    logAction("search : " + searchTerm); // Log the search action with the entered search term.
                }
            }
        }
    }

    // This method is used to log actions to a file.
    private static void logAction(String action) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true))) {
            writer.write(LocalDateTime.now() + " " + action); // Write the current timestamp and the provided action to the log file.
            writer.newLine(); // Move to the next line for the next log entry.
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the log file.");
            e.printStackTrace(); // If there's an error, print an error message and stack trace to the console.
        }
    }
}

