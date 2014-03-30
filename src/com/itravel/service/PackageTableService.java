package com.itravel.service;

import java.util.List;

import com.itravel.dao.PackageTableDAO;
import com.itravel.model.PackageTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("PackageTableService")
@Transactional(readOnly = true)
public class PackageTableService {

	// PackageTableDAO is injected...
    @Autowired
    PackageTableDAO packageTableDAO;

    /**
     * Add PackageTable
     *
     * @param  packageTable PackageTable
     */
    @Transactional(readOnly = false)
    public void addPackageTable(PackageTable packageTable) {
        getPackageTableDAO().addPackageTable(packageTable);
    }

    /**
     * Delete PackageTable
     *
     * @param   packageTable  PackageTable
     */
    @Transactional(readOnly = false)
    public void deletePackageTable(PackageTable packageTable) {
        getPackageTableDAO().deletePackageTable(packageTable);
    }

    /**
     * Update PackageTable
     *
     * @param packageTable  PackageTable
     */
    @Transactional(readOnly = false)
    public void updatePackageTable(PackageTable packageTable) {
        getPackageTableDAO().updatePackageTable(packageTable);
    }

    /**
     * Get PackageTable
     *
     * @param  id int PackageTable Id
     */

    public PackageTable getPackageTableById(int id) {
        return getPackageTableDAO().getPackageTableById(id);
    }

    /**
     * Get PackageTable List
     *
     */

    public List<PackageTable> getPackageTables() {
        return getPackageTableDAO().getPackageTables();
    }

    /**
     * Get PackageTable DAO
     *
     * @return packageTableDAO - PackageTable DAO
     */
    public PackageTableDAO getPackageTableDAO() {
        return packageTableDAO;
    }

    /**
     * Set PackageTable DAO
     *
     * @param  packageTableDAO - PackageTableDAO
     */
    public void setPackageTableDAO(PackageTableDAO packageTableDAO) {
        this.packageTableDAO = packageTableDAO;
    }
}
