package network;

import java.util.HashMap;
import java.util.Map;

public class Node implements Identifiable {
    protected double ip;
    Map<Integer, Integer> timeCostToNeighbours; // Map<to, cost>

    public Node() {
        ip = -1;
        timeCostToNeighbours = new HashMap<>();
    }

    public Node(double ip) {
        this.ip = ip;
        timeCostToNeighbours = new HashMap<>();
    }

    public Map<Integer, Integer> getTimeCostToNeighbours() {
        return timeCostToNeighbours;
    }

    public boolean findNode(int[] nodeList, int nodeIp) {
        for(int i = 0; i<nodeList.length;++i) {
            if(nodeList[i] == nodeIp)
                return true;
        }
        return false;
    }

    public void setTimeCosts(int totalNodes) {
        int numberOfNeighbours = (int) Math.floor(Math.random() * totalNodes);
        int[] takenNodes = new int[totalNodes];
        int counter = 0;
//        System.out.println("Numarul de noduri: " + numberOfNeighbours);
        for (int i = 0; i < numberOfNeighbours; ++i) {
            int currentNode = (int) Math.floor(Math.random() * totalNodes);
            while(findNode(takenNodes, currentNode)) {
                currentNode = (int) Math.floor(Math.random() * totalNodes);
            }
            takenNodes[counter++] = currentNode;
//            System.out.println("node: " + currentNode + "cost: " + (int) (Math.random() * 10));
            timeCostToNeighbours.put(currentNode, (int) (Math.random() * 10));
        }
    }

    public void printTimeCosts() {
        System.out.println(timeCostToNeighbours);
    }

    public boolean isIdentifiable() {
        if (ip != -1)
            return true;
        return false;
    }

    @Override
    public double getIP() {
        return ip;
    }
}
