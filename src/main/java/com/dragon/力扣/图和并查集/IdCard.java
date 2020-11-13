package com.dragon.力扣.图和并查集;

import java.util.HashMap;

public class IdCard {
//并查集求几个人
    public static int getPeople(char[][] people){
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        HashMap<Character,Integer> map3 = new HashMap<>();
        int peopleSize = 0;
        int x = 0;
        for(int i = 0;i<people.length;i++){
            if(!map1.containsKey(people[i][0])){
                map1.put(people[i][0],i);
                x++;
            }
            if(!map2.containsKey(people[i][1])){
                map1.put(people[i][1],i);
                x++;
            }
            if(!map3.containsKey(people[i][2])){
                map1.put(people[i][2],i);
                x++;
            }
            if(x==3){
                peopleSize++;
            }
            x = 0;
        }
        return peopleSize;
    }

    public static void main(String[] args) {
        char[][] x = {{1,2,3},{2,2,3},{4,5,6},{1,1,1},{7,8,9}};
        System.out.println(IdCard.getPeople(x));
    }
}
