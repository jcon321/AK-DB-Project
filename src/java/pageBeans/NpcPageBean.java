/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageBeans;

import beans.Npc;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.primefaces.model.SelectableDataModel;
import sessionBeans.NpcFacadeLocal;

/**
 *
 * @author jconner
 */
@Named
@SessionScoped
public class NpcPageBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(NpcPageBean.class.getName());
    private Context context = null;

    private final NpcFacadeLocal npcsFacade = lookupNpcFacadeLocal();
    private NpcDataModel npcs = new NpcDataModel();
    private Npc selectedNpc = new Npc();

    String paramZone = "";

    public NpcPageBean() {

    }

    @PostConstruct
    public void init() {

    }

    private NpcFacadeLocal lookupNpcFacadeLocal() {
        try {
            if (context == null) {
                context = new InitialContext();
            }
            return (NpcFacadeLocal) context.lookup("java:global/AK/NpcFacade!sessionBeans.NpcFacadeLocal");
        } catch (NamingException ne) {
            logger.log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public SelectableDataModel<Npc> getNpcs() {
        if (FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("zone") != null) {
            if (!paramZone.equals(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("zone"))) {
                paramZone = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("zone");
                npcs.setWrappedData(this.npcsFacade.findAllByZone(paramZone));
            }
        }
        return npcs;
    }

    public void setNpcs(NpcDataModel npcs) {
        this.npcs = npcs;
    }

    public Npc getSelectedNpc() {
        return selectedNpc;
    }

    public void setSelectedNpc(Npc selectedNpc) {
        this.selectedNpc = selectedNpc;
    }

}
