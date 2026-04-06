CLASS DIAGRAM
+----------------------+
| DistributedCache     |
+----------------------+
| - nodes              |
| - strategy           |
| - database           |
+----------------------+
| + get(key)           |
| + put(key, value)    |
+----------------------+

+----------------------+
| CacheNode            |
+----------------------+
| - map                |
| - evictionPolicy     |
| - capacity           |
+----------------------+
| + get(key)           |
| + put(key, value)    |
+----------------------+

+----------------------+
| DistributionStrategy |
+----------------------+
| + getNode(key)       |
+----------------------+

+----------------------+
| EvictionPolicy       |
+----------------------+
| + keyAccessed(key)   |
| + evict()            |
+----------------------+