/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import beans.Npc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jconner
 */
@Local
public interface NpcFacadeLocal {

    void create(Npc requestForm);

    void edit(Npc requestForm);

    void remove(Npc requestForm);

    Npc find(Object id);

    List<Npc> findAll();
    
    List<Npc> findAllByZone(String zone);
}
