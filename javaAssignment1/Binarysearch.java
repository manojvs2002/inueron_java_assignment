package javaAssignment1;

import java.util.*;

public class Binarysearch{
	
	public static void main(String...args) {
		Scanner sc=new Scanner(System.in) ;
			int t=sc.nextInt();
			
			while(t>0) {
				int n=sc.nextInt();
				int a[]=new int[n];
				for(int i=0;i<n;i++) {
					a[i]=sc.nextInt();
					
				}
				
				int k=sc.nextInt();
				Solution g=new Solution();
				
				System.out.println(g.binarysearch(a, n, k));
				t--;
			}
		
	}
}


class Solution {
     int binarysearch(int arr[], int n,int k) {
        
        int first=0,last=arr.length-1;
        while(first<last)
        {
        int mid=(first+last)/2;
        
        if(arr[mid]==k){
            return mid;
        }
            
            
        else if(arr[mid]>k)
          first=mid+1;
        
        
        else
           last=mid-1;
        
        }
        
       return -1;
        
        
    }
 }

