// Definition
/*
- A tree is a non-linear data structure for storing data
- It is made up of nodes and edges, without having any cycle.
Each node in a tree can point to n number of nodes.
- It is a way of presenting hierarchical structure with a parent node called root and 
many levels of additional nodes.
- Parent nodes are nodes with children beneath.
- Leaf nodes are nodes without children.  
*/
public class BinaryTree{
    private TreeNode root;

    public class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;
        public TreeNode(int data){
            this.data = data;
        }
    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data +" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;
        

    }

    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        bt.preOrder(bt.root);
    }
}