package LFUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache<T> {
    private int initialCapacity;
    private LinkedHashMap<Integer, CacheEntry<T>> cacheMap = new LinkedHashMap<Integer, CacheEntry<T>>();

    public LFUCache(int initialCapacity){
        this.initialCapacity = initialCapacity;
    }

    public void addCacheEntry(int key, T data){
        if (!this.isFull()){
            CacheEntry<T> temp = new CacheEntry<T>();
            temp.setData(data);
            temp.setFrequency(0);

            cacheMap.put(key, temp);
        } else {
            int entryKeyToBeRemoved = getLFUKey();
            CacheEntry<T> temp = new CacheEntry<T>();
            temp.setData(data);
            temp.setFrequency(0);

            cacheMap.put(entryKeyToBeRemoved, temp);
        }
    }

    private int getLFUKey() {
        int key = 0;
        int minFreq = Integer.MAX_VALUE;

        for (Map.Entry<Integer, CacheEntry<T>> entry : cacheMap.entrySet()){
            if (minFreq > entry.getValue().getFrequency()){
                key = entry.getKey();
                minFreq = entry.getValue().getFrequency();
            }
        }
        return  key;
    }

    public T getCacheEntry(int key){
        if (cacheMap.containsKey(key)){
            CacheEntry<T> temp = cacheMap.get(key);
            temp.setFrequency(temp.getFrequency()+1);
            cacheMap.put(key, temp);
            return temp.getData();
        }
        return null;
    }

    private boolean isFull() {
        return cacheMap.size() == initialCapacity;
    }

}
