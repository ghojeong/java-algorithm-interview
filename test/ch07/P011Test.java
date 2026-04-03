package ch07;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class P011Test {
    @Test
    void P011_1() {
        P011_1 s = new P011_1();
        assertArrayEquals(new int[] {105, 35, 21, 15}, s.productExceptSelf(new int[] {1, 3, 5, 7}));
    }

    @Test
    void P011_2() {
        P011_2 s = new P011_2();
        assertArrayEquals(new int[] {105, 35, 21, 15}, s.productExceptSelf(new int[] {1, 3, 5, 7}));
    }
}
