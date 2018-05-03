public class TennisPlayersContainer implements TennisPlayersContainerInterface{

    private TennisPlayerNode head;
    private int numPlayers;

    public TennisPlayersContainer() {
        head = null;
        numPlayers = 0;
    }

    private TennisPlayerNode getPlayerNode( String id ) {
        TennisPlayerNode currNode = head;
        int indexCurrNode = 0;
        while ((indexCurrNode < numPlayers) &&
                (currNode.getPlayer().getId().compareTo(id) < 0)) {
            currNode = currNode.getNext();
            indexCurrNode++;
        }
        if (currNode.getPlayer().getId().equals(id)) {
            return currNode;
        } else {
            return null;
        }
    }

    public TennisPlayer getPlayer( String id ) {
        TennisPlayerNode currNode = head;
        for (int i = 0; i < numPlayers; i++) {
            if( currNode.getPlayer().getId().equals(id)) {
                return currNode.getPlayer();
            } else {
                currNode = currNode.getNext();
            }
        }
        return null;


        // may need to change to


//        TennisPlayerNode currNode = head;
//        for (int i = 0; (i < numPlayers) && (currNode.getPlayer().getId().compareTo(id) <= 0); i++) {
//            if( currNode.getPlayer().getId().equals(id)) {
//                return currNode.getPlayer();
//            } else {
//                currNode = currNode.getNext();
//            }
//        }
//        return null;
    }


    @Override
    public void insertPlayer(TennisPlayer player) throws TennisDatabaseRuntimeException {
        TennisPlayer sameId = getPlayer(player.getId() );
        if (sameId != null) {
            // may need to take out dummy implementation
            if (!sameId.isDummy() ) {
                throw new TennisDatabaseRuntimeException("Duplicate player");
            } else {
                sameId.setFirstName(player.getFirstName());
                sameId.setLastName(player.getLastName());
                sameId.setBirthYear(player.getBirthYear());
                sameId.setCountry(player.getCountry());
                sameId.setDummy(false);
            }
        } else {
            TennisPlayerNode prevNode = null;
            TennisPlayerNode currNode = head;
            int indexCurrNode = 0;
            while( (indexCurrNode < numPlayers) &&
                    (currNode != null) &&
                    (player.compareTo(currNode.getPlayer() ) > 0)) {
                prevNode = currNode;
                currNode = currNode.getNext();
                indexCurrNode++;
            }
            TennisPlayerNode newNode = new TennisPlayerNode(player);
            if(prevNode == null) {
                head = newNode;
                newNode.setPrev(newNode);
                newNode.setNext(newNode);
            } else {
                newNode.setPrev(prevNode);
                newNode.setNext(currNode);
                prevNode.setNext(newNode);
                if (currNode != null)
                currNode.setPrev(newNode);
                numPlayers++;
            }
        }
    }

    @Override
    public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException {
        TennisPlayerNode nodePlayer1 = getPlayerNode(m.getPlayer1Id());
        if (nodePlayer1 == null) {
            TennisPlayer player = new TennisPlayer(m.getPlayer1Id(),
                    "", "", 0, "");
            player.setDummy(true);
            try {
                insertPlayer(player);
            } catch (TennisDatabaseRuntimeException ex) {
                System.out.println("Problem inserting player One.");
                player.print();
            }
            nodePlayer1 = getPlayerNode(m.getPlayer1Id());
        }
        if (nodePlayer1 != null) {
            nodePlayer1.insertMatch(m);
        }

        TennisPlayerNode nodePlayer2 = getPlayerNode(m.getPlayer2Id());
        if (nodePlayer2 == null) {
            TennisPlayer player2 = new TennisPlayer(m.getPlayer2Id(),
                    "", "", 0, "");
            player2.setDummy(true);
            try {
                insertPlayer(player2);
            } catch (TennisDatabaseRuntimeException ex) {
                System.out.println("Problem inserting player Two.");
                player2.print();
            }
            nodePlayer2 = getPlayerNode(m.getPlayer2Id());
        }
        if (nodePlayer2 != null) {
            nodePlayer2.insertMatch(m);
        }
    }

    @Override
    public void printAllPlayers() throws TennisDatabaseRuntimeException {
        TennisPlayerNode currNode = head;
        for (int i = 0; i < numPlayers; i++) {
            currNode.getPlayer().print();

            currNode = currNode.next;
        }
    }

    public void printMatchesOfPlayer(String playerId) throws TennisDatabaseRuntimeException {
        TennisPlayer player = getPlayer(playerId);
        if (player != null) {
        } else {
            throw new TennisDatabaseRuntimeException("There does not exist a player with the selected Id");
        }
    }
}
