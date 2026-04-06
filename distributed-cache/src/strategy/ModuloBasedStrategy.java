package strategy;

public class ModuloBasedStrategy implements DistributionStrategy {

    @Override
    public int getNodeIndex(String key, int numberOfNodes) {
        return Math.abs(key.hashCode()) % numberOfNodes;
    }
}