/* Heap data structure :
   1. It's a Binary tree
   2. It should be complete Binary Tree ( where all the levels are completely filled ,
      except last level it should either be filled for partially filled from left to right )
   3. Should follow Heap Order Property(either min-heap or max-heap)

*/

public class Heap {
    private final int[] arr;
    private int capacity = 10;
    private int heap_size = 0;

    public Heap(int capacity) {
        this.capacity = capacity;
        arr = new int[this.capacity + 1];
    }

    public int parent(int i) {
        return i / 2;
    }

    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return 2 * i + 1;
    }

    public void add(int val, boolean minHeap) {
        this.heap_size++;
        arr[this.heap_size] = val;
        if (minHeap) min_heapify(this.heap_size);
        else max_heapify(this.heap_size);
    }

    public void remove(boolean minheap) {
        swap(arr, 1, this.heap_size);
        arr[this.heap_size] = 0;
        this.heap_size--;
        if(minheap)down_min_heapify(1);
        else down_max_heapify(1);
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void min_heapify(int i) {
        int parent = parent(i);
        while (i > 1 && arr[parent] > arr[i]) {
            swap(arr, parent, i);
            min_heapify(parent(i));
        }
    }

    public void down_min_heapify(int i) {
        int l = left(i);
        int r = right(i);
        int minIndex=i;

        if (l <= this.heap_size && arr[i] > arr[l]) {
            minIndex=l;
        }
        if (r <= this.heap_size && arr[r] < arr[minIndex]) {
           minIndex=r;
        }
        if(minIndex!=i){
            swap(arr,i,minIndex);
            down_min_heapify(minIndex);
        }
    }
    public void down_max_heapify(int i) {
        int l = left(i);
        int r = right(i);
        int maxIndex=i;

        if (l <= this.heap_size && arr[i] < arr[l]) {
            maxIndex=l;
        }
        if (r <= this.heap_size && arr[r] > arr[maxIndex]) {
            maxIndex=r;
        }
        if(maxIndex!=i){
            swap(arr,i,maxIndex);
            down_max_heapify(maxIndex);
        }
    }

    public void max_heapify(int i) {
        int parent = parent(i);
        while (i > 1 && arr[parent] < arr[i]) {
            swap(arr, parent, i);
            max_heapify(parent(i));
        }
    }

    public int getMin() {
        return this.arr[1];
    }

    public int getMax() {
        return this.arr[1];
    }

    public void printHeap() {
        for (int x : this.arr) {
            System.out.print(x + ",");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Heap minHeap = new Heap(10);
        minHeap.add(10, true);
        minHeap.add(20, true);
        minHeap.add(30, true);
        minHeap.add(4, true);
        minHeap.add(2, true);
        minHeap.add(1, true);
        minHeap.printHeap();
        minHeap.remove(true);
        System.out.println(minHeap.getMin());
        minHeap.printHeap();
        minHeap.remove(true);
        System.out.println(minHeap.getMin());
        minHeap.printHeap();
        minHeap.remove(true);
        System.out.println(minHeap.getMin());
        minHeap.printHeap();

        Heap maxHeap = new Heap(10);
        maxHeap.add(10, false);
        maxHeap.add(30, false);
        maxHeap.add(20, false);
        maxHeap.add(80, false);
        maxHeap.add(60, false);
        System.out.println(maxHeap.getMax());
        maxHeap.printHeap();
        maxHeap.remove(false);
        System.out.println(maxHeap.getMax());
        maxHeap.printHeap();
        maxHeap.remove(false);
        System.out.println(maxHeap.getMax());
    }

}
