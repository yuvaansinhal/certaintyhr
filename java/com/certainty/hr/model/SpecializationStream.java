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
 * Model class to represent SpecializationStream
 * 
 */

@Entity
@Table(name = "specialization_stream")
public class SpecializationStream implements Comparable<SpecializationStream>, java.io.Serializable {

	private static final long serialVersionUID = 1204058573868514108L;
	private Integer streamId;
	private String streamName;
	private String streamDesc;
	private Set<EmpEducationDetail> empEducationDetails = new HashSet<EmpEducationDetail>(0);

	public SpecializationStream() {
	}

	public SpecializationStream(String streamName) {
		this.streamName = streamName;
	}

	public SpecializationStream(String streamName, String streamDesc, Set<EmpEducationDetail> empEducationDetails) {
		this.streamName = streamName;
		this.streamDesc = streamDesc;
		this.empEducationDetails = empEducationDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "stream_id", unique = true, nullable = false)
	public Integer getStreamId() {
		return this.streamId;
	}

	public void setStreamId(Integer streamId) {
		this.streamId = streamId;
	}

	@Column(name = "stream_name", nullable = false, length = 64)
	public String getStreamName() {
		return this.streamName;
	}

	public void setStreamName(String streamName) {
		this.streamName = streamName;
	}

	@Column(name = "stream_desc", length = 256)
	public String getStreamDesc() {
		return this.streamDesc;
	}

	public void setStreamDesc(String streamDesc) {
		this.streamDesc = streamDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "specializationStream")
	@JsonIgnore
	public Set<EmpEducationDetail> getEmpEducationDetails() {
		return this.empEducationDetails;
	}

	public void setEmpEducationDetails(Set<EmpEducationDetail> empEducationDetails) {
		this.empEducationDetails = empEducationDetails;
	}

	@Override
	public int compareTo(SpecializationStream comparedObject) {
		return this.getStreamName().compareToIgnoreCase(comparedObject.getStreamName());
	}
}
