package ru.svsand.adventofcode2024.day9;

import java.util.ArrayList;

/**
 * @author sand <sve.snd@gmail.com>
 * @since 11.12.2024
 */

public class FileSystem {
    private final ArrayList<Integer> diskMap;
    private final ArrayList<Integer> files = new ArrayList<>();

    public FileSystem(ArrayList<Integer> diskMap) {
        this.diskMap = diskMap;
    }

    public void createDiskBlocks() {
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
    }

    public void moveBlocks() {
        for (int index = files.size() - 1; index > 0 ; index--)
            if (files.get(index) != -1) {
                boolean moved = false;
                for (int i = 0; i < index; i++)
                    if (files.get(i) == -1) {
                        files.set(i, files.get(index));
                        files.set(index, -1);
                        moved = true;
                        break;
                    }
                if (!moved)
                    break;
            }
    }

    public long calculateSum() {
        long sum = 0;
        for (int index = 0; index < files.size(); index++)
            if (files.get(index) > 0)
                sum += index * files.get(index);
        return sum;
    }
}
