//-----------------------------------------------------------------------------
// NAME: AISHNI PARAB
// CRUZID: APARAB
// CLASS: CMPS 12B
// DATE: AUGUST 2 2015
// FILENAME: Simulation.java
// DESCRIPTION: Implements Queue ADT and Job ADT
//-----------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

public class Simulation{

   public static void main(String[] args) throws IOException{
     //Initializing variables
     Scanner in = null;
     PrintWriter report = null;
     PrintWriter trace = null;
     String line = null;
     String numJobs = null;
     int m; //Probably an extra variable, need to convert String to int (this is m)
     Queue storageCopy = new Queue();
     Queue storage = new Queue();
     Queue finished = new Queue();
     Job j = null;
     Queue[] processorQueues = null;
     int time = 0;

     if(args.length < 1){
      System.out.println("Usage: Simulation infile");
       System.exit(1);
     }

     in = new Scanner(new File(args[0]));
     report = new PrintWriter(new FileWriter(args[0] + ".rpt"));
     trace = new PrintWriter(new FileWriter(args[0] + ".trc"));

     numJobs = in.nextLine();
     m = Integer.parseInt(numJobs);

     while (in.hasNext()){
       j = getJob(in);
       storageCopy.enqueue(j);
     }

     trace.println("Trace file: " + (args[0] + ".trc"));
     trace.println(m + " Jobs:");
     trace.println(storageCopy.toString());
     trace.println();

     report.println("Report file: " + (args[0] + ".rpt"));
     report.println(m + " Jobs:");
     report.println(storageCopy.toString());
     report.println();
     report.print("*****************************************************************************");

     // Main program loop for running simulations n=1 to n=(m-1)
     for(int n = 1; n < m; n++){ // one less processor than jobs
       int totalWait = 0;
       int maxWait = 0;
       double averageWait = 0.00;
       for(int i = 1; i<storageCopy.length()+1; i++){
         j = (Job)storageCopy.dequeue();
         j.resetFinishTime();
         storage.enqueue(j);
         storageCopy.enqueue(j);
       }

       int processors = n;
       processorQueues = new Queue[n+2];
       processorQueues[0] = storage;//place storage in first array index
       processorQueues[n+1] = finished;//place finished in last array index
       for (int i = 1; i < n+1; i++){//filling array with empty queues
         processorQueues[i] = new Queue();
       }

       trace.println("*****************************");//Print for each run of the main loop
       if(processors==1){
         trace.println(processors + " processor:");
       }else{
         trace.println(processors + " processors:");
       }
       trace.println("*****************************");

       trace.println("time=" + time);
       trace.println("0: " + storage.toString());
       for(int i = 1; i < processors+1; i++){
         trace.println(i + ": " + processorQueues[i]);
       }
      // trace.println("finished: " + finished.toString());

       while(finished.length()!=m){ // Run as long as there are still jobs pending
         // While loop variables
         int compFinal = Integer.MAX_VALUE; //-1 THESE ARE MESSING ME UP <---------------------------------------------------------
         int finalIndex = 1; //-1 THESE ARE MESSING ME UP <---------------------------------------------------------
         int comp = -1;
         int length = -1;
         int finalLength = -1;
         Job compare = null;

         if(!storage.isEmpty()){ // Check storage arrival time, if empty ignore
           compare = (Job)storage.peek();
           compFinal = compare.getArrival(); // -1 if don't go into loop <------------------------------------------
           finalIndex = 0; // -1 if don't go into loop <------------------------------------------------------------
         }//end of if statement

         for(int i = 1; i < processors+1; i++){ // Check processor indicies
           if(processorQueues[i].length() != 0){ // Check processor finish time, if empty ignore
             compare = (Job)processorQueues[i].peek();
             comp = compare.getFinish();
           }
           if(comp == -1){ // Never went into if loop above because que was empty
           }else if(comp<compFinal){ // Compare ints in for loop to find smallest, track index
             compFinal = comp; // if (comp < -1) CAN'T HAPPEN <------------------------------------------------------
             finalIndex = i;
           }
           time = compFinal;
         }//end of comparison for loop

         if(finalIndex == 0){ // Move from storage to processor with shortest length(index), compute finish time if first in line
           int tempIndex = 1;
           finalLength = processorQueues[tempIndex].length(); //Always at least 1 processor!!!! RIGHT?!
           for(int i = 1; i < processors+1; i++){
             length = processorQueues[i].length();
             if(length<finalLength){
               finalLength = length;
               tempIndex = i;
             }
           }//end of comparison for loop

           compare = (Job)storage.dequeue();
           processorQueues[tempIndex].enqueue(compare);
           if(processorQueues[tempIndex].length()==1){
             compare = (Job)processorQueues[tempIndex].peek();
             compare.computeFinishTime(time);
           }
         }//end of if statement

         else{ // Move from processor to finish
           compare = (Job)processorQueues[finalIndex].dequeue();
           finished.enqueue(compare);
           int tempWait = compare.getWaitTime();
           if(tempWait > maxWait){
             maxWait = tempWait;
           }
           totalWait += tempWait;

           if(processorQueues[finalIndex].length() >= 1){
             compare = (Job)processorQueues[finalIndex].peek();
             compare.computeFinishTime(time);
           }

         }//end else

         trace.println();
         trace.println("time=" + time);
         trace.println("0: " + storage.toString());
         for(int i = 1; i < processors+1; i++){
           trace.println(i + ": " + processorQueues[i]);
         }
      //   trace.println("finished: " + finished.toString());

       } // end of processing while loop

     //compute the total wait, maximum wait, and average wait for all Jobs, then reset finish times
       averageWait = ((double)totalWait/m);
       averageWait = (double)Math.round(averageWait*100)/100;
       trace.println();
       report.println();
       if(processors==1){
         report.print(processors + " processor: totalWait=" + totalWait + ", maxWait=" + maxWait + ", averageWait=" + averageWait);
       }else{
         report.print(processors + " processors: totalWait=" + totalWait + ", maxWait=" + maxWait + ", averageWait=" + averageWait);
       }

       time = 0;
       finished.dequeueAll();
       }//end main body loop

       in.close();
       report.close();
       trace.close();

   }

      //getJob()
      public static Job getJob(Scanner in) {
         String[] s = in.nextLine().split(" ");
         int p = Integer.parseInt(s[0]);
         int q = Integer.parseInt(s[1]);
         return new Job(p, q);
      }
}
