package cache;

import strategy.DistributionStrategy;
import eviction.LRUEvictionPolicy;
import db.Database;

import java.util.ArrayList;
import java.util.List;

public class DistributedCache {

    private List<CacheNode> nodes;
    private DistributionStrategy strategy;
    private Database database;

    public DistributedCache(int numberOfNodes, int capacityPerNode,
                            DistributionStrategy strategy, Database database) {

        this.strategy = strategy;
        this.database = database;
        this.nodes = new ArrayList<>();

        for (int i = 0; i < numberOfNodes; i++) {
            nodes.add(new CacheNode(capacityPerNode, new LRUEvictionPolicy()));
        }
    }

    public String get(String key) {

        int index = strategy.getNodeIndex(key, nodes.size());
        CacheNode node = nodes.get(index);

        String value = node.get(key);

        if (value == null) {
            System.out.println("Cache MISS for key: " + key);

            value = database.get(key);
            node.put(key, value);
        } else {
            System.out.println("Cache HIT for key: " + key);
        }

        return value;
    }

    public void put(String key, String value) {

        int index = strategy.getNodeIndex(key, nodes.size());
        CacheNode node = nodes.get(index);

        node.put(key, value);
        database.put(key, value);
    }
}