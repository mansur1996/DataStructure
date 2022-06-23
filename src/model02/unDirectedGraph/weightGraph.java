package model02.unDirectedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class weightGraph {

    private class Node{
        private String value;

        public Node(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    private class Edge{
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to; // A->B
        }
    }

    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.put(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight){
        var fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();
        var toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(new Edge(fromNode, toNode, weight));
        adjacencyList.get(toNode).add(new Edge(toNode, fromNode, weight));
    }


}
