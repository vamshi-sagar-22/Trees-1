import java.util.HashMap;
import java.util.Map;
/*
Construct Binary Tree from pre and in order traversals
time: O(n)
space: O(n)
 */
class TreeNode {
          int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
public class Problem2 {
    static int rootIndex = 0;
    static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for(int i=0;i<inorder.length;i++) {
            inorderMap.put(inorder[i], i);
        }

        return constructTree(preorder, inorder, inorderMap, 0, preorder.length-1);
    }

    static TreeNode constructTree(int []preorder,int[] inorder, Map<Integer, Integer> inorderMap, int start, int end) {
        if(start>end || rootIndex>=preorder.length) return null;
        TreeNode root = new TreeNode(preorder[rootIndex++]);
        int mid = inorderMap.get(root.val);
        root.left = constructTree(preorder, inorder, inorderMap, start, mid-1);
        root.right = constructTree(preorder, inorder, inorderMap, mid+1, end);

        return root;
    }

    public static void main(String []args) {
        buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}