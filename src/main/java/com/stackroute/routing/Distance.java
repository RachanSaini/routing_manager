package com.stackroute.routing;

import java.util.Random;
import java.lang.*;

public class Distance {

    //random variable
    private Random random = new Random(151190);

    //For demo hard coded parameters
    int noOfContainers = 30;
    int noOfVehicles = 10;
    int vehicleCapacity = 50;

    //Depot Co-ordinates
    int depot_x = 50;
    int depot_y = 50;



    //Tabu parameter for tabu search
    int tabu_horizon = 10;

    public void calculateDistance(){
        System.out.println("inside distance class");
        //Initializing
        //creating random containers
        Node nodes[] = new Node[noOfContainers + 1];
        Node depot = new Node(depot_x,depot_y);

        nodes[0] = depot; //making first node as warehouse depot location.

        for(int i = 1; i<= noOfContainers; i++) {
            nodes[i] = new Node(i,
                    random.nextInt(100),
                    random.nextInt(100),
                    4 + random.nextInt(7)
            );
        }

        double[][] distanceMatrix = new double[noOfContainers + 1][noOfContainers + 1];
        double delta_x,delta_y;
        for(int i = 0; i<= noOfContainers; i++){
            for(int j = i+1; j<=noOfContainers; j++){
                //depot to next neighbor
                delta_x = (nodes[i].node_x - nodes[j].node_x);
                delta_y = (nodes[i].node_y - nodes[j].node_y);

                double distance = Math.sqrt((delta_x * delta_x) + (delta_y * delta_y));
                distance = Math.round(distance); //to get distance in nearest integer value

                distanceMatrix[i][j] = distance;
                distanceMatrix[j][i] = distance;

            }
        }

        int printMatrix = 1; //to print distance matrix.

        if (printMatrix == 1){
            for (int i =0; i<=noOfContainers; i++){
                for (int j=0; j<=noOfContainers; j++){
                    System.out.print(distanceMatrix[i][j] + "-");
                }
                System.out.println();
            }
        }

    }



}
