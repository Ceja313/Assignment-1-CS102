
// Interface (package-private) providing the specifications for the TennisPlayerNode class.
interface TennisPlayerNodeInterface {
   
   // Accessors (getters).
   public TennisPlayer getPlayer();
   public Node getPrev();
   public Node getNext();
   
   // Modifiers (setters).
   public void setPrev( Node p );
   public void setNext( Node n );
   
   // Desc.: Insert a TennisMatch object (reference) into this node.
   // Input: A TennisMatch object (reference).
   // Output: Throws an exception if match cannot be inserted in this list.
   public void insertMatch( TennisMatch m ) throws TennisDatabaseRuntimeException;
   
   // Desc.: Prints all tennis matches in the list of this player to the console.
   // Output: Throws an exception if there are no matches in this list.
   public void printMatches() throws TennisDatabaseRuntimeException;
   
}


