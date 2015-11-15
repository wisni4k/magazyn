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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wisnia
 */
@Entity
@Table(name = "invoices")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Invoices.findAll", query = "SELECT i FROM Invoices i"),
		@NamedQuery(name = "Invoices.findByInvoiceID", query = "SELECT i FROM Invoices i WHERE i.invoiceID = :invoiceID"),
		@NamedQuery(name = "Invoices.findByPrice", query = "SELECT i FROM Invoices i WHERE i.price = :price") })
public class Invoices implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "InvoiceID")
	private Integer invoiceID;
	@Basic(optional = false)
	@NotNull
	@Column(name = "Price")
	private int price;
	@JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
	@ManyToOne(optional = false)
	private Customers customerID;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "invoiceID")
	private Collection<Invoiceproducts> invoiceproductsCollection;

	public Invoices() {
	}

	public Invoices(Integer invoiceID) {
		this.invoiceID = invoiceID;
	}

	public Invoices(Integer invoiceID, int price) {
		this.invoiceID = invoiceID;
		this.price = price;
	}

	public Integer getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(Integer invoiceID) {
		this.invoiceID = invoiceID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Customers getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Customers customerID) {
		this.customerID = customerID;
	}

	@XmlTransient
	public Collection<Invoiceproducts> getInvoiceproductsCollection() {
		return invoiceproductsCollection;
	}

	public void setInvoiceproductsCollection(Collection<Invoiceproducts> invoiceproductsCollection) {
		this.invoiceproductsCollection = invoiceproductsCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (invoiceID != null ? invoiceID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Invoices)) {
			return false;
		}
		Invoices other = (Invoices) object;
		if ((this.invoiceID == null && other.invoiceID != null)
				|| (this.invoiceID != null && !this.invoiceID.equals(other.invoiceID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ENTITY.Invoices[ invoiceID=" + invoiceID + " ]";
	}

}
