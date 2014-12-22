package com.supenghao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="t_topic")
public class Topic extends BasicDomain {
	/*
	 * 精华帖子
	 */
	public static final int DIGEST_TOPIC = 1;
	
	/*
	 * 普通帖子
	 */
	public static final int NOT_DIGEST_TOPIC = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "topic_id")
	private int topicId;
}
