package com.itravel.model;
// default package
// Generated 26 Mar, 2014 6:29:53 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ServicesLookupTable generated by hbm2java
 */
@Entity
@Table(name = "services_lookup_table", catalog = "itradb")
public class ServicesLookupTable implements java.io.Serializable {

	private Integer id;
	private PackageTable packageTable;
	private String serviceName;

	public ServicesLookupTable() {
	}

	public ServicesLookupTable(PackageTable packageTable, String serviceName) {
		this.packageTable = packageTable;
		this.serviceName = serviceName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "package_id")
	public PackageTable getPackageTable() {
		return this.packageTable;
	}

	public void setPackageTable(PackageTable packageTable) {
		this.packageTable = packageTable;
	}

	@Column(name = "service_name", length = 40)
	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}