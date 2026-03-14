package learnCollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/*
Stack extends Vector, it is synchronized, making it thread-safe
 */

public class LearnStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack); // [1, 2, 3, 4, 5]

        Integer removedElement = stack.pop();
        System.out.println(stack); // [1, 2, 3, 4]

        Integer topElement = stack.peek();
        System.out.println(topElement); // 4
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.size()); // 4

        int search = stack.search(3);
        System.out.println(search); // 2 (1-based index from the top of the stack)
        // 4
        // 3
        // 2
        // 1


        // linkedlist as stack

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.getLast(); // peek
        linkedList.removeLast(); // pop


        // arraylist as stack

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.get(arrayList.size() - 1); // peek
        arrayList.remove(arrayList.size() - 1); // pop
    }
}
