class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        int low=0,high=m*n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int val=matrix[mid/n][mid%n];
            if(val==target){
                return true;
            }else if(val>target) high--;
            else low++;
        }

        return false;
    }
}
