/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageBeans;

import beans.Zones;
import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import java.io.Serializable;
import java.util.logging.Level;
import javax.faces.model.ListDataModel;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.primefaces.model.SelectableDataModel;
import sessionBeans.ZonesFacadeLocal;

/**
 *
 * @author jconner
 */
public class ZonesDataModel extends ListDataModel<Zones> implements SelectableDataModel<Zones>, Serializable {

    private static final long serialVersionUID = 1L;
    private Context context;

    private final ZonesFacadeLocal zonesFacade = lookupZonesFacadeLocal();

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

    public ZonesDataModel() {
        super();
    }

    @Override
    public Object getRowKey(Zones t) {
        return (String.valueOf(t.getId()));
    }

    @Override
    public Zones getRowData(String rowKey) {
        Zones result = null;
        if (!rowKey.equals("null")) {
            result = this.zonesFacade.find(Integer.parseInt(rowKey));
        }
        return (result);
    }

}
