package com.codingpan.leetcode.todo;

import com.codingpan.leetcode.util.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1169InvalidTrasactions {
  public List<String> invalidTransactions(String[] transactions) {
    List<String> invalidT = new ArrayList<>();

    Arrays.sort(transactions);

    String name = "";
    for (String transaction : transactions) {
      String[] tran = transaction.trim().split(",");
      if (!name.equalsIgnoreCase(tran[0])) {
        name = tran[0];
      } else {

      }
    }

    return invalidT;
  }

  public static void main(String[] args) {
    LC1169InvalidTrasactions solu = new LC1169InvalidTrasactions();
    String[] transactions = {"bob,50,1200,mtv", "alice,20,800,mtv", "alice,50,100,beijing"};
    Arrays.sort(transactions);
    Utility.printObjArray(transactions);
  }
}
