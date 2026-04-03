package ch13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class P045Test {
    @Test
    void P045_1() {
        P045_1 s = new P045_1();
        assertEquals(
                500,
                s.findCheapestPrice(
                        3,
                        new int[][] {
                            new int[] {0, 1, 100},
                            new int[] {1, 2, 200},
                            new int[] {0, 2, 500},
                        },
                        0,
                        2,
                        0));
    }

    @Test
    void P045_2() {
        P045_2 s = new P045_2();
        assertEquals(
                500,
                s.findCheapestPrice(
                        3,
                        new int[][] {
                            new int[] {0, 1, 100},
                            new int[] {1, 2, 200},
                            new int[] {0, 2, 500},
                        },
                        0,
                        2,
                        0));
    }

    @Test
    void P045_3() {
        P045_3 s = new P045_3();
        assertEquals(
                500,
                s.findCheapestPrice(
                        3,
                        new int[][] {
                            new int[] {0, 1, 100},
                            new int[] {1, 2, 200},
                            new int[] {0, 2, 500},
                        },
                        0,
                        2,
                        0));
    }
}
