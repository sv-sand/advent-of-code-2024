package ru.svsand.adventofcode.day9;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 9: Disk Fragmenter");

        String fileName = args[0];
        FileParser parser = new FileParser();
        ArrayList<Integer> diskMap = parser.read(fileName);

        // Create disk blocks
        ArrayList<Integer> files = new ArrayList<>();
        int number = 0;
        for (int index = 0; index < diskMap.size(); index++, number++) {
            for (int count = 0; count < diskMap.get(index); count++)
                files.add(number);

            index++;
            if (index >= diskMap.size())
                break;
            for (int count = 0; count < diskMap.get(index); count++)
                files.add(-1);
        }

        // Move blocks
        for (int index = files.size() - 1; index > 0 ; index--)
            if (files.get(index) != -1)
                for (int i = 0; i < index; i++)
                    if (files.get(i) == -1) {
                        files.set(i, files.get(index));
                        files.set(index, -1);
                    }

        // Add
        long sum = 0;
        for (int index = 0; index < files.size(); index++)
            if (files.get(index) > 0)
                sum += index * files.get(index);

        System.out.println("Filesystem checksum: " + sum);
    }
}