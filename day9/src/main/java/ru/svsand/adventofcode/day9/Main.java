package ru.svsand.adventofcode.day9;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 9: Disk Fragmenter");

        String fileName = args[0];
        FileParser parser = new FileParser();
        ArrayList<Integer> diskMap = parser.read(fileName);

        FileSystem fs = new FileSystem(diskMap);
        fs.createDiskBlocks();
        fs.moveBlocks();
        System.out.println("Filesystem checksum: " + fs.calculateSum());
    }
}