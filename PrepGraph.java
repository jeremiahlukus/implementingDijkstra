package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jeremiahlukus on 3/26/17.
 */
public class PrepGraph {

    public int getEdgeCount(String outputFileName) throws IOException {
        BufferedReader inputReader;
        Scanner lineScanner;
        int countInput;
        String line;
        inputReader = new BufferedReader(new FileReader(outputFileName));
        inputReader.readLine();//skips the first line
        int edgecount = 0;
        while ((line = inputReader.readLine()) != null) {
            lineScanner = new Scanner(line);
            countInput = 0;

            while (lineScanner.hasNext()) {

                countInput++;
                //edgecount++;
                lineScanner.nextInt();
                //System.out.printf("%d\n",lineScanner.nextInt());
            }
            if (countInput == 1) {

                //System.out.printf("node\n");

            } else {
                //System.out.printf("Edge\n");
                edgecount++;//counting edges to create edge count...
            }
            //System.out.println(line);

        }
        inputReader.close();
        System.out.println("Edge is: "+(edgecount));
        return edgecount;
    }


    public Edge[] makeEdge ( int edgecount, String outputFileName) throws IOException{
        Edge[] edges = new Edge[edgecount];//creating edge array  // If i give it the correct edgecount i get error
        BufferedReader inputReader;
        Scanner lineScanner;
        String line;
        int countInput;
//now storing to array
        inputReader = new BufferedReader(new FileReader(outputFileName));
        inputReader.readLine();//skips the first line
        int source = 0, i = 0;
        while ((line = inputReader.readLine()) != null) {
            lineScanner = new Scanner(line);
            countInput = 0;
            int a[] = new int[2], k = 0; //size of array a should be 2 its holding the source as well as other two elements, edge and distance.
            while (lineScanner.hasNext()) {
                countInput++;
                a[k] = lineScanner.nextInt();
                k++;
                //System.out.printf("%d\n",lineScanner.nextInt());
            }
            if (countInput == 1) {
                source = a[0]; //SOURCE WILL ALWAYS HOLD THE FIRST VALUE OF ARRAY a[]
                // System.out.printf("node\n");
            } else {
                // System.out.printf("Edge\n");
                //VALUES PASSING TO CLASSES MODIFIED ACCORDINGLY
                if(k > edgecount){
                    break;
                }
                edges[i++] = new Edge(source, a[k-2], a[k-1]);//adding to array ...

            }
            //System.out.println(line);

        }
        return edges;
    }
}
