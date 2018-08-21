package com.prokarma.viewpost.service;

import java.text.ParseException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prokarma.common.util.CommonUtil;
import com.prokarma.viewpost.dao.IViewDao;
import com.prokarma.viewpost.model.PostQueryInfo;
import com.prokarma.viewpost.model.PostReplyModelSet;
import com.prokarma.viewpost.model.PostReplyTotal;
import com.prokarma.viewpost.model.ReplyOnPost;
import com.prokarma.viewpost.model.ReplyQueriesInfo;
import com.prokarma.viewpost.model.ResponseModelOnRply;
import com.prokarma.viewpost.model.SearchInfoModel;

/**
 * @author prokarma
 *
 */
@Component
public class ViewAllPostService implements IViewService {

	/**
	 * 
	 */
	@Autowired
	public IViewDao viewDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.viewpost.service.IViewService#getAllPostsAndReplies
	 */
	public Set<PostReplyModelSet> getAllPostsAndReplies(final SearchInfoModel searchModelInfo) {

		final Set<PostReplyModelSet> pstRplyModSets = new HashSet<>();

		final List<PostReplyTotal> pstRplyTotList = viewDao.getPostdata(searchModelInfo);

		final Map<PostQueryInfo, Set<ReplyQueriesInfo>> mapPostReply = new HashMap<>();

		for (PostReplyTotal postQueryInfo : pstRplyTotList) {
			createPostReplyMap(mapPostReply, postQueryInfo);

		}
		createSetForPostReply(pstRplyModSets, mapPostReply);
		return pstRplyModSets;
	}

	/**
	 * @param pstRplyModSetsSet
	 * @param mapPostReply
	 */
	private void createSetForPostReply(final Set<PostReplyModelSet> pstRplyModSets,
			final Map<PostQueryInfo, Set<ReplyQueriesInfo>> mapPostReply) {
		PostReplyModelSet pstRplyModSet;
		for (Map.Entry<PostQueryInfo, Set<ReplyQueriesInfo>> entry : mapPostReply.entrySet()) {
			pstRplyModSet = new PostReplyModelSet();
			pstRplyModSet.setPostQueryObj(entry.getKey());
			pstRplyModSet.setRplyQueriesInfosSet(entry.getValue());

			pstRplyModSets.add(pstRplyModSet);
		}
	}

	/**
	 * @param mapPostReply
	 * @param postQueryInfo
	 */
	private void createPostReplyMap(final Map<PostQueryInfo, Set<ReplyQueriesInfo>> mapPostReply,
			final PostReplyTotal postReplyTotal) {
		Set<ReplyQueriesInfo> replyQueriesInfos;
		ReplyQueriesInfo queriesInfo;
		PostQueryInfo postQueryInfoObj;
		postQueryInfoObj = new PostQueryInfo();
		postQueryInfoObj.setPostId(postReplyTotal.getPostId());
		postQueryInfoObj.setPostedMsg(postReplyTotal.getPostedMsg());
		postQueryInfoObj.setPostedBy(postReplyTotal.getPostedBy());
		postQueryInfoObj.setCtgryName(postReplyTotal.getCtgryName());
		postQueryInfoObj.setPostedDate(postReplyTotal.getPostedDate());
		postQueryInfoObj.setFirstName(CommonUtil.toInitCap(postReplyTotal.getFirstName()));
		postQueryInfoObj.setLastName(postReplyTotal.getLastName());
		postQueryInfoObj.setCrtdByName(
				CommonUtil.formatEmployeeName(postReplyTotal.getFirstName(), postReplyTotal.getLastName()));
		if (mapPostReply.isEmpty()) {
			replyQueriesInfos = new HashSet<>();
			if ("Y".equalsIgnoreCase(postReplyTotal.getReplyStatus())) {
				queriesInfo = new ReplyQueriesInfo();
				setReplyObject(queriesInfo, postReplyTotal);
				replyQueriesInfos.add(queriesInfo);

			}
			mapPostReply.put(postQueryInfoObj, replyQueriesInfos);
		} else {
			if (mapPostReply.containsKey(postQueryInfoObj)) {
				if ("Y".equalsIgnoreCase(postReplyTotal.getReplyStatus())) {
					queriesInfo = new ReplyQueriesInfo();
					setReplyObject(queriesInfo, postReplyTotal);
					mapPostReply.get(postQueryInfoObj).add(queriesInfo);
				}
			} else {
				replyQueriesInfos = new HashSet<>();
				if ("Y".equalsIgnoreCase(postReplyTotal.getReplyStatus())) {
					queriesInfo = new ReplyQueriesInfo();
					setReplyObject(queriesInfo, postReplyTotal);
					replyQueriesInfos.add(queriesInfo);
				}
				mapPostReply.put(postQueryInfoObj, replyQueriesInfos);
			}
		}
	}

	/**
	 * @param queriesInfo
	 * @param postQueryInfo
	 */
	private void setReplyObject(final ReplyQueriesInfo queriesInfo, final PostReplyTotal postReplyTotal) {
		queriesInfo.setRepliesMsgs(postReplyTotal.getRepliesMsgs());
		queriesInfo.setReplyedDate(postReplyTotal.getReplyedDate());
		queriesInfo.setReplyStatus(postReplyTotal.getReplyStatus());
		queriesInfo.setReplyId(postReplyTotal.getReplyId());
		queriesInfo.setRepliedBy(postReplyTotal.getRepliedBy());
		queriesInfo.setRplPostId(postReplyTotal.getReplyPostId());
		queriesInfo.setRplyFirstName(postReplyTotal.getRplyFirstName());
		queriesInfo.setRplyLastName(postReplyTotal.getRplyLastName());
		queriesInfo.setRpldByName(
				CommonUtil.formatEmployeeName(postReplyTotal.getRplyFirstName(), postReplyTotal.getRplyLastName()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.prokarma.viewpost.service.IViewService#replyToPost
	 */
	public ResponseModelOnRply replyToPost(final ReplyOnPost replyOnPost) throws ParseException {
		final ResponseModelOnRply responseModelOnRply = new ResponseModelOnRply();
		responseModelOnRply.setReplyStatus(viewDao.insertReply(replyOnPost));
		return responseModelOnRply;
	}
}
