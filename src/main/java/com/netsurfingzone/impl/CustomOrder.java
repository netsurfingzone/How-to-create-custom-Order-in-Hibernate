package com.netsurfingzone.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Order;

public class CustomOrder extends Order {

	private String propName;

	protected CustomOrder(String propertyName, boolean ascending) {
		super(propertyName, ascending);
		this.propName = propertyName;
	}

	@Override
	public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery) {

		final StringBuilder query = new StringBuilder();
		query.append(" LENGTH(").append("student_name").append(") ").append(super.isAscending() ? "asc" : "desc");

		return query.toString();
	}

	public static Order addCustomOrder(String propertyName, boolean ascending) {
		return new CustomOrder(propertyName, ascending);
	}

}