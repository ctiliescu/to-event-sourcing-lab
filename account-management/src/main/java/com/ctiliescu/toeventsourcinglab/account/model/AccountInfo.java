package com.ctiliescu.toeventsourcinglab.account.model;

import java.util.Objects;

public class AccountInfo {

	private String currency;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof AccountInfo))
			return false;
		AccountInfo that = (AccountInfo) o;
		return Objects.equals(currency, that.currency);
	}

	@Override
	public int hashCode() {
		return Objects.hash(currency);
	}

}
