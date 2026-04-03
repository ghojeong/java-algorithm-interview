package ch07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class P08Test {
    @Test
    void P08_1() {
        P08_1 s = new P08_1();
        assertEquals(6, s.trap(new int[] {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    void P08_2() {
        P08_2 s = new P08_2();
        assertEquals(6, s.trap(new int[] {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    void P08_3() {
        P08_3 s = new P08_3();
        assertEquals(6, s.trap(new int[] {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
