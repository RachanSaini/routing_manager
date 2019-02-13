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

    public int calculateDistance(){
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


    }



}
