import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
public class IT481_Unit7V2 {

private static boolean debug = false;

public static void main(String[] args) {

//Set type using number:
// 1 = bubble sort
// 2 = quicksort
int type = 1;

//***************************************************//
//Bubble sort

/**
* Small array
*/
//create a small integer array (10)
int smallArray[] = getArray(10, 100);

//Deep copy to a new array used for removing duplicates
int newSmallArray[] = new int[smallArray.length];

System.arraycopy(smallArray, 0, newSmallArray, 0,

newSmallArray.length);

//Deep copy to another array used for quick sorting
int quickSmallArray[] = new int[newSmallArray.length];
System.arraycopy(newSmallArray, 0, quickSmallArray, 0,

quickSmallArray.length);

//run the small bubble sort
String size = "small";
runSortArray(smallArray, size, type);

/**
* Medium array
*/
//create a medium integer array (1000)
int mediumArray[] = getArray(1000, 100);

//Deep copy to a new array used for removing duplicates
int newMediumArray[] = new int[mediumArray.length];
System.arraycopy(mediumArray, 0, newMediumArray, 0,newMediumArray.length);

//Deep copy to another array used for quick sorting
int quickMediumArray[] = new int[newMediumArray.length];
System.arraycopy(newMediumArray, 0, quickMediumArray, 0,quickMediumArray.length);

//run the medium bubble sort

size = "medium";
runSortArray(mediumArray, size, type);

/**
* Large array
*/
//create a large integer array (10,000)
int largeArray[] = getArray(10000, 100);

//Deep copy to a new array used for removing duplicates
int newLargeArray[] = new int[largeArray.length];
System.arraycopy(largeArray, 0, newLargeArray, 0,

newLargeArray.length);

//Deep copy to another array used for quick sorting
int quickLargeArray[] = new int[newLargeArray.length];
System.arraycopy(newLargeArray, 0, quickLargeArray, 0,

quickLargeArray.length);

//run the large bubble sort
size = "large";
runSortArray(largeArray, size, type);

//****************************************************//
//Set to remove duplicates

/**
* Remove duplicates and rerun tests
*/

//new small array by removing duplicates
newSmallArray = onlyUniqueElements(newSmallArray);
size = "new small unique";
runSortArray(newSmallArray, size, type);

//new medium array by removing duplicates
newMediumArray = onlyUniqueElements(newMediumArray);
size = "new medium unique";
runSortArray(newMediumArray, size, type);

//new large array by removing duplicates
newLargeArray = onlyUniqueElements(newLargeArray);
size = "new large unique";
runSortArray(newLargeArray, size, type);

//*************************************************//
//Quicksort

//Set the type to run quicksort

type = 2;

/**
* Run the quick sorts with duplicates
*/

//Use the quick sort
size = "quick small";

//Run the array for timing
runSortArray(quickSmallArray, size, type);

//Use the quick sort
size = "quick medium";

//Run the array for timing
runSortArray(quickMediumArray, size, type);

//Use the quick sort
size = "quick large";

//Run the array for timing
runSortArray(quickLargeArray, size, type);

iterativeQuicksort(quickSmallArray);
iterativeQuicksort(quickMediumArray);
iterativeQuicksort(quickLargeArray);
}

//Get array of integers of sizes as determined by parameters passed
private static int[] getArray (int size, int randomMaxSize) {

//Create the array with size
int myArray[] = new int[size];

//Get the random values for the array
for (int i = 0; i < myArray.length; i++)
{
//Get the random number with randomMaxSize as the upper limit of 1 -
	 myArray[i] = getRandomNumber(randomMaxSize);

}

//Return the filled array
return myArray;

}

//Run the sort actions by printing and timing the arrays
private static void runSortArray (int[] arr, String size, int type) {

//Set the sort type as a string
String sort = null;

if(type == 1) {

sort = "bubble";

} else if(type == 2) {

sort = "quick";
}

//print array before sorting using bubble sort algorithm
if(debug) {
System.out.println("Array before the " + sort + " sort");
for (int i = 0; i < arr.length; i++) {
System.out.print(arr[i] + " ");
}
}

//start timer

long startRun = System.nanoTime();

//sort an array using bubble sort algorithm

if(type == 1) {
bubbleSort(arr);
} else if (type == 2) {
//Set low and high values for a quick sort

int low = 0;

int high = arr.length - 1;

sortAsc(arr, low, high);

}

System.out.println();

//print array after sorting using bubble sort algorithm
if(debug) {
System.out.println("Array after the " + sort + " sort");
for (int i = 0; i < arr.length; i++) {
System.out.print(arr[i] + " ");
}
}

//end timer

long endRun = System.nanoTime();

System.out.println("\n");

//Print out the time in nanoseconds
System.out.println("The run time is for the " + size + " array in nanoseconds is " + (endRun -
startRun));

System.out.println("\n\n");

}

//Random number methods
public static int getRandomNumber(int maxValue)
{
//Get a random number between 1 - maxValue.
int x = 1 + (int) (Math.random() * maxValue );

//Return the random number
return x;
}

//Perform the bubble sort
private static void bubbleSort(int[] intArray) {

/*
* In bubble sort, we basically traverse the array from first to

array_length -

* 1 position and compare the element with the next one. Element is

swapped with

* the next element if the next element is greater.
*
* Bubble sort steps are as follows.
*
* 1. Compare array[0] & array[1] 2. If array[0] > array [1] swap it. 3.

Compare

* array[1] & array[2] 4. If array[1] > array[2] swap it. ... 5. Compare
* array[n-1] & array[n] 6. if [n-1] > array[n] then swap it. After this step

we

* will have largest element at the last index.
*

* Repeat the same steps for array[1] to array[n-1]
*
*/
int n = intArray.length;
int temp = 0;
for (int i = 0; i < n; i++) {
for (int j = 1; j < (n - i); j++) {
if (intArray[j - 1] > intArray[j]) {
//swap the elements!
temp = intArray[j - 1];
intArray[j - 1] = intArray[j];
intArray[j] = temp;
}
}
}

}

//Remove duplicates in an array using a set
@SuppressWarnings("unused")
private static int[] onlyUniqueElements(final int[] inputArray)
{
//create the set
final Set<Integer> set = new HashSet<>();

//create the temporary array
final int[] tmp = new int[inputArray.length];
int index = 0;

//use the set to remove duplicates and add to new array.
for (final int i: inputArray)
if (set.add(i))
tmp[index++] = i;

//return the array
return Arrays.copyOfRange(tmp, 0, index);
}

//Quicksort and compare numbers
public static void sortAsc(int[] arr, int low, int high) {

// pick the pivot
int middle = low + (high - low) / 2;
//System.out.println("The middle is " + middle);
int pivot = arr[middle];
// make left < pivot and right > pivot
int i = low, j = high;
while (i <= j) {
while (arr[i] < pivot) {
i++;
}
while (arr[j] > pivot) {
j--;
}

//System.out.println("i = " + i + " and " + "j is " + j);

if (i <= j) {
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
i++;
j--;
}
}
// recursively sort two sub parts
if (low < j)
sortAsc(arr, low, j);
if (high > i)
sortAsc(arr, i, high);

}

public static void iterativeQuicksort(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    stack.push(arr.length - 1);

    while (!stack.isEmpty()) {
        int end = stack.pop();
        int start = stack.pop();

        if (start < end) {
            int pivotIndex = partition(arr, start, end);

            if (pivotIndex - 1 > start) {
                stack.push(start);
                stack.push(pivotIndex - 1);
            }

            if (pivotIndex + 1 < end) {
                stack.push(pivotIndex + 1);
                stack.push(end);
            }
        }
    }
}
public static int partition(int[] arr, int low, int high) {
    int pivot = arr[high]; // Choose the rightmost element as the pivot
    int i = low - 1; // Index of smaller element

    for (int j = low; j < high; j++) {
        // If the current element is smaller than the pivot
        if (arr[j] < pivot) {
            i++;

            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Swap arr[i+1] and arr[high] (or the pivot)
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1; // Return the position of the pivot after partitioning
}

}