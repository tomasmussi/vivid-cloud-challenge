package com.challenge.core;

public class BasicPalindromicFinder implements LongestPalindromicFinder {

    @Override
    public int findLongestPalindrome(int number1, int number2) {
        int minimum = Math.min(number1, number2);
        int maximum = Math.max(number1, number2);
        for (int number = maximum; number >= minimum; number--) {
            if (isPalindrome(number)) {
                return number;
            }
        }
        return -1;
    }

    private boolean isPalindrome(int number) {
        String numberString = String.valueOf(number);
        int left = 0;
        int right = numberString.length() - 1;
        while (left < right) {
            if (numberString.charAt(left) != numberString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
