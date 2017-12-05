package com.alex.palindrome;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by alex on 05/12/2017.
 */
public class Palindrome {

    public static List<List<String>> longest3Palindromes(String s) {
        Map<String, Integer> allPalindromes = palindromesByIndex(s);
        List<String> keys = new ArrayList<>();
        keys.addAll(allPalindromes.keySet());

        keys.sort(Comparator.comparingInt(String::length).reversed());
        List<List<String>> result = new ArrayList<>();
        for (String key : keys.stream().limit(3).collect(Collectors.toList())) {
            String index = allPalindromes.get(key).toString();
            result.add(Lists.newArrayList(key, index, String.valueOf(key.length())));
        }

        return result;
    }

    public static Map<String, Integer> palindromesByIndex(String input) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < input.length() - 1; i++) {
            int start = i;
            int end = i + 1;
            int index = -1;
            int endIndex = -1;

            // Look for even length palindromes.
            if (input.charAt(start) == input.charAt(end)) {
                index = start;
                endIndex = end;
                while (true) {
                    start--;
                    end++;
                    // Look for even length palindromes.
                    if (start >= 0 && end < input.length() &&
                            input.charAt(start) == input.charAt(end)) {
                        index = start;
                        endIndex = end;
                    } else {
                        break;
                    }
                }
            }
            // Look for odd length palindromes
            start = i - 1;
            end = i + 1;
            while (start >= 0 && end < input.length() &&
                    input.charAt(start) == input.charAt(end)) {
                if (end - start > endIndex - index) {
                    index = start;
                    endIndex = end;
                }
                start--;
                end++;
            }
            if (index != -1) {
                String palindrome = input.substring(index, endIndex + 1);
                if (!result.containsKey(palindrome)) {
                    result.put(palindrome, index);
                }
            }
        }
        return result;
    }
}
