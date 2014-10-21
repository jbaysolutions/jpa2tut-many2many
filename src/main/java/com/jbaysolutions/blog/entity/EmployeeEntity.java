/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbaysolutions.blog.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rui
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeEntity.findAll", query = "SELECT e FROM EmployeeEntity e"),
    @NamedQuery(name = "EmployeeEntity.findByIdemployee", query = "SELECT e FROM EmployeeEntity e WHERE e.idemployee = :idemployee"),
    @NamedQuery(name = "EmployeeEntity.findByName", query = "SELECT e FROM EmployeeEntity e WHERE e.name = :name"),
    @NamedQuery(name = "EmployeeEntity.findByPhone", query = "SELECT e FROM EmployeeEntity e WHERE e.phone = :phone")})
public class EmployeeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idemployee")
    private Integer idemployee;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @JoinColumn(name = "company", referencedColumnName = "idcompany")
    @ManyToOne(optional = false)
    private CompanyEntity company;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Integer idemployee) {
        this.idemployee = idemployee;
    }

    public EmployeeEntity(Integer idemployee, String name, String phone) {
        this.idemployee = idemployee;
        this.name = name;
        this.phone = phone;
    }

    public Integer getIdemployee() {
        return idemployee;
    }

    public void setIdemployee(Integer idemployee) {
        this.idemployee = idemployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idemployee != null ? idemployee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeEntity)) {
            return false;
        }
        EmployeeEntity other = (EmployeeEntity) object;
        if ((this.idemployee == null && other.idemployee != null) || (this.idemployee != null && !this.idemployee.equals(other.idemployee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "syshex.tutorials.jpa2.tut3.entity.EmployeeEntity[ idemployee=" + idemployee + " ]";
    }
    
}
