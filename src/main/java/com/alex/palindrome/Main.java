package com.alex.palindrome;

import java.util.List;
import java.util.Map;

/**
 * Created by alex on 04/12/2017.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: input");
            return;
        }
        Palindrome.longest3Palindromes(args[0]).forEach(item-> {
            String line = String.format("Text: %s, Index: %s, Length: %s", item.getKey(), item.getValue(), item.getKey().length());
            System.out.println(line);
        });
    }
}
