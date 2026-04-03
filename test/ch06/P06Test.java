package ch06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class P06Test {
    @Test
    void P06_1() {
        P06_1 s = new P06_1();
        assertEquals("dcbabcd", s.longestPalindrome("dcbabcdd"));
    }

    @Test
    void P06_2() {
        P06_2 s = new P06_2();
        assertEquals("dcbabcd", s.longestPalindrome("dcbabcdd"));
    }
}
