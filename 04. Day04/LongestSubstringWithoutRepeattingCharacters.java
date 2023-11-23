class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Char,Integer> map=new HashMap<>();
        int ans=0;
        int count=0;
        int i=0,j=0;
        while(j<s.length){
            if(map.containsKey(s[i]) && map.get(s[i]>0)){
                ans=Math.max(count,ans);
                i=j;
            }else{
                map.put(s[i],1);
            }
            j++;
        }
    }
}
