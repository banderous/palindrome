package com.alex.palindrome;

import spock.lang.Specification;

/**
 * Created by alex on 04/12/2017.
 */
public class TestPalindrome extends Specification {
    def 'handles empty string'() {
        when:
        def output = Palindrome.longestPalindrome('')
        then:
        output.equals [:]
    }

    def 'single character is a palindrome'() {
        when:
        def output = Palindrome.longestPalindrome('a')
        then:
        output == ['a': 0]
    }

    def 'ignores duplicate palindromes'() {
        when:
        String input = 'zzabahannahabahannah'
        def output = Palindrome.longestPalindrome(input)
        then:
        output == [
                'hannah': 3,
                'aba': 2,
                'zz': 0
        ]
    }
    
    def 'permits unique palindromes of the same length'() {
        when:
        String input = 'hannahpannapdannadabba'
        def output = Palindrome.longestPalindrome(input)
        then:
        output == [
               'hannah': 6,
               'pannap': 6,
               'dannad': 6
        ]
    }

    def 'solves problem specification string'() {
        when:
        def input = 'sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop'
        def output = Palindrome.longestPalindrome(input)
        then:
        output == [
                'hijkllkjih': 23,
                'defggfed': 13,
                'abccba': 5
        ]
    }
}

