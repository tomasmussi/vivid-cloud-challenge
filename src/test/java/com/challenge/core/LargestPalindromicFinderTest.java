package com.challenge.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class LargestPalindromicFinderTest {

    private LargestPalindromicFinder largestPalindromicFinder;

    @BeforeEach
    public void setup() {
        largestPalindromicFinder = new BasicPalindromicFinder();
    }

    @Test
    public void whenNumberInRange_ItReturnsLargestPalindromic() {
        int result = largestPalindromicFinder.findLargestPalindrome(100, 200);
        assertThat(result, is(191));
    }

    @Test
    public void whenNumberBoundsAreReversed_ItReturnsLargestPalindromic() {
        int result = largestPalindromicFinder.findLargestPalindrome(200, 100);
        assertThat(result, is(191));
    }

    @Test
    public void whenNoResult_ThenReturnMinusOne() {
        int result = largestPalindromicFinder.findLargestPalindrome(103, 104);
        assertThat(result, is(-1));
    }

    @Test
    public void whenPalindromeIsBound_ThenItReturnsLowerPalindrome() {
        int upperPalindrome = 191;
        int result = largestPalindromicFinder.findLargestPalindrome(100, upperPalindrome);
        assertThat(result, not(is(upperPalindrome)));
        assertThat(result, is(181));
    }

    @Test
    public void whenRangeIsEmpty_ThenReturnMinusOne() {
        int result = largestPalindromicFinder.findLargestPalindrome(14, 14);
        assertThat(result, is(-1));
    }
}
