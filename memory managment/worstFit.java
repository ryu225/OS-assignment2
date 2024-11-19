public class worstFit{
static void WorstFit(int blockSize[], int m , int processSize[],int n){

    int allocated[]= new int[n];

    //for(int i=0; i<allocated.length; i++){    
    //}
    int largestPos=0;
    int j=0;
    for(int i=0; i<n; i++){
        for(int k=0; k<n; i++){
            largestPos=k;
            for(j=0; j<m; j++){
                if(blockSize[j]> blockSize[k])
                    largestPos= j;
            }
        }
        if (blockSize[largestPos]>= processSize[i]){
            allocated[i]=largestPos;
            blockSize[largestPos]=blockSize[largestPos]-processSize[j];
        }
    }
    System.out.println("Worst fit");
}}