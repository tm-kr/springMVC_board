package com.board.dto;

import org.springframework.stereotype.Component;

@Component
public class PageVO {
	private int startPage; // ����������
	private int endPage; // �� ������
	private int countPage; // ������ ���� ex ) [1] [2] [3] ����
	private int currentPage; // ���� ������
	private int first; //fist ���� second ������ �Խù��� �����ش�
	private int second;
	private int block; // �Խñ� ��� ���� ���� ������ ������ �� ��ȣ �� ���̴�.
	private String search; // �˻�����
	
	public PageVO() {
	}
	
	public PageVO(int startPage, int endPage, int countPage, int currentPage, int first, int second, int block,
			String search) {
		super();
		this.startPage = startPage;
		this.endPage = endPage;
		this.countPage = countPage;
		this.currentPage = currentPage;
		this.first = first;
		this.second = second;
		this.block = block;
		this.search = search;
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
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
}
