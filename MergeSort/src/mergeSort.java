import java.util.Scanner;


public class mergeSort {

	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int count = read.nextInt();
		int[] arr = new int[count];
		
		for(int i=0; i<count; i++)
			arr[i]= read.nextInt();
		
			
		sort(arr,0,count-1);
		
		printArray(arr);
		
		read.close();
	}
	
	public static void printArray(int[] arr)
	{
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
		System.out.println();
	}
	
	public static void sort(int[] arr, int low, int high)
	{		
		if(low<high)
		{
			int middle = (low+high)/2;
			
			sort(arr, low, middle);
			sort(arr, middle+1, high);
			merge(arr,low,middle,high);
		}	
		
	}
	
	public static void merge(int[] arr, int low, int mid, int high)
	{
		int array1 = mid-low+1;
		int array2 = high-mid;
		
		int[] leftArray = new int[array1];
		int[] rightArray = new int[array2];
		

		
		for(int i=0; i<array1; ++i)
		{
			leftArray[i] = arr[low+i];			
		}
		for(int j=0; j<array2; ++j)
		{
			rightArray[j] = arr[mid+1+j];				
		}
		

		
		//Merge left and right Arrays
		int i=0, j=0;
		int k = low;
		
		while(i<array1 && j<array2)
		{
			if(leftArray[i]<rightArray[j])
			{
				arr[k]=leftArray[i];				
				i++;				
			}
			else
			{
				arr[k]=rightArray[j];
				j++;
			}
			k++;
		}
		
		while(i<array1)
		{
			arr[k] = leftArray[i];
			k++;
			i++;
		}
		while(j<array2)
		{
			arr[k] = rightArray[j];
			k++;
			j++;
		}
		
	}

}
