/*
public class TrieDataStructure {

	public static void main(String[] args) {
//http://www.java2blog.com/2016/10/trie-data-structure-in-java.html
	}

}*/
//Check insert and search
//https://www.hackerearth.com/practice/data-structures/advanced-data-structures/trie-keyword-tree/tutorial/
import java.util.*;
 
class TrieNode 
{
    char data; 
    boolean isEnd; 
    int count;  
    LinkedList<TrieNode> childList; 
 
    /* Constructor */
    public TrieNode(char c)
    {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        data = c;
        count = 0;
    }  
    public TrieNode getChild(char c)
    {
        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.data == c)
                    return eachChild;
        return null;
    }
}
 
public class TrieDataStructure
{
    private TrieNode root;
 
     /* Constructor */
    public TrieDataStructure()
    {
        root = new TrieNode(' '); 
    }
    /* This function is used to insert a word in trie*/
    public void insert(String word)
    {
        if (search(word) == true) 
            return;        
        TrieNode current = root; 
        for (char ch : word.toCharArray() )
        {
            TrieNode child = current.getChild(ch);
            if (child != null)
                current = child;
            else 
            {
             // If child not present, adding it io the list
                 current.childList.add(new TrieNode(ch));
                 current = current.getChild(ch);
            }
            current.count++;
        }
        current.isEnd = true;
    }
    /* This function is used to search a word in trie*/
    public boolean search(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.getChild(ch) == null)
                return false;
            else
                current = current.getChild(ch);
        }      
        if (current.isEnd == true) 
            return true;
        return false;
    }
    /* This function is used to remove function from trie*/
    public void remove(String word)
    {
        if (search(word) == false)
        {
            System.out.println(word +" does not present in trien");
            return;
        }             
        TrieNode current = root;
        for (char ch : word.toCharArray()) 
        { 
            TrieNode child = current.getChild(ch);
            if (child.count == 1) 
            {
                current.childList.remove(child);
                return;
            } 
            else 
            {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }
  
    public static void printAllWordsInTrie(TrieNode root,String s)
    {
      TrieNode current = root;
      if(root.childList==null || root.childList.size()==0)
       return;
      Iterator iter=current.childList.iterator();
     while(iter.hasNext())
     {
      TrieNode node= (TrieNode) iter.next();
      s+=node.data;
      printAllWordsInTrie(node,s);
      if(node.isEnd==true)
      { 
       System.out.print(" "+s);
       s=s.substring(0,s.length()-1);
      }
      else
      {
       s=s.substring(0,s.length()-1);
      }
     }
      
    }
    public static void main(String[] args)
    {            
        TrieDataStructure t = new TrieDataStructure();       
        t.insert("dear");
        t.insert("deal");
        t.insert("do");
        t.insert("he");
        t.insert("hen");
        t.insert("heat");
        
        System.out.println("hen present in trie : "+t.search("hen"));
        System.out.println("hear present in trie : "+t.search("hear"));
        System.out.println("deal present in trie : "+t.search("deal"));
        System.out.println("========================");
        System.out.println("Printing all word present in trie : ");
        printAllWordsInTrie(t.root,"");              
    }
}