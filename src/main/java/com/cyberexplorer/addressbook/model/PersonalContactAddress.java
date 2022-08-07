package com.cyberexplorer.addressbook.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("PERSONAL")
public class PersonalContactAddress extends ContactAddress{
	private static final long serialVersionUID = 1L;
	@Column(name = "messenger_account")
	protected String messengerAccount;
	public PersonalContactAddress(Integer id, String name, String phoneNumber, String email, String addressType, boolean defaultAddress, String messengerAccount) {
		super(id, name, phoneNumber, email, addressType, defaultAddress);
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
