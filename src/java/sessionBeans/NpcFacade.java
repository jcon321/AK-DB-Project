/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import beanManager.AbstractFacade;
import beans.Npc;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 *
 * @author jconner
 */
@PersistenceContext(name = "persistence/AKPU", unitName = "AKPU")
@Stateless
public class NpcFacade extends AbstractFacade<Npc> implements NpcFacadeLocal {

    private static final Logger logger = Logger.getLogger("NpcFacade");

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

    public NpcFacade() {
        super(Npc.class);
    }

    @Override
    public List<Npc> findAllByZone(String zone) {
        List<Npc> result = new ArrayList<>();
        Context c;
        Connection conn = null;
        Statement s = null;
        try {
            c = new InitialContext();
            DataSource ds = (DataSource) c.lookup("jdbc/AK");
            conn = ds.getConnection();
            s = conn.createStatement();
            String query = "select id,name,level,race,class,AC,hp,mana,"
                    + "STR,STA,AGI,DEX, _INT, WIS, ATK,mindmg,maxdmg,"
                    + "runspeed,attack_delay,MR,FR,CR,DR,PR,see_invis,"
                    + "see_invis_undead,see_improved_hide from npc_types "
                    + "where id IN (select npcID from spawnentry "
                    + "where spawngroupID IN (select spawngroupId from spawn2 "
                    + "where zone = '" + zone + "'));";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                Npc npc = new Npc();
                npc.setId(rs.getLong("id"));
                npc.setName(rs.getString("name"));
                npc.setLevel(rs.getInt("level"));
                npc.setRace(rs.getInt("race"));
                npc.setNpcClass(rs.getInt("class"));
                npc.setAC(rs.getInt("AC"));
                npc.setHp(rs.getInt("hp"));
                npc.setMana(rs.getInt("mana"));
                npc.setSTR(rs.getInt("STR"));
                npc.setSTA(rs.getInt("STA"));
                npc.setAGI(rs.getInt("AGI"));
                npc.setDEX(rs.getInt("DEX"));
                npc.setINT(rs.getInt("_INT"));
                npc.setWIS(rs.getInt("WIS"));
                npc.setATK(rs.getInt("ATK"));
                npc.setMinDmg(rs.getInt("mindmg"));
                npc.setMaxDmg(rs.getInt("maxdmg"));
                npc.setRunSpeed(rs.getInt("runspeed"));
                npc.setAttackDelay(rs.getInt("attack_delay"));
                npc.setMR(rs.getInt("MR"));
                npc.setCR(rs.getInt("CR"));
                npc.setFR(rs.getInt("FR"));
                npc.setDR(rs.getInt("DR"));
                npc.setPR(rs.getInt("PR"));
                npc.setSeeInvis(rs.getBoolean("see_invis"));
                npc.setSeeInvisUndead(rs.getBoolean("see_invis_undead"));
                npc.setSeeImprovedHide(rs.getBoolean("see_improved_hide"));
                result.add(npc);
            }
        } catch (NamingException | SQLException ex) {
            logger.log(Level.SEVERE, "", ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (s != null) {
                    s.close();
                }
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "", ex);
            }
        }
        return (result);
    }
}
