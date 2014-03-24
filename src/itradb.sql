drop database if exists itradb;
create database itradb;
use itradb;

drop table if exists country_table;
create table country_table(
	id			int primary key auto_increment not null,
	country		varchar(20),
	description	varchar(300)
);

drop table if exists destination_table;
create table destination_table(
	id							int primary key auto_increment not null,
	destination_name			varchar(40),
	country						int,
	destination_info			varchar(300),
	destination_image_id		int,
	destination_video			varchar(2000),
	foreign key (country) references country_table (id)
);

drop table if exists destination_image;
create table destination_image(
	id					int primary key auto_increment not null,
	destination_id		int,
	destination_image	blob,
	foreign key (destination_id) references destination_table (id)
);

drop table if exists theme_table;
create table theme_table(
	id			int primary key auto_increment not null,
	theme_name	varchar(100),
	theme_info	varchar(300)
);
 
drop table if exists activity_table;
create table activity_table(
	id							int primary key auto_increment not null,
	activity_name				varchar(40),
	activity_description		varchar(300),
	activity_destination		int,
	activity_multi_image_id		int,
	activity_video				varchar(200),
	foreign key (activity_destination) references destination_table (id)
);

drop table if exists activity_image;
create table activity_image(
	id					int primary key auto_increment not null,
	activity_id			int,
	activity_image		blob,
	foreign key (activity_id) references activity_table (id)
);

drop table if exists hotel_table;
create table hotel_table(
	id							int primary key auto_increment not null,
	hotel_name					varchar(100),
	hotel_category				int,
	hotel_description			varchar(300),
	hotel_image_id				int,
	hotel_video					varchar(200),
	hotel_amenities_map_id		int,
	hotel_contact_person		varchar(200),
	hotel_contact_person_number	int,
	hotel_contact_person_email	varchar(40),
	hotel_address				varchar(300),
	hotel_contact_number		int,
	hotel_email					varchar(40),
	hotel_city					int,
	hotel_country				int,
	foreign key (hotel_city) references destination_table (id),
	foreign key (hotel_country) references country_table (id)
);

drop table if exists hotel_amenities_lookup_table;
create table hotel_amenities_lookup_table(
	id				int primary key auto_increment not null,
	hotel_id		int,
	category		varchar(40),
	amenity_name	varchar(40),
	foreign key (hotel_id) references hotel_table (id)
);
insert into hotel_amenities_lookup_table (category, amenity_name) values
	('Facilities', '24-hour room service'),
	('Facilities', 'airport transfer'),
	('Facilities', 'babysitting'),
	('Facilities', 'bar'),
	('Facilities', 'business center'),
	('Facilities', 'coffee shop'),
	('Facilities', 'concierge'),
	('Facilities', 'elevator'),
	('Facilities', 'executive floor'),
	('Facilities', 'facilities for disabled guests'),
	('Facilities', 'family room'),
	('Facilities', 'laundry service'),
	('Facilities', 'meeting facilities'),
	('Facilities', 'restaurant'),
	('Facilities', 'room service'),
	('Facilities', 'safety deposit boxes'),
	('Facilities', 'salon'),
	('Facilities', 'shops'),
	('Facilities', 'smoking area'),
	('Facilities', 'Wi-Fi in public areas'),
	('Sports and Recreation', 'fitness center'),
	('Sports and Recreation', 'garden'),
	('Sports and Recreation', 'hot tub'),
	('Sports and Recreation', 'kids club'),
	('Sports and Recreation', 'outdoor pool'),
	('Sports and Recreation', 'pool (kids)'),
	('Sports and Recreation', 'sauna'),
	('Sports and Recreation', 'squash courts'),
	('Sports and Recreation', 'spa'),
	('Sports and Recreation', 'steamroom'),
	('Internet in Rooms', 'LAN access (charges apply)'),
	('Internet in Rooms', 'LAN and WiFi access (charges apply)'),
	('Parking', 'car park'),
	('Parking', 'valet parking');

drop table if exists hotel_image;
create table hotel_image(
	id				int primary key auto_increment not null,
	hotel_id		int,
	hotel_image		blob,
	foreign key (hotel_id) references hotel_table (id)
);

drop table if exists supplier_table;
create table supplier_table(
	id								int primary key auto_increment not null,
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
	supplier_company_country		int,
	foreign key (supplier_company_city) references destination_table (id),
	foreign key (supplier_company_country) references country_table (id)
);

drop table if exists package_budget_lookup_table;
create table package_budget_lookup_table(
	id		int primary key auto_increment not null,
	package_budget	varchar(20)
);
insert into package_budget_lookup_table (package_budget) values
	('Economy'),
	('Standard'),
	('Delux'),
	('Premium');

