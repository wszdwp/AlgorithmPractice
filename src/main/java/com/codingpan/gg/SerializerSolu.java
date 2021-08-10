package com.codingpan.gg;

import edu.princeton.cs.algs4.StdOut;

import java.io.Serializable;

public class SerializerSolu {

  //    class Employee implements Serializable{
  //        String firstName;
  //        String lastName;
  //        int eId;
  //        Address address;
  //
  //    }
  //
  //    class Address implements Serializable {
  //        String address1;
  //        String address2;
  //        String zip;
  //        String state;
  //    }

  class Serializer {
    void writeObject(Serializable s) {}

    //        Object readObject() {
    //        }
  }

  public static String getQueryString(String s) {
    StringBuilder sb = new StringBuilder();
    sb.append(s.replaceAll("-|\\\\", " ").trim());
    return sb.toString();
  }

  public static void main(String[] args) {
    String[] ss = {
      "AC9091-1002\\9100 ", "AC 110", " D---C\\91\\9\\1 ",
    };
    for (String s : ss) {
      StdOut.println("original " + s);
      StdOut.println(getQueryString(s));
    }
  }
}
