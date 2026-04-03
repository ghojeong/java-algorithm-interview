package ch06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class P006Test {
    @Test
    void P006_1() {
        P006_1 s = new P006_1();
        assertEquals("dcbabcd", s.longestPalindrome("dcbabcdd"));
    }

    @Test
    void P006_2() {
        P006_2 s = new P006_2();
        assertEquals("dcbabcd", s.longestPalindrome("dcbabcdd"));
    }
}
