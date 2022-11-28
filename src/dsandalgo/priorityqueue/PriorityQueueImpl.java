package dsandalgo.priorityqueue;

public class PriorityQueueImpl implements Pqueue {

    private int capacity;
    private int maxIndex = 0;


    private Entry[] entries = null;

    public PriorityQueueImpl(int capacity) {
        this.capacity = capacity;
        entries = new Entry[capacity];
    }

    public PriorityQueueImpl(int capacity, Entry[] items) {
        if (items.length > capacity) {
            throw new RuntimeException("capacity should be more the number of items");
        }
        this.capacity = capacity;
        entries = new Entry[capacity + 1];
        for (int idx = 0; idx < items.length; idx++) {
            Entry entry = new Entry(items[idx].getKey(), items[idx].getVal());
            entries[idx + 1] = entry;
        }
        maxIndex = items.length;
        bottomUpConstruct();
    }


    private void bottomUpConstruct() {
        int lastInnerChild = maxIndex / 2;
        int idx = lastInnerChild;
        while (idx > 0) {
            bubbleDown(idx);
            idx--;
        }
    }

    public void insert(Entry e) {
        if (maxIndex == capacity) {
            throw new RuntimeException("Capacity exceeded");
        }

        maxIndex = maxIndex + 1;
        entries[maxIndex] = new Entry(e.getKey(), e.getVal());
        bubbleUp(maxIndex);

    }

    private void bubbleDown(int index) {

        int lastInnerChild = maxIndex / 2;
        while (index <= lastInnerChild) {
            int minChildIdx;
            int leftChildIdx = 2 * index;
            int rightChildIdx = leftChildIdx + 1;
            Entry minChild = entries[leftChildIdx];
            minChildIdx = leftChildIdx;
            if (rightChildIdx <= maxIndex) {
                if (entries[rightChildIdx].compareTo(entries[leftChildIdx]) < 0) {
                    minChild = entries[rightChildIdx];
                    minChildIdx = rightChildIdx;
                }

            }

            //swap with smallest child if its smaller than the parent
            if (minChild.compareTo(entries[index]) < 0) {
                swap(minChildIdx, index);
            } else {
                //nothing more to bubble down. Stop bubbling down.
                return;
            }

            index = minChildIdx;
        }

    }

    private void bubbleUp(int index) {


        while (index > 1) {
            int parentIdx = index / 2;
            if (entries[parentIdx].compareTo(entries[index]) > 0) {
                swap(parentIdx, index);
            } else {
                return;
            }
            index = parentIdx;

        }


    }


    private void swap(int idx1, int idx2) {
        Entry temp = entries[idx1];
        entries[idx1] = entries[idx2];
        entries[idx2] = temp;
    }

    public int getSize() {
        return maxIndex;
    }

    public Entry removeMin() {
        if (maxIndex == 0) {
            return null;
        }
        Entry min = entries[1];
        entries[1] = entries[maxIndex];
        bubbleDown(1);
        maxIndex--;

        return min;

    }


    public Entry getMin() {
        if (maxIndex == 0) {
            return null;
        }
        return entries[1];
    }


}
