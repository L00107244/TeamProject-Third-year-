
drop table if exists Ward;
create table Ward(
	id int not null primary key auto_increment,
    ward_name varchar(20) not null,
    room_type varchar(20) not null,
    bed_number int not null,
    bed_free int not null
);

drop table if exists Bedside_Notes;
create table Bedside_Notes(
	id int not null primary key auto_increment,
    patient_id int(8) not null references Patient(id),
    Blood_type int(8) not null references Blood_type(id),
    blood_pressure varchar(10),
    blood_results varchar(50),
    comments varchar(200),
    investigations varchar(200),
    Pstatus varchar(100),
    notes_date date,
    notes varchar(200),
    seen_by varchar(100)
);

drop table if exists Tests;
create table Tests(
	id int not null primary key auto_increment,
    patient_id int(8) not null references Patient(id),
    test_type varchar(20),
    results varchar(100),
    test_date date,
    seen_by varchar(100)
);


drop table if exists Blood_type;
create table Blood_type(
	id int not null primary key,
	type varchar(30)
);

drop table if exists Gender;
create table Gender(
	id int not null primary key,
	gender varchar(30)
);
drop table if exists speciality;
create table speciality(
	id int not null primary key,
	speciality varchar(30)
);

drop table if exists Dosage;
create table Dosage(
	id int not null primary key,
	dosage varchar(10)
);


drop table if exists referral_class;
create table referral_class(
	id int not null primary key,
	rf varchar(50)
);

drop table if exists Treatment_type;
create table Treatment_type(
	id int not null primary key,
	type varchar(30)
);
drop table if exists Title;
create table Title(
	id int not null primary key,
	title varchar(30)
);

drop table if exists Patient;
create table Patient(
	id int not null primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    DOB Date not null,
    address varchar(200) not null,
    email varchar(50),
    phone_Nb char(10),
	PPSN char(8) not null,
    religion varchar(50),
    next_of_kin varchar(50),
    next_of_kin_pn char(10),
    allergy varchar(200),
    history varchar(200),
    referral varchar(50),
    referral_class int not null references referral_class(id),
	ward_id int references Ward(id),
    date_of_admisson date not null,
    length_of_stay varchar(50)
);

drop table if exists Staff;
create table Staff(
	id int not null primary key auto_increment,
    title int not null references Title(id),
    gender int not null references Gender(id),
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    address varchar(200) not null,
    phone_Nb char(10),
    email varchar(50) not null,
    speciality int references speciality(id),
    username varchar(30),
    Password varchar(30)
);

drop table if exists Diagnosis;
create table Diagnosis(
	id int not null primary key auto_increment,
    patient_id int not null references Patient(id),
    presenting_complaint varchar(200),
    symptoms varchar(200),
    diagnosis varchar(200),
    date_issued date,
    seen_by varchar(1000)
);

drop table if exists Treatment;
create table Treatment(
	id int not null primary key auto_increment,
    patient_id int not null references Patient(id),
	treatment_type int not null references Treatment_type(id),
    dosage int references Dosage(id),
    treatment_name varchar(30),
    treatment_length varchar(30),
    effects varchar(100),
    begin_date date,
    end_date date,
    notes varchar(200),
    given_by varchar(100)
);


insert into Patient(
    first_name,
    last_name,
    DOB,
    address,
    email,
    phone_Nb,
	PPSN,
    religion,
    next_of_kin,
    next_of_kin_pn,
    allergy,
    history,
    referral,
    referral_class,
     date_of_admisson,
    length_of_stay)
    values('John','Smith','1959-11-11','42 not here street','johntest@gmail.com','0871235684','1234567A', 'chatolic','Mary Smith', '0877718912','nuts','tonsillitis','Surgical 2',1, '2016-06-13' , '3 weeks');
    insert into Patient(
    first_name,
    last_name,
    DOB,
    address,
    email,
    phone_Nb,
	PPSN,
    religion,
    next_of_kin,
    next_of_kin_pn,
    allergy,
    history,
    referral,
    referral_class,
     date_of_admisson,
    length_of_stay)
    values('Stephen','Reilly','1969-11-11','15 Ramelton rd cavan','StephenReilly@gmail.com','0861239863','1483934A', 'chatolic','Susan Reilly', '0874568234','none','Cancer','Surgical',2, '2016-04-13' , '5 weeks');
    
    insert into Patient(
    first_name,
    last_name,
    DOB,
    address,
    email,
    phone_Nb,
	PPSN,
    religion,
    next_of_kin,
    next_of_kin_pn,
    allergy,
    history,
    referral,
    referral_class,
     date_of_admisson,
    length_of_stay)
    values('John','Smith','1959-11-11','42 not here street','johntest@gmail.com','0871235684','1234567A', 'chatolic','Mary Smith', '0877718912','nuts','tonsillitis','Surgical 2',1, '2016-06-13' , '3 weeks');
    
    insert into Patient(
    first_name,
    last_name,
    DOB,
    address,
    email,
    phone_Nb,
	PPSN,
    religion,
    next_of_kin,
    next_of_kin_pn,
    allergy,
    history,
    referral,
    referral_class,
     date_of_admisson,
    length_of_stay)
    values('Gavin','Burns','1979-11-11','15 navan rd cavan','GavB@gmail.com','0830956348','1237640A', 'chatolic','Kelly Burns', '0875551891','Milk','Meningitis','ICU',1, '2016-04-13' , '4 weeks');

