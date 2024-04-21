import java.util.ArrayList;
import java.util.Collections;

class BucketSort{

    class Bucket{
        int size;
        ArrayList<Integer> b;
        int n = 0;
       
        Bucket (int bucketSize){
            this.size = bucketSize;
            this.b = new ArrayList<Integer>(this.size);
        }
       
        protected void insert(Integer integer){
            b.add(n, integer);
            n++;
        }
        
        protected int transfer(ArrayList<Integer> data, int index){
            for (int i = 0; i < this.n; i++){
                data.set(index + i, b.get(i));
            }
            
            return index + n;
        }
   }

   public void sort(ArrayList<Integer> data, int nBuckets) {
    Bucket[] buckets = new Bucket[nBuckets];
    int listSize = data.size();
    for (int i = 0; i < nBuckets; i++) buckets[i] = new Bucket(listSize / nBuckets);
    int max = data.get(0), min = max;
    
    // find min and max
    for (int i = 0; i < listSize; i++){
        Integer currentInt = data.get(i);
        if (currentInt.compareTo(max) > 0) max = currentInt;
        else if (currentInt.compareTo(min) < 0) min = currentInt;
    }
    
    // find coefficient
    double f = (double) nBuckets / (max - min + 1); 
    
    // fill each bucket
    for (int i = 0; i < listSize; i++){
        Integer currentInt = data.get(i);
        int b = (int)((currentInt - min) * f);
        buckets[b].insert(currentInt);
    }
    
    // sort each bucket
    for (Bucket b : buckets) bubble(b.b);
   
    // transfer to initial ArrayList
    int i = 0;
    for (Bucket b : buckets) i = b.transfer(data, i);
  }

  private void bubble(ArrayList<Integer> data) {
    boolean hadSwap = false;

    for (int i = 0; i < data.size() - 1; i++) {
      hadSwap = false;

      for (int j = 0; j < data.size() - (i + 1); j++) {

        if (data.get(j) > data.get(j + 1)) {
          Collections.swap(data, j, j + 1);
          hadSwap = true;
        }
      }

      if (!hadSwap) {
        break;
      }
    }
  }
}