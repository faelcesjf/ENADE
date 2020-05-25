/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author tassi
 */
@Entity
@Table(name = "tbTipoUsuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTipoUsuario.findAll", query = "SELECT t FROM TbTipoUsuario t"),
    @NamedQuery(name = "TbTipoUsuario.findByIdTipoUsuario", query = "SELECT t FROM TbTipoUsuario t WHERE t.idTipoUsuario = :idTipoUsuario"),
    @NamedQuery(name = "TbTipoUsuario.findByNomeTipoUsuario", query = "SELECT t FROM TbTipoUsuario t WHERE t.nomeTipoUsuario = :nomeTipoUsuario")})
public class TbTipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTipoUsuario")
    private Integer idTipoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "nomeTipoUsuario")
    private String nomeTipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbTipoUsuarioidTipoUsuario")
    private List<TbUsuario> tbUsuarioList;

    public TbTipoUsuario() {
    }

    public TbTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public TbTipoUsuario(Integer idTipoUsuario, String nomeTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
        this.nomeTipoUsuario = nomeTipoUsuario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNomeTipoUsuario() {
        return nomeTipoUsuario;
    }

    public void setNomeTipoUsuario(String nomeTipoUsuario) {
        this.nomeTipoUsuario = nomeTipoUsuario;
    }

    @XmlTransient
    public List<TbUsuario> getTbUsuarioList() {
        return tbUsuarioList;
    }

    public void setTbUsuarioList(List<TbUsuario> tbUsuarioList) {
        this.tbUsuarioList = tbUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoUsuario != null ? idTipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipoUsuario)) {
            return false;
        }
        TbTipoUsuario other = (TbTipoUsuario) object;
        if ((this.idTipoUsuario == null && other.idTipoUsuario != null) || (this.idTipoUsuario != null && !this.idTipoUsuario.equals(other.idTipoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uniacademia.enade.model.TbTipoUsuario[ idTipoUsuario=" + idTipoUsuario + " ]";
    }
    
}
