package ch07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class P010Test {
    @Test
    void P010_1() {
        P010_1 s = new P010_1();
        assertEquals(4, s.arrayPairSum(new int[] {1, 3, 4, 2}));
    }

    @Test
    void P010_2() {
        P010_2 s = new P010_2();
        assertEquals(4, s.arrayPairSum(new int[] {1, 3, 4, 2}));
    }

    @Test
    void P010_3() {
        P010_3 s = new P010_3();
        assertEquals(4, s.arrayPairSum(new int[] {1, 3, 4, 2}));
    }
}
