/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.jsf;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author justin
 */
@ManagedBean
@SessionScoped
public class FormBean implements Serializable{
    private static final Logger LOG = Logger.getLogger(FormBean.class.getName());

    private Form form;
    private People applicant;
    
    /**
     * Creates a new instance of FormBean
     */
    public FormBean() {
    }
    
    @PostConstruct
    public void gearup(){
        LOG.log(Level.INFO, "Post Construct Called!!!");
        this.form = new Form();
    }
    
    @PreDestroy
    public void finishup(){
        //save form to a file
        //then 
        this.form = null;
    }

    public People getApplicant() {
        return applicant;
    }
    
    
    
    public void initiateNewPeople(ActionEvent event){
        //this.form.addPeople(new People());
        this.applicant = new People();
    }
    
    public void commitPeople(ActionEvent event){
        this.form.addPeople(applicant);
        this.applicant = null;
    }

    public Form getForm() {
        return form;
    }
    
    
    
}
