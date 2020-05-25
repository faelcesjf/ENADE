/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tassi
 */
@Entity
@Table(name = "tbProva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProva.findAll", query = "SELECT t FROM TbProva t"),
    @NamedQuery(name = "TbProva.findByIdProva", query = "SELECT t FROM TbProva t WHERE t.idProva = :idProva"),
    @NamedQuery(name = "TbProva.findByDataProva", query = "SELECT t FROM TbProva t WHERE t.dataProva = :dataProva")})
public class TbProva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProva")
    private Integer idProva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataProva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataProva;
    @JoinTable(name = "tbProva_has_tbQuestao", joinColumns = {
        @JoinColumn(name = "tbProva_idProva", referencedColumnName = "idProva")}, inverseJoinColumns = {
        @JoinColumn(name = "tbQuestao_idQuestao", referencedColumnName = "idQuestao")})
    @ManyToMany
    private List<TbQuestao> tbQuestaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbProvaidProva")
    private List<TbResultado> tbResultadoList;

    public TbProva() {
    }

    public TbProva(Integer idProva) {
        this.idProva = idProva;
    }

    public TbProva(Integer idProva, Date dataProva) {
        this.idProva = idProva;
        this.dataProva = dataProva;
    }

    public Integer getIdProva() {
        return idProva;
    }

    public void setIdProva(Integer idProva) {
        this.idProva = idProva;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }

    @XmlTransient
    public List<TbQuestao> getTbQuestaoList() {
        return tbQuestaoList;
    }

    public void setTbQuestaoList(List<TbQuestao> tbQuestaoList) {
        this.tbQuestaoList = tbQuestaoList;
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
        hash += (idProva != null ? idProva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProva)) {
            return false;
        }
        TbProva other = (TbProva) object;
        if ((this.idProva == null && other.idProva != null) || (this.idProva != null && !this.idProva.equals(other.idProva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uniacademia.enade.model.TbProva[ idProva=" + idProva + " ]";
    }
    
}
