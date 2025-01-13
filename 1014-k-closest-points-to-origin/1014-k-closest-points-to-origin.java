class Solution {
    public class Point implements Comparable<Point>{
        int x;
        int y;
        int distance;

        public Point(int x,int y,int distance){
            this.x=x;
            this.y=y;
            this.distance=distance;
        }


        public int compareTo(Point p1){
            return p1.distance-this.distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap=new PriorityQueue<>();

        for(int i=0;i<points.length;i++){
             int distance=points[i][0] * points[i][0] + points[i][1] * points[i][1];
             Point point=new Point(points[i][0],points[i][1],distance);


             maxHeap.add(point);

             if(maxHeap.size()>k){
                maxHeap.remove();
             }
        }

        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            Point p=maxHeap.remove();
            ans[i][0]=p.x;
            ans[i][1]=p.y;
        }
        return ans;
    }
}