package com.dou.datastruct;
/**
 *
 */
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
public class AVLTree {
	/*
	 * 树节点
	 */
	public static class AvlNode<Integer>
	{
		public AvlNode(Integer theElement)
		{
			this(theElement,null,null);
		}
		public AvlNode(Integer theElement,AvlNode<Integer> lt,AvlNode<Integer> rt)
		{
			element = theElement;
			left = lt;
			right =right;
		}
		
		Integer element;
		AvlNode<Integer> left;
		AvlNode<Integer> right;
		int height;
	}
	/*
	 * 计算树的高度
	 */
	private int height (AvlNode<Integer> l)
	{
		return l == null ? -1: l.height;
	}
	/**
	 * 插入节点
	 */
	private AvlNode<Integer> insert(Integer x,AvlNode<Integer> t)
	{
		if ( null == t ) {
			return new AvlNode<Integer>(x, null, null);
		}
		int compareResult = compare(x,t.element);
		if (compareResult < 0 ) {
			t.left = insert(x, t.left);
			if (height(t.left) - height(t.right) == 2) {
				if (compare(x, t.left.element) < 0) {
					t = rotateWithLeftChild(t);
				}else {
					t = doubleWithLeftChild(t);
				}
			}
		}else if (compareResult > 0) {
			t.right = insert(x, t.right);
			if (height(t.left) - height(t.right) == 2) {
				if (compare(x, t.right.element) > 0)  {
					t = rotateWithRightChild(t);
				}else {
					t = doubleWithRightChild(t);
				}
			}
		}
		else {
			;
		}
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}
	/**
	 * 左单旋转
	 * 
	 */
	private AvlNode<Integer> rotateWithLeftChild(AvlNode<Integer> k2)
	{
		AvlNode<Integer> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height= Math.max(height(k2.left), height(k2.right))+1;
		k1.height = Math.max(height(k1.left), height(k1.right)) +1 ;
		return k1;
	}
	/**
	 * 右单旋转
	 * @param k2
	 * @return
	 */
	private AvlNode<Integer> rotateWithRightChild(AvlNode<Integer> k2)
	{
		AvlNode<Integer> k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		k2.height= Math.max(height(k2.left), height(k2.right))+1;
		k1.height = Math.max(height(k1.left), height(k1.right)) +1 ;
		return k1;
	}
	/*
	 * 左右双旋转
	 */
	private AvlNode<Integer> doubleWithLeftChild(AvlNode<Integer> k3)
	{
		k3.left =  rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
		
	}
	/*
	 * 
	 */
	private AvlNode<Integer> doubleWithRightChild(AvlNode<Integer> k3)
	{
		k3.right = rotateWithLeftChild(k3.right);
		return rotateWithRightChild(k3);

		
	}
	/**
	 * @param x
	 * @param element
	 * @return
	 */
	private int compare(Integer x, Integer y) {//
		// TODO Auto-generated method stub
		if (x > y) {
			return 1;
		}else if (x < y) {
			return -1;
		}else return 0;
	}
}
