package com.martirosyan.lesson7;

import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    static int[] sizes = new int[]{10, 100, 10_000, 100_000};

    public static void main(String[] args) {
        testMiddleAccess();
        testDelete();
        testMyEntry();
    }

    //    Delete:
//                  10	    100	    10000	100000
//    ArrayList:    0	    0	    3	    124
//    LinkedList:   0	    0	    22	    2927
    private static void testDelete() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("Delete: \n");
        List<Long> alTimes = new ArrayList<>();
        List<Long> llTimes = new ArrayList<>();
        for (int size : sizes) {
            ArrayList<Integer> arrayList = rnd.ints(size).boxed().collect(Collectors.toCollection(ArrayList::new));
            LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
            long arraylistTime = System.currentTimeMillis();
            for (int i = 0; i < size / 2; i++) {
                int a = arrayList.remove(size / 2);
            }
            arraylistTime = System.currentTimeMillis() - arraylistTime;
            alTimes.add(arraylistTime);
            long linkedListTime = System.currentTimeMillis();
            for (int i = 0; i < size / 2; i++) {
                int a = linkedList.remove(size / 2);
            }
            linkedListTime = System.currentTimeMillis() - linkedListTime;
            llTimes.add(linkedListTime);
        }
        sb.append(
                Arrays.stream(sizes).mapToObj(String::valueOf)
                        .collect(Collectors.joining("\t", "\t\t\t", "\n"))
        );
        sb.append(alTimes.stream().map(String::valueOf)
                .collect(Collectors.joining("\t", "ArrayList: ", "\n"))
        );
        sb.append(llTimes.stream().map(String::valueOf)
                .collect(Collectors.joining("\t", "LinkedList: ", "\n"))
        );
        System.out.println(sb);
    }

    //    			    10	    100	    10000	100000
//    ArrayList:    2	    1	    0	    1
//    LinkedList:   1	    1	    82	    1117
    private static void testMiddleAccess() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("Access: \n");
        List<Long> alTimes = new ArrayList<>();
        List<Long> llTimes = new ArrayList<>();
        for (int size : sizes) {
            ArrayList<Integer> arrayList = rnd.ints(size).boxed().collect(Collectors.toCollection(ArrayList::new));
            LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
            long arraylistTime = System.currentTimeMillis();
            for (int i = 0; i < 10_000; i++) {
                int a = arrayList.get(size / 2);
            }
            arraylistTime = System.currentTimeMillis() - arraylistTime;
            alTimes.add(arraylistTime);
            long linkedListTime = System.currentTimeMillis();
            for (int i = 0; i < 10_000; i++) {
                int a = linkedList.get(size / 2);
            }
            linkedListTime = System.currentTimeMillis() - linkedListTime;
            llTimes.add(linkedListTime);
        }
        sb.append(
                Arrays.stream(sizes).mapToObj(String::valueOf)
                        .collect(Collectors.joining("\t", "\t\t\t", "\n"))
        );
        sb.append(alTimes.stream().map(String::valueOf)
                .collect(Collectors.joining("\t", "ArrayList: ", "\n"))
        );
        sb.append(llTimes.stream().map(String::valueOf)
                .collect(Collectors.joining("\t", "LinkedList: ", "\n"))
        );
        System.out.println(sb);
    }
//ListTime: 9490
// MapTime:  18
    public static void testMyEntry() {
        ArrayList<MyEntry> entryArrayList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Random rnd = new Random();
        for (int i = 0; i < 50000; i++) {
            int v = rnd.nextInt();
            entryArrayList.add(new MyEntry(i, v));
            hashMap.put(i, v);
        }
        long mapTime = 0;
        long listTime = 0;
        for (int i = 0; i < 100_000; i++) {
            int k = rnd.nextInt(50_000);
            long time = System.currentTimeMillis();
            hashMap.get(k);
            mapTime += System.currentTimeMillis() - time;

            time = System.currentTimeMillis();
            for (MyEntry el : entryArrayList) {
                if (el.getK() == k)
                    break;
            }
            listTime += System.currentTimeMillis() - time;
        }

        System.out.printf("ListTime: %d",listTime);
        System.out.printf("MapTime:  %d",mapTime);

    }
}
