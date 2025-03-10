package com.challenge.core;

import com.challenge.core.finder.BasicPalindromicFinder;
import com.challenge.core.finder.ImprovedPalindromicFinder;
import com.challenge.core.finder.LargestPalindromicFinder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class LargestPalindromicFinderTest {

    private static List<LargestPalindromicFinder> FINDERS;

    @BeforeAll
    public static void setup() {
        FINDERS = new ArrayList<>();
        FINDERS.add(new BasicPalindromicFinder());
        // uncomment when this works
        FINDERS.add(new ImprovedPalindromicFinder());
    }

    @Test
    public void whenNumberInRange_ItReturnsLargestPalindromic() {
        for (LargestPalindromicFinder finder : FINDERS) {
            int result = finder.findLargestPalindrome(100, 200);
            assertThat(finder.getClass() + " returned error", result, is(191));
        }
    }

    @Test
    public void whenNumberBoundsAreReversed_ItReturnsLargestPalindromic() {
        for (LargestPalindromicFinder finder : FINDERS) {
            int result = finder.findLargestPalindrome(200, 100);
            assertThat(finder.getClass() + " returned error", result, is(191));
        }
    }

    @Test
    public void whenNoResult_ThenReturnMinusOne() {
        for (LargestPalindromicFinder finder : FINDERS) {
            int result = finder.findLargestPalindrome(103, 104);
            assertThat(finder.getClass() + " returned error", result, is(-1));
        }
    }

    @Test
    public void whenPalindromeIsBound_ThenItReturnsLowerPalindrome() {
        for (LargestPalindromicFinder finder : FINDERS) {
            int upperPalindrome = 191;
            int result = finder.findLargestPalindrome(100, upperPalindrome);
            assertThat(finder.getClass() + " returned error", result, not(is(upperPalindrome)));
            assertThat(finder.getClass() + " returned error", result, is(181));
        }
    }

    @Test
    public void whenRangeIsEmpty_ThenReturnMinusOne() {
        for (LargestPalindromicFinder finder : FINDERS) {
            int result = finder.findLargestPalindrome(14, 14);
            assertThat(finder.getClass() + " returned error", result, is(-1));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "1275,1221",
            "1221,1111",
            "150,141",
            "18923,18881",
            "12345,12321",
            "54321,54245",
            "5421,5335",
            "5000,4994",
            "100,99",
            "7537,7447",
            "75001,74947",
            "11105,11011",
            "11001,10901",
    })
    public void whenUpperBoundIsSet_ThenResultIsAsExpected(int upperBound, int expected) {
        for (LargestPalindromicFinder finder : FINDERS) {
            int result = finder.findLargestPalindrome(0, upperBound);
            assertThat(finder.getClass() + " returned error", result, is(expected));
        }
    }
}
