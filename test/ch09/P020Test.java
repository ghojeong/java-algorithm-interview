package ch09;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class P020Test {
    @Test
    void P020_1() {
        P020_1 s = new P020_1();
        assertTrue(s.isValid("(){}[]"));
    }

    @Test
    void P020_2() {
        P020_2 s = new P020_2();
        assertTrue(s.isValid("(){}[]"));
    }
}
