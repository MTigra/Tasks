package com.martirosyan.lesson13;

import java.io.*;
import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) throws IOException {
        System.out.println(findCountOfStrings("C:\\Users\\User\\Documents\\Projects\\Tasks\\musor\\1", "74"));
        joinAllFilesInDirectory("C:\\Users\\User\\Documents\\Projects\\Tasks\\musor");
    }


    // TASK 1
    private static int findCountOfStrings(String path, String str) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int ch;
            int i = 0;
            boolean flag = false;

            while ((ch = reader.read()) != -1) {


                if (i == 0 && flag) {
                    count++;
                }

                if (((char) ch) == str.charAt(i)) {
                    char cha = (char) ch;
                    flag = true;
                    i = ++i % str.length();
                } else {
                    flag = false;
                    i = 0;
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    // TASK 2
    private static void joinAllFilesInDirectory(String directoryPath) {
        File dir = new File(directoryPath);
        File newfile = new File("newfile");
        try {
            newfile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.stream(dir.listFiles()).forEach(f -> fileConsumer(f, newfile));
    }

    private static void fileConsumer(File f, File newfile) {
        try (InputStream in = new BufferedInputStream((new FileInputStream(f)));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(newfile,true))) {

            int ch;
            while ((ch = in.read()) != -1) {
                out.write(ch);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // TASK 3
    private static boolean removeRecursively(String directoryPath) {
        File dir = new File(directoryPath);
        File[] filelist = dir.listFiles();
        if (filelist != null) {
            for (File file : filelist) {
                removeRecursively(file.getAbsolutePath());
            }
        }
        return dir.delete();

    }
}
