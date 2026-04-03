package ch08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import datatype.ListNode;
import org.junit.jupiter.api.Test;

class P015Test {
    @Test
    void P015_1() {
        P015_1 s = new P015_1();
        ListNode r =
                s.reverseList(
                        new ListNode(
                                1,
                                new ListNode(
                                        2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        assertEquals(5, r.val);
        assertEquals(4, r.next.val);
        assertEquals(3, r.next.next.val);
        assertEquals(2, r.next.next.next.val);
        assertEquals(1, r.next.next.next.next.val);
    }

    @Test
    void P015_2() {
        P015_2 s = new P015_2();
        ListNode r =
                s.reverseList(
                        new ListNode(
                                1,
                                new ListNode(
                                        2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        assertEquals(5, r.val);
        assertEquals(4, r.next.val);
        assertEquals(3, r.next.next.val);
        assertEquals(2, r.next.next.next.val);
        assertEquals(1, r.next.next.next.next.val);
    }

    @Test
    void P015_3() {
        P015_3 s = new P015_3();
        ListNode r =
                s.reverseList(
                        new ListNode(
                                1,
                                new ListNode(
                                        2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        assertEquals(5, r.val);
        assertEquals(4, r.next.val);
        assertEquals(3, r.next.next.val);
        assertEquals(2, r.next.next.next.val);
        assertEquals(1, r.next.next.next.next.val);
    }
}
