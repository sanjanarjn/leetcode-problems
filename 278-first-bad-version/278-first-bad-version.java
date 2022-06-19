/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    
    public int firstBadVersion(int n) {
        
        int low = 0;
        int high = n;
        
        int firstBadVersion = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            boolean isMidBadVersion = isBadVersion(mid);
            if(isMidBadVersion) {
                firstBadVersion = firstBadVersion == -1 ? mid : Math.min(firstBadVersion, mid);
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return firstBadVersion;
    }
}