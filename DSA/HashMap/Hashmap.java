import java.util.Iterator;
import java.util.LinkedList;

public class HashMap<K, V> {
    public class HMPair<K, V> {
        public K key;
        public V value;

        public HMPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "HMPair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            HMPair pair = (HMPair) obj;
            return pair.key.equals(this.key);
        }
    }

    private static int default_capacity = 6;
    private int size=0;
    private static double load_factor = 0.75;
    private LinkedList<HMPair>[] bucketArray;

    public HashMap() {
        this(default_capacity);
    }

    public HashMap(int capacity) {
        this.default_capacity = capacity;
        this.bucketArray = new LinkedList[capacity];
    }

    public void put(K key, V value) {
        int index = hashFunction(key);
        LinkedList<HMPair> bucket = bucketArray[index];
        HMPair hmPair = new HMPair(key, value);
        if (bucket == null) {
            bucket = new LinkedList<>();
            bucket.add(hmPair);
            bucketArray[index] = bucket;
            size++;
        } else {
            HMPair getHmPair = get(bucket, key);
            if (getHmPair == null) {
                bucket.addLast(hmPair);
                size++;
            } else {
                getHmPair.value = value;
            }
        }
        double lambda=(1.0*size)/this.bucketArray.length;
        if(lambda>this.load_factor){
            System.out.println("Rehashed....");
            rehash();
        }
    }


    public void rehash(){
        LinkedList<HMPair>[] oldBucket=this.bucketArray;
        this.bucketArray=(LinkedList<HMPair>[]) new LinkedList[2*oldBucket.length];

        for(LinkedList<HMPair> list:oldBucket){
            while(list!=null && !list.isEmpty()){
                HMPair pair=list.removeFirst();
                this.put((K)pair.key,(V)pair.value);
            }
        }
    }

    public HMPair get(LinkedList<HMPair> list, K key) {
        Iterator<HMPair> itr = list.iterator();
        while (itr.hasNext()) {
            HMPair pair = itr.next();
            if (pair.key.equals(key)) {
                return pair;
            }
        }
        return null;
    }

    public void get(K key) {
        int index = hashFunction(key);
        LinkedList<HMPair> bucket = bucketArray[index];
        if (bucket == null) {
            System.out.println("Key doesn't present");
        } else {
            HMPair pair = get(bucket, key);
            if (pair == null) {
                System.out.println("key doesn't present ");
            } else {
                System.out.println(pair.value);
            }
        }
    }

    public int hashFunction(K key) {
        int hashCode = Math.abs(key.hashCode());
        hashCode %= bucketArray.length;
        return hashCode;
    }

    public void display() {
        for (LinkedList<HMPair> list : bucketArray) {
            if (list == null) continue;
            for (HMPair pair : list) {
                System.out.println(pair);
            }
        }
    }


    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Prerna");
        map.put(2, "Nitesh");
        map.put(3, "Vancha");
        map.put(3, "Shivani");
        map.put(4, "Vijay");
        map.put(5, "Deepak");
        map.put(6, "Simran");
        map.put(7, "Anurag");
        map.display();

        map.get(3);

    }
}
