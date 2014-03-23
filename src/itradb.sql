drop database if exists itradb;
create database itradb;

drop table if exists country_table;
create table country_table(
	id			int,
	country		varchar(20),
	description	varchar(300)
);

drop table if exists destination_table;
create table destination_table(
	id							int,
	destination_name			varchar(40),
	country						int,
	destination_info			varchar(300),
	destination_image_map_id	int,
	destination_video			varchar(200)
);

drop table if exists destination_image;
create table destination_image(
	id					int,
	destination_image	blob
);

drop table if exists destination_image_map;
create table destination_image_map(
	destination_image_map_id	int,
	destination_id				int,
	destination_image_id		int
);

drop table if exists theme_table;
create table theme_table(
	id			int,
	theme_name	varchar(100),
	theme_info	varchar(300),
);

drop table if exists activity_table;
create table activity_table(
	id							int,
	activity_name				varchar(40),
	activity_description		varchar(300),
	activity_destination		int,
	activity_multi_image_id		int,
	activity_video				varchar(200)
);

drop table if exists activity_image;
create table activity_image(
	id					int,
	activity_image		blob
);

drop table if exists activity_image_map;
create table activity_image_map(
	activity_image_map_id	int,
	activity_id				int,
	activity_image_id		int
);

drop table if exists hotel_table;
create table hotel_table(
	hotel_name					varchar(100),
	hotel_category				int,
	hotel_description			varchar(300),
	hotel_image_map_id			int,
	hotel_video					varchar(200),
	hotel_amenities				varchar(200),
	hotel_contact_person		varchar(200),
	hotel_contact_person_number	int,
	hotel_contact_person_email	varchar(40),
	hotel_address				varchar(300),
	hotel_contact_number		int,
	hotel_email					varchar(40),
	hotel_city					int,
	hotel_country				int
);

drop table if exists hotel_image;
create table hotel_image(
	id				int,
	hotel_image		blob
);

drop table if exists hotel_image_map;
create table hotel_image_map(
	hotel_image_map_id		int,
	hotel_id				int,
	hotel_image_id			int
);

drop table if exists supplier_table;
create table supplier_table(
	supplier_name					varchar(40),
	supplier_company				varchar(40),
	supplier_description			varchar(300),
	supplier_pan_no					varchar(10),
	supplier_bank_acc_no			int,
	supplier_bank_details			varchar(200),
	supplier_contact_person			varchar(40),
	supplier_contact_person_number	int,
	supplier_contact_email			varchar(40),
	supplier_company_address		varchar(300),
	supplier_company_contact_number	int,
	supplier_company_email			varchar(40),
	supplier_company_city			int,
	supplier_company_country		int
);

drop table if exists package_table;
create table package_table(
	id						int,
	package_id				varchar(20),
	package_name			varchar(40),
	package_category		int,
	number_of_nights		int,
	number_of_days			int,
	package_description		varchar(300),
	theme					int,
	best_season				varchar(40),
	valid_from				date,
	valid_to				date,
	booking_from			date,
	booking_to				date,
	package_highlights		varchar(300),
	terms_and_conditions	varchar(1000),
	package_inclusions		varchar(300),
	package_exclusions		varchar(300),
	services_included		int,
	package_type			int,
	country					int,
	package_destinations	int,
	cancellation_policy		varchar(300),
	package_amenities		varchar(300),
	itinerary_id			int,
	itinerary_type			int,
	package_hotels			int,
	package_supplier		int,
	package_budget			int,
	package_currency		int,
	meal_plan				int,
	package_status			int,
	origin_points			int
);

drop table if exists price_table;
create table price_table(
	id						int,
	package_id				varchar(20),
	default_city			int,
	city					varchar(20),	
	adult_single_sharing	double,
	adult_twin_sharing		double,
	adult_triple_sharing	double,
	child_with_bed			double,
	child_without_bed		double,
	infant					double,
	extra_bed				double
);


drop table if exists itinerary_table;
create table itinerary_table(
	id			int,	
	itinerary_day		int,
	itinerary_image		blob,
	itinerary_description	varchar(1000),	
);

drop table if exists user_table;
create table user_table(
	id		int,
	username	varchar(40),
	password	varchar(40),
	role		int
);

drop table if exists package_type_lookup_table;
create table package_type_lookup_table(
	id		int,
	package_type	varchar(20)
);
insert into table package_type_lookup_table (id, package_type) values(
	('1', 'Domestic'),
	('2', 'International')
);

drop table if exists package_budget_lookup_table;
create table package_budget_lookup_table(
	id		int,
	package_budget	varchar(20)
);
insert into table package_budget_lookup_table (id, package_budget) values(
	('1', 'Economy'),
	('2', 'Standard'),
	('3', 'Delux'),
	('4', 'Premium')
);

drop table if exists meal_plan_lookup_table;
create table meal_plan_lookup_table(
	id		int,
	meal_plan	varchar(5)
);
insert into table meal_plan_lookup_table (id, meal_plan) values(
	('1', 'CP'),
	('2', 'MAP'),
	('3', 'AP'),
	('4', 'APAI'),
	('5', 'EP')
);

drop table if exists currency_lookup_table;
create table currency_lookup_table(
	id		int,
	currency_name	varchar(20),
	currency_symbol	varchar(5)
);
insert into table currency_lookup_table (id, currency_name, currency_symbol) values(
	('1', 'United States Dollar', '$'),
	('2', 'India Rupee', '₹'),
	('3', 'Argentina Peso', '$'),
	('4', 'Aruba Guilder', 'ƒ'),
	('5', 'Australia Dollar', '$'),
	('6', 'Azerbaijan New Manat', 'ман'),
	('7', 'British Pound', '£'),
	('8', 'Euro Member Countries', '€'),
	('9', 'Canadian Dollar', '$'),
	('10', 'Emirati Dirham', 'د.إ'),
	('11', 'Malaysian Ringgit', 'RM'),
	('12', 'Swiss Franc', 'CHF'),
	('13', 'Chinese Yuan Renminbi', '¥'),
	('14', 'Thai Baht', '฿'),
	('15', 'Hong Kong Dollar', '$'),
	('16', 'Singapore Dollar', '$')
);
