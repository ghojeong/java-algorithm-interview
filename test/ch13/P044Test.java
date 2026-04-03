package ch13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class P044Test {
    @Test
    void P044_1() {
        P044_1 s = new P044_1();
        assertEquals(
                5,
                s.networkDelayTime(
                        new int[][] {
                            new int[] {3, 1, 5},
                            new int[] {3, 2, 2},
                            new int[] {2, 1, 2},
                            new int[] {3, 4, 1},
                            new int[] {4, 5, 1},
                            new int[] {5, 6, 1},
                            new int[] {6, 7, 1},
                            new int[] {7, 8, 1},
                            new int[] {8, 1, 1},
                        },
                        8,
                        3));
    }

    @Test
    void P044_2() {
        P044_2 s = new P044_2();
        assertEquals(
                5,
                s.networkDelayTime(
                        new int[][] {
                            new int[] {3, 1, 5},
                            new int[] {3, 2, 2},
                            new int[] {2, 1, 2},
                            new int[] {3, 4, 1},
                            new int[] {4, 5, 1},
                            new int[] {5, 6, 1},
                            new int[] {6, 7, 1},
                            new int[] {7, 8, 1},
                            new int[] {8, 1, 1},
                        },
                        8,
                        3));
    }
}
