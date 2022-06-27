package com.cyberexplorer.addressbook.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("BUSINESS")
public class BusinessContactAddress extends ContactAddress {
	private static final long serialVersionUID = 1L;
	protected String website;
	
	public BusinessContactAddress(String name, String phoneNumber, String email, String addressType, boolean defaultAddress, String website) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = email;
		this.addressType = addressType;
		this.defaultAddress = defaultAddress;
		this.website = website;
	}

	@Override
	public String show() {
		
		return toString();
	}
	
	@Override
	public String toString() {
		return getName() + "," + getPhoneNumber() + "," + getEmailAddress() + "," + getAddressType() + "," + isDefaultAddress() + "," + getWebsite();
	}
}
