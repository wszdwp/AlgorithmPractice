package com.codingpan.amazon;

import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LogFileSort {
  public List<String> reorderLines(int logFileSize, List<String> logLines) {
    if (logFileSize <= 0 || logLines == null || logLines.size() == 0) return logLines;
    if (logFileSize != logLines.size()) return logLines;

    List<String> res = new ArrayList<>();
    List<String> wordList = new ArrayList<>();
    List<String> numberList = new ArrayList<>();

    for (String logLine : logLines) {
      String[] logs = logLine.split("\\s+");
      if (isInteger(logs[1])) {
        numberList.add(logLine);
      } else {
        wordList.add(logLine);
      }
    }

    Collections.sort(
        wordList,
        new Comparator<String>() {
          @Override
          public int compare(String log1, String log2) {
            int log1Delimeter = log1.indexOf(" ");
            int log2Delimeter = log2.indexOf(" ");
            String logId1 = log1.substring(0, log1Delimeter);
            String logId2 = log2.substring(0, log2Delimeter);
            String logContent1 = log1.substring(log1Delimeter + 1).trim();
            String logContent2 = log2.substring(log2Delimeter + 1).trim();
            if (logContent1.equals(logContent2)) {
              return log1.compareTo(log2);
            } else {
              return logContent1.compareTo(logContent2);
            }
          }
        });

    for (String logLine : wordList) {
      res.add(logLine);
    }
    for (String logLine : numberList) {
      res.add(logLine);
    }

    return res;
  }

  private boolean isInteger(String log) {
    boolean isInteger = false;
    try {
      int logNo = Integer.parseInt(log);
      isInteger = true;
    } catch (NumberFormatException e) {
      isInteger = false;
    }
    return isInteger;
  }

  public static void main(String[] args) {
    LogFileSort solu = new LogFileSort();
    int logFileSize = 5;
    List<String> logLines = new ArrayList<>();
    //        logLines.add("a3 this is a com.codingpan.test log");
    //        logLines.add("b23 1 25 69 8 125 200");
    //        logLines.add("b13 41 23 6 8 1 20");
    //        logLines.add("f12 word comes first");
    //        logLines.add("dd this is a com.codingpan.test log");

    logLines.add("a1 9 2 3 1");
    logLines.add("g1 act car");
    logLines.add("zo4 4 7");
    logLines.add("ab1 off key dog");
    logLines.add("a8 act zoo");
    // output:.
    // [g1 act car]
    // [a8 act zoo]
    // [ab1 off key dog]
    // [a1 9 2 3 1]
    // [zo4 4 7] 来
    //        logLines.add("a1 9 2 3 1");
    //        logLines.add("g1 act car");
    //        logLines.add("zo4 4 7");
    //        logLines.add("ab1 off key dog");
    //        logLines.add("a8 act zoo");
    List<String> res = solu.reorderLines(logFileSize, logLines);
    Utility.printList(res);
  }
}
