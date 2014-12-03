/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import beans.Zones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jconner
 */
@Local
public interface ZonesFacadeLocal {

    void create(Zones requestForm);

    void edit(Zones requestForm);

    void remove(Zones requestForm);

    Zones find(Object id);

    List<Zones> findAll();
}
