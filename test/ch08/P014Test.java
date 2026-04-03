package ch08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import datatype.ListNode;
import org.junit.jupiter.api.Test;

class P014Test {
    @Test
    void P014_1() {
        P014_1 s = new P014_1();
        ListNode r =
                s.mergeTwoLists(
                        new ListNode(1, new ListNode(2, new ListNode(5))),
                        new ListNode(1, new ListNode(3, new ListNode(4))));
        assertEquals(1, r.val);
        assertEquals(1, r.next.val);
        assertEquals(2, r.next.next.val);
        assertEquals(3, r.next.next.next.val);
        assertEquals(4, r.next.next.next.next.val);
        assertEquals(5, r.next.next.next.next.next.val);
    }

    @Test
    void P014_2() {
        P014_2 s = new P014_2();
        ListNode r =
                s.mergeTwoLists(
                        new ListNode(1, new ListNode(2, new ListNode(5))),
                        new ListNode(1, new ListNode(3, new ListNode(4))));
        assertEquals(1, r.val);
        assertEquals(1, r.next.val);
        assertEquals(2, r.next.next.val);
        assertEquals(3, r.next.next.next.val);
        assertEquals(4, r.next.next.next.next.val);
        assertEquals(5, r.next.next.next.next.next.val);
    }
}
