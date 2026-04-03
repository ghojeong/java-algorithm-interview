package ch13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class P046Test {
    @Test
    void P046_1() {
        P046_1 s = new P046_1();
        assertEquals(
                11,
                s.solution(
                        new int[][] {
                            {1, 0, 1, 1, 1},
                            {1, 0, 1, 0, 1},
                            {1, 0, 1, 1, 1},
                            {1, 1, 1, 0, 1},
                            {0, 0, 0, 0, 1}
                        }));
    }
}
