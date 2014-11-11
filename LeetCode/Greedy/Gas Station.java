//There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
//
//You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
//
//Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
//
//Note:
//The solution is guaranteed to be unique.

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] num = new int[gas.length];
        for(int i=0; i<gas.length; i++){
            num[i] = gas[i] - cost[i];
        }
        int sum = 0;
        for(int i=0; i<gas.length; i++){
            sum += num[i];
        }
        if(sum<0)
            return -1;
        int index = 0, start = -1;
        sum = 0;
        for(int k=0; k<num.length; k++){
            sum += num[index];
            if(start==-1)
                start = index;
            if(sum<0){
                sum = 0;
                start = -1;
            }
            index = (index+1)%num.length;
        }
        return start;
    }
}