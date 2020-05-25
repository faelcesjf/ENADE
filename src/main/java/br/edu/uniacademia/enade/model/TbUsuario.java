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
 * @author tassi
 */
@Entity
@Table(name = "tbUsuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsuario.findAll", query = "SELECT t FROM TbUsuario t"),
    @NamedQuery(name = "TbUsuario.findByIdUsuario", query = "SELECT t FROM TbUsuario t WHERE t.idUsuario = :idUsuario"),
    @NamedQuery(name = "TbUsuario.findByNomeUsuario", query = "SELECT t FROM TbUsuario t WHERE t.nomeUsuario = :nomeUsuario"),
    @NamedQuery(name = "TbUsuario.findByEmailUsuario", query = "SELECT t FROM TbUsuario t WHERE t.emailUsuario = :emailUsuario"),
    @NamedQuery(name = "TbUsuario.findBySenhaUsuario", query = "SELECT t FROM TbUsuario t WHERE t.senhaUsuario = :senhaUsuario")})
public class TbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeUsuario")
    private String nomeUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "emailUsuario")
    private String emailUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "senhaUsuario")
    private String senhaUsuario;
    @JoinColumn(name = "tbTipoUsuario_idTipoUsuario", referencedColumnName = "idTipoUsuario")
    @ManyToOne(optional = false)
    private TbTipoUsuario tbTipoUsuarioidTipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbUsuarioidUsuario")
    private List<TbResultado> tbResultadoList;

    public TbUsuario() {
    }

    public TbUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TbUsuario(Long idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public TbTipoUsuario getTbTipoUsuarioidTipoUsuario() {
        return tbTipoUsuarioidTipoUsuario;
    }

    public void setTbTipoUsuarioidTipoUsuario(TbTipoUsuario tbTipoUsuarioidTipoUsuario) {
        this.tbTipoUsuarioidTipoUsuario = tbTipoUsuarioidTipoUsuario;
    }

    @XmlTransient
    public List<TbResultado> getTbResultadoList() {
        return tbResultadoList;
    }

    public void setTbResultadoList(List<TbResultado> tbResultadoList) {
        this.tbResultadoList = tbResultadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuario)) {
            return false;
        }
        TbUsuario other = (TbUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uniacademia.enade.model.TbUsuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
