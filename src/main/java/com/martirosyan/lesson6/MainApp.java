package com.martirosyan.lesson6;

import com.martirosyan.lesson6.phonebook.PhoneBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainApp {
    private static String[] WORDS = new String[]{"барабан", "бассейн", "берег", "береза", "беседа", "библиотека", "билет", "близко",
            "ботинки", "быстро"};

    public static void main(String[] args) {
        Random rnd = new Random();
        String[] arr = new String[18];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = WORDS[rnd.nextInt(WORDS.length)];
        }

        HashMap<String, Integer> hm = new HashMap<>();
        for (String word : arr) {
            hm.putIfAbsent(word, 0);
            hm.computeIfPresent(word, (k, v) -> v += 1);

        }

        System.out.println("Список уникальных слов: " + hm.keySet().toString());
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        testPhoneBook();
    }



    private static void testPhoneBook() {
        PhoneBook pb = new PhoneBook();
        pb.add("Martirosyan","8989283232");
        pb.add("Martirosyan","8342331133");
        pb.add("Inozemcev","8949399999");
        System.out.println(pb.get("Martirosyan"));
        System.out.println(pb.get("Inozemcev"));
    }


}