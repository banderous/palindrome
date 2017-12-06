package com.alex.palindrome;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by alex on 05/12/2017.
 */
public class Palindrome {

    /*
        Find the longest 3 unique palindromes in a string.
        A palindrome is represented as a Tuple of string and index,
        added to a list to allow ordering by length.
     */
    public static List<Map.Entry<String, Integer>> longest3Palindromes(String s) {
        Map<String, Integer> allPalindromes = palindromesByIndex(s);
        // Sort the palindromes on their length.
        Comparator<Map.Entry<String, Integer>> compare = (a, b) -> {
            return Integer.valueOf(b.getKey().length()).compareTo(a.getKey().length());
        };
        Stream<Map.Entry<String, Integer>> sorted = allPalindromes.entrySet().stream().sorted(compare);
        // return the first 3.
        return sorted.limit(3).collect(Collectors.toList());
    }

    /*
        Get all palindromes of a string and their indexes.
        Running time is O(N^2) on the length of input.
        A linear time solution is possible
        but not in the time I have!
     */
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
