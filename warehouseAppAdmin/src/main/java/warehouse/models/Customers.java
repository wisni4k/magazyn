/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wisnia
 */
@Entity
@Table(name = "customers")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c"),
		@NamedQuery(name = "Customers.findByCustomerID", query = "SELECT c FROM Customers c WHERE c.customerID = :customerID"),
		@NamedQuery(name = "Customers.findByCompanyName", query = "SELECT c FROM Customers c WHERE c.companyName = :companyName"),
		@NamedQuery(name = "Customers.findByContactName", query = "SELECT c FROM Customers c WHERE c.contactName = :contactName"),
		@NamedQuery(name = "Customers.findByAddress", query = "SELECT c FROM Customers c WHERE c.address = :address"),
		@NamedQuery(name = "Customers.findByCity", query = "SELECT c FROM Customers c WHERE c.city = :city"),
		@NamedQuery(name = "Customers.findByPostCode", query = "SELECT c FROM Customers c WHERE c.postCode = :postCode"),
		@NamedQuery(name = "Customers.findByCountry", query = "SELECT c FROM Customers c WHERE c.country = :country"),
		@NamedQuery(name = "Customers.findByPhone", query = "SELECT c FROM Customers c WHERE c.phone = :phone"),
		@NamedQuery(name = "Customers.findByFax", query = "SELECT c FROM Customers c WHERE c.fax = :fax") })
public class Customers implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 6)
	@Column(name = "CustomerID")
	private String customerID;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "CompanyName")
	private String companyName;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "ContactName")
	private String contactName;
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
	// @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
	// message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the
	// field contains phone or fax number consider using this annotation to
	// enforce field validation
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "Fax")
	private String fax;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
	private Collection<Invoices> invoicesCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
	private Collection<Releasee> releaseeCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
	private Collection<Deliveries> deliveriesCollection;

	public Customers() {
	}

	public Customers(String customerID) {
		this.customerID = customerID;
	}

	public Customers(String customerID, String companyName, String contactName, String address, String city,
			String postCode, String country, String phone, String fax) {
		this.customerID = customerID;
		this.companyName = companyName;
		this.contactName = contactName;
		this.address = address;
		this.city = city;
		this.postCode = postCode;
		this.country = country;
		this.phone = phone;
		this.fax = fax;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
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

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@XmlTransient
	public Collection<Invoices> getInvoicesCollection() {
		return invoicesCollection;
	}

	public void setInvoicesCollection(Collection<Invoices> invoicesCollection) {
		this.invoicesCollection = invoicesCollection;
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
		hash += (customerID != null ? customerID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Customers)) {
			return false;
		}
		Customers other = (Customers) object;
		if ((this.customerID == null && other.customerID != null)
				|| (this.customerID != null && !this.customerID.equals(other.customerID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ENTITY.Customers[ customerID=" + customerID + " ]";
	}

}
