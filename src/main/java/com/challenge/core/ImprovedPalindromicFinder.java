package com.challenge.core;

/**
 * This algorithm is an improvement to the brute force algorithm
 */
public class ImprovedPalindromicFinder implements LargestPalindromicFinder {

    private LargestPalindromicFinder finder;

    public ImprovedPalindromicFinder() {
        this.finder = new BasicPalindromicFinder();
    }

    @Override
    public int findLargestPalindrome(int number1, int number2) {
        return this.finder.findLargestPalindrome(number1, number2);
    }
}
