package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Actions choices = new Actions();

        System.out.println("Type 'start' to play");
        String play = scanner.nextLine();
        switch (play) {
            case "start": choices.introduction();
        }


    }
}