package com.challenge.core;

import static com.challenge.core.Utils.isPalindrome;

public class BasicPalindromicFinder implements LargestPalindromicFinder {

    @Override
    public int findLargestPalindrome(int number1, int number2) {
        int minimum = Math.min(number1, number2);
        int maximum = Math.max(number1, number2);
        for (int number = maximum - 1; number > minimum; number--) {
            if (isPalindrome(number)) {
                return number;
            }
        }
        return -1;
    }
}
