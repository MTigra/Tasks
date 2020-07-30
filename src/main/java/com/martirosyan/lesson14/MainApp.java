package com.martirosyan.lesson14;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class MainApp {

    public static void main(String[] args) {
        try {
            System.out.println(findCountOfStrings("prostofile", "aaf"));
            joinAllFilesInDirectory("papka");
            deleteRecursively("papka");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int findCountOfStrings(String path, String substring) throws FileNotFoundException {
        RandomAccessFile aFile = new RandomAccessFile(path, "r");

        FileChannel inChannel = aFile.getChannel();
        int bufferSize = substring.length();

        int counter = 0;
        try {
            ByteBuffer buf = ByteBuffer.allocate(bufferSize);

            while (inChannel.read(buf) > 0) {
                if (new String(buf.array()).equals(substring)) {
                    counter++;
                }
                buf.clear();
                if (inChannel.position() < inChannel.size())
                    inChannel.position(inChannel.position() - (substring.length() - 1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

    public static void joinAllFilesInDirectory(String directoryPath) {
        Path directory = Paths.get(directoryPath);
        Path newfilePath = Paths.get("newfile");
        try {
            Files.list(directory).forEach(x -> fileConsumer(x, newfilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileConsumer(Path f, Path newFilePath) {
        try {
            Files.write(newFilePath,
                    Files.readAllBytes(f),
                    StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteRecursively(String rootDir) {
        try {
            Files.walkFileTree(Paths.get(rootDir), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




