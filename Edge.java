package com.company;



/**
 * Created by jeremiahlukus on 3/24/17.
 *
 * This class sets the vertex, edge, and weight.
 *
 */
public class Edge {
    private int fromNodeIndex;
    private int toNodeIndex;
    private int length;

    public Edge (int fromNodeIndex, int toNodeIndex, int length){
        this.fromNodeIndex = fromNodeIndex;
        this.toNodeIndex = toNodeIndex;
        this.length = length;
    }

    public int getFromNodeIndex() {
        return fromNodeIndex;
    }

    public int getToNodeIndex() {
        return toNodeIndex;
    }

    public int getLength() {
        return length;
    }

    //determines the neighboring node of a supplied node
    public int getNeighbourIndex(int nodeIndex){
        if(this.fromNodeIndex == nodeIndex) {
            return this.toNodeIndex;
        }else{
            return this.fromNodeIndex;
        }
    }
}
