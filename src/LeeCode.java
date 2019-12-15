import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeeCode{
   static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode createTree(TreeNode root){
        TreeNode n1 = root;
         n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        return n1;
    }

    /**
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            //此时的count表示上一层节点的count，后面队列中添加的元素不会影响count的值
            while(count > 0 ){
                TreeNode node = queue.poll();
                count --;
                if(count == 0){
                    ans.add(node.val);
                }
                if(node.left !=null){
                    queue.offer(node.left);
                }
                if(node.right !=null){
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }
    /**
     * 二叉树的层序遍历二
     * @param root 根节点
     * @return 给定一个二叉树，返回其节点值自底向上的层次遍历
     *
     *
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>>ans = new LinkedList<>();
        Queue<TreeNode> queue  = new LinkedList<>();
        if(root == null)
            return ans;
        TreeNode cur = root;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int count = queue.size();
            for(int i = 0 ; i < count ; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null)
                queue.offer(node.left);
                if(node.right!=null)
                queue.offer(node.right);
            }
            //addFirst()是LinedList中的方法，不是List中的方法。
            ans.addFirst(list);
        }
        return ans;
    }
  static   TreeNode root = null;
    public static void main(String[] args) {
        TreeNode cur = LeeCode.createTree(root);
        LeeCode l = new LeeCode();
        System.out.println(l.levelOrderBottom(cur));
        System.out.println(l.rightSideView(cur));
    }
}
