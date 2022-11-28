package dsandalgo.priorityqueue;

public interface PrQueue {
    void insert(Entry e);

    int getSize();

    Entry removeMin();

    Entry getMin();
}
