public class worst_Fit{
static void worstFit(int blockSize[], int m , int processSize[],int n){

    int allocated[]= new int[n];

    //for(int i=0; i<allocated.length; i++){    
    //}
    for(int i=0; k<n; i++){
        for(int k=0; k<n; i++){
            int largestPos=k;
            for(int j=0; j<m; j++){
                if(blockSize[j]> blockSize[k])
                    largestPos= j;
            }
        }
        if (blockSize[largestPos]>= processSize[i]){
            allocated[i]=largestPos;
            blockSize[largestPos]=blockSize[largestPos]-processSize[j];
        }
    }
}}