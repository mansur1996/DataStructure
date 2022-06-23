package model02.unDirectedGraph;

public class Lesson10 {

    public static void main(String[] args) {
        ChangedWeightGraph changedWeightGraph = new ChangedWeightGraph();
        changedWeightGraph.addNode("a");
        changedWeightGraph.addNode("b");
        changedWeightGraph.addNode("c");
        changedWeightGraph.addNode("d");
        changedWeightGraph.addNode("e");
        changedWeightGraph.addNode("z");

        changedWeightGraph.addEdge("a", "b", 4);
        changedWeightGraph.addEdge("a", "c", 2);
        changedWeightGraph.addEdge("b", "d", 5);
        changedWeightGraph.addEdge("b", "c", 1);
        changedWeightGraph.addEdge("c", "d", 8);
        changedWeightGraph.addEdge("c", "e", 10);
        changedWeightGraph.addEdge("d", "z", 6);
        changedWeightGraph.addEdge("d", "e", 2);
        changedWeightGraph.addEdge("e", "z", 5);

        var dis = changedWeightGraph.getShortestDistance("a", "z");
        var path = changedWeightGraph.getShortestPath("a", "z");
        System.out.println(dis);
        System.out.println(path);

    }
}
