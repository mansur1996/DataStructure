package model02.DirectedGraph;

import java.util.*;

public class DirectedGraph {

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
    private Map<Node, ArrayList<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label){
        var node  = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.put(node, new ArrayList<>());
    }

    public void addEdge(String from, String to){
        Node fromNode;
        fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode); // Directed Graph
    }

    public void traverseBreadthFirst(String root){
        Node node = nodes.get(root);
        if (node == null) return;

        Set<Node>  visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()){
            Node current = queue.remove();
            if (visited.contains(current)) continue;

            System.out.println(current);
            visited.add(current);

            for (var neighbour  : adjacencyList.get(current)){
                if (!visited.contains(neighbour)){
                    queue.add(neighbour);
                }
            }
        }
    }

    public void traverseDepthFirst(String root){
        Node node = nodes.get(root);
        if (node == null) return;

        Set<Node>  visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()){
            Node current = stack.pop();
            if (visited.contains(current)) continue;

            System.out.println(current);
            visited.add(current);

            for (var neighbour  : adjacencyList.get(current)){
                if (!visited.contains(neighbour)){
                    stack.add(neighbour);
                }
            }
        }
    }

    public void removeNode(String label){

    }

    public void removeEdge(String from, String to){

    }

    public void print() {
        for (var source : adjacencyList.keySet()){
            ArrayList<Node> targets;
            targets = adjacencyList.get(source);
            if (!targets.isEmpty()){
                System.out.println(source.value + " is connected to " + targets.toString());
            }
        }
    }
}
