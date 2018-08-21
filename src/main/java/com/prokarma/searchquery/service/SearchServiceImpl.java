package com.prokarma.searchquery.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.prokarma.searchquery.dao.ISearchDao;

/**
 * @author prokarma
 *
 */
public class SearchServiceImpl implements ISearchService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Autowired
	@Qualifier("searchDao")
	private transient ISearchDao searchDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.search_query.service.ISearchService#getcategory()
	 */
	@Override
	public List<String> getcategory() {
		return searchDao.getCategory();

	}

}
