package controller;

import java.util.Scanner;

public interface Handler {
    Scanner scanner = new Scanner(System.in);
    void handle();
}
