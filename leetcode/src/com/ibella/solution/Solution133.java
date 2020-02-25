package com.ibella.solution;

import com.ibella.model.Node;

import java.util.*;

public class Solution133 {
    public Node cloneGraph(Node node) {
        if (node==null){
            return null;
        }
       //存放访问过的结点
        Map<Node,Node> visit = new HashMap<>();

        //存放不重复的元素，用来出栈用
        LinkedList<Node> list = new LinkedList<>();

        visit.put(node,new Node(node.val,new ArrayList<Node>()));
        list.add(node);

        while (!list.isEmpty()){
            Node temp = list.remove();
            List<Node> neighbors = temp.neighbors;
            if (neighbors!=null){
                for (Node n:neighbors){

                    if (!visit.containsKey(n)){
                        visit.put(n,new Node(n.val,new ArrayList<Node>()));
                        list.add(n);
                    }
                    visit.get(temp).neighbors.add(visit.get(n));
                }
            }

        }
        return visit.get(node);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Solution133 solution133 = new Solution133();
        Node result =  solution133.cloneGraph(node1);
    }
}
