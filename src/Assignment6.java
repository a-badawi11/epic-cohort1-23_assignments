/** Assignment #6: find median using two priority queues **/

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Assignment6 {

    private static Queue<Integer> lower =
            new PriorityQueue<>(Comparator.<Integer>comparingInt(a->a).reversed());

    // By default, the items in the priority queue are ordered in natural order.
    private static Queue<Integer> higher = new PriorityQueue<>();

    public static void main(String[] args) {
        addNum(2);
        addNum(1);
        addNum(3);
        addNum(7);
        addNum(5);
        addNum(6);
        addNum(4);
        addNum(8);
        System.out.println("findMedian([1-8]) = " + findMedian());
    }

    private static void addNum(int num) {
        higher.add(num);
        lower.add(higher.poll());
        if (higher.size() < lower.size()) {
            higher.add(lower.poll());
        }
    }

    private static double findMedian() {
        return higher.size() > lower.size()
                ? higher.peek()
                : (higher.peek() + lower.peek()) / 2.0;
    }
}
