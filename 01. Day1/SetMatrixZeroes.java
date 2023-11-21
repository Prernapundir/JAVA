class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        boolean col=false,row=false;

        for(int i=0;i<n;i++){
            if(matrix[0][i]==0) row=true;
        }
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0) col=true;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=m-1;i>=1;i--){
            for(int j=n-1;j>=1;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(row) matrix[0][i]=0;
        }
        
        for(int i=0;i<m;i++){
            if(col) matrix[i][0]=0;
        }
    }
}
