package com.supenghao.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 分页对象，包含当前页数据及分页信息如总数据数
 * @author Penghao
 *
 */
public class Page implements Serializable {

	private static final long serialVersionUID = -349644780406187096L;
	private static int DEFAULT_PAGE_SIZE = 20;
	private int pageSize = DEFAULT_PAGE_SIZE; //每页的记录数
	private long start;
	private List data;
	private long totalCount;
	
	//构造方法，之构造空页
	public Page() {
		this(0,0,DEFAULT_PAGE_SIZE, new ArrayList());
	}
	
	//默认构造方法
	public Page(long start, long totalCount, int pageSize, List data) {
		this.pageSize = pageSize;
		this.start = start;
		this.totalCount = totalCount;
		this.data = data;
	}
	
	//取总页数
	public long getTotalPageCount() {
		if(totalCount % pageSize == 0) {
			return totalCount % pageSize;
		} else {
			return totalCount % pageSize + 1;
		}
		
	}
	
	//取该页当前页码，从1开始
	public long getCurrentPageNo() {
		return start/pageSize +1;
	}
	
	//判断该页是否有下一页
	public boolean isHasNextPage() {
		return this.getCurrentPageNo() < this.getTotalPageCount();
	}
	
	
	//判断是否有上一页
	public boolean isHasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}
	
	//获取任一页第一条数据在数据集的位置,每页条数使用默认值
	  public static int getStartOfPage(int pageNo) {
	    	return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE );
	    }
	  
	
	//获取任一页第一条数据在数据集的位置
    public static int getStartOfPage(int pageNo, int pageSize) {
    	return (pageNo-1)*pageSize;
    }
}
