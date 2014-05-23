package com.dou.datastruct;

import com.dou.exception.UnderflowException;

public class BinarySearchTree <Integer extends Comparable<? super Integer>>{
	//嵌套类BianaryNode 树节点
	private static class BinaryNode<Integer>
	{
		public BinaryNode(Integer theElement) {
			// TODO Auto-generated constructor stub
			this(theElement,null,null);
		}
		public BinaryNode(Integer theElement,BinaryNode<Integer> lt,BinaryNode<Integer> rt)
		{
			element = theElement;
			left = lt;
			right = rt;
		}
		Integer element;
		BinaryNode<Integer> left;
		BinaryNode<Integer> right;
	}
	public BinarySearchTree() {
		// TODO Auto-generated constructor stub
		root = null;
	}
	public void makeEmpty(){
		root = null;
	}
	public boolean isEmpty()
	{
		return root == null;
	}
	/*
	 * 树中的节点是否包含该值为x的节点
	 */
	
	public boolean contains(Integer x)
	{
		return contains(x,root);
	}
	private boolean contains(Integer x,BinaryNode<Integer> t)
	{
		if(null == t)
			return false;
		int comResult = x.compareTo(t.element);
		if (comResult < 0) {
			return contains(x,t.left);
		}else if (comResult > 0) {
			return contains(x, t.right);
		}else return true;
		
	}
	/*
	 * 查找树中的最小元素
	 */
	public Integer findMin() throws UnderflowException 
	{
		if (isEmpty()) {
			throw new UnderflowException();
		}
		return findMin(root).element;
	}
	private BinaryNode<Integer> findMin(BinaryNode<Integer> t)
	{
		if (null == t) {
			return null;
		}else if (null == t.left) {
			return t;
		}
		return findMin(t.left);
		
	}
	/*
	 * 查找最大元素
	 */
	public Integer findMax() throws UnderflowException 
	{
		if (isEmpty()) {
			throw new UnderflowException();
		}
		return findMax(root).element;
	}
	private BinaryNode<Integer> findMax(BinaryNode<Integer> t)
	{
		/*非递归写法
		 * if (null != t) {
			while(null != t.right)
				t = t.right
		}
		return t;*/
		if (null == t) {
			return null;
		}else if (null == t.right) {
			return t;
		}
		return findMax(t.right);          //递归调用
	}
	/*
	 * 在数中插入新的节点
	 */
	public void insert(Integer x)
	{
		root = insert(x, root);
	}
	private BinaryNode<Integer> insert(Integer x,BinaryNode<Integer> t)
	{
		if (t == null) {
			return new BinaryNode<Integer>(x,null,null);
			
		}
		int comResult = x.compareTo(t.element);
		if (comResult < 0) {
			t.left = insert(x, t.left);
		}
		else if (comResult > 0 ) {
			t.right = insert(x, t.right);
		}
		else 
			;
		return t;
		
	}
	/*
	 * 删除树中的值为x的节点
	 */
	public void remove(Integer x)
	{
		root = remove(x,root);
	}
	private BinaryNode<Integer> remove(Integer x,BinaryNode<Integer> t)
	{
		if (t== null) {
			return t;
		}
		int compareResult = 0;
		compareResult = x.compareTo(t.element);
		if ( compareResult < 0) {
			t = remove(x, t.left);
		}else if (compareResult > 0) {
			t = remove(x, t.right);
		}else 
		{
			if (t.left != null && t.right != null) {
				t.element = findMin(t.right).element;
				t.right = remove(t.element, t.right);
			}
			else t = (t.left == null) ? t.left:t.right;
		}
		return t;
	}
	/*
	 * 
	 */
	
	public void print()
	{
		System.out.println("先序遍历二叉查找树：");
		printPre(root);
		System.out.println("\n中序序遍历二叉查找树：");
		printMid(root);
		System.out.println("\n后序遍历二叉查找树：");
		printAft(root);
	}
	private void printAft(BinaryNode<Integer> t)
	{
		if (null != t) {
			printAft(t.left);
			printAft(t.right);
			System.out.print(t.element+" ");
		}
		
	}
	//中序遍历树
	private void printMid(BinaryNode<Integer> t)
	{
		if (null != t) {
			printMid(t.left);
			System.out.print(t.element+" ");
			printMid(t.right);
		}
		
	}
	//先序遍历树
	private void printPre(BinaryNode<Integer> t)
	{
		if (null != t ) {
			System.out.print(t.element+" ");
			printPre(t.left);
			printPre(t.right);
		}
		
	}
	private BinaryNode<Integer> root;
}
