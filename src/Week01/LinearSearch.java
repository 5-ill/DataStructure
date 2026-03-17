package Week01;
// No importing allowed in this lecture
// E.g.) import java.util.*;
// It works with unsorted array too.
// LinearSearch checks every index of array.

public class LinearSearch {
    public static void main(String[] args) {
        // code for searching
        int [] array = new int [] {85, 0, 15, -5, 3, 28, 21};
        int index = linearSearch(array, -5);
        if (index!=-1) {
            System.out.println("Target number index: " + index);
        }
        else
        {
            System.out.println("Not found in the array");
        }
    }
    public static int linearSearch(int[] array, int target)
    {
        for (int i = 0; i<array.length; i++)
        {
            if (array[i]==target)
                return i;
        }
        return -1;
    }
}
