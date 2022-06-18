class WordFilter {

    Trie trie = new Trie();
    
    public WordFilter(String[] words) {
        for(int i = 0; i < words.length; i++) {
            trie.add(words[i], i);
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode node = trie.search(suffix + "#" +prefix);
        return node == null ? -1 : node.index;
    }
}

class Trie {

	private TrieNode root;
	public int count;
    
	public Trie() {
		root = new TrieNode('\0');
	}
    
    public TrieNode search(String prefix) {
        
        TrieNode node = root;
        int prefixLen = prefix.length();
        for(int i = 0; i < prefixLen; i++) {
            char c = prefix.charAt(i);
            int childIndex = c == '#' ? 26 : c - 'a';
            TrieNode childNode = node.children[childIndex];
            if(childNode == null) {
                return null;
            }
            node = childNode;
        }
        return node;
    }
    
    public void add(String word, int index) {
        int len = word.length();
        String hashedWord = "#" + word;
        for(int i = len - 1; i >= 0; i--) {
            hashedWord = word.charAt(i) + hashedWord;
            insert(hashedWord, index);
        }
    }
    
    public void insert(String word, int index) {
        int len = word.length();
        TrieNode node = root;
        
        for(int i = 0; i < len; i++) {
            char c = word.charAt(i);
            int childIndex = c == '#' ? 26 : c - 'a';
            TrieNode childNode = node.children[childIndex];
            if(childNode == null) {
                childNode = new TrieNode(c);
                node.children[childIndex] = childNode;
            }
            childNode.index = index;
            node = childNode;
            if(i == len - 1)
                node.isTerminating = true;
        }
    }
}

class TrieNode{

	char data;
	boolean isTerminating;
	TrieNode children[];
    int index;
    
	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[27];
    }
}
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */