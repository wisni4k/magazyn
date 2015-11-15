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
@Table(name = "deliveryproducts")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Deliveryproducts.findAll", query = "SELECT d FROM Deliveryproducts d"),
		@NamedQuery(name = "Deliveryproducts.findByDeliveryProductsID", query = "SELECT d FROM Deliveryproducts d WHERE d.deliveryProductsID = :deliveryProductsID"),
		@NamedQuery(name = "Deliveryproducts.findByQuantity", query = "SELECT d FROM Deliveryproducts d WHERE d.quantity = :quantity") })
public class Deliveryproducts implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "DeliveryProductsID")
	private Integer deliveryProductsID;
	@Basic(optional = false)
	@NotNull
	@Column(name = "Quantity")
	private int quantity;
	@JoinColumn(name = "DeliveryID", referencedColumnName = "DeliveryID")
	@ManyToOne(optional = false)
	private Deliveries deliveryID;
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
	@ManyToOne(optional = false)
	private Products productID;

	public Deliveryproducts() {
	}

	public Deliveryproducts(Integer deliveryProductsID) {
		this.deliveryProductsID = deliveryProductsID;
	}

	public Deliveryproducts(Integer deliveryProductsID, int quantity) {
		this.deliveryProductsID = deliveryProductsID;
		this.quantity = quantity;
	}

	public Integer getDeliveryProductsID() {
		return deliveryProductsID;
	}

	public void setDeliveryProductsID(Integer deliveryProductsID) {
		this.deliveryProductsID = deliveryProductsID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Deliveries getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(Deliveries deliveryID) {
		this.deliveryID = deliveryID;
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
		hash += (deliveryProductsID != null ? deliveryProductsID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Deliveryproducts)) {
			return false;
		}
		Deliveryproducts other = (Deliveryproducts) object;
		if ((this.deliveryProductsID == null && other.deliveryProductsID != null)
				|| (this.deliveryProductsID != null && !this.deliveryProductsID.equals(other.deliveryProductsID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ENTITY.Deliveryproducts[ deliveryProductsID=" + deliveryProductsID + " ]";
	}

}
