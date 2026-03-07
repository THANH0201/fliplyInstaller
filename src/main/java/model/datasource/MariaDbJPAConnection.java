package model.datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class MariaDbJPAConnection {

    private static EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {

        // Read environment variables
        String url = System.getProperty("DB_URL", System.getenv("DB_URL"));
        String user = System.getProperty("DB_USER", System.getenv("DB_USER"));
        String pass = System.getProperty("DB_PASS", System.getenv("DB_PASS"));

        // Fallback for local development
        if (url == null) url = "jdbc:mariadb://localhost:3307/fliply";
        if (user == null) user = "root";
        if (pass == null) pass = "root";

        Map<String, Object> props = new HashMap<>();
        props.put("jakarta.persistence.jdbc.url", url);
        props.put("jakarta.persistence.jdbc.user", user);
        props.put("jakarta.persistence.jdbc.password", pass);
        props.put("jakarta.persistence.jdbc.driver", "org.mariadb.jdbc.Driver");

        return Persistence.createEntityManagerFactory("FliplyDbUnit", props);
    }

    public static EntityManager createEntityManager() {
        if (emf == null || !emf.isOpen()) {
            emf = buildEntityManagerFactory();
        }
        return emf.createEntityManager();
    }

    public static void shutdown() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
