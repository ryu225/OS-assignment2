import java.util.*;
public class main{

public static void Main(String [] args){

    System.out.println("Enter Total Memory size in bytes: ");
    System.out.println("Enter total number of blocks: ");
    System.out.println("Enter allocation strategy (1 for first-fit, 2 for best-fit, 3 for worst-fit)");
    /*Memory blocks are created…
Memory blocks:
================================================
Blook# start-end status
============================================
Block0 0-299 free
Block1 300-569 free
Block2 570-788 free
Block3 789-849 free
Block4 850-999 free
===========================================
===========================================
*/

    System.out.println("Enter:\n===========================================\n1) Allocate\n2) Print Memory, External Fragmentation\n3) Exit\n===========================================");

    int blockSize[] = {100, 500, 200, 300, 600}; 
         int processSize[] = {212, 417, 112, 426}; 
         int m = blockSize.length; 
         int n = processSize.length; 
           
         FirstFit.firstFit(blockSize, m, processSize, n); 
         BestFit.bestFit(blockSize, m, processSize, n); 
         worstFit.WorstFit(blockSize, m, processSize, n); 
}
}