package com.itravel.model;
// default package
// Generated 26 Mar, 2014 6:29:53 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ThemeTable generated by hbm2java
 */
@Entity
@Table(name = "theme_table", catalog = "itradb")
public class ThemeTable implements java.io.Serializable {

	private Integer id;
	private String themeName;
	private String themeInfo;
	private Set packageTables = new HashSet(0);

	public ThemeTable() {
	}

	public ThemeTable(String themeName, String themeInfo, Set packageTables) {
		this.themeName = themeName;
		this.themeInfo = themeInfo;
		this.packageTables = packageTables;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "theme_name", length = 100)
	public String getThemeName() {
		return this.themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	@Column(name = "theme_info", length = 300)
	public String getThemeInfo() {
		return this.themeInfo;
	}

	public void setThemeInfo(String themeInfo) {
		this.themeInfo = themeInfo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "themeTable")
	public Set getPackageTables() {
		return this.packageTables;
	}

	public void setPackageTables(Set packageTables) {
		this.packageTables = packageTables;
	}

}
