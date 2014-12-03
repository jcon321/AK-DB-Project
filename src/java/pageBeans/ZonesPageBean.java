/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageBeans;

import beans.Zones;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.primefaces.model.SelectableDataModel;
import sessionBeans.ZonesFacadeLocal;

/**
 *
 * @author jconner
 */
@Named
@SessionScoped
public class ZonesPageBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ZonesPageBean.class.getName());
    private Context context = null;

    private final ZonesFacadeLocal zonesFacade = lookupZonesFacadeLocal();
    private ZonesDataModel zones = new ZonesDataModel();
    List<Zones> zonesList = new ArrayList<>();
    private Zones selectedZone = new Zones();

    public ZonesPageBean() {

    }

    @PostConstruct
    public void init() {
        zonesList = getZonesList();
        zones.setWrappedData(zonesList);
    }

    private ZonesFacadeLocal lookupZonesFacadeLocal() {
        try {
            if (context == null) {
                context = new InitialContext();
            }
            return (ZonesFacadeLocal) context.lookup("java:global/AK/ZonesFacade!sessionBeans.ZonesFacadeLocal");
        } catch (NamingException ne) {
            logger.log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public List<Zones> getZonesList() {
        return (this.zonesFacade.findAll());
    }

    public SelectableDataModel<Zones> getZones() {
        return zones;
    }

    public void setZones(ZonesDataModel zones) {
        this.zones = zones;
    }

    public Zones getSelectedZone() {
        return selectedZone;
    }

    public void setSelectedZone(Zones selectedZone) {
        this.selectedZone = selectedZone;
    }

}
