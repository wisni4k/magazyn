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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wisnia
 */
@Entity
@Table(name = "releaseproducts")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Releaseproducts.findAll", query = "SELECT r FROM Releaseproducts r"),
		@NamedQuery(name = "Releaseproducts.findByReleaseProductsID", query = "SELECT r FROM Releaseproducts r WHERE r.releaseProductsID = :releaseProductsID"),
		@NamedQuery(name = "Releaseproducts.findByQuantity", query = "SELECT r FROM Releaseproducts r WHERE r.quantity = :quantity") })
public class Releaseproducts implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ReleaseProductsID")
	private Integer releaseProductsID;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 6)
	@Column(name = "Quantity")
	private String quantity;
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
	@ManyToOne(optional = false)
	private Products productID;
	@JoinColumn(name = "ReleaseID", referencedColumnName = "ReleaseID")
	@ManyToOne(optional = false)
	private Releasee releaseID;

	public Releaseproducts() {
	}

	public Releaseproducts(Integer releaseProductsID) {
		this.releaseProductsID = releaseProductsID;
	}

	public Releaseproducts(Integer releaseProductsID, String quantity) {
		this.releaseProductsID = releaseProductsID;
		this.quantity = quantity;
	}

	public Integer getReleaseProductsID() {
		return releaseProductsID;
	}

	public void setReleaseProductsID(Integer releaseProductsID) {
		this.releaseProductsID = releaseProductsID;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Products getProductID() {
		return productID;
	}

	public void setProductID(Products productID) {
		this.productID = productID;
	}

	public Releasee getReleaseID() {
		return releaseID;
	}

	public void setReleaseID(Releasee releaseID) {
		this.releaseID = releaseID;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (releaseProductsID != null ? releaseProductsID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Releaseproducts)) {
			return false;
		}
		Releaseproducts other = (Releaseproducts) object;
		if ((this.releaseProductsID == null && other.releaseProductsID != null)
				|| (this.releaseProductsID != null && !this.releaseProductsID.equals(other.releaseProductsID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ENTITY.Releaseproducts[ releaseProductsID=" + releaseProductsID + " ]";
	}

}
