package com.sqli.training.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex7 {

    public static void main(String[] args) {

        String str = "abc1cef253";
        Pattern pattern = Pattern.compile(".+?\\d");
        Matcher matcher = pattern.matcher(str);
        List<String> b = new ArrayList<String>();

        while (matcher.find()) {
            String a = matcher.group();
            b.add(a);

        }
        System.out.println(b);
    }

}
