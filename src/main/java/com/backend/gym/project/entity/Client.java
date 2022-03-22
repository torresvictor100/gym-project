package com.backend.gym.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "client")
public class Client {
	
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "numero", unique = false, nullable = false)
	private String numero;
	
	@Column(name = "datepagament", unique = false, nullable = false)
	@Max(value=20)
	@Min(value=1)
	private Integer datePagament;
	
	@Column(name = "lastmouthpaid", unique = false, nullable = false)
	private Integer lastMouthPaid;
	
	
	@Column(name = "currentYear", unique = false, nullable = false)
	private Integer currentYear;
	
	//@JsonFormat(pattern = "dd/MM")
	//@JsonSerialize(using = DateSerializer.class)
	//@JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
	//@Temporal(TemporalType.TIME)
	//@Column(name = "paymentdate", nullable = false)
	//private Date paymentDate;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Integer getDatePagament() {
		return datePagament;
	}


	public void setDatePagament(Integer datePagament) {
		this.datePagament = datePagament;
	}


	public Integer getLastMouthPaid() {
		return lastMouthPaid;
	}


	public void setLastMouthPaid(Integer lastMouthPaid) {
		this.lastMouthPaid = lastMouthPaid;
	}
	
	


	public Integer getcurrentYear() {
		return currentYear;
	}


	public void setcurrentYear(Integer currentYear) {
		this.currentYear = currentYear;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", numero=" + numero + ", datePagament=" + datePagament
				+ ", lastMouthPaid=" + lastMouthPaid + ", yearOfEnrollment=" + currentYear + "]";
	}


	

	
	
	
	
	
	

}
