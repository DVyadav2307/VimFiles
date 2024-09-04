import java.util.Stack;

public class StackDS {

    public static void main(String[] args) {
        

        Stack<String> stack = new Stack<String>();
        
        stack.push("third");
        stack.push("first");
        stack.push("second");

        stack.pop();

        System.out.println("stack.peek() = " + stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println("stack = " + stack);
    }
}