package ch07;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class P11Test {
    @Test
    void P11_1() {
        P11_1 s = new P11_1();
        assertArrayEquals(new int[] {105, 35, 21, 15}, s.productExceptSelf(new int[] {1, 3, 5, 7}));
    }

    @Test
    void P11_2() {
        P11_2 s = new P11_2();
        assertArrayEquals(new int[] {105, 35, 21, 15}, s.productExceptSelf(new int[] {1, 3, 5, 7}));
    }
}
