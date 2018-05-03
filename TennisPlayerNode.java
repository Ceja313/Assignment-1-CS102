public class TennisPlayerNode implements  TennisPlayerNodeInterface {

    private TennisPlayer player;
    private TennisMatchesList list;
    private TennisPlayerNode prev;
    protected TennisPlayerNode next;

    public TennisPlayerNode( TennisPlayer player) {
        this.player = player;
        this.list = new TennisMatchesList();
        this.prev = null;
        this.next = null;
    }

    @Override
    public TennisPlayer getPlayer() {
        return player;
    }

    @Override
    public TennisPlayerNode getPrev() {
        return prev;
    }

    @Override
    public TennisPlayerNode getNext() {
        return next;
    }

    @Override
    public void setPrev(TennisPlayerNode p) {
        prev = p;
    }

    @Override
    public void setNext(TennisPlayerNode n) {
        next = n;
    }

    @Override
    public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException {
        list.insertMatch(m);
    }

    @Override
    public void printMatches() throws TennisDatabaseRuntimeException {
        list.printMatches();
    }
}
