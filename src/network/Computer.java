package network;

public class Computer extends Node implements Storage{
    private double storageCapacity;

    @Override
    public double getStorageCapacity() {
        return storageCapacity;
    }
}
