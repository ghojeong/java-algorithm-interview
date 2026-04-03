package ch06;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class P01Test {
    @Test
    void P01_1() {
        P01_1 s = new P01_1();
        assertTrue(s.isPalindrome("Do geese see God?"));
        assertTrue(s.isPalindrome("Hannah"));
        assertFalse(s.isPalindrome("Hang up!"));
    }

    @Test
    void P01_2() {
        P01_2 s = new P01_2();
        assertTrue(s.isPalindrome("Do geese see God?"));
        assertTrue(s.isPalindrome("Hannah"));
        assertFalse(s.isPalindrome("Hang up!"));
    }

    @Test
    void P01_3() {
        P01_3 s = new P01_3();
        assertTrue(s.isPalindrome("Do geese see God?"));
        assertTrue(s.isPalindrome("Hannah"));
        assertFalse(s.isPalindrome("Hang up!"));
    }
}
