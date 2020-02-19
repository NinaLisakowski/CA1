package facades;

import dto.GroupMemberDTO;
import entities.GroupMember;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class GroupMemberFacade {

    private static GroupMemberFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private GroupMemberFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static GroupMemberFacade getGroupMemberFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new GroupMemberFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public GroupMemberDTO addGroupMember(String name, String studentid, String favouriteColour, String favouriteAnimal, String eyeColor, int height, int shoeSize) {
        EntityManager em = getEntityManager();
        GroupMember gm = new GroupMember(name, studentid, favouriteColour, favouriteAnimal, eyeColor, height, shoeSize);
        em.getTransaction().begin();
        em.persist(gm);
        em.getTransaction().commit();
        return new GroupMemberDTO(gm);
    }

    public List<GroupMemberDTO> getAllGroupMembers() {
        EntityManager em = emf.createEntityManager();
        List<GroupMemberDTO> gmdList = new LinkedList<>();
        try {
            TypedQuery tq = em.createQuery("SELECT gm FROM GroupMember gm", GroupMember.class);
            for (Object gm : tq.getResultList()) {
                gmdList.add(new GroupMemberDTO((GroupMember) gm));
            }
            return gmdList;
        } finally {
            em.close();
        }

    }

}
