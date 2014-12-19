package com.supenghao.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BasicDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6012400872536766098L;

	
	public String toString() {
		
		return ToStringBuilder.reflectionToString(this);
		
	}


}
