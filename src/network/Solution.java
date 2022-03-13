package network;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {


    public boolean checkIfVisited(int ip, int[] visitedNodes) {
        for(int visitedIp : visitedNodes) {
            if(visitedIp == ip) {
                return true;
            }
        }
        return false;
    }

    public int pickMinNode(Node n, Map<Integer, Integer> neighbours, int[] visitedNodes) {
        int min = 9999;
        int minNode = -1;
        for(Map.Entry<Integer, Integer> entry : neighbours.entrySet()) {
            int ip = entry.getKey();
            int cost = entry.getValue();
            if(cost < min && !checkIfVisited(ip, visitedNodes)) {
                min = cost;
                minNode = neighbours.get(ip);
            }
        }
        return minNode;
    }

    public int allShortestTimes(Network network, Node node) {
        List<Node> path = new ArrayList<>();
        int[] time = new int[network.getNetworkSize()];
        List<Node> nodeList = network.getNodeList();
        int[] visitedNodes = new int[network.getNetworkSize()];

        for(Node n : nodeList) {
            pickMinNode(n, n.getTimeCostToNeighbours(), visitedNodes);
        }

        int counter = 0;
        Node currentNode = node;
        while(counter < network.getNetworkSize()) {
            System.out.print(currentNode.getIP() + " --> ");
            int newNodeIp = pickMinNode(currentNode, currentNode.getTimeCostToNeighbours(), visitedNodes);
            visitedNodes[counter] = (int)currentNode.getIP();
            Node newNode = network.findByIp(newNodeIp);
            if(newNode.getIP() != -1) {
                currentNode = newNode;
                counter++;
            }
            else {
                System.out.println("NOT FOUND " + newNodeIp);
                break;
            }
        }
        return counter;
    }
}
