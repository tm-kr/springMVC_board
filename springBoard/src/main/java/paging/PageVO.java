package paging;

public class PageVO {
	private int startPage;
	private int endPage;
	
	public PageVO() {
		// TODO Auto-generated constructor stub
	}
	
	public PageVO(int startPage, int endPage) {
		this.startPage = startPage;
		this.endPage = endPage;
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
	
	
}
