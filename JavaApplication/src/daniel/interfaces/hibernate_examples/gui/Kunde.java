/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daniel.interfaces.hibernate_examples.gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author dan
 */
@Entity
@Table(name = "kunde", catalog = "bestell_db", schema = "")
@NamedQueries({
    @NamedQuery(name = "Kunde.findAll", query = "SELECT k FROM Kunde k"),
    @NamedQuery(name = "Kunde.findByKundeId", query = "SELECT k FROM Kunde k WHERE k.kundeId = :kundeId"),
    @NamedQuery(name = "Kunde.findByVorname", query = "SELECT k FROM Kunde k WHERE k.vorname = :vorname"),
    @NamedQuery(name = "Kunde.findByGeburtsdatum", query = "SELECT k FROM Kunde k WHERE k.geburtsdatum = :geburtsdatum")})
public class Kunde implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kunde_id")
    private Integer kundeId;
    @Basic(optional = false)
    @Column(name = "vorname")
    private String vorname;
    @Basic(optional = false)
    @Column(name = "geburtsdatum")
    @Temporal(TemporalType.DATE)
    private Date geburtsdatum;

    public Kunde() {
    }

    public Kunde(Integer kundeId) {
        this.kundeId = kundeId;
    }

    public Kunde(Integer kundeId, String vorname, Date geburtsdatum) {
        this.kundeId = kundeId;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
    }

    public Integer getKundeId() {
        return kundeId;
    }

    public void setKundeId(Integer kundeId) {
        Integer oldKundeId = this.kundeId;
        this.kundeId = kundeId;
        changeSupport.firePropertyChange("kundeId", oldKundeId, kundeId);
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        String oldVorname = this.vorname;
        this.vorname = vorname;
        changeSupport.firePropertyChange("vorname", oldVorname, vorname);
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        Date oldGeburtsdatum = this.geburtsdatum;
        this.geburtsdatum = geburtsdatum;
        changeSupport.firePropertyChange("geburtsdatum", oldGeburtsdatum, geburtsdatum);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kundeId != null ? kundeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kunde)) {
            return false;
        }
        Kunde other = (Kunde) object;
        if ((this.kundeId == null && other.kundeId != null) || (this.kundeId != null && !this.kundeId.equals(other.kundeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gui.Kunde[ kundeId=" + kundeId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
