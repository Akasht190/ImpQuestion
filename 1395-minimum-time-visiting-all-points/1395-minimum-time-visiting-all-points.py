class Solution(object):
    def minTimeToVisitAllPoints(self, points):
        total_Points=0

        for i in range(1,len(points)):
            x1,y1=points[i-1]
            x2,y2=points[i]

            horizontal_distance=abs(x2-x1)
            vertical_distance=abs(y2-y1)


            total_Points+=max(horizontal_distance,vertical_distance)

        return total_Points

        