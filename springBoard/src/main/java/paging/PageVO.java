package paging;

import org.springframework.stereotype.Component;

@Component
public class PageVO {
	private int startPage;
	private int endPage;
	private int countPage;
	private int currentPage;
	private int first;
	private int second;
	
	public PageVO() {
		// TODO Auto-generated constructor stub
	}

	public PageVO(int startPage, int endPage, int countPage, int currentPage, int first, int second) {
		super();
		this.startPage = startPage;
		this.endPage = endPage;
		this.countPage = countPage;
		this.currentPage = currentPage;
		this.first = first;
		this.second = second;
	}

	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getCountPage() {
		return countPage;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}	
	
	
}
