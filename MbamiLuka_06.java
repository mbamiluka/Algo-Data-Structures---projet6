import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/* INPUT - Project 06_Input.txt
 * 
 * This class' main method uses a scanner to read all values from
 * the specified input file. Then, values are placed into an array.
 * The array is sorted using two sorting techniques ( Shell and Quick sort)
 * 
 * OUTPUT - Project 06_Output.txt
 * 
 * Idiosyncratic - belonging to one's peculiar and individual character
 * 
 * "Where there is life there is hope" - S.Hawking
 * 
 * @author Mbami Luka * Zach Morlan
 */
public class Main 
{
	//*************************************************************************
	public static void main ( String[]args ) throws FileNotFoundException 
	{
		int size = 100;							// Number of digits to be read
		int [] arrUnsorted = new int [size];	// Array to hold digits read
		int [] arrSorted = new int [size];		// Array to hold sorted digits
		
		int start = 0;
		int end = size-1;
		
		final String INPUT_FILENAME;			// File being read from
		INPUT_FILENAME = "Project06_Input.txt";
		File inputFile = new File(INPUT_FILENAME);
		Scanner input = new Scanner (inputFile);
		
		
		int i = 0;
		while ( input.hasNextLine() )
		{
			int value = Integer.parseInt( input.next());
			arrUnsorted[i] = value;
			i++;			
		}
		
		
		arrSorted = shellSort ( arrUnsorted);
		
		printArray ( arrSorted);
	}
	//*************************************************************************
	/*
	 * This method uses the shell sort method to arrange an int array in
	 * ascending order. Sub-arrays are used
	 * 
	 * @param	arr		This is the array which is taken for sorting
	 * 
	 * @return	arr		A sorted version of a specified array
	 */
	public static int[] shellSort( int [] arr)
	{	
		int gap;							// Gap between each element to swap
		gap = ( int) arr.length / 2;
		
		while ( gap >= 1)
		{
			for (int i = 0; i < gap; i++)
			{
				insertionSort ( arr, gap);
			}
			gap /= 2;
		}
		
		return arr;
	}
	
	//*************************************************************************
	/*
	 * This method sorts pairs of integers n elements apart using the concept 
	 * of insertion sort.
	 * 
	 * @param		arr		Specified array to be sorted
	 * @param		gap		Distance between each value to pair and compare 
	 */
	public static void insertionSort ( int[]arr, int gap)
	{
		for ( int i = 0; i < arr.length; i += gap)
		{
			int currValue = arr[i];
			int index = i;
			
			
			while ( index >= gap && arr[index - gap] > currValue)
			{
				arr[index] = arr[index-gap];
			    index -= gap;
			}
			
			arr[index] = currValue;
		}
	}
	//*************************************************************************
	/*
	 * This method will print the values of a given array
	 * @param		arr		specified array to print
	 */
	public static void printArray ( int [] arr)
	{
		for ( int i = 0; i < arr.length; i++)
		{
			String line = arr[i] + "  ";
			System.out.print ( line);
		}
	}
	//*************************************************************************
	
	public static int[] quickSort ( int [] array, int first, int last) 
	{
        
        final int MIN_SIZE = 4;
        int pivotIndex = 0; 
        
        if (last - first + 1 < MIN_SIZE) 
        {
        
           insertionSort ( array, first, last); 
        
        }// End if
        else 
        {
        
        pivotIndex = partition ( array, first, last);
        
        quickSort(array, first, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, last);
        
        }// End else
        
		return array;
	}
        
     
	
	//*****************************************************************************  
    /**
    *  This method sorts the first middle and last entry by acending order
    * @param T [] array an array storing some sort of data type
    * @param int first the position of the first entry of the array 
    * @param int last the position of the last entry of the array
    * @return int pivotIndex the postion of the pivot value
    */           
    public static int partition ( int [] array, int first, int last) 
    {
             
    int pivot = array[last];
    int i = first - 1;
    for ( int j = first; j < last; ++j) 
    {
      if ( array[j] <= pivot) 
      {
        swap ( array, ++i, j);
      }
    }
    swap ( array, ++i, last);
    return i;            
    } // End partition
    
    public static  void insertionSort(int [] array, int first, int last) 
    {      
         if( first < last) 
         {
         
            insertionSort ( array, first, last - 1);
            
            insertInOrder ( array[last], array, first, last - 1);
         
         } // End if
            
     } // End InsertionSort
    
  //*****************************************************************************
    /**
    * Sorts small array under MIN_SIZE into acending order
    * @param  T anEntry abstract data type from the array
    * @param array An array of comparable Objects.
    * @param int first postion of first comparable object in array.
    * @param int last postion of the last comparable object in array.  
    * @return	none
    */
    public static void insertInOrder(int anEntry, int [] array, int first, int last) 
    {
           
        if(anEntry >= array[last] ) 
        {
        
           array[last + 1] = anEntry;
        
        } // End if
        else if( first < last) 
        {
        
           array[last + 1] = array[last];
           insertInOrder(anEntry, array, first, last - 1);
        } // End else if
        else {
        
           array[last + 1] = array[last];
           array[last] = anEntry; 
        } // End else 
                
    } // End InsertionSort 
    
  //*****************************************************************************   
    /**
    * Swaps two entries in the array 
    * @param int i First entry in the array to be swapped 
    * @param int j Second entry in the array to be swapped
    * @return none
    */      
    private static void swap ( int [] array, int i, int j) 
    {
         
         int temp = array[i];
         
         array[i] = array[j];
         array[j] = temp;
         
     } // End swap
}
