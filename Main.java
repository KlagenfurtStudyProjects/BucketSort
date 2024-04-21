import java.util.Random;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

class Main{
    public static void main(String[] args){
        Random r = new Random();
        StringBuilder times = new StringBuilder();
        TimeMeasure tm = new TimeMeasure();

        // if length == 1, then array list size is constant with different bucket numbers
        if (args.length == 1){
            StringBuilder bucketsNumbers = new StringBuilder();
            int size = Integer.parseInt(args[0]);
            ArrayList<Integer> generalList = CreateArrayList(r, size);
            for (int i = 10; i <= size / 10; i*=10){
                BucketSort bs = new BucketSort();
                bucketsNumbers.append(i + ", ");
                ArrayList<Integer> examList = new ArrayList<>(generalList);

                tm.Start();
                bs.sort(examList, i);
                tm.End();

                times.append(tm.GetElapsedTime() + ", ");
            }

            String bucketsSizePath = "C:\\Users\\pichu\\OneDrive\\Рабочий стол\\Ausbildung\\2ndSemester\\Java\\Problem6.1\\buckets.txt";
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File(bucketsSizePath)));
                writer.write(bucketsNumbers.toString());
                writer.close();
            }
            catch (Exception ex){}
        }
        // if length == 2 => bucket number is constant with different array lists' sizes (args[0] - start array size, args[1] - last array size)
        else{
            int startArraySize = Integer.parseInt(args[0]);
            int lastArraySize = Integer.parseInt(args[1]);
            StringBuilder arraySize = new StringBuilder();

            for (int i = startArraySize; i <= lastArraySize; i*=10){
                ArrayList<Integer> tmpList = CreateArrayList(r, i);
                BucketSort bs = new BucketSort();
                arraySize.append(i + ", ");

                tm.Start();
                bs.sort(tmpList, 1000);
                tm.End();

                times.append(tm.GetElapsedTime() + ", ");
            }

            String arraySizePath = "C:\\Users\\pichu\\OneDrive\\Рабочий стол\\Ausbildung\\2ndSemester\\Java\\Problem6.1\\arrays.txt";
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File(arraySizePath)));
                writer.write(arraySize.toString());
                writer.close();
            }
            catch (Exception ex){}

        }
        
        String timePath = "C:\\Users\\pichu\\OneDrive\\Рабочий стол\\Ausbildung\\2ndSemester\\Java\\Problem6.1\\time.txt";
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(timePath)));
            writer.write(times.toString());
            writer.close();
        }
        catch (Exception ex){}  
    }

    // create general array list with certain size
    public static ArrayList<Integer> CreateArrayList(Random r, int size){
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < size; i++){
            a.add(i, r.nextInt(size));
        }

        return a;
    }
}