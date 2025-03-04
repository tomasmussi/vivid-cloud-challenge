package com.challenge.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LongestPalindromicFinderTest {

    private LongestPalindromicFinder longestPalindromicFinder;

    @BeforeEach
    public void setup() {
        longestPalindromicFinder = new BasicPalindromicFinder();
    }

    @Test
    public void whenNumberInRange_ItReturnsLongestPalindromic() {
        int result = longestPalindromicFinder.findLongestPalindrome(100, 200);
        assertThat(result, is(191));
    }

    @Test
    public void whenNumberBoundsAreReversed_ItReturnsLongestPalindromic() {
        int result = longestPalindromicFinder.findLongestPalindrome(200, 100);
        assertThat(result, is(191));
    }

    @Test
    public void whenNoResult_ThenReturnMinusOne() {
        int result = longestPalindromicFinder.findLongestPalindrome(103, 104);
        assertThat(result, is(-1));
    }
}
