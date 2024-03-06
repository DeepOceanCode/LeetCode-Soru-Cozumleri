class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int len = deck.length;
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<len; i++){
            queue.add(i);
        }

        int arr [] = new int[len];
        for(int j = 0; j<len; j++){
            arr[queue.poll()] = deck[j];
            queue.add(queue.poll());
        }

        return arr;
    }
}