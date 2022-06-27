package com.cyberexplorer.addressbook.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("PERSONAL")
public class PersonalContactAddress extends ContactAddress{
	private static final long serialVersionUID = 1L;
	protected String messengerAccount;
	public PersonalContactAddress(String name, String phoneNumber, String email, String addressType, boolean defaultAddress, String messengerAccount) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = email;
		this.addressType = addressType;
		this.defaultAddress= defaultAddress;
		this.messengerAccount = messengerAccount;
	}

	@Override
	public String show() {
		return toString();
	}
	
	@Override
	public String toString() {
		return getName() + "," + getPhoneNumber() + "," + getEmailAddress() + "," + getAddressType() + "," + isDefaultAddress() + "," + getMessengerAccount();
	}
}
