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
@Table(name = "salaries")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Salaries.findAll", query = "SELECT s FROM Salaries s"),
		@NamedQuery(name = "Salaries.findBySalariesID", query = "SELECT s FROM Salaries s WHERE s.salariesID = :salariesID"),
		@NamedQuery(name = "Salaries.findByMounth", query = "SELECT s FROM Salaries s WHERE s.mounth = :mounth"),
		@NamedQuery(name = "Salaries.findByNumberOfHours", query = "SELECT s FROM Salaries s WHERE s.numberOfHours = :numberOfHours"),
		@NamedQuery(name = "Salaries.findBySalaryBrutto", query = "SELECT s FROM Salaries s WHERE s.salaryBrutto = :salaryBrutto"),
		@NamedQuery(name = "Salaries.findBySalaryNetto", query = "SELECT s FROM Salaries s WHERE s.salaryNetto = :salaryNetto"),
		@NamedQuery(name = "Salaries.findByBankAccountNumber", query = "SELECT s FROM Salaries s WHERE s.bankAccountNumber = :bankAccountNumber") })
public class Salaries implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "SalariesID")
	private Integer salariesID;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "Mounth")
	private String mounth;
	@Basic(optional = false)
	@NotNull
	@Column(name = "NumberOfHours")
	private int numberOfHours;
	@Basic(optional = false)
	@NotNull
	@Column(name = "SalaryBrutto")
	private int salaryBrutto;
	@Basic(optional = false)
	@NotNull
	@Column(name = "SalaryNetto")
	private int salaryNetto;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "BankAccountNumber")
	private String bankAccountNumber;
	@JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
	@ManyToOne(optional = false)
	private Employees employeeID;

	public Salaries() {
	}

	public Salaries(Integer salariesID) {
		this.salariesID = salariesID;
	}

	public Salaries(Integer salariesID, String mounth, int numberOfHours, int salaryBrutto, int salaryNetto,
			String bankAccountNumber) {
		this.salariesID = salariesID;
		this.mounth = mounth;
		this.numberOfHours = numberOfHours;
		this.salaryBrutto = salaryBrutto;
		this.salaryNetto = salaryNetto;
		this.bankAccountNumber = bankAccountNumber;
	}

	public Integer getSalariesID() {
		return salariesID;
	}

	public void setSalariesID(Integer salariesID) {
		this.salariesID = salariesID;
	}

	public String getMounth() {
		return mounth;
	}

	public void setMounth(String mounth) {
		this.mounth = mounth;
	}

	public int getNumberOfHours() {
		return numberOfHours;
	}

	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	public int getSalaryBrutto() {
		return salaryBrutto;
	}

	public void setSalaryBrutto(int salaryBrutto) {
		this.salaryBrutto = salaryBrutto;
	}

	public int getSalaryNetto() {
		return salaryNetto;
	}

	public void setSalaryNetto(int salaryNetto) {
		this.salaryNetto = salaryNetto;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public Employees getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Employees employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (salariesID != null ? salariesID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Salaries)) {
			return false;
		}
		Salaries other = (Salaries) object;
		if ((this.salariesID == null && other.salariesID != null)
				|| (this.salariesID != null && !this.salariesID.equals(other.salariesID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ENTITY.Salaries[ salariesID=" + salariesID + " ]";
	}

}
