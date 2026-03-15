package Week01;
// No importing allowed in this lecture
// E.g.) import java.util.*;
// It only works with sorted array

public class BinarySearch {
    public static void main(String[] args) {
    // Code for searching
        int [] array = new int [] {0, 2, 7, 11, 16, 79, 85};
        int index = binarySearch(array, 16);
        if (index!=-1) {
            System.out.println("Target number index: " + index);
        }
        else
        {
            System.out.println("Not found in the array");
        }
    }

    /* Since I know that it is a violation of OOP rules, but just for the study
       Just to make it simple, I declare all in public access level */

    public static int binarySearch(int[] array, int target)
    {
        int left = 0;
        int right = array.length - 1;


        while(left <= right)
        {
            // Caution : overflow
            // mid = left + (right-left) / 2 is also good!
            int mid = (left + right) / 2;

            if (array[mid] == target)
                return mid;
            // Divide the range
            else if (array[mid] < target) {
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return -1;
    }








}
