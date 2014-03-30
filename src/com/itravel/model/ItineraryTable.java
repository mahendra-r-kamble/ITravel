package com.itravel.model;
// default package
// Generated 26 Mar, 2014 6:29:53 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ItineraryTable generated by hbm2java
 */
@Entity
@Table(name = "itinerary_table", catalog = "itradb")
public class ItineraryTable implements java.io.Serializable {

	private Integer id;
	private Integer itineraryDay;
	private byte[] itineraryImage;
	private String itineraryDescription;
	private Set packageTables = new HashSet(0);

	public ItineraryTable() {
	}

	public ItineraryTable(Integer itineraryDay, byte[] itineraryImage,
			String itineraryDescription, Set packageTables) {
		this.itineraryDay = itineraryDay;
		this.itineraryImage = itineraryImage;
		this.itineraryDescription = itineraryDescription;
		this.packageTables = packageTables;
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

	@Column(name = "itinerary_day")
	public Integer getItineraryDay() {
		return this.itineraryDay;
	}

	public void setItineraryDay(Integer itineraryDay) {
		this.itineraryDay = itineraryDay;
	}

	@Column(name = "itinerary_image")
	public byte[] getItineraryImage() {
		return this.itineraryImage;
	}

	public void setItineraryImage(byte[] itineraryImage) {
		this.itineraryImage = itineraryImage;
	}

	@Column(name = "itinerary_description", length = 1000)
	public String getItineraryDescription() {
		return this.itineraryDescription;
	}

	public void setItineraryDescription(String itineraryDescription) {
		this.itineraryDescription = itineraryDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "itineraryTable")
	public Set getPackageTables() {
		return this.packageTables;
	}

	public void setPackageTables(Set packageTables) {
		this.packageTables = packageTables;
	}

}