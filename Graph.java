package com.company;

import java.util.ArrayList;

/**
 * Created by jeremiahlukus on 3/24/17.
 */
public class Graph {

    private Node[] nodes;
    private int numOfNodes;
    private Edge[] edges;
    private int numOfEdges;


    public Graph(Edge[] edges){
        this.edges = edges;

        this.numOfNodes = calculateNumOfNodes(edges);
        this.nodes = new Node[this.numOfNodes];

        for(int i = 0; i < this.numOfNodes; i++){
            this.nodes[i] = new Node();
        }
        //add all the edges to the nodes
        this.numOfEdges = edges.length;

        for(int edgeToAdd = 0; edgeToAdd < this.numOfEdges; edgeToAdd++){
            this.nodes[edges[edgeToAdd].getFromNodeIndex()].getEdges().add(edges[edgeToAdd]);
            this.nodes[edges[edgeToAdd].getToNodeIndex()].getEdges().add(edges[edgeToAdd]);
        }

    }

    private int calculateNumOfNodes(Edge[] edges){
        int numOfNodes = 0;

        for(Edge e : edges){
            if( e.getToNodeIndex() > numOfNodes)
                numOfNodes = e.getToNodeIndex();
            if(e.getFromNodeIndex() > numOfNodes)
                numOfNodes = e.getFromNodeIndex();
        }
        numOfNodes++;
        return numOfNodes;
    }


    //Dijkstras
    public void calculateShortestDistance() {
        //node 0 as source
        this.nodes[0].setDistanceFromSource(0);
        int nextNode = 0;

        //vist every node
        for(int i = 0; i < this.nodes.length; i++){
            //loop around the current node
            ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();

            for(int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++){
                int neighborIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);

                //only if not visited
                if(!this.nodes[neighborIndex].isVisited()){
                    int tentative = this.nodes[nextNode].getDistanceFromSource() + currentNodeEdges.get(joinedEdge).getLength();

                    if( tentative <  nodes[neighborIndex].getDistanceFromSource()){
                        nodes[neighborIndex].setDistanceFromSource(tentative);
                    }
                }
            }

            //all neighbours checked so node has been visited
            nodes[nextNode].setVisited(true);

            //next node must be with shortest distance
            nextNode = getNodeShortestDistance();

        }
    }


    private int getNodeShortestDistance() {
        int storedNodeIndex = 0;
        int storedDist = Integer.MAX_VALUE;

        for(int i = 0; i < this.nodes.length; i++){
            int currentDist = this.nodes[i].getDistanceFromSource();

            if(!this.nodes[i].isVisited() && currentDist < storedDist){
                storedDist = currentDist;
                storedNodeIndex = i;
            }
        }
        return storedNodeIndex;
    }

    //display result


    public void printResult(){
        String output= "";
        System.out.println("Number of nodes = " + this.numOfNodes);
        System.out.println("\nNumber of edges = " + this.numOfEdges);
int sum = 0;

        for(int i = 0; i < this.nodes.length; i++){
           output = ("\nThe shortest distance from node 0 to node " + i + " is " + nodes[i].getDistanceFromSource());
           sum +=  nodes[i].getDistanceFromSource();
        }
        System.out.println(output);
        System.out.println(sum);
    }



    public int getNumOfNodes() {
        return numOfNodes;
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public Node[] getNodes() {

        return nodes;
    }

    public Edge[] getEdges() {

        return edges;
    }
}
