package dsandalgo.priorityqueue;

public class Entry implements Comparable<Entry> {

    public Entry(int key, String val) {
        this.key = key;
        this.val = val;
    }

    private int key;
    private String val;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }


    @Override
    public int compareTo(Entry o) {
        if (o != null) {
            if (o.key > this.key) {
                return -1;
            } else if (o.key == this.key) {
                return 0;
            }
        }
        return 1;
    }


    @Override
    public String toString() {
        return String.format("Key:[%s], Value:[%s]", this.key, this.val);
    }
}
