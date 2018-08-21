package com.prokarma.postquery.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.prokarma.postquery.dao.IPostQueryDao;
import com.prokarma.postquery.model.PostQueryModel;
import com.prokarma.searchquery.dao.ISearchDao;

/**
 * @author Prokarma
 *
 */
@Service
public class PostQueryServiceImpl implements IPostQueryService {

	/**
	 * 
	 */
	@Autowired
	private IPostQueryDao postqrydao;

	@Autowired
	@Qualifier("searchDao")
	private ISearchDao searchDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.post_query.service.PostQueryService#postque(com.prokarma.
	 * post_query.model.PostQueryModel)
	 */
	@Override
	public String postquestion(final PostQueryModel postquerymodel) throws ParseException {
		String retVal = "";
		int count = 0;
		if (postquerymodel.getOther().equals("")) {
			retVal = postqrydao.postque(postquerymodel);
		} else {
			List<String> ctrgyNmaes = searchDao.getCategory();
			for (String selectedCtrgy : ctrgyNmaes) {
				if (selectedCtrgy.equalsIgnoreCase(postquerymodel.getOther())) {
					count++;
					retVal = "The catergory '" + postquerymodel.getOther() + "' already exist";
					break;
				}
			}
			if (count == 0) {
				retVal = postqrydao.postque(postquerymodel);
			}
		}
		return retVal;

	}

}
