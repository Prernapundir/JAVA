
import java.util.*;
public class Solution {

    static List<Integer> inorder=new ArrayList<>();
    static List<Integer> preorder=new ArrayList<>();
    static List<Integer> postorder=new ArrayList<>();

    public static void dfs(TreeNode root){
        if(root==null) return;
        
        preorder.add(root.data);
        dfs(root.left);
        inorder.add(root.data);
        dfs(root.right);
        postorder.add(root.data);
    }

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        dfs(root);
        ans.add(inorder);
        ans.add(preorder);
        ans.add(postorder);
        return ans;

    }
}
