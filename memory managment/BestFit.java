public class BestFit{
static void bestFit(int blockSize[], int m, int processSize[],int n){

    int allocated[]= new int[n];

    //for(int i=0; i<allocated.length; i++){    
    //}
    int j=0;
    for(int i=0; i<n; i++){
        int emptyPos=-1;
        for(j=0; j<m; j++){
            if(blockSize[j]>= processSize[i]){
                if(emptyPos==-1)
                    emptyPos=j;
                else if (blockSize[emptyPos]>blockSize[j])
                    emptyPos=j;
            }
        }

        if(emptyPos!=-1){
                allocated[i]=emptyPos;
                blockSize[emptyPos]=blockSize[emptyPos]-processSize[j];
                
            }
        }
        System.out.println("Worst fit");
    }
}