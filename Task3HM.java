import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.TreeMap;

/*
 * Реализовать алгоритм пирамидальной сортировки (HeapSort)
 */

public class Task3HM {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter random array length: ");
        int arrayLength = iScanner.nextInt();

        ArrayList<Integer> workArrayList = filledArrayList(arrayLength);
        logger.info(String.format("Random array: %s", Arrays.toString(workArrayList.toArray())));
        buildHeap(workArrayList);
        logger.info(String.format("Heaped initial array: %s", Arrays.toString(workArrayList.toArray())));

        TreeMap<Integer, Integer> resMap = new TreeMap<>();
        while (workArrayList.size() > 0) {
            int swap = workArrayList.get(0);
            workArrayList.set(0, workArrayList.get(workArrayList.size() - 1));
            workArrayList.set(workArrayList.size() - 1, swap);
            resMap.put(workArrayList.size(), workArrayList.get(workArrayList.size() - 1));
			workArrayList.remove(workArrayList.size() - 1);
			heapCreate(workArrayList, 0);
		}

        logger.info(String.format("Sorted array: %s", resMap.values().toString()));
        iScanner.close(); 
    } 

    public static ArrayList<Integer> filledArrayList(int arrayLength) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayLength; i++) {
            result.add((int) ((Math.random() * 100)));
        }
        return result;
    }

    private static void buildHeap(ArrayList<Integer> arr) {
		for (int i = arr.size() / 2; i >= 0; i--) {
			heapCreate(arr, i);
		}
	}

    public static void heapCreate(ArrayList<Integer> arr, int i)
    {
        int largest = i;
        int l = 2*i + 1; 
        int r = 2*i + 2; 

        if (l < arr.size() && arr.get(i) < arr.get(l))
            largest = l;
        if (r < arr.size() && arr.get(largest) < arr.get(r))
            largest = r;
        if (largest != i)
        {
            int swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);

            heapCreate(arr, largest);
        }
    }  
}
