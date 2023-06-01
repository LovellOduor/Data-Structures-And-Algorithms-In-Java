public class Trie{

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }
    
    private class TrieNode{
        private TrieNode[] children;
        private boolean isWord;
        public TrieNode(){
            children = new TrieNode[26]; // store english words a -> z
            isWord = false;
        }
    }

    public void insert(String word){
        TrieNode current = root;
        word = word.toLowerCase();
        for(int i = 0; i< word.length(); i++){    
            char c = word.charAt(i);
            int index = c - 'a'; // convert the char to it's ascii numerical equivalent and normalize between 0 - 25 i.e a - z
            if(current.children[index] == null){
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            }else{
                current = current.children[index];
            }
        }
        current.isWord = true;
    }

    public boolean search(String word){
        return false;
    }

    public static void main(String[] args){
    
    }
}