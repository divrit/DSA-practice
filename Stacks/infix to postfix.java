public class Solution {
    public String solve(String A) {


        Stack<Character> s = new Stack<Character>();

        StringBuilder sb = new StringBuilder();
        for(int i =0; i< A.length(); i++){

            if(A.charAt(i) >='a' && A.charAt(i) <= 'z'){
                sb.append(A.charAt(i));
            }
            else if( A.charAt(i) == '('){
                s.push(A.charAt(i));
            }

            else if( !s.isEmpty() && A.charAt(i) == ')'){
                while(!s.isEmpty() && s.peek() != '('){
                    sb.append(s.pop());
                }
              if(!s.isEmpty()) { // Ensure that stack is not empty before popping
        s.pop();
    }
            }
 
            else{

                while( !s.isEmpty() && getPrecedence(s.peek()) >= getPrecedence(A.charAt(i))){
                    sb.append(s.pop());
                }
                
                    s.push(A.charAt(i));
                
            }
        }

  while (!s.isEmpty()) {
            sb.append(s.pop()); // Pop any remaining operators from the stack
        }


        return sb.toString();
    }




    public int getPrecedence(char c){

            if(c == '^'){
                return 2;
            }
            if(c == '*' || c == '/'){
                return 1;
            }
            if(c == '+'|| c == '-'){
                return 0;
            }

        return 0;
    }
}
