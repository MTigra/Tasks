package com.martirosyan.lesson6.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    //           или тут(1)                                         и тут соответственно
    Map<String, List<String>> surnameToPhoneListMap = new HashMap<String, List<String>>();

    //Короче тут я не знаю где лучше написать ArrayList<String>.
    public void add(String surname, String phone) {
        //                                             или тут(2)
        surnameToPhoneListMap.putIfAbsent(surname, new ArrayList<>());
        surnameToPhoneListMap.computeIfPresent(surname, (k, phoneList) -> {
            phoneList.add(phone);
            return phoneList;
        });

    }

    public List<String> get(String surname) {
        return surnameToPhoneListMap.get(surname);
    }
}
