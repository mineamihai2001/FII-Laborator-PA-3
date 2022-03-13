package network;

public interface Storage {
    default double getStorageCapacity(String unit) {
        double capacity = 0;
        switch (unit) {
            case "kb":
                capacity = getCapacity() * 10;
                break;
            case "mb":
                capacity = getCapacity() * 100;
                break;
        }
        return capacity;
    }
    double getCapacity();
}
