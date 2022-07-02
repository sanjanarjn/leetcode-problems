public class Solution {

    public int reverseBits(int n) {
       int pos = Integer.SIZE - 1;     // maintains shift
 
        // store reversed bits of `n`. Initially, all bits are set to 0
        int reverse = 0;
 
        // do till all bits are processed
        while (pos >= 0 && n != 0)
        {
            // if the current bit is 1, then set the corresponding bit in the result
            if ((n & 1) != 0) {
                reverse = reverse | (1 << pos);
            }
 
            n >>= 1;                    // drop current bit (divide by 2)
            pos--;                      // decrement shift by 1
        }
 
        return reverse;
    }
}