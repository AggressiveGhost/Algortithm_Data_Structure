package com.company;
import com.company.classes.City;
import com.company.classes.User;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph<T extends Comparable<T>> {
    private HashMap<T, ArrayList<Edge<T>>> map;
    private boolean directed;
    public Graph(boolean directed){this.directed = directed;map = new HashMap<>();}

    public void put(T from, T to, int weight) {
        if (!map.containsKey(from))
            map.put(from, new ArrayList<Edge<T>>());
        map.get(from).add(new Edge<>(to, weight));

        if (!directed) {
            if (!map.containsKey(to))
                map.put(to, new ArrayList<Edge<T>>());
            map.get(to).add(new Edge<>(from, weight));
        }
    }
    public void put(T from, T to) { put(from, to, 1); }

    public int coverage(T key){
        int subs = ((User)key).getSubs();
        ArrayList<Edge<T>> list = new ArrayList<>(map.get(key));
        for (Edge<T> e : list)
            subs += ((User) e.getVertex()).getSubs();

        return subs + coverage(key,followers(list));
    }
    private int coverage(T key, ArrayList<T> keys){
        int subs = 0;
        for (T t : keys)
            for (Edge<T> e : map.get(t))
                if (e.getVertex().compareTo(key) == 0){
                    subs += ((User) e.getVertex()).getSubs();
                    break;
                }
        return subs;
    }

    public void ambulance(T from, int oil){
        ArrayList<T> list = ambulance(from, from, oil);
        int ill = 0;
        for (T t : list){
            System.out.printf(((City)t).getName() + "<-");
            ill += ((City)t).getIll();
        }System.out.printf(ill + " people treated\n");
    }
    private ArrayList<T> ambulance(T from, T back, int oil){
        ArrayList<ArrayList<T>> all_route = new ArrayList<>();
        ArrayList<Edge<T>> list = new ArrayList<>(map.get(from));
        ArrayList<T> optimal_route = new ArrayList<>();

        for (Edge<T> e : list)
            if (e.getVertex().compareTo(back)!=0 && e.getWeight() <= oil)
                all_route.add(
                        ambulance(e.getVertex(), from, oil - e.getWeight())
                );

        if (all_route.size() != 0)
            optimal_route.addAll(optimal(all_route));

        optimal_route.add(from);
        return optimal_route;
    }

    private ArrayList<T> optimal(ArrayList<ArrayList<T>> route){
        int max = -1;

        int max_index = 0;
        for (int i=0; i<route.size(); i++)
            if (max_treat(route.get(i)) > max){
                max = max_treat(route.get(i));
                max_index = i;
            }

        return route.get(max_index);
    }
    private int max_treat(ArrayList<T> list){
        int ill = 0;
        for (T city : list)
            ill += ((City)city).getIll();
        return ill;
    }
    private ArrayList<T> followers(ArrayList<Edge<T>> list){
        ArrayList<T> key_list = new ArrayList<>(map.keySet());
        for (Edge<T> e  : list)
            if (key_list.contains(e.getVertex()))
                key_list.remove(e.getVertex());

        return key_list;
    }
    private int getIndex(T key) {
        ArrayList<T> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < keys.size(); i++)
            if (keys.get(i).compareTo(key) == 0)
                return i;
        return -1;
    }
}
