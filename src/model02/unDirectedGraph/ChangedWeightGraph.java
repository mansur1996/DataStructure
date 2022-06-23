package model02.unDirectedGraph;

import java.util.*;

public class ChangedWeightGraph {

    private class Edge {
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

    private class Node {
        private String value;
        private List<Edge> edges = new ArrayList<>();

        public Node(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();

        Node toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (var node : nodes.values()) {
            var edges = node.getEdges();
            if (!edges.isEmpty()) System.out.println(node + " is connected to " + edges);
        }
    }

    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public int getShortestDistance(String from, String to) {
        Node fromNode = nodes.get(from);

        Map<Node, Integer> distances = new HashMap<>();

        for (var node : nodes.values()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.replace(nodes.get(from), 0);

        Set<Node> visited = new HashSet<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(nodeEntry -> nodeEntry.priority)
        );
        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            Node current = queue.remove().node;
            visited.add(current);
            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                var newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }
        return distances.get(nodes.get(to));
    }

    public Path getShortestPath(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        Map<Node, Integer> distances = new HashMap<>();

        for (var node : nodes.values()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.replace(nodes.get(from), 0);

        Map<Node, Node> previousNodes = new HashMap<>();

        Set<Node> visited = new HashSet<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(nodeEntry -> nodeEntry.priority)
        );
        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            Node current = queue.remove().node;
            visited.add(current);
            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                var newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        Node previous = previousNodes.get(toNode);

        while (previous != null){
            stack.push(previous);
            previous = previousNodes.get(previous);
        }
        var path = new Path();
        while (!stack.isEmpty()){
            path.add(stack.pop().value);
        }
        return path;
    }
}
