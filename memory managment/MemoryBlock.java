
class MemoryBlock {
    int start;
    int end;
    boolean isFree;

    public MemoryBlock(int start, int end) {
        this.start = start;
        this.end = end;
        this.isFree = true;
    }

    public int getSize() {        return end - start + 1;    }
}