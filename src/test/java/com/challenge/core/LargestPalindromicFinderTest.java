package com.challenge.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class LargestPalindromicFinderTest {

    private List<LargestPalindromicFinder> finders;

    @BeforeEach
    public void setup() {
        finders = new ArrayList<>();
        finders.add(new BasicPalindromicFinder());
        finders.add(new ImprovedPalindromicFinder());
    }

    @Test
    public void whenNumberInRange_ItReturnsLargestPalindromic() {
        for (LargestPalindromicFinder finder : finders) {
            int result = finder.findLargestPalindrome(100, 200);
            assertThat(finder.getClass() + " returned error", result, is(191));
        }
    }

    @Test
    public void whenNumberBoundsAreReversed_ItReturnsLargestPalindromic() {
        for (LargestPalindromicFinder finder : finders) {
            int result = finder.findLargestPalindrome(200, 100);
            assertThat(finder.getClass() + " returned error", result, is(191));
        }
    }

    @Test
    public void whenNoResult_ThenReturnMinusOne() {
        for (LargestPalindromicFinder finder : finders) {
            int result = finder.findLargestPalindrome(103, 104);
            assertThat(finder.getClass() + " returned error", result, is(-1));
        }
    }

    @Test
    public void whenPalindromeIsBound_ThenItReturnsLowerPalindrome() {
        for (LargestPalindromicFinder finder : finders) {
            int upperPalindrome = 191;
            int result = finder.findLargestPalindrome(100, upperPalindrome);
            assertThat(finder.getClass() + " returned error", result, not(is(upperPalindrome)));
            assertThat(finder.getClass() + " returned error", result, is(181));
        }
    }

    @Test
    public void whenRangeIsEmpty_ThenReturnMinusOne() {
        for (LargestPalindromicFinder finder : finders) {
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
    })
    public void whenUpperBoundIsSet_ThenResultIsAsExpected(int upperBound, int expected) {
        for (LargestPalindromicFinder finder : finders) {
            int result = finder.findLargestPalindrome(0, upperBound);
            assertThat(finder.getClass() + " returned error", result, is(expected));
        }
    }
}
