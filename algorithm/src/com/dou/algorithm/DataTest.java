
package com.dou.algorithm;

import com.dou.datastruct.*;

import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.dou.datastruct.MyLinkedList;
import com.dou.exception.UnderflowException;
/**
 * 
 * @author dou_jianbo
 *
 */


public class DataTest {

	
	public static void main(String []args) throws UnderflowException
	{
		/*BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int x = random.nextInt(100);
			System.out.print(x+" ");
			tree.insert(x);
		}
		System.out.println("最小元素："+ tree.findMin());
		System.out.println();
		tree.print();*/
		/*int a[] = new int[10];
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			a[i] = random.nextInt(100);
			System.out.print(a[i]+" ");
			
		}
		Sort sort = new Sort();
		//sort.insertsort(a);
		sort.shellsort(a);
		sort.printarr(a);
		*/
		BinaryHeap bHeap = new BinaryHeap();
		Random random = new Random();
		for (int i = 1; i < 9 ; i++) {
			int x = random.nextInt(100);
			bHeap.insert(x);
			System.out.print(x+" ");
		}
		bHeap.printHeap();
		
	}

}
