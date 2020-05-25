/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "tbQuestao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbQuestao.findAll", query = "SELECT t FROM TbQuestao t"),
    @NamedQuery(name = "TbQuestao.findByIdQuestao", query = "SELECT t FROM TbQuestao t WHERE t.idQuestao = :idQuestao"),
    @NamedQuery(name = "TbQuestao.findByDescricaoQuestao", query = "SELECT t FROM TbQuestao t WHERE t.descricaoQuestao = :descricaoQuestao"),
    @NamedQuery(name = "TbQuestao.findByAlternativaA", query = "SELECT t FROM TbQuestao t WHERE t.alternativaA = :alternativaA"),
    @NamedQuery(name = "TbQuestao.findByAlternativaB", query = "SELECT t FROM TbQuestao t WHERE t.alternativaB = :alternativaB"),
    @NamedQuery(name = "TbQuestao.findByAlternativaC", query = "SELECT t FROM TbQuestao t WHERE t.alternativaC = :alternativaC"),
    @NamedQuery(name = "TbQuestao.findByAlternativaD", query = "SELECT t FROM TbQuestao t WHERE t.alternativaD = :alternativaD"),
    @NamedQuery(name = "TbQuestao.findByAlternativaE", query = "SELECT t FROM TbQuestao t WHERE t.alternativaE = :alternativaE"),
    @NamedQuery(name = "TbQuestao.findByQuestaoCorreta", query = "SELECT t FROM TbQuestao t WHERE t.questaoCorreta = :questaoCorreta"),
    @NamedQuery(name = "TbQuestao.findByEstadoQuestao", query = "SELECT t FROM TbQuestao t WHERE t.estadoQuestao = :estadoQuestao")})
public class TbQuestao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idQuestao")
    private Integer idQuestao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricaoQuestao")
    private String descricaoQuestao;
    @Size(max = 45)
    @Column(name = "alternativaA")
    private String alternativaA;
    @Size(max = 45)
    @Column(name = "alternativaB")
    private String alternativaB;
    @Size(max = 45)
    @Column(name = "alternativaC")
    private String alternativaC;
    @Size(max = 45)
    @Column(name = "alternativaD")
    private String alternativaD;
    @Size(max = 45)
    @Column(name = "alternativaE")
    private String alternativaE;
    @Column(name = "questaoCorreta")
    private Character questaoCorreta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoQuestao")
    private short estadoQuestao;
    @ManyToMany(mappedBy = "tbQuestaoList")
    private List<TbProva> tbProvaList;
    @JoinColumn(name = "tbTipoQuestao_idTipoQuestao", referencedColumnName = "idTipoQuestao")
    @ManyToOne(optional = false)
    private TbTipoQuestao tbTipoQuestaoidTipoQuestao;

    public TbQuestao() {
    }

    public TbQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public TbQuestao(Integer idQuestao, String descricaoQuestao, short estadoQuestao) {
        this.idQuestao = idQuestao;
        this.descricaoQuestao = descricaoQuestao;
        this.estadoQuestao = estadoQuestao;
    }

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getDescricaoQuestao() {
        return descricaoQuestao;
    }

    public void setDescricaoQuestao(String descricaoQuestao) {
        this.descricaoQuestao = descricaoQuestao;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public String getAlternativaE() {
        return alternativaE;
    }

    public void setAlternativaE(String alternativaE) {
        this.alternativaE = alternativaE;
    }

    public Character getQuestaoCorreta() {
        return questaoCorreta;
    }

    public void setQuestaoCorreta(Character questaoCorreta) {
        this.questaoCorreta = questaoCorreta;
    }

    public short getEstadoQuestao() {
        return estadoQuestao;
    }

    public void setEstadoQuestao(short estadoQuestao) {
        this.estadoQuestao = estadoQuestao;
    }

    @XmlTransient
    public List<TbProva> getTbProvaList() {
        return tbProvaList;
    }

    public void setTbProvaList(List<TbProva> tbProvaList) {
        this.tbProvaList = tbProvaList;
    }

    public TbTipoQuestao getTbTipoQuestaoidTipoQuestao() {
        return tbTipoQuestaoidTipoQuestao;
    }

    public void setTbTipoQuestaoidTipoQuestao(TbTipoQuestao tbTipoQuestaoidTipoQuestao) {
        this.tbTipoQuestaoidTipoQuestao = tbTipoQuestaoidTipoQuestao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestao != null ? idQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbQuestao)) {
            return false;
        }
        TbQuestao other = (TbQuestao) object;
        if ((this.idQuestao == null && other.idQuestao != null) || (this.idQuestao != null && !this.idQuestao.equals(other.idQuestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uniacademia.enade.model.TbQuestao[ idQuestao=" + idQuestao + " ]";
    }
    
}
