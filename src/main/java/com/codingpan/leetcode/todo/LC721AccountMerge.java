package com.codingpan.leetcode.todo;

import java.util.*;

public class LC721AccountMerge {
  //	Input:
  //		accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John",
  // "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary",
  // "mary@mail.com"]]
  //		Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John",
  // "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
  //
  //		Explanation:
  //		The first and third John's are the same person as they have the common email
  // "johnsmith@mail.com".
  //
  //		The second John and Mary are different people as none of their email addresses are used by
  // other accounts.
  //
  //		We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'],
  // ['John', 'johnnybravo@mail.com'],
  //		['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be
  // accepted.
  public static List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, List<Integer>> hMap = new HashMap<String, List<Integer>>();
    for (int i = 0; i < accounts.size(); i++) {
      List<String> account = accounts.get(i);
      if (account.size() <= 1) continue;
      for (int j = 0; j < account.size(); j++) {
        if (j == 0) {
          String name = account.get(j);
          if (hMap.containsKey(name)) {
            //            			List<String> emailList = hMap.get(name);
            //            			hMap.put(name, arrayToList(account, emailList));
          } else {
            hMap.put(name, new ArrayList<Integer>(j));
          }
        }
      }
    }

    List<List<String>> res = new ArrayList<List<String>>();
    for (Map.Entry<String, List<Integer>> entry : hMap.entrySet()) {
      String email = entry.getKey();
      List<Integer> indexList = entry.getValue();
      List<String> accoutInfo = getMergedAccount(indexList, accounts);
      res.add(accoutInfo);
    }

    return res;
  }

  private static List<String> arrayToList(String[] strArr, List<String> emailList) {
    List<String> strList = new ArrayList<String>();
    for (int i = 1; i < strArr.length; i++) {
      String email = strArr[i];
      if (!isDuplicate(email, emailList)) {
        strList.add(email);
      }
    }
    strList.addAll(emailList);

    return strList;
  }

  private static boolean isDuplicate(String email, List<String> emailList) {
    HashSet<String> hSet = new HashSet<String>();
    for (String s : emailList) {
      hSet.add(s);
    }
    return hSet.contains(email);
  }

  private static List<String> getMergedAccount(
      List<Integer> indexList, List<List<String>> accounts) {
    List<String> ans = new ArrayList<String>();
    for (Integer i : indexList) {
      List<String> account = accounts.get(i);
      if (account.size() <= 1) continue;
      if (ans.isEmpty()) {
        ans.add(account.get(0));
      } else {
        for (int j = 1; j < account.size(); j++) {
          ans.add(account.get(j));
        }
      }
    }

    return ans;
  }

  private static void printAns(List<List<String>> mergedAccounts) {
    for (List<String> acct : mergedAccounts) {
      System.out.println(Arrays.toString(acct.toArray()));
    }
  }

  public static void main(String[] args) {
    List<List<String>> accounts = new ArrayList<List<String>>();
    //    	accounts.add(convertStringArrayToArraylist(new String[]{"John", "johnsmith@mail.com",
    // "john00@mail.com"}));
    //    	accounts.add(convertStringArrayToArraylist(new String[]{"John",
    // "johnnybravo@mail.com"}));
    //    	accounts.add(convertStringArrayToArraylist(new String[]{"Mary", "mary@mail.com"}));

    List<List<String>> mergedAccounts = accountsMerge(accounts);
    printAns(mergedAccounts);
  }
}
