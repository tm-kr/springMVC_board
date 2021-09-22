package paging;

import org.springframework.stereotype.Component;

@Component
public class PageVO {
	private int startPage; // 시작페이지
	private int endPage; // 끝 페이지
	private int countPage; // 페이지 갯수 ex ) [1] [2] [3] 다음
	private int currentPage; // 현재 페이지
	private int first; //fist 부터 second 까지의 게시물을 보여준다
	private int second;
	private int block; // 게시글 목록 갯수 위의 페이지 갯수의 끝 번호 일 것이다.
	
	public PageVO() {
	}
	public PageVO(int startPage, int endPage, int countPage, int currentPage, int first, int second, int block) {
		super();
		this.startPage = startPage;
		this.endPage = endPage;
		this.countPage = countPage;
		this.currentPage = currentPage;
		this.first = first;
		this.second = second;
		this.block = block;
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

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}	
	
	
}
