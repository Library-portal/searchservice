package com.services.searchservice.cache;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

import com.services.searchservice.model.Book;

public class LRUBookCache {
	
	private Map<Integer, Book> booksMap;
	private Deque<Integer> queue = new LinkedList<>();
	
	public void put(Book book){
		booksMap.put(book.getId(), book);
		queue.addFirst(book.getId());
	}
	
	public Book get(Integer id){
		
		Book book = booksMap.get(id);
		if(book == null){
			//get the Book from database service
			book = null;
			put(book);
			return book;
		}
		
		queue.remove(book.getId());
		queue.addFirst(book.getId());
		return book;
		
	}

}
