package org.example;

import java.util.Scanner;

public class Main { //최종적으로 실행하는 클래스
    public static void main(String[] args) {
        Container.init();
        new App().run();
        Container.close();
    }
}