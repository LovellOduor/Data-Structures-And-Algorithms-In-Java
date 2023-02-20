// Binary Search Tree
/*
- It's a type of binary tree in which data is organized in an ordered manner
which helps in faster search and insertion of data. it 
satisfies the following properties.
- The left subtree of a node contains only nodes with values lesser than the node's value.
- The right subtree of a node contains only nodes with values greater than the node's value.
- The left and right subtree must also be a binary tree.
*/

public class BinarySearchTree{
    private TreeNode root;

    public class TreeNode{
    TreeNode left;
    TreeNode right;
    int data;
    public TreeNode(int data){
            this.data = data;
        }
    }

    // Insert values into a binary search tree
    public TreeNode insert(TreeNode root,int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(value<root.data){
            root.left = insert(root.left,value);
        }else{
            root.right = insert(root.right,value);
        }
        return root;
    }

    public void insert(int value){
        this.root = insert(root,value);
    }

    // Search for a given key in a binary search tree
    public TreeNode search(TreeNode root,int key){
        if(root == null || root.data == key){
            return root;
        }
        if(key<root.left.data){
            return search(root.left,key);
        }else{
            return search(root.right,key);
        }
    }

    public TreeNode search(int key){
        return search(root,key);
    }

    // Recursive in order traversal of a binary search tree
    public void recursiveInOrder(TreeNode root){
        if(root == null){
            return;
        }
        recursiveInOrder(root.left);
        System.out.println(root.data);
        recursiveInOrder(root.right);
    }

    public void recursiveInOrder(){
        recursiveInOrder(root);
    }

    // Validate Binary Search Tree
    /*
    Given the root of a binary tree, determine if it's a valid binary search tree.
    */
    public Boolean isValid(TreeNode root,Long min, Long max){
        if(root == null){
            return true;
        }
        if(root.data <= min || root.data >= max){
            return false;
        }
        Boolean left = isValid(root.left,min,root.data);
        if(left){
            Boolean right = isValid(root.right,root.data,max);
            return right;
        }
        return false;
    }

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(1);
        bst.insert(7);
        bst.insert(9);
        //bst.recursiveInOrder();
        System.out.print(bst.search(11).data);
    }

}