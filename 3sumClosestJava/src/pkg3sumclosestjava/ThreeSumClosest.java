package pkg3sumclosestjava;

import java.util.Arrays;


public class ThreeSumClosest {
    
    public static String[] threeSumClosest(int[] nums, int target) {
        int difference = Integer.MAX_VALUE;
        Arrays.sort(nums);
        boolean done=false;
        String [] numAns = new String[2];
        int left,right, leftNum=0, rightNum=0;
        int i=0;
        
        while(i<nums.length && done==false){ //nums[i] will always be smallest value of the three
            left = i + 1;
            right =nums.length - 1;
            
            while (left < right) { //they don't intersect
                leftNum=nums[left];
                rightNum=nums[right];
                    
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(difference)){ //if there is a smaller difference to target
                    difference = target - sum;
                    numAns[0]=Integer.toString(target-difference);
                    numAns[1]=Integer.toString(nums[i])+", "+Integer.toString(leftNum)+", "+Integer.toString(rightNum);
            
                }
                
                if (sum < target){ //means we need a bigger "lower" number
                    left=left+1;
                }
                else{ //#means we need a smaller "upper" number
                    right=right-1;
                }
            }
            if(difference == 0){
                done=true;
                numAns[0]=Integer.toString(target-difference);
                numAns[1]=Integer.toString(nums[i])+", "+Integer.toString(leftNum)+", "+Integer.toString(rightNum);
            }
            i=i+1;
        }
        return numAns;
    }
    
    
    public static void main(String[] args) {
        int[][] allTestInput = 
        {                
            {-1,2,1,-4},
            {1,2,4,8,16,32,64,128},
            {-86,8,0,-79,-23,88,-26,-17,41,70},
            {-83,13,6,81,-23,-50,-17,17,100,99,66,-62,},
            {3,65,-23,69,60,85,-95,84,-73,-21,43,35},
            {4,-52,-77,-39,91,-13,98,41,-1},
            {-86,8,0,-79,-23,88,-26,-17,41,70,1,29,3,-52,-30,-31,14,42,4,-52,-77,-39,91,-13,98,41,-16,-8,91,54,50,1,-22,45,30,20,-36,-41,-48,-25,-3,76,69,-38,78,-45,-75,-57,55,-23,65,-23,69,60,85,-95,84,-73,-21,43,35,58,66,6,-49,38,-5,46,-24,23,-23,63,55,-91,80,-73,-53,24,-77,-5,-93,4,2,-71,23,2,-44,-19,33,73,9,-94,41,81,-14,43,27,3,-65,-89,0,-100,-89,-76,95,0,-60,65,-77,85,-29,98,-8,18,41,-93,-64,51,-77,-39,-75,-6,-65,0,-15,66,80,67,-96,26,-57,-43,-76,72,20,-55,-83,95,-65,22,-47,-90,-83,13,6,81,-23,-50,-17,17,100,99,66,-62,-21,76,37,60,-88,64,78,-90,67,-65,-62,55,-87,-75,-79,14,87,-100,-87,9,-98,0,-83,7,29,33,-87,-50,6,-57,28,17,26,4}
        };
    
        
        int [] target={1, 82, 22, 42, 0, 10, 136};

        String [] correctOutput = {"2", "82", "21", "43", "0", "8", "136"};

        String output="";
        
        for(int i=0; i<7;i++){
            int [] testInput= allTestInput[i];

            String[] result = threeSumClosest(testInput, target[i]);

            for(int j=0;j<testInput.length;j++){
                output=output+testInput[j]+", ";
            }
            if(result[0].equals(correctOutput[i])){
                System.out.println(output+"\t with Target: "+target[i]+",\t  Result: "+result[0]+"\t from numbers:"+result[1]+"\t\t Correct result:"+correctOutput[i]+"\t\t therefore "+true+"\n\n");
            }
            else{
                System.out.println(output+"\t with Target: "+target[i]+",\t  Result: "+result[0]+"\t from numbers:"+result[1]+"\t\t Correct result:"+correctOutput[i]+"\t\t therefore "+false+"\n\n");
            }
            output="";
        }
    }
}
