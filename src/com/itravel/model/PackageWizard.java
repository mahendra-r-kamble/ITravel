package com.itravel.model;

import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FlowEvent;

import com.itravel.controller.PackageTableManagedBean;

public class PackageWizard {
	private PackageTableManagedBean packageTableManagedBean = new PackageTableManagedBean();

	private boolean skip;

	private static Logger logger = Logger.getLogger(PackageWizard.class.getName());

	public PackageTableManagedBean getPackageTableManagedBean() {
		return packageTableManagedBean;
	}

	public void setgetPackageTableManagedBean(PackageTableManagedBean packageTableManagedBean) {
		this.packageTableManagedBean = packageTableManagedBean;
	}

	public void save(ActionEvent actionEvent) {
		// Persist packageTableManagedBean

		FacesMessage msg = new FacesMessage("Successful", "Welcome :"
				+ packageTableManagedBean.getPackageName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
		logger.info("Current wizard step:" + event.getOldStep());
		logger.info("Next step:" + event.getNewStep());

		if (skip) {
			skip = false; // reset in case packageTableManagedBean goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}
}
