package LFUCache;

class CacheEntry<T> {
    private T data;
    private int frequency;

    CacheEntry() {
    }

    T getData() {
        return data;
    }

    int getFrequency() {
        return frequency;
    }

    void setData(T data) {
        this.data = data;
    }

    void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
