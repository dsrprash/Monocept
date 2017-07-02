import java.io.*;

public class Monocept {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int testCases = Integer.parseInt(br.readLine());
		
		while(testCases > 0){
			String temp[] = br.readLine().split(" ");
			int length = Integer.parseInt(temp[0]);
			int magicMoves = Integer.parseInt(temp[1]);
			String input = br.readLine();	
			
			int i;
			char ch = 'A';
			int alphaCount[] = new int[26];
			for(i=0; i < 26 ; i++){
				
				StringBuilder sb = new StringBuilder(input);
				int binaryArray[] = new int[sb.length()];
				binaryArray = generateBinaryArray(sb,ch);
				int indexArrayToMax[] = findZeroes(binaryArray, magicMoves);
				binaryArray = modifyBinaryArray(binaryArray,indexArrayToMax);
				alphaCount[i] = getMaxLength(binaryArray);
				
				
				
				ch++;
			}
			int result = getMax(alphaCount);
			System.out.println(result);
			testCases -= 1;
		}
	}
	
	private static int getMax(int[] alphaCount) {
		// TODO Auto-generated method stub
		int max = alphaCount[0];
		int i;
		for(i=1;i < alphaCount.length; i++){
			if(max < alphaCount[i])
				max = alphaCount[i];
		}
		return max;
	}

	private static int[] modifyBinaryArray(int[] binaryArray, int[] indexArrayToMax) {
		int i;
		for(i=0;i < indexArrayToMax.length; i++){
			binaryArray[indexArrayToMax[i]] = 1;
		}
		return binaryArray;
	}

	public static int[] generateBinaryArray(StringBuilder sb, char ch){
		int arr[] = new int[sb.length()];
		int i;
				for(i=0; i< sb.length(); i++){
					if(sb.charAt(i) == ch)
						arr[i] = 1;
					else 
						arr[i] = 0;
				}
				
				return arr;
	}
	
	
	
	
	 static int[] findZeroes(int arr[],int m)
	    {
	        int index[] = new int[m];
		 	// Left and right indexes of current window
	        int wL = 0, wR = 0; 
	      
	        // Left index and size of the widest window 
	        int bestL = 0, bestWindow = 0; 
	      
	        // Count of zeroes in current window
	        int zeroCount = 0; 
	      
	        // While right boundary of current window doesn't cross 
	        // right end
	        while (wR < arr.length)
	        {
	            // If zero count of current window is less than m,
	            // widen the window toward right
	            if (zeroCount <= m)
	            {
	                if (arr[wR] == 0)
	                  zeroCount++;
	                wR++;
	            }
	      
	            // If zero count of current window is more than m,
	            // reduce the window from left
	            if (zeroCount > m)
	            {
	                if (arr[wL] == 0)
	                  zeroCount--;
	                wL++;
	            }
	      
	            // Update widest window if this window size is more
	            if (wR-wL > bestWindow)
	            {
	                bestWindow = wR-wL;
	                bestL = wL;
	            }
	        }
	      
	        int k = 0;
	        // Print positions of zeroes in the widest window
	        for (int i=0; i<bestWindow; i++)
	        {
	            if (arr[bestL+i] == 0)
	               {
	            	 index[k] = bestL+i;
	            	 k++;
	            	}
	        }
	        
	        return index;
	      }
	
	
	
	 public static int getMaxLength(int arr[])
	 {
	     int count = 0; //intitialize count
	     int result = 0; //initialize max
	  
	     for (int i = 0; i < arr.length; i++)
	     {
	         // Reset count when 0 is found
	         if (arr[i] == 0)
	             count = 0;
	  
	         // If 1 is found, increment count
	         // and update result if count becomes
	         // more.
	         else
	         {
	             count++;//increase count
	             result = max(result, count);
	         }
	     }
	  
	     return result;
	 }
	
	public static int max(int x,int y){
		return x>y? x:y;
	}
	
}
