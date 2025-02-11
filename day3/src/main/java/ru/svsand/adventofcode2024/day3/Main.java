package ru.svsand.adventofcode2024.day3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 3: Mull It Over");

        String fileName = args[0];
        String text = Reader.readFile(fileName).get(0);
        InstructionMultiplier multiplier = new InstructionMultiplier(text);

        System.out.println("Result of instructions: " + multiplier.multiply());
        System.out.println("Result of enabled instructions: " + multiplier.multiplyEnabled());
    }
}
