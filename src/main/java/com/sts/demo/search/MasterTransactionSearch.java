package com.sts.demo.search;

/**
 * Search/filter model for Master Transaction list (Yii2 Search Model pattern).
 * Holds optional criteria submitted from the list page search form.
 * Empty fields mean "no filter" for that column.
 */
public class MasterTransactionSearch {

	/** Partial or full match against transaction name (maps to entity {@code name}). */
	private String transactionName;

	/** Filter by status: 1 = Active, 0 = Inactive; null = all statuses. */
	private Integer status;

	public MasterTransactionSearch() {
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/** True when no search criteria are set (show all records). */
	public boolean isEmpty() {
		return (transactionName == null || transactionName.trim().isEmpty()) && status == null;
	}
}
