/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbaysolutions.blog.entity;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rui
 */
@Entity
@Table(name = "company")
public class CompanyEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcompany")
    private Integer idcompany;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    
    @JoinTable
        (name = "company_has_client"
            , 
            joinColumns = { 
                @JoinColumn(name = "company_idcompany", referencedColumnName = "idcompany")
            }, 
            inverseJoinColumns = { 
                @JoinColumn(name = "client_idclient", referencedColumnName = "idclient")
            }
        )
    @ManyToMany
    private Collection<ClientEntity> clientCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Collection<EmployeeEntity> employeeCollection;

    public CompanyEntity() {
    }

    public CompanyEntity(Integer idcompany) {
        this.idcompany = idcompany;
    }

    public CompanyEntity(Integer idcompany, String name, String address) {
        this.idcompany = idcompany;
        this.name = name;
        this.address = address;
    }

    public Integer getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(Integer idcompany) {
        this.idcompany = idcompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<ClientEntity> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<ClientEntity> clientEntityCollection) {
        this.clientCollection = clientEntityCollection;
    }

    @XmlTransient
    public Collection<EmployeeEntity> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<EmployeeEntity> employeeEntityCollection) {
        this.employeeCollection = employeeEntityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompany != null ? idcompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyEntity)) {
            return false;
        }
        CompanyEntity other = (CompanyEntity) object;
        if ((this.idcompany == null && other.idcompany != null) || (this.idcompany != null && !this.idcompany.equals(other.idcompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "syshex.tutorials.jpa2.tut3.entity.CompanyEntity[ idcompany=" + idcompany + " ]";
    }
    
}
