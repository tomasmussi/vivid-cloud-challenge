package com.challenge;

import com.challenge.core.finder.BasicPalindromicFinder;
import com.challenge.core.finder.ImprovedPalindromicFinder;
import com.challenge.core.finder.LargestPalindromicFinder;

public class LargestPalindromicFinderApplication {

    private static final String IMPROVED_OPTION = "-i";

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: LargestPalindromicFinderApplication <number1> <number2>");
            return;
        }
        LargestPalindromicFinder finder = createFinder(args);
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);
        int result = finder.findLargestPalindrome(number1, number2);
        System.out.printf("The largest palindrome is in the range %s and %s is: %s%n", number1, number2, result);
    }

    private static LargestPalindromicFinder createFinder(String[] args) {
        if (args.length == 3 && IMPROVED_OPTION.equals(args[2])) {
            return new ImprovedPalindromicFinder();
        }
        return new BasicPalindromicFinder();
    }
}
