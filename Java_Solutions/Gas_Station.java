/*
* Leetcode challenge: Gas Station
*
* There are n gas stations along a circular route, 
* where the amount of gas at the ith station is gas[i].
* You have a car with an unlimited gas tank and it costs cost[i] of gas 
* to travel from the ith station to its next (i + 1)th station. 
* You begin the journey with an empty tank at one of the gas stations.
*
* Given two integer arrays gas and cost, return the starting gas station's 
* index if you can travel around the circuit once in the clockwise direction, 
* otherwise return -1. If there exists a solution, it is guaranteed to be unique
*
* 7/2/24
* Mark Robuck
*/
class Solution{
    /*
    * Determine if a loop of an array can be completed given traversal weights.
    * @params gas, amount of gas gained at each station as list of integers
    * @params cost, amount of gas spent to travel to the next station as a list
    *       of integer
    * @return index of statring station if a complete loop can be made, 
    *       -1 otherwise
    */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //amount of gas currently in the tank
        int tank = 0;
        //pointer for the current station
        int station = 0;
        //is a solution feasible?
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {
            return -1;
        }
        //check for a starting point
        for (int i= 0; i < gas.length; i++){
            //determine gas remaining at each stop
            tank += gas[i] - cost[i];
            //if we cannot reach the next stop reset the starting station
            if (tank < 0){
                station = i + 1;
                tank = 0;
            }
        }
        return station;
    }
}
