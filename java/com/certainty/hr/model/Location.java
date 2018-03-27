package com.certainty.hr.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model class to represent Locations
 * 
 */
@Entity
@Table(name = "location")
public class Location implements Comparable<Location>, java.io.Serializable {
	private static final long serialVersionUID = -5137155812920652840L;
	private Integer locationId;
	private String stateName;
	private String cityName;
	private String locationDesc;
	private String countryName;
	private String floorNumber;
	private String zone;
	private String office;
	private Set<EmpDetail> empDetails = new HashSet<EmpDetail>(0);

	public Location() {
	}

	public Location(String stateName, String cityName, String countryName, String floorNumber, String zone,
			String office) {
		this.stateName = stateName;
		this.cityName = cityName;
		this.countryName = countryName;
		this.floorNumber = floorNumber;
		this.zone = zone;
		this.office = office;
	}

	public Location(String stateName, String cityName, String locationDesc, String countryName, String floorNumber,
			String zone, String office, Set<EmpDetail> empDetails) {
		this.stateName = stateName;
		this.cityName = cityName;
		this.locationDesc = locationDesc;
		this.countryName = countryName;
		this.floorNumber = floorNumber;
		this.zone = zone;
		this.office = office;
		this.empDetails = empDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "location_id", unique = true, nullable = false)
	public Integer getLocationId() {
		return this.locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	@Column(name = "state_name", nullable = false, length = 32)
	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Column(name = "city_name", nullable = false, length = 32)
	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Column(name = "location_desc", length = 256)
	public String getLocationDesc() {
		return this.locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	@Column(name = "country_name", nullable = false, length = 32)
	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Column(name = "floor_number", nullable = false, length = 16)
	public String getFloorNumber() {
		return this.floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	@Column(name = "zone", nullable = false, length = 32)
	public String getZone() {
		return this.zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	@Column(name = "office", nullable = false, length = 32)
	public String getOffice() {
		return this.office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "location")
	@JsonIgnore
	public Set<EmpDetail> getEmpDetails() {
		return this.empDetails;
	}

	public void setEmpDetails(Set<EmpDetail> empDetails) {
		this.empDetails = empDetails;
	}

	@Override
	public int compareTo(Location comparedObject) {
		return this.getOffice().compareToIgnoreCase(comparedObject.getOffice());
	}
}
