package ch10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import datatype.ListNode;
import org.junit.jupiter.api.Test;

class P027Test {
    @Test
    void P027_1() {
        P027_1 s = new P027_1();
        ListNode r =
                s.mergeKLists(
                        new ListNode[] {
                            new ListNode(1, new ListNode(4, new ListNode(5))),
                            new ListNode(1, new ListNode(3, new ListNode(4))),
                            new ListNode(2, new ListNode(7)),
                        });
        assertEquals(1, r.val);
        assertEquals(1, r.next.val);
        assertEquals(2, r.next.next.val);
        assertEquals(3, r.next.next.next.val);
        assertEquals(4, r.next.next.next.next.val);
        assertEquals(4, r.next.next.next.next.next.val);
        assertEquals(5, r.next.next.next.next.next.next.val);
        assertEquals(7, r.next.next.next.next.next.next.next.val);
    }

    @Test
    void P027_2() {
        P027_2 s = new P027_2();
        ListNode r =
                s.mergeKLists(
                        new ListNode[] {
                            new ListNode(1, new ListNode(4, new ListNode(5))),
                            new ListNode(1, new ListNode(3, new ListNode(4))),
                            new ListNode(2, new ListNode(7)),
                        });
        assertEquals(1, r.val);
        assertEquals(1, r.next.val);
        assertEquals(2, r.next.next.val);
        assertEquals(3, r.next.next.next.val);
        assertEquals(4, r.next.next.next.next.val);
        assertEquals(4, r.next.next.next.next.next.val);
        assertEquals(5, r.next.next.next.next.next.next.val);
        assertEquals(7, r.next.next.next.next.next.next.next.val);
    }
}
