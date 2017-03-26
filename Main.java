package com.company;

import java.io.*;
import java.util.*;
public class Main {



    public static void main(String[] args) throws Exception {



        BufferedReader inputReader;
        Scanner lineScanner;
        int countInput;
        String line;
        inputReader = new BufferedReader(new FileReader("/Users/jeremiahlukus/Desktop/real2.txt"));
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
            System.out.println(line);

        }
        inputReader.close();
        System.out.println("Edge is: "+(edgecount));
        Edge[] edges = new Edge[edgecount];//creating edge array  // If i give it the correct edgecount i get error

//now storing to array
        inputReader = new BufferedReader(new FileReader("/Users/jeremiahlukus/Desktop/real2.txt"));
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


       // System.out.println(edges[i-1]);




        //Now creating the graph
      /* Edge[] edges = {
                new Edge(0, 2, 1),
                new Edge(0, 3, 4),
                new Edge(0, 4, 2),
                new Edge(0, 1, 3),
                new Edge(1, 3, 2),
                new Edge(1, 4, 3),
                new Edge(1, 5, 1),
                new Edge(2, 4, 1),
                new Edge(3, 5, 4),
                new Edge(4, 5, 2),
                new Edge(4, 6, 7),
                new Edge(4, 7, 2),
                new Edge(5, 6, 4),
                new Edge(6, 7, 5),
        };*/

        Graph g = new Graph(edges);
        g.calculateShortestDistance();
         g.printResult();


    }
}
