package com.alex.palindrome;

import com.google.common.collect.Lists;

import java.util.*;
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
            int searchStart = i;
            int searchEnd = i + 1;
            int foundStart = -1;
            int foundEnd = -1;
            // Search for even length palindromes.
            while (searchStart >= 0 && searchEnd < input.length() &&
                    input.charAt(searchStart) == input.charAt(searchEnd)) {
                foundStart = searchStart;
                foundEnd = searchEnd;
                searchStart--;
                searchEnd++;
            }
            // Look for odd length palindromes
            searchStart = i - 1;
            searchEnd = i + 1;
            while (searchStart >= 0 && searchEnd < input.length() &&
                    input.charAt(searchStart) == input.charAt(searchEnd)) {
                foundStart = searchStart;
                foundEnd = searchEnd;
                searchStart--;
                searchEnd++;
            }
            if (foundStart != -1) {
                String palindrome = input.substring(foundStart, foundEnd + 1);
                if (!result.containsKey(palindrome)) {
                    result.put(palindrome, foundStart);
                }
            }
        }
        return result;
    }
}
