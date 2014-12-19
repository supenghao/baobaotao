package com.supenghao.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.util.Assert;

//所有dao类的基类
public class BaseDao<T> {
	
	private Class<T> entityClass;
	
	private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	private BaseDao() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
		entityClass = (Class<T>) params[0];
	}
	
	
	/**
	 * 根据id加载PO实例
	 * @param id
	 * @return 返回相应的持久化实例
	 */
	public T load(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}
	
	
	/**
	 * 根据ID获取PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	public T get(Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}
	
	
	/**
	 * 获取PO的所有对象
	 * 
	 * @return
	 */
	public List<T> loadAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}
	
	
	/**
	 * 保存PO
	 * 
	 * @param entity
	 */
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}
	
	
	/**
	 * 删除PO
	 * 
	 * @param entity
	 */
	public void remove(T entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * 更改PO
	 * 
	 * @param entity
	 */
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	
	/**
	 * 执行HQL查询
	 * 
	 * @param sql
	 * @return 查询结果
	 */
	public List find(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 执行带参的HQL查询
	 * 
	 * @param sql
	 * @param params
	 * @return 查询结果
	 */
	public List find(String hql, Object... params) {
		return this.getHibernateTemplate().find(hql,params);
	}
    
	/**
	 * 对延迟加载的实体PO执行初始化
	 * @param entity
	 */
	public void initialize(Object entity) {
		this.getHibernateTemplate().initialize(entity);
	}
	
	
	
/*	public Page pagedQuery(String hql, int pageNo, int pageSize, Object... values) {
		Assert.hasText(hql);
		Assert.isTrue(pageNo>=1, "pageNo should start form 1");
		//Count查询
		String countQueryString = " select count(*) " + removeSelect(removeOrders(hql));
	}
	*/
	
	//去除hql的select语句
	private static String removeSelect(String hql) {
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, " hql: " + hql + "must has a keyword 'from'");
		return hql.substring(beginPos);
	}
	
	//去除hql的orderby 语句
	private static String removeOrders(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while(m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	
	public HibernateTemplate getHibernateTemplate(){
		return hibernateTemplate;
	}

}
