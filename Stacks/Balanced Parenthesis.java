public class Solution {
    public int solve(String A) {
        Stack<Character> s = new Stack<Character>();


        for(int i=0;i< A.length(); i++){
        if(A.charAt(i)=='('|| A.charAt(i)=='{'||A.charAt(i)=='['){
            s.push(A.charAt(i));
        }
        else if(A.charAt(i) == ')' &&!s.isEmpty()&& s.peek() == '('){
            s.pop();
        }
        else if(A.charAt(i) == '}' &&!s.isEmpty()&& s.peek()=='{' ){
            s.pop();

        }
        else if(A.charAt(i) == ']' &&!s.isEmpty()&& s.peek() == '['){
            s.pop();

        }
        else if (A.charAt(i) == ')' || A.charAt(i) == '}' || A.charAt(i) == ']') {
                // If it's a closing bracket but either stack is empty or it doesn't match the top of the stack
                return 0;
        }


}


    return s.isEmpty()? 1:0;
}

}
