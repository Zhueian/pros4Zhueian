package cn.zhueian.highConcurrentMultithreading.shibingMa.msb.step03.concurrent_container;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: qiucy
 * @Date: 2019-04-26 10:32
 * @Description:
 */
public class T01_ConcurrentMap {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        Map<String, String> synMap = Collections.synchronizedMap(map);

//        Hashtable<String,String> map = new Hashtable<>();

//        TreeMap<String,String> map = new TreeMap<>();

//        LinkedHashMap map = new LinkedHashMap();

//        SortedMap map = new SortedMap() {
//            @Override
//            public Comparator comparator() {
//                return null;
//            }
//
//            @Override
//            public SortedMap subMap(Object fromKey, Object toKey) {
//                return null;
//            }
//
//            @Override
//            public SortedMap headMap(Object toKey) {
//                return null;
//            }
//
//            @Override
//            public SortedMap tailMap(Object fromKey) {
//                return null;
//            }
//
//            @Override
//            public Object firstKey() {
//                return null;
//            }
//
//            @Override
//            public Object lastKey() {
//                return null;
//            }
//
//            @Override
//            public Set keySet() {
//                return null;
//            }
//
//            @Override
//            public Collection values() {
//                return null;
//            }
//
//            @Override
//            public Set<Entry> entrySet() {
//                return null;
//            }
//
//            @Override
//            public int size() {
//                return 0;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//
//            @Override
//            public boolean containsKey(Object key) {
//                return false;
//            }
//
//            @Override
//            public boolean containsValue(Object value) {
//                return false;
//            }
//
//            @Override
//            public Object get(Object key) {
//                return null;
//            }
//
//            @Override
//            public Object put(Object key, Object value) {
//                return null;
//            }
//
//            @Override
//            public Object remove(Object key) {
//                return null;
//            }
//
//            @Override
//            public void putAll(Map m) {
//
//            }
//
//            @Override
//            public void clear() {
//
//            }
//        };

        //1.8之前是分段锁，之后是cas：compare and set;默认segment = 16：1<<4=16
//        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();

        //插入效率还行，有序
//        ConcurrentSkipListMap<String,String>  map = new ConcurrentSkipListMap<>();

        Thread[] ths = new Thread[100];
        CountDownLatch latch = new CountDownLatch(ths.length);
        Random random = new Random();

        long start = System.currentTimeMillis();
        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) map.put("key"+random.nextInt(100),"val"+random.nextInt(100));
                latch.countDown();
            });
        }
        Arrays.asList(ths).forEach(a->a.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println(map.toString()+"::"+(end - start));
    }
}
