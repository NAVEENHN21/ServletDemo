package com.hibernatehelloworld.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Embedded
	@AttributeOverride(column = @Column(name="shipping_street"), name = "street")
	@AttributeOverride(column = @Column(name="shipping_city"), name = "city")
	@AttributeOverride(column = @Column(name="shipping_pincode"), name = "pincode")

	private Address shippingaddress;
	
//	@Embedded
//	@AttributeOverride({
//	@AttributeOverride(column = @Column(name="shipping_street"), name = "street")),
//	@AttributeOverride(column = @Column(name="shipping_city"), name = "city")),
//	@AttributeOverride(column = @Column(name="shipping_pincode"), name = "pincode"))
//	})
	@AttributeOverride(column = @Column(name="shipping_street"), name = "street")
	@AttributeOverride(column = @Column(name="shipping_city"), name = "city")
	@AttributeOverride(column = @Column(name="shipping_pincode"), name = "pincode")


	private Address billingaddress;

	public person(String name, Address shippingaddress, Address billingaddress) {
		super();
	
		this.name = name;
		this.shippingaddress = shippingaddress;
		this.billingaddress = billingaddress;
	}




}
