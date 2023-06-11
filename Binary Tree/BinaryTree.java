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
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
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

    //Iterative pre-order traversal
    public void iterativePreOrder(TreeNode root){
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode temp = stk.pop();
            System.out.println(temp.data);
            if(temp.left != null){
                stk.push(temp.left);
            }
            if(temp.right != null){
                stk.push(temp.right);
            }
        }

    }
    //Iterative in-order traversal
    public void iterativeInOrder(TreeNode root){
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode current = root;
        while(!stk.isEmpty() || current != null){
            if(current != null){
                stk.push(current);
                current = current.left;
            }else{
                current = stk.pop();
                System.out.println(current.data+" ");
                current = current.right;
            }
        }
    }

    // Find maximum value
    public int findMax(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        
        if(left>result){
            result = left;
        }
        if(right>result){
            result = right;
        }
        return result;
    }

    // Iterative post-order traversal
    public void iterativePostOrder(TreeNode root){
        /* First create two variables current to keep track of the current node
        And a stack to store all the nodes
        */
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        /* Through a while loop, we then check whether the current node is null or
        the stack is empty if either conditions are false then we are done traversing the binary tree*/
        while(current!=null || !stack.isEmpty()){
            /* The algorithm will first traverse all the left nodes of the sub trees before going to the right nodes
            First we check whether the current node is null if not then
            we add the current node to the stack to keep track of it then move the current node to the left node
            of it's next subtree
            */      
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                /* When the algorithm gets to the end of the subtrees by reaching a null value
                we check whether we are at the right or the left node of the current subtree
                If we are at the left, then it means we need to visit the right before visiting the parent. Otherwise
                If we are at the right the we can pop the current node as it is the parent and process it cause it means we
                have finishedd traversing the tree*/
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    /* It means we've visited all nodes on the left and there is no subtree left on the right so we can 
                    visit the parent */
                    temp = stack.pop();
                    System.out.print(temp.data+" ");
                    /*
                    After poping out the temp node, we need to check whether it was to the left or right of it's parent
                    if it's to the left then we visit the parent's right if it's the right then we visit the parent by poping 
                    the stack
                     */
                    /*
                     We use a while loop because there is also a chance that the node we visit forms a chain of nodes to 
                     the right of their parent
                     */
                    while(!stack.isEmpty() && temp==stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }else{
                    current = temp;
                }
            }
        }
    }

    //Recursive pre-order traversal
    public void recursivePreOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data +" ");
        recursivePreOrder(root.left);
        recursivePreOrder(root.right);
    }

    //Recursive in-order traversal
    public void recursiveInOrder(TreeNode root){
        if(root == null){
            return;
        }
        recursiveInOrder(root.left);
        System.out.println(root.data);
        recursiveInOrder(root.right);
    }

    //Recursive post-order traversal
    public void recursivePostOrder(TreeNode root){
        if(root == null){
            return;
        }
        recursivePostOrder(root.left);
        recursivePostOrder(root.right);
        System.out.println(root.data);
    }

    // Level order traversal
    public void levelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.println(temp.data);
            if(temp.left !=  null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
    }


    // Is the binary tree symetric

    public boolean isSymetric(){
        Stack<TreeNode> stk = new Stack<>();
        stk.push(this.root.left);
        stk.push(this.root.right);  
        while(!stk.isEmpty()){
            TreeNode n1 = stk.pop();
            TreeNode n2 = stk.pop();
            if(n1==null && n2 == null) continue;
            if(n1 ==null || n2==null || n1.data != n2.data) return false;
            stk.push(n1.left);
            stk.push(n2.right);
            stk.push(n1.right);
            stk.push(n2.left);
        }
        return true;
    }
    
    public void createBinaryTree(){    
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(2);
        
        root = first;
        first.left = second;
        first.right = third;
    }

    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        System.out.print(bt.isSymetric());
    }
}