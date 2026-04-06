package strategy;

public interface DistributionStrategy {
    int getNodeIndex(String key, int numberOfNodes);
}