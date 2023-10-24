public class Solution {
    public int evalRPN(String[] A) {


        int sum =0;
        Stack st = new Stack();

        int i=0;
        int X=0,Y=0;
        while(i< A.length){
        
            if(A[i].equals("+") || A[i].equals("-") || A[i].equals("*") || A[i].equals( "/")){

                Y = (int)st.pop();
                X = (int)st.pop();





            }

            else{
                st.push(Integer.parseInt(A[i]));

            }

            if(A[i].equals("+")){
                st.push(X+Y);
            }
              if(A[i].equals("-")){
               st.push(X-Y);
            }
              if(A[i].equals("/")){
                st.push(X/Y);
            }
              if(A[i].equals("*")){
               st.push(X*Y);
            }




        i++;

        }

return (int)st.pop();

    }
}
