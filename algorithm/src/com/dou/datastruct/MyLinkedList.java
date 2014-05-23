/**
 * create at 2014年4月22日
 * @author dou_jianbo
 */
package com.dou.datastruct;
import java.util.*;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;


public class MyLinkedList<Integer> implements Iterable<Integer>{
	private static class Node<Integer>
	{
		public Node(Integer d,Node<Integer> p,Node<Integer> q)
		{
			data = d;
			prevNode = p;									//前驱节点
			nextNode = q;									//后驱节点
		}
		public Integer data;
		public Node<Integer> prevNode;
		public Node<Integer> nextNode;
	}
	public MyLinkedList() {
		// TODO Auto-generated constructor stub
		clear();
	}
	public int size()
	{
		return theSize;
	}
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	/*
	 * 增加节点
	 */
	public boolean add(Integer x)
	{
		add(size(),x);
		return true;
	}
	
	public void add(int idx,Integer x)
	{
		addBefore(getNode(idx),x);
		
	}
	/*
	 * 在前驱节点p之间增加节点
	 */
	public void addBefore(Node<Integer> p,Integer x)
	{
		Node<Integer> newNode = new Node<Integer>(x, p.prevNode, p);
		newNode.prevNode.nextNode = newNode;
		p.prevNode = newNode;
		theSize++;
		modCount++;
	}
	/**
	 * 获取idx位置的Node
	 * @return
	 */
	private Node<Integer> getNode(int idx)						//不可直接访问
	{
		Node<Integer> p;
		if(idx<0||idx > size())
			throw new IndexOutOfBoundsException();				 //越界
		if (idx < size()/2) {									//属于前半段
			p = beginMarker.nextNode;
			for (int i = 0; i < idx; i++) {
				p = p.nextNode;
			}
		}
		else 
		{
			p =  endMarker;
			for(int i = size();i > idx;i--)
			{
				p = p.prevNode;
			}
		}
		return p;
		
	}
	public Integer remove(int idx)
	{
		return remove(getNode(idx));
	}
	private Integer remove(Node<Integer> p)
	{
		p.nextNode.prevNode = p.prevNode;
		p.prevNode.nextNode = p.nextNode;
		theSize--;
		modCount++;
		return p.data;
		
	}
	public Integer get(int idx)
	{
		return getNode(idx).data;
	}
	public Integer set(int idx,Integer newVal)
	{
		Node<Integer> p = getNode(idx);
		Integer oldVal = p.data;
		p.data = newVal;
		return oldVal;
	}
	public void clear()
	{
		beginMarker = new Node<Integer>(null,null,null);
		endMarker = new Node<Integer>(null, beginMarker, null);
		beginMarker.nextNode = endMarker;
		theSize = 0;
		modCount++;
		
	}
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	private class LinkedListIterator  implements Iterator<Integer>
	{
		private Node<Integer> current = beginMarker.nextNode;
		private int expectModCount = modCount;
		private boolean okToRemove = false;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=endMarker;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			if (modCount != expectModCount) {
				throw new ConcurrentModificationException();
			}
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Integer nextItem = current.data;
			current = current.nextNode;
			okToRemove = true;
			return nextItem;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			if (modCount != expectModCount) {
				throw new ConcurrentModificationException();
			}
			if (!okToRemove) {
				throw new IllegalStateException();
			}
			MyLinkedList.this.remove(current.prevNode);
			okToRemove = false;
			expectModCount++;
		}

		
		
	}
	private int theSize;							//列表的长度
	private int modCount = 0;						//列表的改变次数
	private Node<Integer> beginMarker;
	private Node<Integer> endMarker;
	
}
