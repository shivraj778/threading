package multithreading.platformthread;

import java.sql.Array;
import java.util.*;
import java.util.stream.Stream;
// context switching is the process of storing a thread current state
// and later restoring the state of the thread to continue execution

// virtual thread always have same priority 5
public class PlatFormThreadExample {
    public static void main(String[] args) throws InterruptedException {
        var threads = Stream.generate(()-> Thread
                        //.ofPlatform()
                        .ofVirtual()
                .unstarted(PlatFormVsVirtual::waitUp))
                .limit(1_000_000)
                .toList();
        threads.forEach(Thread::start);
        for (var t: threads) {
            t.join();
        }
        PlatFormVsVirtual obj = new PlatFormVsVirtual();
        System.out.println(PlatFormVsVirtual.strStr("leetcodeleet","leet"));

    }

}

class PlatFormVsVirtual {
    static void waitUp() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static  int strStr(String haystack, String needle) {
        return  haystack.indexOf(needle);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newListNode = new ListNode();
        ListNode head = newListNode;
        List<Integer> list =  new ArrayList<>();

        for (int i=0;i< lists.length;i++) {
            ListNode temp = lists[i];

            while (temp != null) {
                list.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(list);
        for (Integer i: list) {
            //ListNode listNode =  ;
            newListNode.next = new ListNode(i);
            newListNode =  newListNode.next;
        }



        return head.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList =  new ListNode();

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode head = newList;
        ListNode temp = head;

        while (temp1 != null && temp2 != null) {
            ListNode node = new ListNode();
            int value1 = temp1.val;
            int value2 = temp2.val;
            if (value1 < value2) {
                node.val = value1;
                temp1 = temp1.next;
            } else {
                node.val = value2;
                temp2 = temp2.next;
            }
            temp.next = node;
            temp = temp.next;
        }

        if (temp1 == null) {
            while (temp2 != null) {
                ListNode node = new ListNode();
                node.val = temp2.val;
                temp2 = temp2.next;
                temp.next = node;
                temp= temp.next;
            }
        } else {
            while (temp1 != null) {
                ListNode node = new ListNode();
                node.val = temp1.val;
                temp1 = temp1.next;
                temp.next = node;
                temp = temp.next;
            }
        }
        return head.next;
    }
}


  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


