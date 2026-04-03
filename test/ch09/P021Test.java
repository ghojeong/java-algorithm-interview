package ch09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class P021Test {
    @Test
    void P021_1() {
        P021_1 s = new P021_1();
        assertEquals("acdb", s.removeDuplicateLetters("dbacdcbc"));
    }

    @Test
    void P021_2() {
        P021_2 s = new P021_2();
        assertEquals("acdb", s.removeDuplicateLetters("dbacdcbc"));
    }

    @Test
    void P023_3() {
        P021_3 s = new P021_3();
        assertEquals("acdb", s.removeDuplicateLetters("dbacdcbc"));
    }
}
