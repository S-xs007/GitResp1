package cn.algorithm.leetcode.图;

import java.util.*;

/**
 * 你这个学期必须选修 numCourse 门课程，记为0到numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 */

public class LC课程表_拓扑排序 {

//1.构建有向图和入读数组
//2.从入读数组中将入读为0的点加入到队列中
//3.队列开始遍历，定义一个变量，踏出一个节点++，最后判断是否等于总科成熟
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        int[] indeg = new int[numCourses];//入度个数，拓扑排序需要每次找到一个入读为0的点
        for (int[] info : prerequisites) {
            graph.computeIfAbsent(info[1],k->new HashSet<>()).add(info[0]);
            ++indeg[info[0]];
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();   //从队列中删除一个入读为0的节点
            for (int v: graph.getOrDefault(u,new HashSet<>())) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
   //-------------------------------------------课程表二，需要返回路径
   public int[] findOrder(int numCourses, int[][] prerequisites) {
       int[] res = new int[numCourses];
       Map<Integer,Set<Integer>> graph = new HashMap<>();
       int[] indeg = new int[numCourses];//入度个数，拓扑排序需要每次找到一个入读为0的点
       for (int[] info : prerequisites) {
           graph.computeIfAbsent(info[1],k->new HashSet<>()).add(info[0]);
           ++indeg[info[0]];
       }
       Queue<Integer> queue = new LinkedList<Integer>();
       for (int i = 0; i < numCourses; ++i) {
           if (indeg[i] == 0) {
               queue.offer(i);
           }
       }
       int index = 0;
       while (!queue.isEmpty()) {
           int u = queue.poll();   //从队列中删除一个入读为0的节点
           res[index++] = u;
           for (int v: graph.getOrDefault(u,new HashSet<>())) {
               --indeg[v];
               if (indeg[v] == 0) {
                   queue.offer(v);
               }
           }
       }
       if (index != numCourses) {
           return new int[0];
       }
       return res;
   }
    }


