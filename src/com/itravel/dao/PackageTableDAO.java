package com.itravel.dao;

import java.util.List;

import com.itravel.model.PackageTable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PackageTableDAO {

	@Autowired
    private SessionFactory sessionFactory;

    /**
     * Get Hibernate Session Factory
     *
     * @return SessionFactory - Hibernate Session Factory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Set Hibernate Session Factory
     *
     * @param sessionFactory SessionFactory - Hibernate Session Factory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Add packageTable
     *
     * @param   packageTable   packageTable
     */

    public void addPackageTable(PackageTable packageTable) {
        getSessionFactory().getCurrentSession().save(packageTable);
    }

    /**
     * Delete packageTable
     *
     * @param   packageTable  packageTable
     */

    public void deletePackageTable(PackageTable packageTable) {
        getSessionFactory().getCurrentSession().delete(packageTable);
    }

    /**
     * Update packageTable
     *
     * @param  packageTable packageTable
     */

    public void updatePackageTable(PackageTable packageTable) {
        getSessionFactory().getCurrentSession().update(packageTable);
    }

    /**
     * Get packageTable
     *
     * @param  id int
     * @return packageTable
     */

    public PackageTable getPackageTableById(int id) {
        List list = getSessionFactory().getCurrentSession()
                                            .createQuery("from PackageTable  where id=?")
                                            .setParameter(0, id).list();
        return (PackageTable)list.get(0);
    }

    /**
     * Get packageTable List
     *
     * @return List - packageTable list
     */

    public List<PackageTable> getPackageTables() {
        List list = getSessionFactory().getCurrentSession().createQuery("from  PackageTable").list();
        return list;
    }

}
