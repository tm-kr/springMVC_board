package paging;

import org.springframework.stereotype.Repository;

@Repository
public class PageCalc {
	public int pageCalc(int currentPage, int articleCount) {
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
		int start = currentPage*5 - 4;
		int end = currentPage*5;
		
		return 0;
	}
}
