package ru.svsand.adventofcode2024.day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FileSystemTest {

    private FileSystem fs;
    private final List<String> strings = Arrays.asList("2333133121414131402");

    @BeforeEach
    void setUp() {
        ArrayList<Integer> diskMap = Parser.read(strings);
        fs = new FileSystem(diskMap);
        fs.createDiskBlocks();
        fs.moveBlocks();
    }

    @Test
    void calculateSum() {
        Assertions.assertEquals(1928, fs.calculateSum());
    }
}