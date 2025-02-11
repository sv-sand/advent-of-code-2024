package ru.svsand.adventofcode2024.day9;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        
        logger.info("Welcome to Advent of code 2024");
        logger.info("Day 9: Disk Fragmenter");

        String fileName = args[0];
        List<String> strings = Reader.readFile(fileName);
        ArrayList<Integer> diskMap = Parser.read(strings);

        FileSystem fs = new FileSystem(diskMap);
        fs.createDiskBlocks();
        fs.moveBlocks();

        logger.info("Filesystem checksum: " + fs.calculateSum());
    }
}