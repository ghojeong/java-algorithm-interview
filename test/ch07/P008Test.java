package ch07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class P008Test {
    @Test
    void P008_1() {
        P008_1 s = new P008_1();
        assertEquals(6, s.trap(new int[] {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    void P008_2() {
        P008_2 s = new P008_2();
        assertEquals(6, s.trap(new int[] {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    void P008_3() {
        P008_3 s = new P008_3();
        assertEquals(6, s.trap(new int[] {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
