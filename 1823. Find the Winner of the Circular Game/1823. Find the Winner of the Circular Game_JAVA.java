class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i<=n; i++)list.add(i);
        int pointer = 0;
        while(list.size() > 1){
            int indx = (k+pointer-1) % list.size();
            list.remove(indx);
            if(indx >= list.size())
                indx = 0;
            pointer = indx;
        }
        return list.get(0);
    }
}