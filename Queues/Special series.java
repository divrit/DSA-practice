public class Solution {
    public int[] solve(int A) {

        Queue<Integer> queue = new LinkedList();
        int [] ans = new int[A];
        int i=0;
        int ele = 0;
        queue.add(1);
        queue.add(2);
        queue.add(3);



        while(i< A){

          
            ele = queue.remove();

            queue.add(ele * 10 + 1);
            queue.add(ele * 10 + 2);
            queue.add(ele * 10 + 3);

        ans[i] = ele;
        i++;

        }




    return ans;
    }
}
