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

    public int getNetworkSize() {
        return nodeList.size();
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public void newSetNodeList(int numberOfNodes) {
//        for(double ip : nodesIp) {
//            Node newNode = new Node(ip);
//            nodeList.add(newNode);
//        }
        for (int i = 0; i < numberOfNodes; ++i) {
            int newIp = i;
            Node newNode = new Node(newIp);
            newNode.setTimeCosts(numberOfNodes);
            nodeList.add(newNode);
        }
    }

    public Node findByIp(double ip) {
        for(Node n : nodeList) {
            if(n.getIP() == ip) {
                return n;
            }
        }
        Node notFound = new Node(-1);
        return notFound;
    }

    public Node getRandomNode() {
        return nodeList.get(3);
    }

    public void printNodes() {
        for (Node n : nodeList) {
            System.out.println(n.getIP());
            n.printTimeCosts();
            System.out.println("####");
        }

    }

    public void printIdentifiableNodes() {
        for (Node n : nodeList) {
            if (n.isIdentifiable())
                System.out.println(n.getIP());
        }
    }
}
