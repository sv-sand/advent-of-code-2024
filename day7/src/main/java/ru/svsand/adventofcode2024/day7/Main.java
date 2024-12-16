package ru.svsand.adventofcode2024.day7;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 7: Bridge Repair");

        String fileName = args[0];
        FileParser parser = new FileParser();
        ArrayList<Equation> equations = parser.read(fileName);

        long result = 0;
        for (Equation equation: equations) {
            if (equation.isValid())
                result += equation.getResult();
        }
        System.out.println("Sum valid equations: " + result);

        result = 0;
        for (Equation equation: equations) {
            if (equation.isValidWithConcatenation())
                result += equation.getResult();
        }
        System.out.println("Sum valid equations with concatenation: " + result);
    }
}