package com.example.mapping.compoundkey;

import java.io.Serializable;
import java.util.StringTokenizer;

public class ComposedIdKey implements Serializable {

	private static final long serialVersionUID = 1L;
	public String lastname;
	public String firstname;
	public String city;

	
	public ComposedIdKey() {
	}

	public ComposedIdKey(String value) {
		StringTokenizer token = new StringTokenizer(value, "::");
		this.lastname = token.nextToken();
		this.firstname = token.nextToken();
		this.city = token.nextToken();
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof ComposedIdKey)) {
			return false;
		}
		ComposedIdKey c = (ComposedIdKey) obj;
		return lastname.equals(c.lastname) && firstname.equals(c.firstname) && city.equals(c.city);
	}

	public int hashCode() {
		return this.lastname.hashCode() ^ this.firstname.hashCode() ^ this.city.hashCode();
	}

	public String toString() {
		return "" + this.lastname + "::" + this.firstname + "::"+this.city;
	}
}
