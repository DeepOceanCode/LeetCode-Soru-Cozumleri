class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i<=n; i++)list.add(i);
        int pointer = 0;
        while(list.size() > 1){
            if(pointer+k < list.size()){
                int indx = pointer+k-1;
                list.remove(indx);
                if(indx >= list.size())
                    indx = 0;
                pointer = indx;
            }else{
                int indx = (k+pointer-1) % list.size();
                list.remove(indx);
                if(indx >= list.size())
                    indx = 0;
                pointer = indx;
            }
        }
        return list.get(0);
    }
}