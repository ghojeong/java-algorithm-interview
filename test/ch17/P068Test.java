package ch17;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class P068Test {
    @Test
    void P068_1() {
        P068_1 s = new P068_1();
        assertTrue(s.isAnagram("anagram", "nagarma"));
    }

    @Test
    void P068_2() {
        P068_2 s = new P068_2();
        assertTrue(s.isAnagram("anagram", "nagarma"));
    }

    @Test
    void P068_3() {
        P068_3 s = new P068_3();
        assertTrue(s.isAnagram("anagram", "nagarma"));
    }
}
