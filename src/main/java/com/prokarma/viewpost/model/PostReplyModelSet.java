package com.prokarma.viewpost.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author prokarma
 *
 */
public class PostReplyModelSet {
	/**
	 * 
	 */
	private PostQueryInfo postQueryObj;

	/**
	 * 
	 */
	private Set<ReplyQueriesInfo> rplyQueriesInfosSet = new HashSet<>();

	/**
	 * @return
	 */
	public PostQueryInfo getPostQueryObj() {
		return postQueryObj;
	}

	/**
	 * @param postQueryObj
	 */
	public void setPostQueryObj(final PostQueryInfo postQueryObj) {
		this.postQueryObj = postQueryObj;
	}

	/**
	 * @return
	 */
	public Set<ReplyQueriesInfo> getRplyQueriesInfosSet() {
		return rplyQueriesInfosSet;
	}

	/**
	 * @param rplyQueriesInfosSet
	 */
	public void setRplyQueriesInfosSet(final Set<ReplyQueriesInfo> rplyQueriesInfosSet) {
		this.rplyQueriesInfosSet = rplyQueriesInfosSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postQueryObj == null) ? 0 : postQueryObj.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostReplyModelSet other = (PostReplyModelSet) obj;
		if (postQueryObj == null) {
			if (other.postQueryObj != null)
				return false;
		} else if (!postQueryObj.equals(other.postQueryObj))
			return false;
		return true;
	}

}
