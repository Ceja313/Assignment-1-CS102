public class TennisPlayerNode implements  TennisPlayerNodeInterface {

    private TennisPlayer player;
    private TennisMatchesList list;
    private TennisPlayerNode prev;
    private TennisPlayerNode next;

    public TennisPlayerNode( TennisPlayer player) {
        this.player = player;
        this.list = new TennisMatchesList();
        this.prev = null;
    }

    public void insertPlayer


    @Override
    public TennisPlayer getPlayer() {
        return player;
    }

    @Override
    public Node getPrev() {
        return null;
    }

    @Override
    public Node getNext() {
        return null;
    }

    @Override
    public void setPrev(Node p) {

    }

    @Override
    public void setNext(Node n) {

    }

    @Override
    public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException {

    }

    @Override
    public void printMatches() throws TennisDatabaseRuntimeException {

    }
}
