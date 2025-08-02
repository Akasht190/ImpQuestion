class Solution {
    public void duplicateZeros(int[] arr) {
        List<Integer> temp=new ArrayList<>();

        for(int num:arr){
            temp.add(num);
            if(num==0){
                temp.add(0);
            }
        }

        for(int i=0;i<arr.length;i++){
            arr[i]=temp.get(i);
        }
    }
}