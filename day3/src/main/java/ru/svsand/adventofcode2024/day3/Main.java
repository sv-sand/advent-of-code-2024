package ru.svsand.adventofcode2024.day3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 3: Mull It Over");

        String fileName = args[0];
        String text = new Scanner(new File(fileName)).useDelimiter("\\Z").next();

        ArrayList<String> instructions = new ArrayList<>();

        // Part 1
        long result = 0;
        Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find())
            instructions.add(text.substring(matcher.start(), matcher.end()));

        for (String instruction: instructions) {
            String data = instruction.substring(4, instruction.length() - 1);
            String[] array = data.split(",");

            int mul1 = Integer.parseInt(array[0]);
            int mul2 = Integer.parseInt(array[1]);
            result += mul1 * mul2;
        }
        System.out.println("Result of instructions: " + result);

        // Part 2
        instructions.clear();

        long resultOfEnabled = 0;
        pattern = Pattern.compile("mul\\(\\d+,\\d+\\)|do\\(\\)|don\\'t\\(\\)");
        matcher = pattern.matcher(text);

        boolean isEnabled = true;
        while (matcher.find()) {
            String instruction = text.substring(matcher.start(), matcher.end());

            if (instruction.equals("do()"))
                isEnabled = true;

            if (instruction.equals("don't()"))
                isEnabled = false;

            if (isEnabled && !instruction.equals("do()") && !instruction.equals("don't()"))
                instructions.add(instruction);
        }

        for (String instruction: instructions) {
            String data = instruction.substring(4, instruction.length() - 1);
            String[] array = data.split(",");

            int mul1 = Integer.parseInt(array[0]);
            int mul2 = Integer.parseInt(array[1]);
            resultOfEnabled += mul1 * mul2;
        }

        System.out.println("Result of enabled instructions: " + resultOfEnabled);
    }
}
