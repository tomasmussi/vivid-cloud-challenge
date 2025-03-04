package com.challenge;

import com.challenge.core.BasicPalindromicFinder;
import com.challenge.core.ImprovedPalindromicFinder;
import com.challenge.core.LargestPalindromicFinder;

public class LargestPalindromicFinderApplication {

    public static void main(String[] args) {
        LargestPalindromicFinder finder = new ImprovedPalindromicFinder();
        if (args.length != 2) {
            System.out.println("Usage: LargestPalindromicFinderApplication <number1> <number2>");
            return;
        }
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);
        int result = finder.findLargestPalindrome(number1, number2);
        System.out.printf("The largest palindrome is in the range %s and %s is: %s%n", number1, number2, result);
    }
}
