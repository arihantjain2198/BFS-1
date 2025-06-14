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
    //TimeComplexity : O(N)
    //Space : O(N)
    //BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> bfs = new LinkedList<>();// FIFO
        bfs.add(root);
        while (!bfs.isEmpty()) {
            List<Integer> li = new ArrayList<>();
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = bfs.poll();
                li.add(curr.val);

                if (curr.left != null) {
                    bfs.add(curr.left);
                }
                if (curr.right != null) {
                    bfs.add(curr.right);
                }
            }
            result.add(li);
        }
        return result;
    }

    //DFS
    //TimeComplexity : O(N)
    //Space : O(N)
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
         helper(root,0,result);
         return result;

    }

    private void helper(TreeNode root, int level, List<List<Integer>> result){
        //base
        if(root==null) return;
        //logic
        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        helper(root.left,level+1,result);
        helper(root.right,level+1,result);

    }





}