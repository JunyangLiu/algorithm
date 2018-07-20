package tree;

public class NK_MaxSubtree {

    public TreeNode getMax(TreeNode root) {
    	Subtree subtree=get(root);
    	return subtree.node;
        
    }
    public Subtree get(TreeNode root) {
    	
    	Subtree current=new Subtree(null,Integer.MIN_VALUE,Integer.MAX_VALUE,0);
    	if(root==null){
    		return current;
    	}
    	Subtree left=get(root.left);
    	Subtree right=get(root.right);


    	if(root.left==left.node&&root.right==right.node&&left.max<root.val&&root.val<right.min){
    		
    		current.node=root;
        	current.nums=left.nums+right.nums+1;
        	current.max=Math.max(root.val, right.max);
        	current.min=Math.min(root.val, left.min);
        	//这两步很细节，可以符合当前节点是叶子节点的情况
        	//当前节点是叶子节点的话说明max 和min 都要更新为当前节点的值
        	
    	}else{
    		if(left.nums>right.nums){
    			
    			current.node=left.node;
    			current.nums=left.nums;
            	current.max=left.max;
            	current.min=left.min;
            	
    		}else{
    			
    			current.node=right.node;
    			current.nums=right.nums;
    			current.max=right.max;
    			current.min=right.min;
    		}
    	}
    	
		return current;
	}
    class Subtree{
    	
    	public TreeNode node;
    	public int max;//节点的最大值
    	public int min;//节点的最小值
    	public int nums;//最大搜索子树的节点数
    	
    	public  Subtree(TreeNode node,int max,int min,int nums){
    		this.node=node;
    		this.max=max;
    		this.min=min;
    		this.nums=nums;
    	}
    }
}
