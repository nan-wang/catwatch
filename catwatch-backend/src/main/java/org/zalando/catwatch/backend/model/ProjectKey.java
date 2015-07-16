package org.zalando.catwatch.backend.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ProjectKey implements Serializable {

	private long id;

	private Date snapshotDate = null;

	public ProjectKey() {
		super();
	}

	public ProjectKey(long id, Date snapshotDate) {
		super();
		this.id = id;
		this.snapshotDate = snapshotDate;
	}

	/**
	 * See {@link Statistics#getId()}
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * See {@link Statistics#getSnapshotDate()}
	 */
	public Date getSnapshotDate() {
		return snapshotDate;
	}

	public void setSnapshotDate(Date snapshotDate) {
		this.snapshotDate = snapshotDate;
	}

}