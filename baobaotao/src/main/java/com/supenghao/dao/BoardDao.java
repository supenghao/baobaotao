package com.supenghao.dao;

import java.util.Iterator;

import org.springframework.stereotype.Repository;

import com.supenghao.domain.Board;

@Repository
public class BoardDao extends BaseDao<Board>{
	
	protected final String GET_BOARD_NUM = "select count (b.boardId) from board";
	

	public long getBoardNum() {    
		@SuppressWarnings("rawtypes")
		Iterator iter = getHibernateTemplate().iterate(GET_BOARD_NUM);
        return ((Long)iter.next());
	}
	

}
