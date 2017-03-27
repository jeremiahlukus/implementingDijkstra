package com.company;

import java.io.*;
import java.util.*;
public class Main {



    public static void main(String[] args) throws Exception {


        //Cleans all empty lines
        filePrep filePrep = new filePrep();
        // Gets edge count and creates Edge[] edges
        PrepGraph e = new PrepGraph();
        String inputFileName = "/Users/jeremiahlukus/Desktop/test.txt";
        String outputFileName = "/Users/jeremiahlukus/Desktop/real3.txt";

        //Removes all empty lines from text file and writes a new one w/o
        filePrep.removeEmptyLines(inputFileName, outputFileName);

        // counts the edges in the graph.
        int edgecount = e.getEdgeCount(outputFileName);
        System.out.println("Edge is: "+(edgecount));

       // Creates Edge[] edges = {new Edge (vertex, toNode, weight) } } using the given text file
        Edge[] edges = e.makeEdge(edgecount, outputFileName);

        Graph g = new Graph(edges);
        g.calculateShortestDistance();
        g.printResult();


    }
}
