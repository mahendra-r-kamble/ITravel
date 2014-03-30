package com.itravel.dao;

import java.util.List;

import com.itravel.model.PackageCategoryLookupTable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PackageCategoryDAO {

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
     * Add packageCategoryLookupTable
     *
     * @param   packageCategoryLookupTable   packageCategoryLookupTable
     */

    public void addPackageCategoryLookupTable(PackageCategoryLookupTable packageCategoryLookupTable) {
        getSessionFactory().getCurrentSession().save(packageCategoryLookupTable);
    }

    /**
     * Delete packageCategoryLookupTable
     *
     * @param   packageCategoryLookupTable  packageCategoryLookupTable
     */

    public void deletePackageCategoryLookupTable(PackageCategoryLookupTable packageCategoryLookupTable) {
        getSessionFactory().getCurrentSession().delete(packageCategoryLookupTable);
    }

    /**
     * Update packageCategoryLookupTable
     *
     * @param  packageCategoryLookupTable packageCategoryLookupTable
     */

    public void updatePackageCategoryLookupTable(PackageCategoryLookupTable packageCategoryLookupTable) {
        getSessionFactory().getCurrentSession().update(packageCategoryLookupTable);
    }

    /**
     * Get packageCategoryLookupTable
     *
     * @param  id int
     * @return packageCategoryLookupTable
     */

    public PackageCategoryLookupTable getPackageCategoryLookupTableById(int id) {
        List list = getSessionFactory().getCurrentSession()
                                            .createQuery("from PackageCategoryLookupTable where id=?")
                                            .setParameter(0, id).list();
        return (PackageCategoryLookupTable)list.get(0);
    }

    /**
     * Get packageCategoryLookupTable List
     *
     * @return List - packageCategoryLookupTable list
     */

    public List<PackageCategoryLookupTable> getPackageCategoryLookupTables() {
        List list = getSessionFactory().getCurrentSession().createQuery("from PackageCategoryLookupTable").list();
        return list;
    }

}
