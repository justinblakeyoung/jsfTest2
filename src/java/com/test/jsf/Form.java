/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.jsf;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author justin
 */
public class Form {

    private Collection<People> applicants;
    private People agent;
    private Collection<Address> addresses;

    public Form() {
    }

    public Collection<People> getApplicants() {
        return applicants;
    }

    public void setApplicants(Collection<People> applicants) {
        this.applicants = applicants;
    }

    public People getAgent() {
        return agent;
    }

    public void setAgent(People agent) {
        this.agent = agent;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    public void addPeople(People p) {
        if (this.applicants == null && p != null) {
            this.applicants = new LinkedList<People>();
        }

        this.applicants.add(p);
    }
    
    public void deletePeople(People p){
        this.applicants.remove(p);
    }

}
