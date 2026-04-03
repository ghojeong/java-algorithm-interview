package ch08;

import static org.junit.jupiter.api.Assertions.assertTrue;

import datatype.ListNode;
import org.junit.jupiter.api.Test;

class P013Test {
    @Test
    void P013_1() {
        P013_1 s = new P013_1();
        assertTrue(
                s.isPalindrome(
                        new ListNode(
                                1,
                                new ListNode(
                                        2, new ListNode(3, new ListNode(2, new ListNode(1)))))));
    }

    @Test
    void P013_2() {
        P013_2 s = new P013_2();
        assertTrue(
                s.isPalindrome(
                        new ListNode(
                                1,
                                new ListNode(
                                        2, new ListNode(3, new ListNode(2, new ListNode(1)))))));
    }

    @Test
    void P013_3() {
        P013_3 s = new P013_3();
        assertTrue(
                s.isPalindrome(
                        new ListNode(
                                1,
                                new ListNode(
                                        2, new ListNode(3, new ListNode(2, new ListNode(1)))))));
    }

    @Test
    void P013_4() {
        P013_4 s = new P013_4();
        assertTrue(
                s.isPalindrome(
                        new ListNode(
                                1,
                                new ListNode(
                                        2, new ListNode(3, new ListNode(2, new ListNode(1)))))));
    }
}
