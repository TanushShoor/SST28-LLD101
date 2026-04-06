package main;

import cache.DistributedCache;
import db.Database;
import strategy.ModuloBasedStrategy;

public class Main {

    public static void main(String[] args) {

        Database db = new Database();
        DistributedCache cache = new DistributedCache(
                3, // number of nodes
                2, // capacity per node
                new ModuloBasedStrategy(),
                db
        );

        cache.put("A", "Apple");
        cache.put("B", "Ball");
        cache.put("C", "Cat");

        System.out.println(cache.get("A")); // HIT
        System.out.println(cache.get("D")); // MISS → DB

        cache.put("E", "Elephant"); // triggers eviction

        System.out.println(cache.get("B"));
    }
}