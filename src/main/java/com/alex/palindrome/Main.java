package com.alex.palindrome;

import java.util.List;

/**
 * Created by alex on 04/12/2017.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: input");
            return;
        }
        List<List<String>> summary = Palindrome.longest3Palindromes(args[0]);
        for (List<String> strings : summary) {
            String line = String.format("Text: %s, Index: %s, Length: %s", strings.toArray());
            System.out.println(line);
        }
    }
}
