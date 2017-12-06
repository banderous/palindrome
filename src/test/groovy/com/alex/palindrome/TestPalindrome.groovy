package com.alex.palindrome;

import spock.lang.Specification;

/**
 * Created by alex on 05/12/2017.
 */
public class TestPalindrome extends Specification {
    def 'handles empty string'() {
        when:
        def output = Palindrome.palindromesByIndex('input')
        then:
        output.equals [:]
        where:
        input = ''
    }

    def 'single character is not a palindrome'() {
        when:
        def output = Palindrome.palindromesByIndex(input)
        then:
        output == [:]
        where:
        input = 'a'
    }

    def 'two character palindrome'() {
        when:
        def output = Palindrome.palindromesByIndex(input)
        then:
        output == ['aa': 0]
        where:
        input = 'aa'
    }

    def 'three character palindrome'() {
        when:
        def output = Palindrome.palindromesByIndex(input)
        then:
        output == ['aba': 0]
        where:
        input = 'aba'
    }

    def 'ignores duplicate palindromes'() {
        when:
        def output = Palindrome.palindromesByIndex(input)
        then:
        output == [
                'hannah': 11,
                'aba'   : 5,
                'zz'    : 0
        ]
        where:
        input = 'zzafkabaxyzhannahxyzhannah'
    }

    def 'permits unique palindromes of the same length'() {
        when:
        def output = Palindrome.palindromesByIndex(input)
        then:
        output == [
                'hannah': 0,
                'pannap': 6,
                'dannad': 12
        ]
        where:
        input = 'hannahpannapdannad'
    }

    def 'solves problem specification string'() {
        when:
        def output = Palindrome.longest3Palindromes(input)
        then:
        with(output[0]) {
            key == 'hijkllkjih'
            value == 23
        }
        with(output[1]) {
            key == 'defggfed'
            value == 13
        }
        with(output[2]) {
            key == 'abccba'
            value == 5
        }
        where:
        input = 'sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop'
    }
}

