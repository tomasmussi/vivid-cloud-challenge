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
        while (left <= right) {
            if (number[left] == number[right]) {
                // great, these are equal, move to next char
                left++;
                right--;
            } else if (number[left] > number[right]) {
                // left number is greater, will need to reduce a digit from the next position at right
                // reduce the problem to one of the other options
                int position = right;
                while (position >= left) {
                    if (number[position] == '0') {
                        number[position] = '9';
                        position--;
                    } else {
                        number[position]--;
                        break;
                    }
                }
            } else {
                // left number is lower, we can set the right number
                number[right] = number[left];
                left++;
                right--;
            }
        }
        int result = Integer.parseInt(String.valueOf(number));
        return result > lowerBound ? result : -1;
    }
}
