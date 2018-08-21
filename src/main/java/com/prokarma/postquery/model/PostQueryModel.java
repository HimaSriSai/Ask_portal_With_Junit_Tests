package com.prokarma.postquery.model;

/**
 * @author Prokarma
 *
 */

public class PostQueryModel {
	/**
	 * PostId
	 */
	private int postid;
	/**
	 * PostedQuery
	 */
	private String pstdqry;
	/**
	 * CategoryName
	 */
	private String ctgryname;

	/**
	 * 
	 */
	private String other;

	/**
	 * 
	 */
	private int ctgryid;

	/**
	 * 
	 */
	private String ctgrycrtdby;

	/**
	 * LastUpdatedBy
	 */
	private int lastuptdby;

	/**
	 * EmployeeId
	 */
	private int empid;

	/**
	 * @return
	 */
	public int getCtgryid() {
		return ctgryid;
	}

	/**
	 * @return
	 */
	public String getCtgrycrtdby() {
		return ctgrycrtdby;
	}

	/**
	 * @param ctgrycrtdby
	 */
	public void setCtgrycrtdby(String ctgrycrtdby) {
		this.ctgrycrtdby = ctgrycrtdby;
	}

	/**
	 * @return
	 */
	public String getOther() {
		return other;
	}

	/**
	 * @param other
	 */
	public void setOther(String other) {
		this.other = other;
	}

	/**
	 * @return empid
	 */
	public int getEmpid() {
		return empid;
	}

	/**
	 * @param empid
	 */
	public void setEmpid(int empid) {
		this.empid = empid;
	}

	/**
	 * 
	 */
	public PostQueryModel() {

	}

	/**
	 * @return post_id
	 */
	public int getPostid() {
		return postid;
	}

	/**
	 * @return pstd_qry
	 */
	public String getPstdqry() {
		return pstdqry;
	}

	/**
	 * @param pstd_qry
	 */

	public void setPstdqry(String pstdqry) {
		this.pstdqry = pstdqry;
	}

	/**
	 * @return ctgry_name
	 */
	public String getCtgryname() {
		return ctgryname;
	}

	/**
	 * @param ctgry_name
	 */
	public void setCtgryname(String ctgryname) {
		this.ctgryname = ctgryname;
	}

	/**
	 * @return post_crtd_by
	 */

	/**
	 * @return pstd_dt
	 */
	public int getLastuptdby() {
		return lastuptdby;
	}

	/**
	 * @param lst_uptd_by
	 */
	public void setLastuptdby(int lastuptdby) {
		this.lastuptdby = lastuptdby;
	}
}
