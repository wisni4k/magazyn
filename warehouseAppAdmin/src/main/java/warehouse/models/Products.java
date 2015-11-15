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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wisnia
 */
@Entity
@Table(name = "products")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
		@NamedQuery(name = "Products.findByProductID", query = "SELECT p FROM Products p WHERE p.productID = :productID"),
		@NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName = :productName"),
		@NamedQuery(name = "Products.findByQuantity", query = "SELECT p FROM Products p WHERE p.quantity = :quantity"),
		@NamedQuery(name = "Products.findByPricePerPalletPerDay", query = "SELECT p FROM Products p WHERE p.pricePerPalletPerDay = :pricePerPalletPerDay"),
		@NamedQuery(name = "Products.findByStatus", query = "SELECT p FROM Products p WHERE p.status = :status") })
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ProductID")
	private Integer productID;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "ProductName")
	private String productName;
	@Basic(optional = false)
	@NotNull
	@Column(name = "Quantity")
	private int quantity;
	@Basic(optional = false)
	@NotNull
	@Column(name = "PricePerPalletPerDay")
	private int pricePerPalletPerDay;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "Status")
	private String status;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
	private Collection<Deliveryproducts> deliveryproductsCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
	private Collection<Invoiceproducts> invoiceproductsCollection;
	@JoinColumn(name = "DeliveryID", referencedColumnName = "DeliveryID")
	@ManyToOne(optional = false)
	private Deliveries deliveryID;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
	private Collection<Releaseproducts> releaseproductsCollection;

	public Products() {
	}

	public Products(Integer productID) {
		this.productID = productID;
	}

	public Products(Integer productID, String productName, int quantity, int pricePerPalletPerDay, String status) {
		this.productID = productID;
		this.productName = productName;
		this.quantity = quantity;
		this.pricePerPalletPerDay = pricePerPalletPerDay;
		this.status = status;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPricePerPalletPerDay() {
		return pricePerPalletPerDay;
	}

	public void setPricePerPalletPerDay(int pricePerPalletPerDay) {
		this.pricePerPalletPerDay = pricePerPalletPerDay;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlTransient
	public Collection<Deliveryproducts> getDeliveryproductsCollection() {
		return deliveryproductsCollection;
	}

	public void setDeliveryproductsCollection(Collection<Deliveryproducts> deliveryproductsCollection) {
		this.deliveryproductsCollection = deliveryproductsCollection;
	}

	@XmlTransient
	public Collection<Invoiceproducts> getInvoiceproductsCollection() {
		return invoiceproductsCollection;
	}

	public void setInvoiceproductsCollection(Collection<Invoiceproducts> invoiceproductsCollection) {
		this.invoiceproductsCollection = invoiceproductsCollection;
	}

	public Deliveries getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(Deliveries deliveryID) {
		this.deliveryID = deliveryID;
	}

	@XmlTransient
	public Collection<Releaseproducts> getReleaseproductsCollection() {
		return releaseproductsCollection;
	}

	public void setReleaseproductsCollection(Collection<Releaseproducts> releaseproductsCollection) {
		this.releaseproductsCollection = releaseproductsCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (productID != null ? productID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Products)) {
			return false;
		}
		Products other = (Products) object;
		if ((this.productID == null && other.productID != null)
				|| (this.productID != null && !this.productID.equals(other.productID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ENTITY.Products[ productID=" + productID + " ]";
	}

}
