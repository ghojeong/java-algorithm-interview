package ch22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class P089Test {
    @Test
    void P089_1() {
        P089_1 s = new P089_1();
        assertEquals(2, s.majorityElement(new int[] {2, 2, 1, 1, 3, 2, 2}));
    }

    @Test
    void P089_2() {
        P089_2 s = new P089_2();
        assertEquals(2, s.majorityElement(new int[] {2, 2, 1, 1, 3, 2, 2}));
    }

    @Test
    void P089_3() {
        P089_3 s = new P089_3();
        assertEquals(2, s.majorityElement(new int[] {2, 2, 1, 1, 3, 2, 2}));
    }

    @Test
    void P089_4() {
        P089_4 s = new P089_4();
        assertEquals(2, s.majorityElement(new int[] {2, 2, 1, 1, 3, 2, 2}));
    }
}
