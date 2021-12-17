package com.bur1y.ClothesForHands.database.Hibernate;

import com.bur1y.ClothesForHands.database.table.Material;
import com.bur1y.ClothesForHands.database.table.MaterialType;
import org.hibernate.Session;

import java.util.List;

public class Interface {
    public static List<Material> getAllMaterials() {
        return (List<Material>) Hibernate
                .getSessionFactory()
                .openSession()
                .createQuery("FROM Material M")
                .list();
    }

    public static List<MaterialType> getAllMaterialTypes() {
        return (List<MaterialType>) Hibernate
                .getSessionFactory()
                .openSession()
                .createQuery("FROM MaterialType ")
                .list();
    }

    public static Material getMaterial(int id) {
        return (Material) Hibernate.getSessionFactory().openSession().createQuery("FROM Material M WHERE M.id ='" + id + "'").uniqueResult();
    }

    public static void deleteMaterial(Material material) {
        Session session = Hibernate.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(material);
        session.getTransaction().commit();
        session.close();
    }

    public static void updateMaterial(Material material) {
        Session session = Hibernate.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(material);
        session.getTransaction().commit();
        session.close();
    }
}
