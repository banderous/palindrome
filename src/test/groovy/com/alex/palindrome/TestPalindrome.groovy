package com.alex.palindrome;

import spock.lang.Specification;

/**
 * Created by alex on 05/12/2017.
 */
public class TestPalindrome extends Specification {
    def 'handles empty string'() {
        when:
        def output = Palindrome.palindromesByIndex('')
        then:
        output.equals [:]
    }

    def 'single character is not a palindrome'() {
        when:
        def output = Palindrome.palindromesByIndex('a')
        then:
        output == [:]
    }

    def 'two character palindrome'() {
        when:
        def output = Palindrome.palindromesByIndex('aa')
        then:
        output == ['aa': 0]
    }

    def 'three character palindrome'() {
        when:
        def output = Palindrome.palindromesByIndex('aba')
        then:
        output == ['aba': 0]
    }

    def 'ignores duplicate palindromes'() {
        when:
        String input = 'zzafkabaxyzhannahxyzhannah'
        def output = Palindrome.palindromesByIndex(input)
        then:
        output == [
                'hannah': 11,
                'aba'   : 5,
                'zz'    : 0
        ]
    }

    def 'permits unique palindromes of the same length'() {
        when:
        String input = 'hannahpannapdannad'
        def output = Palindrome.palindromesByIndex(input)
        then:
        output == [
                'hannah': 0,
                'pannap': 6,
                'dannad': 12
        ]
    }

    def 'solves problem specification string'() {
        when:
        def input = 'sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop'
        def output = Palindrome.longest3Palindromes(input)
        then:
        output == [
                ['hijkllkjih', '23', '10'],
                ['defggfed', '13', '8'],
                ['abccba', '5', '6']
        ]
    }
}

