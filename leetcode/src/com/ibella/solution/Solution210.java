package com.ibella.solution;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
       if(numCourses==0){
           return null;
       }
       //1.获取所有结点的入度
        int[] inDegree = new int[numCourses];
        for (int i=0;i<prerequisites.length;i++){
            inDegree[prerequisites[i][0]]++;
        }
        //2.找出入度为0的结点
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i=0;i<inDegree.length;i++){
            if (inDegree[i]==0){
                queue.addLast(i);
            }
        }
        //3.删除入度为0的结点，并将其相邻结点的入度-1
        int k =0;
        while (!queue.isEmpty()){
            Integer temp = queue.removeFirst();
            for (int i=0;i<prerequisites.length;i++){
                if (prerequisites[i][1]==temp){
                   int index = prerequisites[i][0];
                   inDegree[index]--;
                   if (inDegree[index]==0){
                       queue.addLast(index);
                   }
                }
            }
            result[k++] = temp;
            numCourses--;
        }
        if (numCourses!=0){
            return new int[]{};
        }
        return result;
    }

    public static void main(String[] args) {
        Solution210 solution210 = new Solution210();
        int[][] prerequisites = new int[1][2];
        prerequisites[0][0] = 1;
        prerequisites[0][1] = 0;
//        prerequisites[1][0] = 2;
//        prerequisites[1][1] = 0;
//        prerequisites[2][0] = 3;
//        prerequisites[2][1] = 1;
//        prerequisites[3][0] = 3;
//        prerequisites[3][1] = 2;
//        prerequisites[2][0] = 0;
//        prerequisites[2][1] = 2;
        int[] r =   solution210.findOrder(2,prerequisites);
        System.out.printf(r.toString());
    }
}
