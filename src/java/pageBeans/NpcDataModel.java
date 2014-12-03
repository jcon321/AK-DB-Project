/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageBeans;

import beans.Npc;
import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import java.io.Serializable;
import java.util.logging.Level;
import javax.faces.model.ListDataModel;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.primefaces.model.SelectableDataModel;
import sessionBeans.NpcFacadeLocal;

/**
 *
 * @author jconner
 */
public class NpcDataModel extends ListDataModel<Npc> implements SelectableDataModel<Npc>, Serializable {

    private static final long serialVersionUID = 1L;
    private Context context;

    private final NpcFacadeLocal zonesFacade = lookupNpcFacadeLocal();

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

    public NpcDataModel() {
        super();
    }

    @Override
    public Object getRowKey(Npc t) {
        return (String.valueOf(t.getId()));
    }

    @Override
    public Npc getRowData(String rowKey) {
        Npc result = null;
        if (!rowKey.equals("null")) {
            result = this.zonesFacade.find(Integer.parseInt(rowKey));
        }
        return (result);
    }

}
