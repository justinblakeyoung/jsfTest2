/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.jsf.converters;

import com.test.jsf.People;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author justin
 */
@FacesConverter("PeopleNameConverter")
public class NameConverter implements Converter {

    private static final Logger LOG = Logger.getLogger(NameConverter.class.getName());

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        LOG.log(Level.INFO, "value {0}", value);
        if (value != null && value instanceof People) {
            StringBuilder sb = new StringBuilder();
            People p = (People) value;
            if (p.getFirstName() != null) {
                sb.append(p.getFirstName());
                LOG.log(Level.INFO, "SB now is {0}", sb.toString());
            }

            if (p.getLastName() != null) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                
                sb.append(p.getLastName());
                LOG.log(Level.INFO, "SB now is {0}", sb.toString());
            }else
                    sb.append(" no last name" );
            LOG.log(Level.INFO, "SB now is {0}", sb.toString());
            return sb.toString();
        } else {
            return null;
        }
    }

}
