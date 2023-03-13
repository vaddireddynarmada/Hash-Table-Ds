public class LinkedList<K> {
    INode head;
    INode tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode newNode) {
        if (this.tail == null) {
            this.tail = newNode;
        }
        if (this.head == null) {
            this.head = newNode;
        } else {
            INode temp = this.head;
            this.head = newNode;
            this.head.setNext(temp);

        }
    }

    public void append(INode newNode) {
        if (this.tail == null) {
            this.tail = newNode;
        }
        if (this.head == null) {
            this.head = newNode;
        } else {
            INode tempINode = this.tail;
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    public void insert(INode previousNode, INode newNode) {
        INode temporaryNode = previousNode.getNext();
        previousNode.setNext(newNode);
        newNode.setNext(temporaryNode);
    }

    public INode pop() {
        INode temporaryNode = this.head;
        this.head = this.head.getNext();
        return temporaryNode;
    }

    public INode popLast() {
        INode temporaryNode = head;
        while (!temporaryNode.getNext().equals(tail)) {
            temporaryNode = temporaryNode.getNext();
        }
        this.tail = temporaryNode;
        temporaryNode = temporaryNode.getNext();
        return temporaryNode;
    }

    public INode search(K key) {
        INode temp = head;
        boolean isFound = false;
        while (temp != null && isFound == false) {
            if (temp.getKey().equals(key)) {
                isFound = true;
            } else {

                temp = temp.getNext();
            }
        }
        if (isFound)
            return temp;
        else {
            return head;
        }
    }

    public void insertWithKey(K key, INode newNode) {
        INode nodeWithKeyValue = search(key);
        if (nodeWithKeyValue.getKey().equals(key)) {
            INode temp = nodeWithKeyValue.getNext();
            nodeWithKeyValue.setNext(newNode);
            newNode.setNext(temp);
        } else {
            System.out.println("Key Node Found");
        }
    }

    public int size() {
        int numberOfNode = 0;
        INode temp = this.head;
        while (temp != null) {
            temp = temp.getNext();
            numberOfNode++;
        }
        return numberOfNode;
    }

    public void printLinkedList() {
        System.out.println("My Nodes: " + head);
    }

    public void print() {
        System.out.println("My Nodes: " + head);
    }


}
