package network;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Node> nodeList;

    public Network() {
        nodeList = new ArrayList<>();
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public void newSetNodeList(double... nodesIp) {
        for(double ip : nodesIp) {
            Node newNode = new Node(ip);
            nodeList.add(newNode);
        }
    }

    public void printNodes() {
        for(Node n : nodeList) {
            System.out.println(n.getIP());
        }
    }
}
