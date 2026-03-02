package com.example.metrics;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Proper Lazy, Thread-safe Singleton Metrics Registry
 */
public class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // Used to prevent reflection-based second construction
    private static boolean instanceCreated = false;

    private final Map<String, Long> counters = new HashMap<>();

    /**
     * Private constructor
     * Prevents external instantiation
     */
    private MetricsRegistry() {

        // Block reflection attack
        if (instanceCreated) {
            throw new RuntimeException("Use getInstance()! Singleton already created.");
        }

        instanceCreated = true;
    }

    /**
     * Static Holder Pattern
     * - Lazy initialized
     * - Thread safe
     * - No synchronization cost
     */
    private static class Holder {
        private static final MetricsRegistry INSTANCE = new MetricsRegistry();
    }

    public static MetricsRegistry getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized void setCount(String key, long value) {
        counters.put(key, value);
    }

    public synchronized void increment(String key) {
        counters.put(key, getCount(key) + 1);
    }

    public synchronized long getCount(String key) {
        return counters.getOrDefault(key, 0L);
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }

    /**
     * Prevents new object creation during deserialization
     */
    @Serial
    protected Object readResolve() {
        return getInstance();
    }
}