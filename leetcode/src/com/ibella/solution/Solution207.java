package com.ibella.solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       //1.存储所有结点的入度
        int[] inDegree = new int[numCourses];
        for (int[] node:prerequisites){
            inDegree[node[0]]++;
        }
        //删除入度为0的结点，并将其邻结点减一
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i=0;i<inDegree.length;i++){
            if (inDegree[i]==0){
                queue.addLast(i);
            }
        }

        while (!queue.isEmpty()){
            Integer temp = queue.removeFirst();
            //找出temp邻接结点，并将其入度减一
            for (int[] arr:prerequisites){
                if (arr[1] == temp){
                    int index = arr[0];
                    inDegree[index]--;
                    if (inDegree[index]==0){
                        queue.addLast(index);
                    }

                }
            }
            numCourses--;
        }
        return numCourses==0;

    }

    public static void main(String[] args) {
        Solution207 solution207 = new Solution207();
        int[][] prerequisites = new int[2][2];
        prerequisites[0][0] = 1;
        prerequisites[0][1] = 0;
        prerequisites[1][0] = 2;
        prerequisites[1][1] = 1;
//        prerequisites[2][0] = 0;
//        prerequisites[2][1] = 2;
      boolean r =   solution207.canFinish(3,prerequisites);
    }

}
