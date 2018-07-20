package tree;

public class FlatternTreeToList114 {
  public  TreeNode pre;
  public void flatten(TreeNode root) {
	  if(root==null){
	     return;
	   }
	  flatten(root.right);
	  flatten(root.left);
	  root.right=pre;
	  root.left=null;
	  pre=root;
  }
   
}
