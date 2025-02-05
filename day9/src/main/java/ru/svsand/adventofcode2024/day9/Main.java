package ru.svsand.adventofcode2024.day9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advent of code 2024");
        System.out.println("Day 9: Disk Fragmenter");

        String fileName = args[0];
        List<String> strings = Reader.readFile(fileName);
        ArrayList<Integer> diskMap = Parser.read(strings);

        FileSystem fs = new FileSystem(diskMap);
        fs.createDiskBlocks();
        fs.moveBlocks();

        System.out.println("Filesystem checksum: " + fs.calculateSum());
    }
}