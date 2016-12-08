import LFUCache.LFUCache;
import org.junit.Test;


public class test_LFU_cache {
    @Test
    public void testLFUcache_String() {
        LFUCache<String> cache1 = new LFUCache<String>(5);

        for (int i = 0; i < 5; i++) {
            cache1.addCacheEntry(i,"Pokemon" + i);
        }

        cache1.getCacheEntry(0); //frequency of Pokemon0 = 1
        cache1.getCacheEntry(2); //frequency of Pokemon2 = 1
        cache1.getCacheEntry(3); //frequency of Pokemon3 = 1
        cache1.getCacheEntry(4); //frequency of Pokemon4 = 1

        // Pokemon1 has frequency = 0  - min! If we add new data, we should change Pokemon1 to new data
        cache1.addCacheEntry(5,"Pokemon5But1");
        assert (cache1.getCacheEntry(1).equals("Pokemon5But1"));

        cache1.getCacheEntry(0); //frequency of Pokemon0 = 2
        cache1.getCacheEntry(1); //frequency of Pokemon5But1 = 2
        cache1.getCacheEntry(3); //frequency of Pokemon3 = 2
        cache1.getCacheEntry(4); //frequency of Pokemon4 = 2

        // Pokemon2 has frequency = 1  - min! If we add new data, we should change Pokemon2 to new data
        cache1.addCacheEntry(5,"Pokemon6But2");
        assert (cache1.getCacheEntry(2).equals("Pokemon6But2"));
    }

    @Test
    public void testLFUcache_Integer() {
        LFUCache<Integer> cache2 = new LFUCache<Integer>(5);

        for (int i = 0; i < 5; i++) {
            cache2.addCacheEntry(i,i*2);
        }

        cache2.getCacheEntry(0);
        cache2.getCacheEntry(1);
        cache2.getCacheEntry(2);
        cache2.getCacheEntry(4);
        // data=6 has 0 frequency - min. If we add new data, we should change 6 to new data (for example 66)

        cache2.addCacheEntry(5,66);
        assert (cache2.getCacheEntry(3)==66);

        cache2.getCacheEntry(0);
        cache2.getCacheEntry(1);
        cache2.getCacheEntry(2);
        cache2.getCacheEntry(3);
        // data=8 has 0 frequency - min. If we add new data, we should change 8 to new data (for example 88)

        cache2.addCacheEntry(5,88);
        assert (cache2.getCacheEntry(4)==88);
    }

    @Test
    public void testLFUcache_Long() {
        LFUCache<Long> cache2 = new LFUCache<Long>(5);

        for (int i = 0; i < 5; i++) {
            cache2.addCacheEntry(i,i* 2L);
        }

        cache2.getCacheEntry(0);
        cache2.getCacheEntry(1);
        cache2.getCacheEntry(2);
        cache2.getCacheEntry(4);
        // data=6 has 0 frequency - min. If we add new data, we should change 6 to new data (for example 66)

        cache2.addCacheEntry(5, 66L);
        assert (cache2.getCacheEntry(3)==66);

        cache2.getCacheEntry(0);
        cache2.getCacheEntry(1);
        cache2.getCacheEntry(2);
        cache2.getCacheEntry(3);
        // data=8 has 0 frequency - min. If we add new data, we should change 8 to new data (for example 88)

        cache2.addCacheEntry(5,88L);
        assert (cache2.getCacheEntry(4)==88);
    }
}
