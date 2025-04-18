class SnapshotArray {
    TreeMap<Integer,Integer>[] hm;
    int snap_id;

    public SnapshotArray(int length) {
        hm=new TreeMap[length];
        snap_id=0;

        for(int i=0;i<length;i++){
            hm[i]=new TreeMap<>();
            hm[i].put(0,0);
        }
    }
    
    public void set(int index, int val) {
        hm[index].put(snap_id,val);
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        return hm[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */