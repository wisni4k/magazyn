/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wisnia
 */
@Entity
@Table(name = "invoiceproducts")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Invoiceproducts.findAll", query = "SELECT i FROM Invoiceproducts i"),
		@NamedQuery(name = "Invoiceproducts.findByInvoiceProductsID", query = "SELECT i FROM Invoiceproducts i WHERE i.invoiceProductsID = :invoiceProductsID"),
		@NamedQuery(name = "Invoiceproducts.findByQuantity", query = "SELECT i FROM Invoiceproducts i WHERE i.quantity = :quantity"),
		@NamedQuery(name = "Invoiceproducts.findByPrice", query = "SELECT i FROM Invoiceproducts i WHERE i.price = :price") })
public class Invoiceproducts implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "InvoiceProductsID")
	private Integer invoiceProductsID;
	@Basic(optional = false)
	@NotNull
	@Column(name = "Quantity")
	private int quantity;
	@Basic(optional = false)
	@NotNull
	@Column(name = "Price")
	private int price;
	@JoinColumn(name = "InvoiceID", referencedColumnName = "InvoiceID")
	@ManyToOne(optional = false)
	private Invoices invoiceID;
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
	@ManyToOne(optional = false)
	private Products productID;

	public Invoiceproducts() {
	}

	public Invoiceproducts(Integer invoiceProductsID) {
		this.invoiceProductsID = invoiceProductsID;
	}

	public Invoiceproducts(Integer invoiceProductsID, int quantity, int price) {
		this.invoiceProductsID = invoiceProductsID;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getInvoiceProductsID() {
		return invoiceProductsID;
	}

	public void setInvoiceProductsID(Integer invoiceProductsID) {
		this.invoiceProductsID = invoiceProductsID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Invoices getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(Invoices invoiceID) {
		this.invoiceID = invoiceID;
	}

	public Products getProductID() {
		return productID;
	}

	public void setProductID(Products productID) {
		this.productID = productID;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (invoiceProductsID != null ? invoiceProductsID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Invoiceproducts)) {
			return false;
		}
		Invoiceproducts other = (Invoiceproducts) object;
		if ((this.invoiceProductsID == null && other.invoiceProductsID != null)
				|| (this.invoiceProductsID != null && !this.invoiceProductsID.equals(other.invoiceProductsID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ENTITY.Invoiceproducts[ invoiceProductsID=" + invoiceProductsID + " ]";
	}

}
