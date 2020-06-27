package com.martirosyan.lesson5;

import com.martirosyan.lesson5.model.Apple;
import com.martirosyan.lesson5.model.Box;
import com.martirosyan.lesson5.model.Orange;
import com.martirosyan.lesson5.utils.ArrayUtils;

public class MainApp {


    public static void main(String[] args) {
        Box<Orange> orangeBox = new Box<>();
        Orange o1 = new Orange();
        Orange o2 = new Orange();
        Orange o3 = new Orange();
        Orange o4 = new Orange();
        orangeBox.addFruits(ArrayUtils.toArrayList(new Orange[]{o1, o2, o3, o4}));

        Box<Apple> appleBox = new Box<>();
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        appleBox.addFruits(ArrayUtils.toArrayList(new Apple[]{a1, a2, a3}));

        Box<Apple> appleBox2 = new Box<>();
        Apple a4 = new Apple();
        Apple a5 = new Apple();
        appleBox.addFruits(ArrayUtils.toArrayList(new Apple[]{a4, a5}));


        System.out.println("applebox: " + appleBox.getWeight());
        System.out.println("orangebox: " + orangeBox.getWeight());
        System.out.println("applebox.compare(orangebox) = " + appleBox.compare(orangeBox));


        System.out.println("applebox: " + appleBox.getWeight());
        System.out.println("applebox2: " + appleBox2.getWeight());
        System.out.println("Lets put from applebox to applebox2");
        appleBox.putToAnother(appleBox2);

        System.out.println("applebox: " + appleBox.getWeight());
        System.out.println("applebox2: " + appleBox2.getWeight());
        // appleBox.putToAnother(orangeBox); Compile Error as it should be.


    }

}
