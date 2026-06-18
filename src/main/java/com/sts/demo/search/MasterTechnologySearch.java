package com.sts.demo.search;

/**
 * Search/filter model for Master Technology list (Yii2 Search Model pattern).
 * Holds optional criteria submitted from the list page search form.
 * Empty fields mean "no filter" for that column.
 */
public class MasterTechnologySearch {

	/** Partial or full match against technology name (maps to entity {@code name}). */
	private String technologyName;

	/** Filter by status: 1 = Active, 0 = Inactive; null = all statuses. */
	private Integer status;

	public MasterTechnologySearch() {
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/** True when no search criteria are set (show all records). */
	public boolean isEmpty() {
		return (technologyName == null || technologyName.trim().isEmpty()) && status == null;
	}
}
