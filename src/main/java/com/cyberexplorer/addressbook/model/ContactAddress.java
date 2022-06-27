package com.cyberexplorer.addressbook.model;

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
	@Override
	public abstract String show();
}
