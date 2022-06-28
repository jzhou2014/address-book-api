package com.cyberexplorer.addressbook.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		discriminatorType = DiscriminatorType.STRING,
		name = "address_type"
)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		property = "addressType")
@JsonSubTypes({
		@JsonSubTypes.Type(value = BusinessContactAddress.class, name = "BUSINESS"),
		@JsonSubTypes.Type(value = PersonalContactAddress.class, name = "PERSONAL")
})
public abstract class ContactAddress implements Contact, Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@NonNull
	protected String name;
	protected String phoneNumber;
	protected String emailAddress;
	@Column(name = "address_type", insertable = false, updatable = false, nullable = false)
	protected String addressType;
	protected boolean defaultAddress;

	public ContactAddress(String name, String phoneNumber, String email, String addressType, boolean defaultAddress) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = email;
		this.addressType = addressType;
		this.defaultAddress= defaultAddress;
	}

	@Override
	public abstract String show();
}
