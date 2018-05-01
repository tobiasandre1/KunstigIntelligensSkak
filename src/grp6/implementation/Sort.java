package grp6.implementation;

import grp6.interfaces.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Sort {

    public static List<Move> sortList(List<Move> moves, boolean isWhite){
        TreeMap<Integer, List<Move>> map = new TreeMap<>();
        int score;
        int factor = 1;
        if(!isWhite){
            factor = -1;
        }
        for(Move m: moves){
            score = m.getHeuristicValue()*factor;

            if(map.get(score) == null){
                map.put(score, new ArrayList<>());
            }
            map.get(score).add(m);
        }

        List<Move> list;
        List<Move> result = new ArrayList<>();
        for(Map.Entry<Integer, List<Move>> entry : map.entrySet()){
            list = map.get(entry.getKey());
            for(Move m: list){
                result.add(m);
            }
        }
        return result;

    }

}
