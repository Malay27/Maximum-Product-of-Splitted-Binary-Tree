/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static long totalSum,ans;
    public int maxProduct(TreeNode root) {
        totalSum=0;
        findTotalSum(root);
        ans=Integer.MIN_VALUE;
        solve(root.left);
        solve(root.right);
        return (int)(ans%(1000000007));
    }
    public static void findTotalSum(TreeNode root){
        if(root==null) return;
        totalSum+=root.val;
        findTotalSum(root.left);
        findTotalSum(root.right);
        if(root.left!=null) root.val+=root.left.val;
        if(root.right!=null) root.val+=root.right.val;
    }
    public static void solve(TreeNode root){
        if(root==null) return;
        ans=Math.max(ans,((totalSum-root.val)*root.val));
        solve(root.left);
        solve(root.right);
    }
}
