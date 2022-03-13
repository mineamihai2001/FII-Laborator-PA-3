package network;

public class Main {

    public static void main(String[] args) {
        Network n = new Network();
        n.newSetNodeList(6);
        n.printNodes();
        System.out.println("#######");
        Solution s= new Solution();
        System.out.println("@@@@@@ " + s.allShortestTimes(n, n.getRandomNode()));
    }
}
