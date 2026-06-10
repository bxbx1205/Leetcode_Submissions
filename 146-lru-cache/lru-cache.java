class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    private int capacity;
    private HashMap<Integer,Node> map;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<>();

        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next=tail;
        tail.prev=head;
    }

    private void insertAfterHead(Node node){

        Node currentAH=head.next;
        head.next=node;
        node.prev=head;

        node.next=currentAH;
        currentAH.prev=node;
        

        return;
    }

    private void deleteNode(Node node){

        Node prevNode=node.prev;
        Node nextNode = node.next;

        prevNode.next=nextNode;
        nextNode.prev=prevNode;
        
        return;
    }


    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);

        deleteNode(node);
        insertAfterHead(node);

        return node.value;

    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){

            Node node = map.get(key);

            node.value=value;

            deleteNode(node);
            insertAfterHead(node);
        }
        else{
            if(map.size()==capacity){
               Node lru = tail.prev;

                map.remove(lru.key);
                deleteNode(lru);
            }
            Node newNode = new Node(key, value);

            insertAfterHead(newNode);
            map.put(key, newNode);
        }

        

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */