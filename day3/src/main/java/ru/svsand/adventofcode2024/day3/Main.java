package ru.svsand.adventofcode2024.day3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 3: Mull It Over");

        String fileName = args[0];
        String text = new Scanner(new File(fileName)).useDelimiter("\\Z").next();

        InstructionMultiplier multiplier = new InstructionMultiplier(text);

        System.out.println("Result of instructions: " + multiplier.multiply());
        System.out.println("Result of enabled instructions: " + multiplier.multiplyEnabled());
    }
}
