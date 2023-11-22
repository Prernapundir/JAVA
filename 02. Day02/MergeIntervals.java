class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        List<int[]> list=new ArrayList<>();
        int[] arr=new int[2];
        arr=intervals[0];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=arr[1]){
                arr[1]=Math.max(intervals[i][1],arr[1]);
            }else{
                list.add(arr);
                arr=intervals[i];
            }
        }
        list.add(arr);

        return list.toArray(new int[list.size()][2]);
    }
}
