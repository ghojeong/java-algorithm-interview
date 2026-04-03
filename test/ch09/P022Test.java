package ch09;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class P022Test {
    @Test
    void P022_1() {
        P022_1 s = new P022_1();
        assertArrayEquals(
                new int[] {1, 1, 4, 2, 1, 1, 0, 0},
                s.dailyTemperatures(new int[] {23, 24, 25, 21, 19, 22, 26, 23}));
    }

    @Test
    void P022_2() {
        P022_2 s = new P022_2();
        assertArrayEquals(
                new int[] {1, 1, 4, 2, 1, 1, 0, 0},
                s.dailyTemperatures(new int[] {23, 24, 25, 21, 19, 22, 26, 23}));
    }
}
