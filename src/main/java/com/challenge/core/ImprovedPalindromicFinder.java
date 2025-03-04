package com.challenge.core;

import static com.challenge.core.Utils.isPalindrome;

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
        int max = Math.max(number1, number2);
        int min = Math.min(number1, number2);
        int upperBound = max - 1;
        // if upperBound is palindrome, return immediately
        if (isPalindrome(upperBound)) {
            return upperBound;
        }
        return findFromUpperBound(min, upperBound);
    }

    private int findFromUpperBound(int lowerBound, int upperBound) {
        char[] number = String.valueOf(upperBound).toCharArray();
        int left = 0;
        int right = number.length - 1;
        boolean isLeftReduced = false;
        while (left <= right) {
            if (left == right) {
                // right at the middle, set the middle at the highest possible value,
                // if the digits at left have been modified
                if (isLeftReduced) {
                    // since the number has been reduced in some digit, we can set this to the maximum digit
                    number[left] = '9';
                }
            }
            if (number[left] == number[right]) {
                // great, these are equal, move to next char
                left++;
                right--;
            } else if (number[left] > number[right]) {
                isLeftReduced = true;
                // left number is greater, will need to reduce a digit from the next position at right
                int position = right - 1;
                while (position >= 0 && number[position] == '0') {
                    number[position--] = '9';
                }
                // copy from left, since it may have changed
                number[right - 1] = number[left];
                left++;
                right--;
            } else {
                // left number is lower, we can set the right number
                number[right] = number[left];
                left++;
                right--;
            }
        }
        return 0;
    }
}
