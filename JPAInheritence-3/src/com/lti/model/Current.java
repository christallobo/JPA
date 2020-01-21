package com.lti.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="current_table")
@DiscriminatorValue("current")
public class Current extends Account {
	private int overDraft;

	public Current() {
		super();
	}

	public Current(int overDraft) {
		super();
		this.overDraft = overDraft;
	}

	public Current(int accountId, String accountHolder, double accountBalance, int overDraft) {
		super(accountId, accountHolder, accountBalance);
		this.overDraft = overDraft;
	}

	public int getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(int overDraft) {
		this.overDraft = overDraft;
	}

	@Override
	public String toString() {
		return "Current [overDraft=" + overDraft + ", toString()=" + super.toString() + "]";
	}
	
}
