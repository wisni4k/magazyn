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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wisnia
 */
@Entity
@Table(name = "releasee")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Releasee.findAll", query = "SELECT r FROM Releasee r"),
		@NamedQuery(name = "Releasee.findByReleaseID", query = "SELECT r FROM Releasee r WHERE r.releaseID = :releaseID"),
		@NamedQuery(name = "Releasee.findByDataaRelease", query = "SELECT r FROM Releasee r WHERE r.dataaRelease = :dataaRelease"),
		@NamedQuery(name = "Releasee.findByDriverName", query = "SELECT r FROM Releasee r WHERE r.driverName = :driverName"),
		@NamedQuery(name = "Releasee.findByPhone", query = "SELECT r FROM Releasee r WHERE r.phone = :phone"),
		@NamedQuery(name = "Releasee.findByVehiclePlate", query = "SELECT r FROM Releasee r WHERE r.vehiclePlate = :vehiclePlate"),
		@NamedQuery(name = "Releasee.findByRoadrailerPlate", query = "SELECT r FROM Releasee r WHERE r.roadrailerPlate = :roadrailerPlate") })
public class Releasee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ReleaseID")
	private Integer releaseID;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DataaRelease")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataaRelease;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "DriverName")
	private String driverName;
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
	@Size(min = 1, max = 15)
	@Column(name = "VehiclePlate")
	private String vehiclePlate;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "RoadrailerPlate")
	private String roadrailerPlate;
	@JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
	@ManyToOne(optional = false)
	private Customers customerID;
	@JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
	@ManyToOne(optional = false)
	private Employees employeeID;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "releaseID")
	private Collection<Releaseproducts> releaseproductsCollection;

	public Releasee() {
	}

	public Releasee(Integer releaseID) {
		this.releaseID = releaseID;
	}

	public Releasee(Integer releaseID, Date dataaRelease, String driverName, String phone, String vehiclePlate,
			String roadrailerPlate) {
		this.releaseID = releaseID;
		this.dataaRelease = dataaRelease;
		this.driverName = driverName;
		this.phone = phone;
		this.vehiclePlate = vehiclePlate;
		this.roadrailerPlate = roadrailerPlate;
	}

	public Integer getReleaseID() {
		return releaseID;
	}

	public void setReleaseID(Integer releaseID) {
		this.releaseID = releaseID;
	}

	public Date getDataaRelease() {
		return dataaRelease;
	}

	public void setDataaRelease(Date dataaRelease) {
		this.dataaRelease = dataaRelease;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getVehiclePlate() {
		return vehiclePlate;
	}

	public void setVehiclePlate(String vehiclePlate) {
		this.vehiclePlate = vehiclePlate;
	}

	public String getRoadrailerPlate() {
		return roadrailerPlate;
	}

	public void setRoadrailerPlate(String roadrailerPlate) {
		this.roadrailerPlate = roadrailerPlate;
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
	public Collection<Releaseproducts> getReleaseproductsCollection() {
		return releaseproductsCollection;
	}

	public void setReleaseproductsCollection(Collection<Releaseproducts> releaseproductsCollection) {
		this.releaseproductsCollection = releaseproductsCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (releaseID != null ? releaseID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Releasee)) {
			return false;
		}
		Releasee other = (Releasee) object;
		if ((this.releaseID == null && other.releaseID != null)
				|| (this.releaseID != null && !this.releaseID.equals(other.releaseID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ENTITY.Releasee[ releaseID=" + releaseID + " ]";
	}

}
