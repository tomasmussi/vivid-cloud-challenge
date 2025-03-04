package com.challenge;

import com.challenge.core.BasicPalindromicFinder;
import com.challenge.core.LongestPalindromicFinder;

public class LongestPalindromicFinderApplication {

    public static void main(String[] args) {
        LongestPalindromicFinder finder = new BasicPalindromicFinder();
        System.out.println(args.length);
        for (String s : args) {
            System.out.println(s);
        }
        if (args.length != 2) {
            System.out.println("Usage: LongestPalindromicFinderApplication <number1> <number2>");
            return;
        }
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);
        int result = finder.findLongestPalindrome(number1, number2);
        System.out.println(String.format("The longest palindrome is in the range %s and %s is: %s", number1, number2, result));
    }
}
