/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.jsf;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author justin
 */
@ManagedBean
@SessionScoped
public class FormBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(FormBean.class.getName());

    private Form form;
    private People applicant;
    private boolean addingpersonMode;

    /**
     * Creates a new instance of FormBean
     */
    public FormBean() {
    }

    @PostConstruct
    public void gearup() {
        LOG.log(Level.INFO, "Post Construct Called!!!");
        this.form = new Form();
    }

    @PreDestroy
    public void finishup() {
        //save form to a file
        //then 
        this.form = null;
    }

    public People getApplicant() {
        return applicant;
    }

    public void setApplicant(People applicant) {
        this.applicant = applicant;
    }

    /*
    public void onDateSelected(SelectEvent event) {
        LOG.log(Level.INFO, "Made it to onDateSelect");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }*/
   

    public void initiateNewPeople(ActionEvent event) {
        String mode = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("EDT_MODE");
        LOG.log(Level.INFO, "EDT_MODE parameter value read as  {0}", mode);

        if ("ADD".equalsIgnoreCase(mode)) {
            //this.form.addPeople(new People());
            this.applicant = new People();
            this.addingpersonMode = true;
        } else {
            this.addingpersonMode = false;
        }
    }
    
    public void initEdit(ActionEvent event){
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("ID");
        LOG.log(Level.INFO, "Editing applicant with row ID:  {0}", id);
        this.addingpersonMode = false;
        for(People p : this.form.getApplicants()){
            if(p.getFirstName().equalsIgnoreCase(id)){
                this.applicant = p;
                break;
            }
        }
    }
    
    public void deleteApplicant(ActionEvent event){
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("ID");
        LOG.log(Level.INFO, "Deleting applicant with rows ID:  {0}", id);
        for(People p : this.form.getApplicants()){
            if(Long.toString(p.hashCode()).equals(id)){
                this.form.deletePeople(p);
                this.applicant = null;
                break;
            }
        }
    }

    public void commitPeople(ActionEvent event) {
        LOG.log(Level.INFO, "Commit people add or update called");
        if (this.addingpersonMode) {
            this.form.addPeople(applicant);
            this.applicant = null;
        }
        this.addingpersonMode = false;
    }

    public Form getForm() {
        return form;
    }

    public boolean isAddingpersonMode() {
        return addingpersonMode;
    }

    public void setAddingpersonMode(boolean addingpersonMode) {
        this.addingpersonMode = addingpersonMode;
    }

}
