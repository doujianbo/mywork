/**
 * create at 2014年5月10日
 * @author dou_jianbo
 */
package com.dou.algorithm;

import java.security.AlgorithmConstraints;
import java.util.Calendar;

/**
 * 排序算法
 */
public class Sort {



	public int compareto(int x,int y)
	{
		if (x > y) {
			return 1;
		}else if (x < y ) {
			return -1;
		}else 
			return 0;
	}
	/*
	 * 插入排序
	 */
	public void insertsort(int[] a)
	{
		long starttime = System.nanoTime();
		int j;
		for(int p = 1; p < a.length; p++)
		{
			int tmp = a[p];
			for( j = p ; j > 0 && compareto(tmp, a[j-
			                                       1]) < 0;j--)
			{
				a[j] = a[j-1];
			}
			a[j] = tmp;
		}
		long endtime = System.nanoTime();
		
		System.out.println("\nrun time: "+(endtime - starttime)+" ns.");
	}
	/*
	 * 
	 * 希尔排序
	 */
	public void shellsort(int a[])
	{
		long starttime = System.nanoTime();
		int j;
		for(int gap = a.length/2; gap > 0; gap /= 2)
		{
			for(int i = gap;i<a.length;i+=gap)
			{
				int temp = a[i];
				for(j =i;j >= gap&&compareto(temp,a[j-gap])<0;j-=gap)
				{
					a[j] = a[j-gap];
				}
				a[j] = temp;
				
			}
		}
		long endtime = System.nanoTime();
		
		System.out.println("\nrun time: "+(endtime - starttime)+" ns.");
	}
	public void printarr(int[] a)
	{
		System.out.println("now the array is:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}
