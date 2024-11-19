
public class FirstFit {

    
static void firstFit(int blockSize[], int n, int processSize[],int m){

    int allocated[]= new int[n];

    //for(int i=0; i<allocated.length; i++){    
    //}

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(blockSize[j]>= processSize[i]){
                allocated[i]=j;
                blockSize[j]=blockSize[j]-processSize[j];
                break;
            }
        }
    }
}
}