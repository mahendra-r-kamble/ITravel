package com.itravel.service;

import java.util.List;

import com.itravel.dao.PackageCategoryDAO;
import com.itravel.model.PackageCategoryLookupTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("PackageCategoryService")
@Transactional(readOnly = true)
public class PackageCategoryService {

	// PackageCategoryDAO is injected...
    @Autowired
    PackageCategoryDAO packageCategoryDAO;

    /**
     * Add PackageCategoryLookupTable
     *
     * @param  packageCategoryLookupTable PackageCategoryLookupTable
     */
    @Transactional(readOnly = false)
    public void addPackageCategoryLookupTable(PackageCategoryLookupTable packageCategoryLookupTable) {
        getPackageCategoryDAO().addPackageCategoryLookupTable(packageCategoryLookupTable);
    }

    /**
     * Delete PackageCategoryLookupTable
     *
     * @param   packageCategoryLookupTable  PackageCategoryLookupTable
     */
    @Transactional(readOnly = false)
    public void deletePackageCategoryLookupTable(PackageCategoryLookupTable packageCategoryLookupTable) {
    	getPackageCategoryDAO().deletePackageCategoryLookupTable(packageCategoryLookupTable);
    }

    /**
     * Update PackageCategoryLookupTable
     *
     * @param packageCategoryLookupTable  PackageCategoryLookupTable
     */
    @Transactional(readOnly = false)
    public void updatePackageCategoryLookupTable(PackageCategoryLookupTable packageCategoryLookupTable) {
    	getPackageCategoryDAO().updatePackageCategoryLookupTable(packageCategoryLookupTable);
    }

    /**
     * Get PackageCategoryLookupTable
     *
     * @param  id int PackageCategoryLookupTable Id
     */

    public PackageCategoryLookupTable getPackageCategoryLookupTableById(int id) {
        return getPackageCategoryDAO().getPackageCategoryLookupTableById(id);
    }

    /**
     * Get PackageCategoryLookupTable List
     *
     */

    public List<PackageCategoryLookupTable> getPackageCategoryLookupTables() {
        return getPackageCategoryDAO().getPackageCategoryLookupTables();
    }

    /**
     * Get PackageCategoryLookupTable DAO
     *
     * @return packageCategoryDAO - PackageCategoryLookupTable DAO
     */
    public PackageCategoryDAO getPackageCategoryDAO() {
        return packageCategoryDAO;
    }

    /**
     * Set PackageTable DAO
     *
     * @param  packageCategoryDAO - PackageCategoryDAO
     */
    public void setPackageCategoryDAO(PackageCategoryDAO packageCategoryDAO) {
        this.packageCategoryDAO = packageCategoryDAO;
    }
}
