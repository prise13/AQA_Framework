package hibernate;

import com.mysql.cj.log.Log;
import entity.LoginData;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class HibernateService {

    private static Session initSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public static Object[][] getLoginTestData() {
        Session session = initSession();
        session.beginTransaction();
        List<LoginData> loginData = session.createQuery("SELECT d FROM LoginData d", LoginData.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return loginData.stream()
                .map(ld -> new Object[]{ld.getLogin(), ld.getPassword()})
                .toArray(Object[][]::new);
    }

}
