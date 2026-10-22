package libraries;

public class Timer {
    private long startTime;
    private long endTime;

    public void start() {
        this.startTime = System.nanoTime();
    }
    public void end() {
    this.endTime =System.nanoTime();
    }
    public long retrieveMs() {
        return (endTime - startTime) / 1_000_000;
    }
    public long quickRetrieve() {
        return (System.nanoTime() - startTime) / 1_000_000;
    }
}
