
import java.util.*;
public class main{

    static ArrayList<MemoryBlock> memoryBlocks = new ArrayList<>();

public static void main(String [] args){

    Scanner in= new Scanner(System.in);

    System.out.print("Enter Total Memory size in bytes: ");
    int MemSize= in.nextInt();
    System.out.print("Enter total number of blocks: ");
    int NoBlocks= in.nextInt();
    System.out.print("Enter allocation strategy (1 for first-fit, 2 for best-fit, 3 for worst-fit)");
    int Strategy= in.nextInt();
    System.out.print("Memory blocks are created...\nMemory blocks:\n================================================");
    // memory blocks
    Random random = new Random();
    int remainingSize = MemSize;
    int start = 0;
    for (int i = 0; i < NoBlocks - 1; i++) {
        int size = random.nextInt(remainingSize / (NoBlocks - i)) + 1;
        int end = start + size - 1;
        memoryBlocks.add(new MemoryBlock(start, end));
        remainingSize= remainingSize-size;
        start = end + 1;
    }
    memoryBlocks.add(new MemoryBlock(start, MemSize - 1));

    printMemory();
    //printMemory();

    boolean running = true;
    while (running) {
    System.out.println("Enter:\n===========================================\n1) Allocate\n2) Print Memory, External Fragmentation\n3) Exit\n===========================================");
    int choice = in.nextInt();

    switch (choice) {
        case 1:
            System.out.print("Enter Allocation Request in bytes: ");
            int requestSize  = in.nextInt();
            /*switch(Strategy){
                case 1: 
                    FirstFit.firstFit(memoryBlocks, memoryBlocks.length, processSize, processSize.length); 
                case 2: 
                    BestFit.bestFit(memoryBlocks, memoryBlocks.length, processSize, processSize.length); 
                case 3: 
                    worstFit.WorstFit(memoryBlocks, memoryBlocks.length, processSize, processSize.length); 
            }*/
            allocateMemory(requestSize, Strategy);
            break;
        case 2:
            printMemory();
            printExternalFragmentation();
            break;
        case 3:
            running = false;
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
        }}

    in.close();
}


    private static void printMemory() {
        System.out.println("Block#    start-end     status\n=================================");
    
        for (int i = 0; i < memoryBlocks.size(); i++) {
            MemoryBlock block = memoryBlocks.get(i);
            String status = block.isFree ? "free" : "allocated";
            System.out.printf("Block%d    %d-%d     %s\n", i, block.start, block.end, status);
        }
        System.out.println("=================================");
}
    
private static void printExternalFragmentation() {
    int externalFragmentation = 0;
    for (MemoryBlock block : memoryBlocks) {
        if (block.isFree) {
            externalFragmentation += block.getSize();
        }
    }
    System.out.println("External Fragmentation: " + externalFragmentation + " bytes");}

    private static void allocateMemory(int requestSize, int strategy) {
        MemoryBlock selectedBlock = null;

        if (strategy == 1) { // First-Fit
            for (MemoryBlock block : memoryBlocks) {
                if (block.isFree && block.getSize() >= requestSize) {
                    selectedBlock = block;
                    break;
                }
            }
        } else if (strategy == 2) { // Best-Fit
            for (MemoryBlock block : memoryBlocks) {
                if (block.isFree && block.getSize() >= requestSize) {
                    if (selectedBlock == null || block.getSize() < selectedBlock.getSize()) {
                        selectedBlock = block;
                    }
                }
            }
        } else if (strategy == 3) { // Worst-Fit
            for (MemoryBlock block : memoryBlocks) {
                if (block.isFree && block.getSize() >= requestSize) {
                    if (selectedBlock == null || block.getSize() > selectedBlock.getSize()) {
                        selectedBlock = block;
                    }
                }
            }
        }

        if (selectedBlock != null) {
            selectedBlock.isFree = false;
            System.out.println("Allocated at address: " + selectedBlock.start);
        } else {
            System.out.println("Allocation failed. No suitable block found.");
        }
    }}