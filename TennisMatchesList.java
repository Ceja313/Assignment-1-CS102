public class TennisMatchesList implements TennisMatchesListInterface {
    private TennisMatchNode head;
    private TennisMatchNode tail ;
    private int size;

    // Constructor for the list, requires no args
    public TennisMatchesList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    // Return if the list is empty or not
    public boolean isEmpty()
    {
        return head == null;
    }

    // Return size of the list
    public int getSize()
    {
        return size;
    }

    // Insert a new item at HEAD
    public void prepend(TennisMatchNode match)
    {
        // If the list is empty, set to head and link circularly
        // else move to HEAD
        if (head == null)
        {
            match.setNext(match);
            match.setPrev(match);
            head = match;
            tail = head;
        } else {
            match.setPrev(tail);
            tail.setNext(match);
            head.setPrev(match);
            match.setNext(head);
            head = match;
        }

        // Update size to reflect new addition
        size++ ;
    }

    // Insert a new item at tail
    public void append(TennisMatchNode match)
    {
        // If the list is empty, set to head and link circularly
        // else move to tail
        if (head == null)
        {
            match.setNext(match);
            match.setPrev(match);
            head = match;
            tail = head;
        } else {
            match.setPrev(tail);
            tail.setNext(match);
            head.setPrev(match);
            match.setNext(head);
            tail = match;
        }

        // Update size to reflect new addition
        size++;
    }

    // Insert item at the given position
    @Override
    public void insertMatch(TennisMatch match)
    {
        // If position is 1, prepend value
        // else, check if pos is new tail
        TennisMatchNode newMatch = new TennisMatchNode(match);
        if (head.equals(newMatch))
        {
            prepend(newMatch);
            return;
        } else if (tail.equals(newMatch)) {
            append(newMatch);
            return;
        }

        // Iterate to position starting at head
        TennisMatchNode node = head;
        do {
            node = node.getNext();
        }
        while (!node.equals(newMatch));

        TennisMatchNode tmp = node.getNext();
        node.setNext(newMatch);
        newMatch.setPrev(node);
        newMatch.setNext(tmp);
        tmp.setPrev(newMatch);

        // Update size to reflect new addition
        size++ ;
    }

    // Remove item at the given position
    public void remove(int pos)
    {
        // Check if pos is impossible, throw an exception
        if (pos > size)
            throw new RuntimeException("Position out of range");

        // If removing HEAD, check if that's the only node
        if (pos == 1)
        {
            if (size == 1)
            {
                head = null;
                tail = null;
                size = 0;
                return;
            }

            head = head.getNext();
            head.setPrev(tail);
            tail.setNext(head);
            size--;
            return;
        }

        // If removing tail, relink from prev to HEAD and reduce size
        if (pos == size)
        {
            tail = tail.getPrev();
            tail.setNext(head);
            head.setPrev(tail);
            size--;
        }

        // Otherwise, find position and remove
        TennisMatchNode node = head.getNext();
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                TennisMatchNode prev = node.getPrev();
                TennisMatchNode next = node.getNext();
                prev.setNext(next);
                next.setPrev(prev);
                size--;
                return;
            }

            node = node.getNext();
        }
    }

    // Empty the list
    public void removeAll() {
        head = null;
        tail = null;
        size = 0;
    }

    // Return the data contained by a TennisMatch
    public TennisMatchNode get(int pos) {
        // Check if pos is impossible, throw an exception
        if (pos > ++size)
            throw new RuntimeException("Position out of range");

        // Start at HEAD, iterate to requested position
        TennisMatchNode node = head;
        if (pos > size)
            return null;
        for (int i = 1; i <= size; i++)
        {
            if (i == pos)
                return node;

            node = node.getNext();
        }
        return null;
    }

    // Format the list as a string
    public void printMatches()
    {
        TennisMatchNode node;

        // Check if empty first
        if (size == 0)
            System.out.print("empty\n");

        String linkedList = head.toString() + "\n";
        node = head.getNext();

        // Iterate over all matches
        while (node.getNext() != head)
        {
            linkedList += node.toString() + "\n";
            node = node.getNext();
        }

        System.out.print(linkedList + "\n" + node.getNext().toString() + "\n");
    }
}