package com.challenge;

import com.challenge.core.finder.BasicPalindromicFinder;
import com.challenge.core.finder.ImprovedPalindromicFinder;
import com.challenge.core.finder.LargestPalindromicFinder;

public class LargestPalindromicFinderApplication {

    private static final String BASIC_OPTION = "-b";

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: LargestPalindromicFinderApplication <number1> <number2> [-i -b]");
            return;
        }
        LargestPalindromicFinder finder = createFinder(args);
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);
        int result = finder.findLargestPalindrome(number1, number2);
        System.out.printf("The largest palindrome (using %s) in the range %s and %s is: %s%n",
                finder.strategyName(),
                number1,
                number2,
                result
        );
    }

    private static LargestPalindromicFinder createFinder(String[] args) {
        if (args.length == 3 && BASIC_OPTION.equals(args[2])) {
            return new BasicPalindromicFinder();
        }
        return new ImprovedPalindromicFinder();
    }
}
