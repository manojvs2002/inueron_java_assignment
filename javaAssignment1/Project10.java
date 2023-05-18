package javaAssignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("ener tthe number of elements");
		int n=scan.nextInt();
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++) {
			list.add(scan.nextInt());
		}
		System.out.println("before sorting");
		list.forEach(System.out::println);
		
		List<Integer> sort = list.stream().sorted().toList();
		System.out.println("sorted elements are ");
		sort.forEach(System.out::println);
		
		List<Integer> large =list.stream().filter(num -> num.equals(list.get(n-1)-1)).toList();
		System.out.println("second largest is");
		large.forEach(System.out::println);
		
		List<Integer> small =list.stream().filter(num -> num.equals(list.get(0)+1)).toList();
		System.out.println("second smallest is");
		small.forEach(System.out::println);

	}

}
