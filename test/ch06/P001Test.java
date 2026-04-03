package ch06;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class P001Test {
    @Test
    void P001_1() {
        P001_1 s = new P001_1();
        assertTrue(s.isPalindrome("Do geese see God?"));
        assertTrue(s.isPalindrome("Hannah"));
        assertFalse(s.isPalindrome("Hang up!"));
    }

    @Test
    void P001_2() {
        P001_2 s = new P001_2();
        assertTrue(s.isPalindrome("Do geese see God?"));
        assertTrue(s.isPalindrome("Hannah"));
        assertFalse(s.isPalindrome("Hang up!"));
    }

    @Test
    void P001_3() {
        P001_3 s = new P001_3();
        assertTrue(s.isPalindrome("Do geese see God?"));
        assertTrue(s.isPalindrome("Hannah"));
        assertFalse(s.isPalindrome("Hang up!"));
    }
}
