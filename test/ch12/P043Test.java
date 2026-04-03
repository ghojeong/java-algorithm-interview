package ch12;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class P043Test {
    @Test
    void P043_1() {
        P043_1 s = new P043_1();
        assertTrue(s.canFinish(3, new int[][] {new int[] {1, 0}, new int[] {2, 1}}));
    }

    @Test
    void P043_2() {
        P043_2 s = new P043_2();
        assertTrue(s.canFinish(3, new int[][] {new int[] {1, 0}, new int[] {2, 1}}));
    }

    @Test
    void P043_3() {
        P043_3 s = new P043_3();
        assertTrue(s.canFinish(3, new int[][] {new int[] {1, 0}, new int[] {2, 1}}));
    }
}
