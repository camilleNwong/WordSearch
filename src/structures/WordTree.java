package structures;

/**
 * A Binary Search Tree of WordNodes.
 * 
 * @author Camille Wong
 * @date 2/11/22
 * @period Class Period 8
 * 
 */

public class WordTree {
	
	WordNode root;
	int numWords;
	
	public WordTree(){
		root = null;
		numWords = 0;
	}
	
	/**
	 * If word doesn't exist in this word tree, it should be inserted in
	 * 		the appropriate place based on Binary Search.  If words already
	 * 		exists in this tree, the quantity should be updated to reflect 
	 * 		the appropriate number of times word appears in the text
	 * @param word a word to be inserted into this Binary Search Tree
	 * @return the quantity, or number of times that word has been added to the list
	 */
	public int insertWord(String word) {
		WordNode prev=null;
		WordNode pointer= root;
		int comparison=0;
			while(pointer!=null) {
				comparison=word.compareTo(pointer.word);
				//if it has found the word, just update quantity
				if (comparison==0){
					pointer.updateQuantity();
					return pointer.getQuantity();
				}
				
				 if(comparison<0) {
					prev=pointer;
					pointer=pointer.left;
					
				}
				 //when (comparison>0)
				else{
					prev=pointer;
					pointer=pointer.right;
				}
			}
				WordNode node= new WordNode(word, null, null);
				if (comparison<0) {
					prev.left= node;
				}
				else if (comparison>0) {
					prev.right= node;
				}
				else {
					root=node;
					}
				numWords++;
				return 1;
			
		}
	
	/**
	 * Performs a search in this word tree for the word.  Determines and returns
	 *      the depth of the word in the tree.  The root is at depth 0, a child of
	 *      the root is at depth 1, etc... If the word is not in this word tree, -1
	 *      is returned to reflect that the word does not exist in the tree.
	 * 
	 * @param word a word to be searched for in this tree
	 * @return the depth of the word in the tree, or -1 if word is not found.
	 */
	public int wordSearch(String word) {
		int depth=0;
		WordNode pointer=root;
		int comparison=0;

		while(pointer!=null) {
			comparison= word.compareTo(pointer.word);
			if(comparison==0) {
				
				return depth;
			}
		
		//when the word is greater than the root, go right
			else if (comparison>0) {
			pointer=pointer.right;
			depth++;
		}
			//if (comparison<0)
		else  {
			pointer=pointer.left;
			depth++;
		}
	}
		return -1;

}
}
