package model02.DirectedGraph;

public class Lesson9 {

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        graph.addEdge("A","B");
        graph.addEdge("A","E");
        graph.addEdge("B","E");
        graph.addEdge("C","A");
        graph.addEdge("C","B");
        graph.addEdge("C","D");
        graph.addEdge("D","E");

//        graph.print();
//        graph.traverseBreadthFirst("C");
        graph.traverseDepthFirst("C");
    }
}
