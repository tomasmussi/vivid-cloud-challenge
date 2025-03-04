package com.challenge.core;

public final class Utils {

    private Utils() {
    }


    /**
     * Check if number, after converting it to String, is a palindrome.
     *
     * @param number to check
     * @return true if palindrome, false otherwise.
     */
    public static boolean isPalindrome(int number) {
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
