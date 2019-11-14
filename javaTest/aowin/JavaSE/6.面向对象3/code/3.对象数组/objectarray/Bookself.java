package com.aowin.objectarray;

public class Bookself {
	private Book book [];
	public Bookself() {
		book=new Book[40];
		for(int i=0;i<book.length;i++) {
			book[i]=new Book("安徒生童话故事",18+i);
		}
	}
	public Book[] getBook() {
		return book;
	}
	public void setBook(Book[] book) {
		this.book = book;
	}
	
}
