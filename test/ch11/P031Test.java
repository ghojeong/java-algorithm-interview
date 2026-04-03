package ch11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class P031Test {
    @Test
    void P031_1() {
        P031_1 s = new P031_1();
        assertEquals(3, s.numJewelsInStones("aA", "aAAbbbb"));
    }

    @Test
    void P031_2() {
        P031_2 s = new P031_2();
        assertEquals(3, s.numJewelsInStones("aA", "aAAbbbb"));
    }

    @Test
    void P031_3() {
        P031_3 s = new P031_3();
        assertEquals(3, s.numJewelsInStones("aA", "aAAbbbb"));
    }
}
