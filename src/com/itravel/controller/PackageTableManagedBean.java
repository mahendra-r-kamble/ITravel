package com.itravel.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.dao.DataAccessException;

import com.itravel.model.CountryTable;
import com.itravel.model.CurrencyLookupTable;
import com.itravel.model.DestinationTable;
import com.itravel.model.HotelTable;
import com.itravel.model.ItineraryTable;
import com.itravel.model.ItineraryTypeLookupTable;
import com.itravel.model.MealPlanLookupTable;
import com.itravel.model.PackageBudgetLookupTable;
import com.itravel.model.PackageCategoryLookupTable;
import com.itravel.model.PackageTable;
import com.itravel.model.PackageTypeLookupTable;
import com.itravel.model.SupplierTable;
import com.itravel.model.ThemeTable;
import com.itravel.service.PackageTableService;

@ManagedBean(name="packageTableMB")
@RequestScoped
public class PackageTableManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
    
    //Spring PackageTable Service is injected...
    @ManagedProperty(value="#{PackageTableService}")
    PackageTableService packageTableService;
    
    List<PackageTable> packageTableList;
    
    private Integer id;
	private ThemeTable themeTable;
	private SupplierTable supplierTable;
	private ItineraryTable itineraryTable;
	private ItineraryTypeLookupTable itineraryTypeLookupTable;
	private DestinationTable destinationTable;
	private PackageBudgetLookupTable packageBudgetLookupTable;
	private CurrencyLookupTable currencyLookupTable;
	private CountryTable countryTable;
	private PackageTypeLookupTable packageTypeLookupTable;
	private HotelTable hotelTable;
	private PackageCategoryLookupTable packageCategoryLookupTable;
	private MealPlanLookupTable mealPlanLookupTable;
	private String packageId;
	private String packageName;
	private int numberOfNights;
	private int numberOfDays;
	private String packageDescription;
	private String bestSeason;
	private Date validFrom;
	private Date validTo;
	private Date bookingFrom;
	private Date bookingTo;
	private String packageHighlights;
	private String termsAndConditions;
	private String packageInclusions;
	private String packageExclusions;
	private int servicesId;
	private String cancellationPolicy;
	private String packageAmenities;
	private Integer packageStatus;
	private Integer originPoints;
	private Set priceTables = new HashSet(0);
	private Set servicesLookupTables = new HashSet(0);
	private int selectedServices;
	private int selectedPackage;
	
	/**
     * Add PackageTable
     *
     * @return String - Response Message
     */
    public String addPackageTable() {
        try {
        	PackageTable packageTable = new PackageTable();
        	packageTable.setId(getId());
        	packageTable.setPackageName(getPackageName());
        	packageTable.setPackageId(getPackageId());
            getPackageTableService().addPackageTable(packageTable);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return ERROR;
    }

    /**
     * Reset Fields
     *
     */
    public void reset() {
        this.setId(0);
        this.setPackageId("");
        this.setPackageName("");
    }

    /**
     * Get PackageTable List
     *
     * @return List - PackageTable List
     */
    public List<PackageTable> getPackageTableList() {
    	packageTableList = new ArrayList<PackageTable>();
    	packageTableList.addAll(getPackageTableService().getPackageTables());
        return packageTableList;
    }

    /**
     * Get PackageTable Service
     *
     * @return IPackageTableService - PackageTable Service
     */
    public PackageTableService getPackageTableService() {
        return packageTableService;
    }

    /**
     * Set PackageTable Service
     *
     * @param packageTableService IPackageTableService - PackageTable Service
     */
    public void setPackageTableService(PackageTableService packageTableService) {
        this.packageTableService = packageTableService;
    }

    /**
     * Set Customer List
     *
     * @param customerList List - Customer List
     */
    public void setPackageTableList(List<PackageTable> packageTableList) {
        this.packageTableList = packageTableList;
    }

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the themeTable
	 */
	public ThemeTable getThemeTable() {
		return themeTable;
	}

	/**
	 * @param themeTable the themeTable to set
	 */
	public void setThemeTable(ThemeTable themeTable) {
		this.themeTable = themeTable;
	}

	/**
	 * @return the supplierTable
	 */
	public SupplierTable getSupplierTable() {
		return supplierTable;
	}

	/**
	 * @param supplierTable the supplierTable to set
	 */
	public void setSupplierTable(SupplierTable supplierTable) {
		this.supplierTable = supplierTable;
	}

	/**
	 * @return the itineraryTable
	 */
	public ItineraryTable getItineraryTable() {
		return itineraryTable;
	}

	/**
	 * @param itineraryTable the itineraryTable to set
	 */
	public void setItineraryTable(ItineraryTable itineraryTable) {
		this.itineraryTable = itineraryTable;
	}

	/**
	 * @return the itineraryTypeLookupTable
	 */
	public ItineraryTypeLookupTable getItineraryTypeLookupTable() {
		return itineraryTypeLookupTable;
	}

	/**
	 * @param itineraryTypeLookupTable the itineraryTypeLookupTable to set
	 */
	public void setItineraryTypeLookupTable(
			ItineraryTypeLookupTable itineraryTypeLookupTable) {
		this.itineraryTypeLookupTable = itineraryTypeLookupTable;
	}

	/**
	 * @return the destinationTable
	 */
	public DestinationTable getDestinationTable() {
		return destinationTable;
	}

	/**
	 * @param destinationTable the destinationTable to set
	 */
	public void setDestinationTable(DestinationTable destinationTable) {
		this.destinationTable = destinationTable;
	}

	/**
	 * @return the packageBudgetLookupTable
	 */
	public PackageBudgetLookupTable getPackageBudgetLookupTable() {
		return packageBudgetLookupTable;
	}

	/**
	 * @param packageBudgetLookupTable the packageBudgetLookupTable to set
	 */
	public void setPackageBudgetLookupTable(
			PackageBudgetLookupTable packageBudgetLookupTable) {
		this.packageBudgetLookupTable = packageBudgetLookupTable;
	}

	/**
	 * @return the currencyLookupTable
	 */
	public CurrencyLookupTable getCurrencyLookupTable() {
		return currencyLookupTable;
	}

	/**
	 * @param currencyLookupTable the currencyLookupTable to set
	 */
	public void setCurrencyLookupTable(CurrencyLookupTable currencyLookupTable) {
		this.currencyLookupTable = currencyLookupTable;
	}

	/**
	 * @return the countryTable
	 */
	public CountryTable getCountryTable() {
		return countryTable;
	}

	/**
	 * @param countryTable the countryTable to set
	 */
	public void setCountryTable(CountryTable countryTable) {
		this.countryTable = countryTable;
	}

	/**
	 * @return the packageTypeLookupTable
	 */
	public PackageTypeLookupTable getPackageTypeLookupTable() {
		return packageTypeLookupTable;
	}

	/**
	 * @param packageTypeLookupTable the packageTypeLookupTable to set
	 */
	public void setPackageTypeLookupTable(
			PackageTypeLookupTable packageTypeLookupTable) {
		this.packageTypeLookupTable = packageTypeLookupTable;
	}

	/**
	 * @return the hotelTable
	 */
	public HotelTable getHotelTable() {
		return hotelTable;
	}

	/**
	 * @param hotelTable the hotelTable to set
	 */
	public void setHotelTable(HotelTable hotelTable) {
		this.hotelTable = hotelTable;
	}

	/**
	 * @return the packageCategoryLookupTable
	 */
	public PackageCategoryLookupTable getPackageCategoryLookupTable() {
		return packageCategoryLookupTable;
	}

	/**
	 * @param packageCategoryLookupTable the packageCategoryLookupTable to set
	 */
	public void setPackageCategoryLookupTable(
			PackageCategoryLookupTable packageCategoryLookupTable) {
		this.packageCategoryLookupTable = packageCategoryLookupTable;
	}

	/**
	 * @return the mealPlanLookupTable
	 */
	public MealPlanLookupTable getMealPlanLookupTable() {
		return mealPlanLookupTable;
	}

	/**
	 * @param mealPlanLookupTable the mealPlanLookupTable to set
	 */
	public void setMealPlanLookupTable(MealPlanLookupTable mealPlanLookupTable) {
		this.mealPlanLookupTable = mealPlanLookupTable;
	}

	/**
	 * @return the packageId
	 */
	public String getPackageId() {
		return packageId;
	}

	/**
	 * @param packageId the packageId to set
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	/**
	 * @return the packageName
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * @param packageName the packageName to set
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * @return the numberOfNights
	 */
	public int getNumberOfNights() {
		return numberOfNights;
	}

	/**
	 * @param numberOfNights the numberOfNights to set
	 */
	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	/**
	 * @return the numberOfDays
	 */
	public int getNumberOfDays() {
		return numberOfDays;
	}

	/**
	 * @param numberOfDays the numberOfDays to set
	 */
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	/**
	 * @return the packageDescription
	 */
	public String getPackageDescription() {
		return packageDescription;
	}

	/**
	 * @param packageDescription the packageDescription to set
	 */
	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	/**
	 * @return the bestSeason
	 */
	public String getBestSeason() {
		return bestSeason;
	}

	/**
	 * @param bestSeason the bestSeason to set
	 */
	public void setBestSeason(String bestSeason) {
		this.bestSeason = bestSeason;
	}

	/**
	 * @return the validFrom
	 */
	public Date getValidFrom() {
		return validFrom;
	}

	/**
	 * @param validFrom the validFrom to set
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * @return the validTo
	 */
	public Date getValidTo() {
		return validTo;
	}

	/**
	 * @param validTo the validTo to set
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	/**
	 * @return the bookingFrom
	 */
	public Date getBookingFrom() {
		return bookingFrom;
	}

	/**
	 * @param bookingFrom the bookingFrom to set
	 */
	public void setBookingFrom(Date bookingFrom) {
		this.bookingFrom = bookingFrom;
	}

	/**
	 * @return the bookingTo
	 */
	public Date getBookingTo() {
		return bookingTo;
	}

	/**
	 * @param bookingTo the bookingTo to set
	 */
	public void setBookingTo(Date bookingTo) {
		this.bookingTo = bookingTo;
	}

	/**
	 * @return the packageHighlights
	 */
	public String getPackageHighlights() {
		return packageHighlights;
	}

	/**
	 * @param packageHighlights the packageHighlights to set
	 */
	public void setPackageHighlights(String packageHighlights) {
		this.packageHighlights = packageHighlights;
	}

	/**
	 * @return the termsAndConditions
	 */
	public String getTermsAndConditions() {
		return termsAndConditions;
	}

	/**
	 * @param termsAndConditions the termsAndConditions to set
	 */
	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	/**
	 * @return the packageInclusions
	 */
	public String getPackageInclusions() {
		return packageInclusions;
	}

	/**
	 * @param packageInclusions the packageInclusions to set
	 */
	public void setPackageInclusions(String packageInclusions) {
		this.packageInclusions = packageInclusions;
	}

	/**
	 * @return the packageExclusions
	 */
	public String getPackageExclusions() {
		return packageExclusions;
	}

	/**
	 * @param packageExclusions the packageExclusions to set
	 */
	public void setPackageExclusions(String packageExclusions) {
		this.packageExclusions = packageExclusions;
	}

	/**
	 * @return the servicesId
	 */
	public int getServicesId() {
		return servicesId;
	}

	/**
	 * @param servicesId the servicesId to set
	 */
	public void setServicesId(int servicesId) {
		this.servicesId = servicesId;
	}

	/**
	 * @return the cancellationPolicy
	 */
	public String getCancellationPolicy() {
		return cancellationPolicy;
	}

	/**
	 * @param cancellationPolicy the cancellationPolicy to set
	 */
	public void setCancellationPolicy(String cancellationPolicy) {
		this.cancellationPolicy = cancellationPolicy;
	}

	/**
	 * @return the packageAmenities
	 */
	public String getPackageAmenities() {
		return packageAmenities;
	}

	/**
	 * @param packageAmenities the packageAmenities to set
	 */
	public void setPackageAmenities(String packageAmenities) {
		this.packageAmenities = packageAmenities;
	}

	/**
	 * @return the packageStatus
	 */
	public Integer getPackageStatus() {
		return packageStatus;
	}

	/**
	 * @param packageStatus the packageStatus to set
	 */
	public void setPackageStatus(Integer packageStatus) {
		this.packageStatus = packageStatus;
	}

	/**
	 * @return the originPoints
	 */
	public Integer getOriginPoints() {
		return originPoints;
	}

	/**
	 * @param originPoints the originPoints to set
	 */
	public void setOriginPoints(Integer originPoints) {
		this.originPoints = originPoints;
	}

	/**
	 * @return the priceTables
	 */
	public Set getPriceTables() {
		return priceTables;
	}

	/**
	 * @param priceTables the priceTables to set
	 */
	public void setPriceTables(Set priceTables) {
		this.priceTables = priceTables;
	}

	/**
	 * @return the servicesLookupTables
	 */
	public Set getServicesLookupTables() {
		return servicesLookupTables;
	}

	/**
	 * @param servicesLookupTables the servicesLookupTables to set
	 */
	public void setServicesLookupTables(Set servicesLookupTables) {
		this.servicesLookupTables = servicesLookupTables;
	}

	/**
	 * @return the selectedServices
	 */
	public int getSelectedServices() {
		return selectedServices;
	}

	/**
	 * @param selectedServices the selectedServices to set
	 */
	public void setSelectedServices(int selectedServices) {
		this.selectedServices = selectedServices;
	}

	/**
	 * @return the selectedPackage
	 */
	public int getSelectedPackage() {
		return selectedPackage;
	}

	/**
	 * @param selectedPackage the selectedPackage to set
	 */
	public void setSelectedPackage(int selectedPackage) {
		this.selectedPackage = selectedPackage;
	}
}
