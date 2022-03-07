package network;

public class Node implements Identifiable{
    protected double ip;

    public Node(){
        ip = -1;
    }

    public Node(double ip) {
        this.ip = ip;
    }

    @Override
    public double getIP() {
        return ip;
    }
}
