package org.example;

import java.util.Scanner;

public class Container { //최초 입력하면 되는 스캐너 입력과 스캐너 종료, 그리고 private로 설정한 sc값을 return.
    private static Scanner sc;
    public static void init(){
        sc = new Scanner(System.in);
    }
    public static void close(){
        sc.close();
    }
    public static Scanner getSc(){
        return sc;
    }
}