package paging;

import org.springframework.stereotype.Component;

@Component
public class PageCalc {
	
	private PageVO pageVO;
	
	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public PageVO pageCalc(int currentPage, int articleCount) {
		// currentPage = 현재페이지, articleCount = 글 총 갯수
		int countList = 5;//한 페이지에 보여줄 글 갯수
		int countPage = 3;// 페이지 갯수 ex ) [1] [2] [3] 다음
		int block = articleCount / countList;
		
		if(articleCount % countList != 0) {
			block++;
		}
		if(currentPage <=0 ) {
			currentPage = 1;
		}
		if(currentPage > block) {
			currentPage -= 3;
		}
		int startPage = (currentPage-1) / countPage * countPage + 1; // 시작 페이지
		int endPage = startPage + countPage - 1; // 끝 페이지
		if (endPage > block) {
			endPage = block;
		}
		int first = currentPage*countList - 4; //fist 부터 second 까지의 게시물을 보여준다
		int second = currentPage*countList; //	ex) 1~5 번 게시물 보이기
		
		
		pageVO.setStartPage(startPage);
		pageVO.setEndPage(endPage);
		pageVO.setCountPage(countPage);
		pageVO.setCurrentPage(currentPage);
		pageVO.setFirst(first);
		pageVO.setSecond(second);
		pageVO.setBlock(block);
		
		return pageVO;
	}

}
