/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jbaysolutions.blog.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rui
 */
@Entity
@Table(name = "client")
public class ClientEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclient")
    private Integer idclient;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    
    @ManyToMany(mappedBy = "clientCollection")
    private Collection<CompanyEntity> companyCollection;

    public ClientEntity() {
    }

    public ClientEntity(Integer idclient) {
        this.idclient = idclient;
    }

    public ClientEntity(Integer idclient, String name) {
        this.idclient = idclient;
        this.name = name;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
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
    public Collection<CompanyEntity> getCompanyCollection() {
        return companyCollection;
    }

    public void setCompanyCollection(Collection<CompanyEntity> companyCollection) {
        this.companyCollection = companyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclient != null ? idclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientEntity)) {
            return false;
        }
        ClientEntity other = (ClientEntity) object;
        if ((this.idclient == null && other.idclient != null) || (this.idclient != null && !this.idclient.equals(other.idclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "syshex.tutorials.jpa2.tut3.entity.ClientEntity[ idclient=" + idclient + " ]";
    }
    
}
