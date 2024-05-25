import java.util.*;
import java.util.Random;
public class Main
{
	
static void bogoSort(int[] i)
/*
 Bogosort is a sorting algorithm that randomly shuffles all of the values in a list
 over and over until that list is in the right order. Just from looking at how this 
 sorting algorithm works, it is logical to assume that this sorting algorithm is
 rather inefficient and has drastic run times. Average time complexity is O(n*n).
 */

{

while(!isSorted(i)) {
shuffle(i);
//shuffled based on sorted or not

}
}

static void shuffle(int[] i) {
for(int x = 0; x < i.length; ++x) {
int index1 = (int) (Math.random() * i.length),
index2 = (int) (Math.random() * i.length);
int a = i[index1];
i[index1] = i[index2];
i[index2] = a;
// shuffle method

}
}

static void swap(int[] a, int i, int j)

{
	
int temp = a[i];
a[i] = a[j];
a[j] = temp;
// Swapping two elements

}

static boolean isSorted(int[] a)

{
	
for (int i=0; i<a.length - 1; i++)
if (a[i] > a[i+1])
return false;
return true;
// Is the array sorted?? Returns true or false values if or if not sorted.
// Helpful source (https://www.geeksforgeeks.org/java-program-for-bogosort-or-permutation-sort/)

}

static void bubbleSort(int arr[])
/*
 The bubblesort algorithm takes two values and compares them to each other. After
 the algorithm determines if the values should be swapped or not it moves to the next
 pair. It goes through the entire list until it does not have to swap values anymore.
 This is how the sorting algorithm knows the values or in order. Time complexity is O(N^2).
*/

{
	
int n = arr.length ;
for (int i = 0; i < n-1; i++)
for (int j = 0; j < n-i-1; j++)
if (arr[j] > arr[j+1])
	
{
	
int temp = arr[j];
arr[j] = arr[j+1];
arr[j+1] = temp;
// Swaps values

}
}

static int partition(int arr[], int low, int high)

{
	
int pivot = arr[high];
int i = (low-1);
for (int j=low; j<high; j++)
	
{
	
if (arr[j] < pivot)
	
{
	
i++;
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
// The partition method takes the last number the pivot and sorts the numbers less than or greater to the left and right

}
}

int temp = arr[i+1];
arr[i+1] = arr[high];
arr[high] = temp;
return i+1;

}

static void quickSort(int arr[], int low, int high)
/*
 The quick sort algorithm takes a number as a pivot and puts the values less
 than the pivot to the left of the pivot number and the higher values to the
 right of the pivot. This is repeated with different numbers as the pivot
 until the values are sorted correctly. Time complexity varies but can be
 O(logn).
 */

{
	
if (low < high)
	
{
	
int pi = partition(arr, low, high);
quickSort(arr, low, pi-1);
quickSort(arr, pi+1, high);
// Sorts the values separately 
// Helpful source is (https://www.geeksforgeeks.org/quick-sort/) and (https://www.youtube.com/watch?v=h8eyY7dIiN4)
}
}

static void selectionSort(int arr[])
/*
The selectionsort algorithm sorts thought the list of values to find the lowest value 
within the array. After this, it replaces the first value in the array with the lowest
value found and stores the "old value" which was replaced into the into temp variable
and then place the temp variable where the minimum value found was stored. It then goes
through the entire list until the entire list is sorted through. The time complexity is
O(n^2). Again this can change depending on the size of the array.
*/

{
	
int n = arr.length;
for (int i = 0; i < n-1; i++)
	
{
	
int min_idx = i;
for (int j = i+1; j < n; j++)
if (arr[j] < arr[min_idx])
min_idx = j;
int temp = arr[min_idx];
arr[min_idx] = arr[i];
arr[i] = temp;
// Swapping the elements and restoring them
// Helpful source is (https://www.geeksforgeeks.org/selection-sort/)
}
}

static void insertionSort(int arr[])
/*
The Instertionsort takes the value and stores it in a temp variable. After this it
compares the value to ones before it and shift the values accordingly. It does this 
throughout the entire array until the whole array is sorted. Time complexity of
O(n^2).
*/

{
	
int n = arr.length;
for (int i = 1; i < n; ++i) {
int key = arr[i];
int j = i - 1;
while (j >= 0 && arr[j] > key) 
// Moves the values according to the chosen value in the array. If greater it will move them to the right etc.
{
	
arr[j + 1] = arr[j];
j = j - 1;

}

arr[j + 1] = key;
//Helpful source (https://www.geeksforgeeks.org/insertion-sort/)

}
}

static int shellSort(int arr[])
// Similar to the insertion sort, but more efficient depending on the array
/*
The Shellsort algorithm first takes values that are farther away and compares them
to each other. It then (like insertionsort) compares the values before it and sorts
accordingly. For example, if larger at the beginning of the array, it will swap them
with the smaller values located at the end of the array. In the shellsort algorithm
the gap between values selected will always be the same. It then compares the values
within this gap and swaps accordingly. Time complexity of O(n*logn). As with most 
big O time complexity it can vary depending on array.

 */
{
	
int n = arr.length;
for (int gap = n/2; gap > 0; gap /= 2)
//Starts with a smaller gap and slowly reduces the gap as the sorting goes on
	
{

for (int i = gap; i < n; i += 1)
// Continues until the gap is sorted
{
// Somewhat similar to insertion, we store a temp variable an compare etc.	
int temp = arr[i];
int j;
for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
arr[j] = arr[j - gap];
arr[j] = temp;

}
}

return 0;
// Helpful source (https://www.geeksforgeeks.org/shellsort/)

}

static void mergeSort(int arr[], int l, int m, int r)
/*
 The mergeSort algorithm takes the values of the array and splits them up into 
 smaller and smaller groups. It then builds these groups back up while at the 
 same time sorting the values. The time complexity is O(n*logn).
*/

{
	
int n1 = m - l + 1;
int n2 = r - m;
int L[] = new int [n1];
int R[] = new int [n2];
for (int i=0; i<n1; ++i)
L[i] = arr[l + i];
// Copying elements of original array and storing them
for (int j=0; j<n2; ++j)
R[j] = arr[m + 1+ j];
//copying elements of original array and storing them
int i = 0, j = 0;
int k = l;
while (i < n1 && j < n2)
// Looping until we run out of elements on either side
{
	
if (L[i] <= R[j])
// Comparing numbers whether greater and less than
{
	
arr[k] = L[i];
i++;

}

else
	
{
	
arr[k] = R[j];
j++;
}
k++;
// Comparing values and then looking at the next value to do the same
}

while (i < n1)
	
{
	
arr[k] = L[i];
i++;
k++;

}

while (j < n2)
	
{
	
arr[k] = R[j];
j++;
k++;
//Adds remaing elements to the arrays
// Helpful source (https://www.geeksforgeeks.org/merge-sort/)
}
}

static void gnomeSort(int arr[], int n)
/*
The gnomesort algorithm takes a value of the array and compares it to the value
left of it. If the values are in the right spot it moves to next value to the right 
and repeats. If the values is not it swaps and moves the value to the right. If there
are no values to the left of the array and it has reached the begging of the array
it moves back over the right. It does the opposite if it reaches the end of the array
until the array is completely sorted. Time complexity of O(n^2).
*/

{

int index = 0;

while (index < n) 
	
{
	
if (index == 0)
index++;
if (arr[index] >= arr[index - 1])
index++;
else {
int temp = 0;
temp = arr[index];
arr[index] = arr[index - 1];
arr[index - 1] = temp;
index--;

}
}

return;
// Helpful source (https://www.geeksforgeeks.org/gnome-sort-a-stupid-one/)
}



static void cocktailSort(int a[])
/*
The cocktailsort algorithm is similar to the bubble algorithm in that
it compares the two values to each other and swaps accordingly. The main
difference is that while the bubble algorithm moves in on direction from 
left to right, the cocktail sort algorithm can move both ways making it 
more efficient. Time complexity of O(N^2).

 */
{
	
boolean swapped = true;
int start = 0;
int end = a.length;

while (swapped == true) 
	
{
	
swapped = false;

for (int i = start; i < end - 1; ++i) 
// Similar to the bubblesort it loops from start to end
{
	
if (a[i] > a[i + 1]) {
int temp = a[i];
a[i] = a[i + 1];
a[i + 1] = temp;
swapped = true;

}
}

if (swapped == false)
break;
swapped = false;
end = end - 1;
for (int i = end - 1; i >= start; i--) {
if (a[i] > a[i + 1]) {
int temp = a[i];
a[i] = a[i + 1];
a[i + 1] = temp;
swapped = true;
// Tells the sorting algorithm if it is completely sorted or not
}
}

start = start + 1;

}
}

static void mergeSort(int arr[], int l, int r)
{
	
if (l < r)
	
{
	
int m = (l+r)/2;
mergeSort(arr, l, m);
mergeSort(arr , m+1, r);
mergeSort(arr, l, m, r);

}
}



public static void display()

{
	
System.out.println("1. Bogo Sort\n2. Selection Sort\n3. Insertion Sort\n4. Bubble Sort" 
				   + "\n5. Quick Sort\n6. Shell Sort\n7. Merge Sort\n8. Gnome Sort"	
				   + "\n9. Cocktail Sort");


}

public static void main(String[] args) {
int choice;
Main m = new Main();
Random random = new Random();
Scanner sc = new Scanner(System.in);
do

{
	
display();
int arr1[] = new int[20];
int arr2[] = new int[100];
int arr3[] = new int[500];
int arr4[] = new int[1000];
int sizes[] = {20,100,500,100};
for(int i = 0;i<20;i++)
	
{
	
arr1[i] = random.nextInt(999);

}

for(int i = 0;i<100;i++)
	
{
	
arr2[i] = random.nextInt(999);

}

for(int i = 0;i<500;i++)
	
{
	
arr3[i] = random.nextInt(999);

}

for(int i = 0;i<1000;i++)
	
{
	
arr4[i] = random.nextInt(999);
// Random arrays for how sorting algorithms to use
}

System.out.print("Selection : ");
choice = sc.nextInt();
int switchInt;
switch(choice)
// Asks what our user wants to use to sort
{

case 1 :
	
{

System.out.println("Choose the size of array : ");
System.out.println("1. 20\n2. 100\n3. 500\n4. 1000");
switchInt = sc.nextInt();
switch(switchInt)

{

case 1:
	
{
	
m.bogoSort(arr1);
System.out.println(arr1);
break;

}

case 2:
	
{
	
m.bogoSort(arr2);
System.out.println(arr2);
break;

}

case 3:
{
	
m.bogoSort(arr3);
System.out.println(arr3);
break;

}

case 4:
	
{
	
m.bogoSort(arr4);
System.out.println(arr4);
break;

}
}

break;

}

case 2:
	
{
selectionSort(arr1);
selectionSort(arr2);
selectionSort(arr3);
selectionSort(arr4);

System.out.println("First Array: ");
System.out.println(Arrays.toString(arr1));
System.out.println("Second Array: ");
System.out.println(Arrays.toString(arr2));
System.out.println("Third Array: ");
System.out.println(Arrays.toString(arr3));
System.out.println("Fourth Array: ");
System.out.println(Arrays.toString(arr4));
break;

}

case 3:
	
{
	
insertionSort(arr1);
insertionSort(arr2);
insertionSort(arr3);
insertionSort(arr4);

System.out.println("First Array: ");
System.out.println(Arrays.toString(arr1));
System.out.println("Second Array: ");
System.out.println(Arrays.toString(arr2));
System.out.println("Third Array: ");
System.out.println(Arrays.toString(arr3));
System.out.println("Fourth Array: ");
System.out.println(Arrays.toString(arr4));
break;

}

case 4:
	
{
	
bubbleSort(arr1);
bubbleSort(arr2);
bubbleSort(arr3);
bubbleSort(arr4);

System.out.println("First Array: ");
System.out.println(Arrays.toString(arr1));
System.out.println("Second Array : ");
System.out.println(Arrays.toString(arr2));
System.out.println("Third Array: ");
System.out.println(Arrays.toString(arr3));
System.out.println("Fourth Array: ");
System.out.println(Arrays.toString(arr4));
break;

}

case 5:
	
{
	
quickSort(arr1,0,19);
quickSort(arr2,0,99);
quickSort(arr3,0,499);
quickSort(arr4,0,999);

System.out.println("First Array: ");
System.out.println(Arrays.toString(arr1));
System.out.println("Second Array: ");
System.out.println(Arrays.toString(arr2));
System.out.println("Third Array: ");
System.out.println(Arrays.toString(arr3));
System.out.println("Fourth Array: ");
System.out.println(Arrays.toString(arr4));
break;

}

case 6:
	
{
	
shellSort(arr1);
shellSort(arr2);
shellSort(arr3);
shellSort(arr4);

System.out.println("First Array: ");
System.out.println(Arrays.toString(arr1));
System.out.println("Second Array: ");
System.out.println(Arrays.toString(arr2));
System.out.println("Third Array: ");
System.out.println(Arrays.toString(arr3));
System.out.println("Fourth Array: ");
System.out.println(Arrays.toString(arr4));
break;

}

case 7:
	
{
	
mergeSort(arr1,0,19);
mergeSort(arr2,0,99);
mergeSort(arr3,0,499);
mergeSort(arr4,0,999);

System.out.println("First Array: ");
System.out.println(Arrays.toString(arr1));
System.out.println("Second Array: ");
System.out.println(Arrays.toString(arr2));
System.out.println("Third Array: ");
System.out.println(Arrays.toString(arr3));
System.out.println("Fourth Array: ");
System.out.println(Arrays.toString(arr4));
break;

}

case 8:
	
{
	
gnomeSort(arr1,20);
gnomeSort(arr2,100);
gnomeSort(arr3,500);
gnomeSort(arr4,1000);

System.out.println("First Array: ");
System.out.println(Arrays.toString(arr1));
System.out.println("Second Array: ");
System.out.println(Arrays.toString(arr2));
System.out.println("Third Array: ");
System.out.println(Arrays.toString(arr3));
System.out.println("Fourth Array: ");
System.out.println(Arrays.toString(arr4));
break;

}

case 9:
	
{
	
cocktailSort(arr1);
cocktailSort(arr2);
cocktailSort(arr3);
cocktailSort(arr4);

System.out.println("First Array: ");
System.out.println(Arrays.toString(arr1));
System.out.println("Second Array: ");
System.out.println(Arrays.toString(arr2));
System.out.println("Third Array: ");
System.out.println(Arrays.toString(arr3));
System.out.println("Fourth Array: ");
System.out.println(Arrays.toString(arr4));
break;

}
// Helpful source (http://www.beginwithjava.com/java/decisions/switch-statement.html)
}
}

while(true);

}
}