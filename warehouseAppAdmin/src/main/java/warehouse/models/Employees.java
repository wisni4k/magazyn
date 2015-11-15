/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wisnia
 */
@Entity
@Table(name = "employees")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
		@NamedQuery(name = "Employees.findByEmployeeID", query = "SELECT e FROM Employees e WHERE e.employeeID = :employeeID"),
		@NamedQuery(name = "Employees.findByLastName", query = "SELECT e FROM Employees e WHERE e.lastName = :lastName"),
		@NamedQuery(name = "Employees.findByFirstName", query = "SELECT e FROM Employees e WHERE e.firstName = :firstName"),
		@NamedQuery(name = "Employees.findByBirthDate", query = "SELECT e FROM Employees e WHERE e.birthDate = :birthDate"),
		@NamedQuery(name = "Employees.findByAddress", query = "SELECT e FROM Employees e WHERE e.address = :address"),
		@NamedQuery(name = "Employees.findByCity", query = "SELECT e FROM Employees e WHERE e.city = :city"),
		@NamedQuery(name = "Employees.findByPostCode", query = "SELECT e FROM Employees e WHERE e.postCode = :postCode"),
		@NamedQuery(name = "Employees.findByCountry", query = "SELECT e FROM Employees e WHERE e.country = :country"),
		@NamedQuery(name = "Employees.findByPhone", query = "SELECT e FROM Employees e WHERE e.phone = :phone"),
		@NamedQuery(name = "Employees.findByTitle", query = "SELECT e FROM Employees e WHERE e.title = :title"),
		@NamedQuery(name = "Employees.findByHourlyRate", query = "SELECT e FROM Employees e WHERE e.hourlyRate = :hourlyRate") })
public class Employees implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "EmployeeID")
	private Integer employeeID;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "LastName")
	private String lastName;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "FirstName")
	private String firstName;
	@Basic(optional = false)
	@NotNull
	@Column(name = "BirthDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthDate;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "Address")
	private String address;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "City")
	private String city;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "PostCode")
	private String postCode;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "Country")
	private String country;
	// @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
	// message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the
	// field contains phone or fax number consider using this annotation to
	// enforce field validation
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "Phone")
	private String phone;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "Title")
	private String title;
	@Basic(optional = false)
	@NotNull
	@Column(name = "HourlyRate")
	private int hourlyRate;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeID")
	private Collection<Salaries> salariesCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeID")
	private Collection<Releasee> releaseeCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeID")
	private Collection<Deliveries> deliveriesCollection;

	public Employees() {
	}

	public Employees(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public Employees(Integer employeeID, String lastName, String firstName, Date birthDate, String address, String city,
			String postCode, String country, String phone, String title, int hourlyRate) {
		this.employeeID = employeeID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.address = address;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
		this.phone = phone;
		this.title = title;
		this.hourlyRate = hourlyRate;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	@XmlTransient
	public Collection<Salaries> getSalariesCollection() {
		return salariesCollection;
	}

	public void setSalariesCollection(Collection<Salaries> salariesCollection) {
		this.salariesCollection = salariesCollection;
	}

	@XmlTransient
	public Collection<Releasee> getReleaseeCollection() {
		return releaseeCollection;
	}

	public void setReleaseeCollection(Collection<Releasee> releaseeCollection) {
		this.releaseeCollection = releaseeCollection;
	}

	@XmlTransient
	public Collection<Deliveries> getDeliveriesCollection() {
		return deliveriesCollection;
	}

	public void setDeliveriesCollection(Collection<Deliveries> deliveriesCollection) {
		this.deliveriesCollection = deliveriesCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (employeeID != null ? employeeID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Employees)) {
			return false;
		}
		Employees other = (Employees) object;
		if ((this.employeeID == null && other.employeeID != null)
				|| (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ENTITY.Employees[ employeeID=" + employeeID + " ]";
	}

}