insert into Bedside_Notes(
    patient_id,
    Blood_type,
    blood_pressure,
    blood_results,
    comments,
    investigations,
    Pstatus,
    notes_date,
    notes,
    seen_by)
    values(1,1,'60','calcium=40','do not feed','did mri came up clear','stable','2016-04-22','only give water','Dr.Curran');
    insert into Bedside_Notes(
    patient_id,
    Blood_type,
    blood_pressure,
    blood_results,
    comments,
    investigations,
    Pstatus,
    notes_date,
    notes,
    seen_by)
    values(2,4,'70','VitD=40','can eat fruit','did mri came up clear','stable','2016-04-22','only feed once a day','Dr.Curran');
insert into ward(
    ward_name,
    room_type,
    bed_number,
    bed_free)values('cardiology','public','20','20');
    
    
  insert into ward(
    ward_name,
    room_type,
    bed_number,
    bed_free)values('Surgical','public','20','10'); 
    
     insert into ward(
    ward_name,
    room_type,
    bed_number,
    bed_free)values('Surgical2','public','20','9'); 
    
     insert into ward(
    ward_name,
    room_type,
    bed_number,
    bed_free)values('ICU','public','20','12'); 
    
     insert into ward(
    ward_name,
    room_type,
    bed_number,
    bed_free)values('Pediatrics','public','20','10'); 
    


insert into title values(1,'Mr');
insert into title values(2,'Dr');
insert into title values(3,'Mrs');
insert into title values(4,'Miss');

insert into Gender values(1,'Male');
insert into Gender values(2,'Female');


insert into speciality values(1,'Doctor');
insert into speciality values(2,'Nurse');
insert into speciality values(3,'Admistrator');


insert into Treatment_type values(1,'Medication');
insert into Treatment_type values(2,'Therapy');
insert into Treatment_type values(3,'Surgery');

insert into Blood_type values(1,'A+');
insert into Blood_type values(2,'A-');
insert into Blood_type values(3,'B+');
insert into Blood_type values(4,'B-');
insert into Blood_type values(5,'AB+');
insert into Blood_type values(6,'AB-');
insert into Blood_type values(7,'O+');
insert into Blood_type values(8,'O-');

insert into Dosage values(1,'50mg');
insert into Dosage values(2,'60mg');
insert into Dosage values(3,'100mg');
insert into Dosage values(4,'150mg');
insert into Dosage values(5,'200mg');
insert into Dosage values(6,'250mg');
insert into Dosage values(7,'300mg');

insert into referral_class values(1,'Accident and emergency');
insert into referral_class values(2,'GP');

insert into Staff(
	id,
    title,
    gender,
    first_name,
    last_name,
    address,
    phone_Nb,
    email,
    speciality,
    username,
    Password) values(1,1,1,'Shaun','Boyle','carrick mines donegal','0868792356','ShaunB@Gmail.com',3,'Admin1','password1');
    insert into Staff(
	id,
    title,
    gender,
    first_name,
    last_name,
    address,
    phone_Nb,
    email,
    speciality,
    username,
    Password) values(2,1,1,'Stephen','Curran','Drung Co.Cavan','0877718912','StephenC@gmail.com',1,'Doctor1','password2');
       insert into Staff(
	id,
    title,
    gender,
    first_name,
    last_name,
    address,
    phone_Nb,
    email,
    speciality,
    username,
    Password) values(3,1,1,'Gabin','Gorrez','west cork Cork','0867891234','Gab@gmail.com',2,'Nurse1','password3');
    
    insert into Tests(
    patient_id,
    test_type,
    results,
    test_date,
    seen_by)
    values(1,'urine test','clear','2016-04-22','Dr.Curran');
    
        insert into Tests(
    patient_id,
    test_type,
    results,
    test_date,
    seen_by)
    values(2,'Blood test','Low Iron','2016-04-22','Dr.Curran');
    
    insert into Diagnosis(
    patient_id,
    presenting_complaint,
    symptoms,
    diagnosis,
    date_issued,
    seen_by)
    values(1,'constant headache','cough','flu', '2016-08-04','Dr.Curran');
    

insert into Treatment(
    patient_id,
	treatment_type,
    dosage,
    treatment_name,
    treatment_length,
    effects,
    begin_date,
    end_date,
    notes,
    given_by)
    values(1,1,4,'Panadol','two weeks','drowsyness','2016-04-22','2016-05-12','take one once a day','Dr.Curran');

