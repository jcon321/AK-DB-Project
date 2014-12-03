/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import beanManager.AbstractFacade;
import beans.Zones;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jconner
 */
@PersistenceContext(name = "persistence/AKPU", unitName = "AKPU")
@Stateless
public class ZonesFacade extends AbstractFacade<Zones> implements ZonesFacadeLocal {

    private static final Logger logger = Logger.getLogger("ZonesFacade");

    @Override
    protected EntityManager getEntityManager() {
        EntityManager em = null;
        try {
            Context envCtx = InitialContext.doLookup("java:comp/env");
            em = (EntityManager) envCtx.lookup("persistence/AKPU");
        } catch (NamingException ne) {
            logger.log(Level.SEVERE, "Naming Exception - Cannot get Entity Manager {0}", ne);
        }
        return em;
    }

    public ZonesFacade() {
        super(Zones.class);
    }
}
