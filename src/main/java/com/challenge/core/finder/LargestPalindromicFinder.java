package com.challenge.core.finder;

public interface LargestPalindromicFinder {

    /**
     * Find the largest palindromic number between number1 and number2
     *
     * @param number1 boundary to find the largest palindromic integer
     * @param number2 boundary to find the largest palindromic integer
     * @return the largest palindromic number between the bounds or -1 if no palindromic number exists.
     */
    int findLargestPalindrome(int number1, int number2);

    /**
     * Pretty name of the strategy used to find the largest palindrome.
     * @return pretty name of the strategy.
     */
    String strategyName();
}
