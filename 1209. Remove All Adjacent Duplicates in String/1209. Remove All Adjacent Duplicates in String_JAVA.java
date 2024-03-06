class Node{
    Node next, prev;
    int key, value, freq;

    Node(int key, int value){
        next = null;
        prev = null;
        this.key = key;
        this.value = value;
        freq = 1;
    }
}

class DoubleLinkedList{
    Node head, tail;
    DoubleLinkedList(){
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    void addNode(Node node){
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }
    Node removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }
    Node removeNode(){
        Node tailPrev = tail.prev;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return tailPrev;
    }
    Boolean isEmpty(){
        return head.next == tail;
    }
}

class LFUCache {
    HashMap<Integer, DoubleLinkedList> freqList = new HashMap<Integer, DoubleLinkedList>();
    HashMap<Integer, Node> cache = new HashMap<Integer, Node>();
    int capacity = 0;
    int counter = 0; 
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 1;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            freqList.get(node.freq).removeNode(node);
            if(freqList.get(node.freq).isEmpty() && minFreq == node.freq){
                minFreq++;
            }
            node.freq++;
            if(freqList.get(node.freq) != null){
                freqList.get(node.freq).addNode(node);
            }else{
                DoubleLinkedList dll = new DoubleLinkedList();
                dll.addNode(node);
                freqList.put(node.freq, dll);      
            }
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(cache.containsKey(key)){
            Node tmpNode = cache.get(key);
            freqList.get(tmpNode.freq).removeNode(tmpNode);
            if (freqList.get(tmpNode.freq).isEmpty() && minFreq == tmpNode.freq) {
                minFreq = tmpNode.freq + 1;
            }
            tmpNode.freq++;
            if (freqList.get(tmpNode.freq) == null) {
                DoubleLinkedList d = new DoubleLinkedList();
                d.addNode(tmpNode);
                freqList.put(tmpNode.freq, d);
            } else {
                freqList.get(tmpNode.freq).addNode(tmpNode);
            }
            tmpNode.value = value;
        }else{
            Node newNode = new Node(key, value);
            if(cache.size() == capacity){
              Node node = freqList.get(minFreq).removeNode();
              cache.remove(node.key);
            }
            cache.put(key, newNode);
            if(freqList.get(1) == null){
                DoubleLinkedList dll = new DoubleLinkedList();
                dll.addNode(newNode);

                freqList.put(1, dll);       
            }else{
                freqList.get(1).addNode(newNode);
            }
            minFreq = 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */