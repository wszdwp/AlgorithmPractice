package com.codingpan.amazon;

import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class OA20190322 {
    /**
     * https://www.1point3acres.com/bbs/thread-501911-1-1.html
     *
     * <p>order junction boxes
     *
     * <p>input: [ykc 82
     */
    public static void sortBoxes(List<String> boxList, int numberOfBoxes) {
        Collections.sort(
                boxList,
                new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.compareTo(s2);
                    }
                });
    }

    public static void main(String[] args) {
        String[] boxes = {
                "ykc 82 01",
                "eo first qpx",
                "09z cat hamster",
                "06f 12 25 6",
                "az0 first qpx",
                "236 cat dog rabbit snake"
        };
        List<String> boxList = new ArrayList<String>(Arrays.asList(boxes));
        // Utility.printList(boxList);

        sortBoxes(boxList, boxList.size());
        for (String box : boxList) {
            StdOut.println(box);
        }
    }
}
