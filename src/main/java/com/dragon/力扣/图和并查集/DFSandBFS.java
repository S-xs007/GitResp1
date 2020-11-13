package com.dragon.力扣.图和并查集;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSandBFS {
    //广度优先
    public static void dfs(Node node){
        HashSet<Node> hashSet = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            Node node1 = queue.poll();
            System.out.println(node1.value);
            for(Node node2:node1.nexts){
                if(!hashSet.contains(node2)){
                    hashSet.add(node2);
                    queue.offer(node2);
                }
            }
        }
    }

    //深度优先
    public static void bfs(Node node){
        if (node == null) {
            return;
        }
        HashSet<Node> hashSet = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        hashSet.add(node);
        System.out.println(node);
        while(!stack.isEmpty()){
            Node node1 = stack.pop();
            for(Node node2:node1.nexts){
                if(!hashSet.contains(node2)){
                    stack.push(node1);
                    stack.push(node2);
                    System.out.println(node2);
                    hashSet.add(node2);
                    break;
                }
            }
        }
    }

}
