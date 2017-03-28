package com.company;

/*
 * This program takes numbers from a text file removes the whitespace from the file
 * then outputs a new file. The outputted file is then used to create the vertices
 * and nodes of a graph. After the graph is from it preforms Dijkstra's Algorithm on
 * the graph. This program does not check for unreachable nodes.
 *
 * I am trusting the user to give the correct file. I threw a few exceptions.
 *
 * I used many concepts from another project I worked on
 * http://codereview.stackexchange.com/questions/118416/matrix-multiplication-in-java
 *
 * Also, I used many concepts from leaning how to find an adjacency list
 * https://github.com/jeremiahlukus/FindAdjacencyList/tree/master/src/com/company
 *
 * I received much help from
 * http://stackoverflow.com/questions/1990215/adjacency-list-of-a-directed-weighted-graph
 *
 * For help implementing Dijkstra's
 * http://algs4.cs.princeton.edu/44sp/DijkstraSP.java.html
 *
 */

public class Main {



    public static void main(String[] args) throws Exception {
        //Cleans all empty lines
        filePrep filePrep = new filePrep();
        // Gets edge count and creates Edge[] edges
        PrepGraph e = new PrepGraph();
        String inputFileName = "/Users/jeremiahlukus/Desktop/test.txt"; //Change this to match your file path
        String outputFileName = "/Users/jeremiahlukus/Desktop/real3.txt"; // Change this once to where you want the output file

        //Removes all empty lines from text file and writes a new one w/o
        filePrep.removeEmptyLines(inputFileName, outputFileName);

        // counts the edges in the graph.
        int edgecount = e.getEdgeCount(outputFileName);
        //System.out.println("Edge is: "+(edgecount));

       // Creates Edge[] edges = {new Edge (vertex, toNode, weight) } } using the given text file
        Edge[] edges = e.makeEdge(edgecount, outputFileName);

        Graph g = new Graph(edges);
        g.calculateShortestDistance();
        g.printResult();


    }
}
