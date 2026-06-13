import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class stack_queue {
  // Stack use case: check balanced parentheses
  Boolean balanced(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (c == '(') stack.push(c);
      else if (c == ')') {
        if (stack.isEmpty()) return false;
        stack.pop();
      }
    }
    return stack.isEmpty();
  }

  public static void main(String argc[]) {
    // stack (LIFO) -----------------------------------
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(20);
    stack.push(10);
    stack.push(30);

    int top = stack.peek(); // reads top & no remove
    int out = stack.pop(); // removes top
    boolean has = stack.isEmpty();

    // Queue (FIFO) ------------------------------------
    Queue<String> queue = new LinkedList<>();
    queue.offer("task1");
    queue.offer("task2");
    String next = queue.peek(); // view front w/o removing
    String done = queue.poll();

    // priorityQueue : min heap by default
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    minHeap.offer(5);
    minHeap.offer(1);
    minHeap.offer(3);
    minHeap.poll(); // smallest first

    // Max heap
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    // Deque as double ended queue
    Deque<Integer> deque = new ArrayDeque<>();
    deque.offerFirst(1);
    deque.offerLast(2);
    deque.pollFirst();
    deque.pollLast();
  }
}
