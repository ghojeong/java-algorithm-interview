package ch14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import datatype.TreeNode;
import org.junit.jupiter.api.Test;

class P047Test {
    @Test
    void P047_1() {
        P047_1 s = new P047_1();
        assertEquals(3, s.maxDepth(new TreeNode(new Integer[] {3, 9, 20, null, null, 15, 7})));
    }

    @Test
    void P047_2() {
        P047_2 s = new P047_2();
        assertEquals(3, s.maxDepth(new TreeNode(new Integer[] {3, 9, 20, null, null, 15, 7})));
    }

    @Test
    void P047_3() {
        P047_3 s = new P047_3();
        assertEquals(3, s.maxDepth(new TreeNode(new Integer[] {3, 9, 20, null, null, 15, 7})));
    }
}
