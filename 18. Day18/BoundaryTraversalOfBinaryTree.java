

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
    public static void leftBoundary(TreeNode root,List<Integer> ans){
        TreeNode curr=root.left;
        while(curr!=null){
            if(!isLeaf(curr)) ans.add(curr.data);
            if(curr.left!=null) curr=curr.left;
            else curr=curr.right;
        }
    }

    public static void rightBoundary(TreeNode root,List<Integer> ans){
        TreeNode curr=root.right;
        List<Integer> temp=new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr)) temp.add(curr.data);
            if(curr.right!=null) curr=curr.right;
            else curr=curr.left;
        }
        for(int i=temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
    }

    public static void leafBoundary(TreeNode root,List<Integer> ans){
        if(root==null) return;
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        leafBoundary(root.left, ans);
        leafBoundary(root.right, ans);
    }

    public static List<Integer> traverseBoundary(TreeNode root){
       List<Integer> ans=new ArrayList<>();
       if(root==null) return ans;
       ans.add(root.data);
    
       leftBoundary(root,ans);
       leafBoundary(root,ans);
       rightBoundary(root,ans);
       return ans;
    }
}
