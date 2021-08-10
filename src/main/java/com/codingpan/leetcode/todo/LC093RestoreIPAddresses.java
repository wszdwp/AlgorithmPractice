package com.codingpan.leetcode.todo;

import java.util.ArrayList;
import java.util.List;

public class LC093RestoreIPAddresses {
  public List<String> restoreIpAddresses(String s) {
    ArrayList<String> ip = new ArrayList<String>();
    ArrayList<String> res = new ArrayList<String>();
    findValidIp(s, 0, ip, res);
    return res;
  }

  private void findValidIp(String s, int pos, List<String> ip, List<String> res) {
    int size = ip.size();
    int len = s.length();
    if (size == 4) {
      if (pos == len) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String ipAddr : ip) {
          stringBuilder.append(ipAddr + ".");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        res.add(stringBuilder.toString());
      }
      return;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = pos; i < len && i < pos + 3; i++) {
      sb.append(s.charAt(i));
      String tempIp = sb.toString();
      //			System.out.println(tempIp);
      if (isValidIp(tempIp)) {
        //				System.out.println("valid " + tempIp);
        ip.add(tempIp);
        findValidIp(s, i + 1, ip, res);
        ip.remove(ip.size() - 1);
      }
    }
  }

  private boolean isValidIp(String s) {
    if (s.isEmpty() || s.length() > 3) return false;
    if (s.charAt(0) == '0' && s.length() != 1) return false;
    if (s.length() == 3 && Integer.parseInt(s) > 255) return false;
    return true;
  }

  public static void main(String[] args) {
    LC093RestoreIPAddresses sol = new LC093RestoreIPAddresses();
    String[] test = {"25525511135", "0000", "1111"};
    for (String t : test) {
      List<String> res = sol.restoreIpAddresses(t);
      for (String ip : res) {
        System.out.println(ip);
      }
    }
  }
}
