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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wisnia
 */
@Entity
@Table(name = "deliveries")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Deliveries.findAll", query = "SELECT d FROM Deliveries d"),
		@NamedQuery(name = "Deliveries.findByDeliveryID", query = "SELECT d FROM Deliveries d WHERE d.deliveryID = :deliveryID"),
		@NamedQuery(name = "Deliveries.findByDateDelivery", query = "SELECT d FROM Deliveries d WHERE d.dateDelivery = :dateDelivery") })
public class Deliveries implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "DeliveryID")
	private Integer deliveryID;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DateDelivery")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDelivery;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryID")
	private Collection<Deliveryproducts> deliveryproductsCollection;
	@JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
	@ManyToOne(optional = false)
	private Customers customerID;
	@JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
	@ManyToOne(optional = false)
	private Employees employeeID;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryID")
	private Collection<Products> productsCollection;

	public Deliveries() {
	}

	public Deliveries(Integer deliveryID) {
		this.deliveryID = deliveryID;
	}

	public Deliveries(Integer deliveryID, Date dateDelivery) {
		this.deliveryID = deliveryID;
		this.dateDelivery = dateDelivery;
	}

	public Integer getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(Integer deliveryID) {
		this.deliveryID = deliveryID;
	}

	public Date getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(Date dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	@XmlTransient
	public Collection<Deliveryproducts> getDeliveryproductsCollection() {
		return deliveryproductsCollection;
	}

	public void setDeliveryproductsCollection(Collection<Deliveryproducts> deliveryproductsCollection) {
		this.deliveryproductsCollection = deliveryproductsCollection;
	}

	public Customers getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Customers customerID) {
		this.customerID = customerID;
	}

	public Employees getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Employees employeeID) {
		this.employeeID = employeeID;
	}

	@XmlTransient
	public Collection<Products> getProductsCollection() {
		return productsCollection;
	}

	public void setProductsCollection(Collection<Products> productsCollection) {
		this.productsCollection = productsCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (deliveryID != null ? deliveryID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Deliveries)) {
			return false;
		}
		Deliveries other = (Deliveries) object;
		if ((this.deliveryID == null && other.deliveryID != null)
				|| (this.deliveryID != null && !this.deliveryID.equals(other.deliveryID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ENTITY.Deliveries[ deliveryID=" + deliveryID + " ]";
	}

}
