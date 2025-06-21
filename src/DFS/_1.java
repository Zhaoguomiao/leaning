package DFS;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x){
        val=x;
    }
}
public class _1 {
    public List<Integer> preOrder(TreeNode root){
        List<Integer> result=new ArrayList<>();
        dfs(root,result);
        return result;
    }
    private void dfs(TreeNode node,List<Integer> result){//深度优先搜索主函数，一个起点一个放数据的列表，递归调用
        if(node==null) return;
        result.add(node.val);//先保存根节点的值
        dfs(node.left,result);//此时根节点的左节点,变成了当前分支的根节点，此后递归的调用所有的根节点
        dfs(node.right,result);//一颗子树全部递归执行完毕才会递归执行下一条子树
    }
}
