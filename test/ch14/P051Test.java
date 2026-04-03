package ch14;

import datatype.TreeNode;
import org.junit.jupiter.api.Test;

class P051Test {
    @Test
    void P051_1() {
        P051_1 s = new P051_1();
        TreeNode r =
                s.mergeTrees(
                        new TreeNode(new Integer[] {1, 4, 2, 5}),
                        new TreeNode(new Integer[] {2, 1, 3, null, 4, null, 7}));
        System.out.println(r.prettyPrint());
    }

    @Test
    void P051_2() {
        P051_2 s = new P051_2();
        TreeNode r =
                s.mergeTrees(
                        new TreeNode(new Integer[] {1, 4, 2, 5}),
                        new TreeNode(new Integer[] {2, 1, 3, null, 4, null, 7}));
        System.out.println(r.prettyPrint());
    }
}
