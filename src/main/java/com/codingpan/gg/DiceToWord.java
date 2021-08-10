package com.codingpan.gg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DiceToWord {
  // N 6-face dices, each side of the dice is a letter, given a word ask if the combination of dice
  // can form to this word.
  // eg: Dices = {"WRFKSP", "ASDDGG", "JOLZRC", "OIUYGF"}, given "WORD",
  // answer is true, the faces of Dices are {'W', 'D', 'R', 'O'}
  // Follow up
  // 1. what if some of dice whose one face is "*", which can represent any letter.
  // 2. what if dices has order, one dice can not be picked after the other
  public boolean isAchievable(String[] dices, String word) {
    String[] matchedFaces = new String[dices.length];

    int idx = 0;
    for (String dice : dices) {
      matchedFaces[idx] = getMatchedFaces(word, dice);
      idx++;
    }
    Arrays.sort(
        matchedFaces,
        new Comparator<String>() {

          @Override
          public int compare(String o1, String o2) {
            // todo Auto-generated method stub
            return o1.length() - o2.length();
          }
        });
    System.out.print("matched sorted ");
    for (int i = 0; i < dices.length; i++) {
      System.out.print(matchedFaces[i] + ", ");
    }
    System.out.println();

    ArrayList<String> cur = new ArrayList<String>();
    ArrayList<String> res = new ArrayList<String>();

    boolean ans = helper(matchedFaces, 0, 0, word, cur, res);
    System.out.println("res " + res);

    return ans;
  }

  private String getMatchedFaces(String word, String dice) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < dice.length(); i++) {
      String s = dice.substring(i, i + 1);
      if (word.contains(s)) {
        sb.append(s);
      }
    }

    return sb.toString();
  }

  private boolean helper(
      String[] faces, int s, int idx, String word, ArrayList<String> cur, ArrayList<String> res) {
    if (s == faces.length || word.length() == 0) {
      return true;
    } else {
      for (int i = s; i < faces.length; i++) {
        String face = faces[i];
        for (int j = idx; j < face.length(); j++) {
          String letter = face.substring(idx, idx + 1);
          System.out.println("letter: " + letter);
          cur.add(letter);
          if (letter.equals(word.subSequence(0, 1))) {
            helper(faces, s + 1, j, word.substring(1), cur, res);
          }
          cur.remove(cur.size() - 1);
        }
      }
      return false;
    }
  }

  public static void main(String[] args) {
    String[] dices = {"WRFKSP", "ASDDGG", "JOLZRC", "OIUYGF"};
    String word = "WORD";

    DiceToWord sol = new DiceToWord();
    System.out.println("expected(true) " + sol.isAchievable(dices, word));
  }
}
