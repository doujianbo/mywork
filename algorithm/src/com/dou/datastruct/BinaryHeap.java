/**
 * create at 2014年5月5日
 * @author dou_jianbo
 */
package com.dou.datastruct;
import com.dou.exception.*;

/**
 * 优先队列---二叉堆 数组下标从0开始要不然无法保证child = hole/2
 */
public class BinaryHeap {
	private static final int DEFAULT_CAPCITY = 50;
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
	public BinaryHeap(int[] items)
	{
		currentsize = items.length;
		array = new int[(currentsize+2)*11/10];
		int i = 1;
		for(int item:items)
		{
			array[i++] = item;
		}
		buildHeap();
	}
	public void insert(int x) 
	{
		if( currentsize == array.length-1)
			return;	
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
		return array[1];
	}
	public int deleteMin() throws UnderflowException
	{
		if(isEmpty())
			throw new UnderflowException();
		int minnumber = findMin();
		array[1] = array[currentsize--];
		percolateDown(1);
		return minnumber;
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
		currentsize = 1;
	}
	
	public void printHeap()
	{
		System.out.println();
		for(int i = 1;i<currentsize;i++)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	private void percolateDown(int hole)   //下滤
	{
		int child;
		int tmp = array[hole];
		for(;hole * 2<= currentsize;hole = child)
		{
			child = hole * 2;
			if(child != currentsize && compare(array[child+1], array[child])<1)
				child++;
			if (compare(array[child], tmp)<0) {
				array[hole] = array[child];
			}
			else {
				break;
			}
		}
		array[hole] = tmp;
	}
	private void buildHeap()
	{
		for(int i = currentsize/2;i>0;i--)
			percolateDown(i);
	}
	

}
