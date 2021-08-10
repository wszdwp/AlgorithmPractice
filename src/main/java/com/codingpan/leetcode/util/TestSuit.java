package com.codingpan.leetcode.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class TestSuit {
  // assume Unicode UTF-8 encoding
  private static final String CHARSET_NAME = "UTF-8";

  // assume language = English, country = US for consistency with System.out.
  private static final Locale LOCALE = Locale.US;

  private static Scanner scanner;

  public static void main(String[] args) {
    System.out.println("Enter com.codingpan.test file name: ");
    String name = args[0];

    if (name == null) throw new IllegalArgumentException("argument is null");
    try {
      // first try to read file from local file system
      File file = new File(name);
      if (file.exists()) {
        // for consistency with StdIn, wrap with BufferedInputStream instead of use
        // file as argument to Scanner
        FileInputStream fis = new FileInputStream(file);
        scanner = new Scanner(new BufferedInputStream(fis), CHARSET_NAME);
        scanner.useLocale(LOCALE);
        while (scanner.hasNextLine()) {
          String line = scanner.nextLine();
          String[] tokens = line.split(",");
          for (String token : tokens) {
            int n = Integer.parseInt(token);
          }
        }
      }
    } catch (IOException ioe) {
      throw new IllegalArgumentException("Could not open " + name, ioe);
    }
    System.out.println("Your username is " + name);
  }
}
