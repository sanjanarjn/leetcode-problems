class Solution {
    
    Trie trie = new Trie();
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        Arrays.sort(products);
        int i = 0;
        for(String product : products) {
            trie.add(product, i++);
        }
        return trie.search(searchWord, products);
    }
}

class Trie {
    
    TrieNode root = null;
    
    public Trie() {
        this.root = new TrieNode('\0');
    }
    
    public void add(String word, int index) {
        
        TrieNode node = root;
        int n = word.length();
        for(int i = 0; i < n; i++) {
            char c = word.charAt(i);
            TrieNode childNode = node.children[c - 'a'];
            if(childNode == null) {
                childNode = new TrieNode(c);
                childNode.indexes = new ArrayList<>();
                node.children[c - 'a'] = childNode;
            }
            childNode.indexes.add(index);
            if(i == n - 1) {
                childNode.isTerminating = true;
            }
                
            node = childNode;
        }
    }
    
    public List<List<String>> search(String prefix, String[] products) {

        List<List<String>> output = new ArrayList<>();
        
        TrieNode node = root;
        int n = prefix.length();
        for(int i = 0; i < n; i++) {
            char c = prefix.charAt(i);
            List<Integer> indexes = Collections.emptyList();
            
            if(node != null) {
                TrieNode childNode = node.children[c - 'a'];
                indexes = childNode == null ? Collections.emptyList() : childNode.indexes; 
                node = childNode;
            }
            
            List<String> words = new ArrayList<>();
            int count = 0;
            for(int index : indexes) {
                if(count++ == 3)
                    break;
                words.add(products[index]);
            }
            output.add(words);
        }
        return output;
    }
}

class TrieNode {
    
    char data;
    TrieNode[] children;
    boolean isTerminating;
    List<Integer> indexes;
    
    public TrieNode(char data) {
        this.data = data;
        this.children = new TrieNode[26];
    }
}