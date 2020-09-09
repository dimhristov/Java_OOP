package com.company.p1_ShapesDrawing;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 3 Integer numbers on every Line:");
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < 3; i++) {
            queue.add(Integer.parseInt(scanner.nextLine()));
        }
       Drawable circle = new Circle(queue.poll());

        Drawable rect = new Rectangle(queue.poll(), queue.poll());
        circle.draw();
        rect.draw();
    }
}
