/**
 * create at 2014年5月5日
 * @author dou_jianbo
 */
package com.dou.datastruct;

import com.dou.exception.Overflow;

/**
 * 优先队列---二叉堆
 */
public class BinaryHeap {
	private static final int DEFAULT_CAPCITY = 10;
	private int currentsize = 0;
	private int[] array;
	
	public BinaryHeap()
	{
		this(DEFAULT_CAPCITY);
	}
	public BinaryHeap(int capacity)
	{
		currentsize = 0;
		array = new int[capacity+1];
	}
	
	public void insert(int x) throws Overflow
	{
		if(isfull())
			throw new Overflow();
		int hole = ++currentsize;
		for(;hole > 1&& compare(x, array[hole/2])<0;hole/=2)      //往上遍历
		{
			array[hole] = array[hole/2];
		}
		array[hole] = x;
	
	}
	public int compare(int x,int y)
	{
		if(x > y)
			return 1;
		else if(x == y)
			return 0;
		else return -1;
	}
	public int findMin()
	{
		if(isEmpty())
			return 0;
		else
			return array[0];
	}
	public int deleteMin()
	{
		
	}
	public boolean isfull()
	{
		return currentsize == array.length -1;
	}
	public boolean isEmpty()
	{
		return currentsize ==0;
	}
	public void makeEmpty()
	{
		
	}
	private void percolateDown()
	{
		
	}
	private void buildHeap()
	{
		
	}
	private void enlargeArray()
	{
		
	}

}
