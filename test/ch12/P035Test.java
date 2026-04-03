package ch12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class P035Test {
    @Test
    void P035_1() {
        P035_1 s = new P035_1();
        int r =
                s.numIslands(
                        new char[][] {
                            {'1', '1', '1', '1', '0'},
                            {'1', '1', '0', '1', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '0', '0', '1'}
                        });
        assertEquals(2, r);
    }

    @Test
    void P035_2() {
        P035_2 s = new P035_2();
        int r =
                s.numIslands(
                        new char[][] {
                            {'1', '1', '1', '1', '0'},
                            {'1', '1', '0', '1', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '0', '0', '1'}
                        });
        assertEquals(2, r);
    }
}
