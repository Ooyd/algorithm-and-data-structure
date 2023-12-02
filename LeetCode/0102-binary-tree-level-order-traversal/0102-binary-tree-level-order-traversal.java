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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for(int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                currentLevel.add(curr.val);

                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(currentLevel);
        }
        
        
        return res;
//         int front = 0, rear = 0;
        
//         queue.append(root,0);
//         rear += 1;
        
//         while(front != rear){
//             curr = queeue[front];
//             front += 1;
            
//             if(curr.left != null){
//                 queue.append(curr[0].left, curr[1] + 1);
//                 rear += 1;
//             } else if(curr.right != null){
//                 queue.append(curr[0].right, curr[1]+1);
//                 rear += 1;
//             }
//         }
        
//         return queue;
        
    }
}