drop table if exists meal_plan_lookup_table;
create table meal_plan_lookup_table(
	id		int primary key auto_increment not null,
	meal_plan	varchar(10)
);
insert into meal_plan_lookup_table (meal_plan) values
	('CP'),
	('MAP'),
	('AP'),
	('APAI'),
	('EP');

drop table if exists currency_lookup_table;
create table currency_lookup_table(
	id		int primary key auto_increment not null,
	currency_name	varchar(40),
	currency_symbol	varchar(5)
);
insert into currency_lookup_table (currency_name, currency_symbol) values
	('United States Dollar', '$'),
	('India Rupee', '₹'),
	('Argentina Peso', '$'),
	('Aruba Guilder', 'ƒ'),
	('Australia Dollar', '$'),
	('Azerbaijan New Manat', 'ман'),
	('British Pound', '£'),
	('Euro Member Countries', '€'),
	('Canadian Dollar', '$'),
	('Emirati Dirham', 'د.إ'),
	('Malaysian Ringgit', 'RM'),
	('Swiss Franc', 'CHF'),
	('Chinese Yuan Renminbi', '¥'),
	('Thai Baht', '฿'),
	('Hong Kong Dollar', '$'),
	('Singapore Dollar', '$');

drop table if exists package_category_lookup_table;
create table package_category_lookup_table(
	id				int primary key auto_increment not null,
	package_type	varchar(40)
);
insert into package_category_lookup_table (package_type) values
	('Escorted'),
	('Individual');

drop table if exists itinerary_type_lookup_table;
create table itinerary_type_lookup_table(
	id						int primary key auto_increment not null,	
	itinerary_type			varchar(40)
);
insert into itinerary_type_lookup_table (itinerary_type) values
	('With Images'),
	('Without Images');

drop table if exists itinerary_table;
create table itinerary_table(
	id						int primary key auto_increment not null,	
	itinerary_day			int,
	itinerary_image			blob,
	itinerary_description	varchar(1000)
);

drop table if exists user_table;
create table user_table(
	id			int primary key auto_increment not null,
	username	varchar(40),
	password	varchar(40),
	role		int
);

drop table if exists package_type_lookup_table;
create table package_type_lookup_table(
	id				int primary key auto_increment not null,
	package_type	varchar(20)
);
insert into package_type_lookup_table (package_type) values
	('Domestic'),
	('International');

drop table if exists package_table;
create table package_table(
	id						int primary key auto_increment not null,
	package_id				varchar(20) not null,
	package_name			varchar(40) not null,
	package_category		int not null,
	number_of_nights		int not null,
	number_of_days			int not null,
	package_description		varchar(300) not null,
	theme					int,
	best_season				varchar(40),
	valid_from				date not null,
	valid_to				date not null,
	booking_from			date not null,
	booking_to				date not null,
	package_highlights		varchar(300) not null,
	terms_and_conditions	varchar(1000) not null,
	package_inclusions		varchar(300) not null,
	package_exclusions		varchar(300) not null,
	services_id				int not null,
	package_type			int not null,
	country					int not null,
	package_destinations	int not null,
	cancellation_policy		varchar(300) not null,
	package_amenities		varchar(300) not null,
	itinerary_id			int,
	itinerary_type			int,
	package_hotels			int,
	package_supplier		int,
	package_budget			int,
	package_currency		int,
	meal_plan				int,
	package_status			int,
	origin_points			int,
	foreign key (package_category) references package_category_lookup_table (id),
	foreign key (theme) references theme_table (id),
	foreign key (package_type) references package_type_lookup_table (id),
	foreign key (country) references country_table (id),
	foreign key (package_destinations) references destination_table (id),
	foreign key (itinerary_id) references itinerary_table (id),
	foreign key (itinerary_type) references itinerary_type_lookup_table (id),
	foreign key (package_hotels) references hotel_table (id),
	foreign key (package_supplier) references supplier_table (id),
	foreign key (package_budget) references package_budget_lookup_table (id),
	foreign key (package_currency) references currency_lookup_table (id),
	foreign key (meal_plan) references meal_plan_lookup_table (id)
);

drop table if exists services_lookup_table;
create table services_lookup_table(
	id				int primary key auto_increment not null,
	package_id		int,
	service_name	varchar(40),
	foreign key (package_id) references package_table (id)
);
insert into services_lookup_table (service_name) values
	('Flight'),
	('Hotel'),
	('Cab'),
	('Cruise'),
	('Train'),
	('Insurance'),
	('Guide'),
	('Sight seeing');

drop table if exists price_table;
create table price_table(
	id						int primary key auto_increment not null,
	package_id				int,country_table
	default_city			int,
	city					varchar(20),	
	adult_single_sharing	double,
	adult_twin_sharing		double,
	adult_triple_sharing	double,
	child_with_bed			double,
	child_without_bed		double,
	infant					double,
	extra_bed				double,
	foreign key (package_id) references package_table (id)
);