package com.challenge.core.finder;

import static com.challenge.core.Utils.isPalindrome;

public class BasicPalindromicFinder implements LargestPalindromicFinder {

    private static final String STRATEGY_NAME = "BasicPalindromicFinder";

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

    @Override
    public String strategyName() {
        return STRATEGY_NAME;
    }
}
