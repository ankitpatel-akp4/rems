-- REMS Database Structure.

drop database rems;
create database rems;
use rems;

create table users 
(
uid int not null,
did enum('bdo','gpm','admin') not null,
password varchar(30) not null,
constraint uid_did unique (uid,did)
);
-- initial values
insert into users values (1,'bdo','123');
insert into users values (2,'bdo','123');
insert into users values (3,'bdo','1234');


create table bdo(
bid int primary key auto_increment,
bname varchar(25),
bemail varchar(25),
bpin_code varchar(10),
district varchar(25),
state varchar(25)
);
-- initial values
insert into bdo values (1,'Siar','indicate0@gmail.com','221715','Ballia','UP');
insert into bdo values (2,'Rasra','123@gmail.com','221719','mau','UP');
insert into bdo values (3,'Luna','1234@gmail.com','251719','Surat','Gujarat');


create table gpm
(
gid int primary key auto_increment,
gbid int,
gname varchar(25),
gemail varchar(25),
gmobile varchar(15),
gpin_code varchar(10),
foreign key (gbid) references bdo (bid)
);


create table employee
( 
eid int primary key auto_increment,
egid int, 
ename varchar(40),
eemail varchar(25),
emobile varchar(15),
edob date,
e_registration_date  date,
gender enum('male','female','other'),
aadhar varchar(12) unique not null,
banck_account varchar(20),
ifsc varchar(15),
foreign key (egid) references gpm (gid)
);


create table project
(
pid int primary key auto_increment,
pgid int,
pname varchar(50),
pdescription varchar(1000),
budget int not null,
pstart_date date not null,
pexpected_end_date date not null,
pend_date date,
total_amount_expended int,
foreign key (pgid)  references gpm (gid)
);


create table project_employee_payment
(
pepid int,
peeid int,
daily_wage int,
foreign key (pepid) references project (pid),
foreign key (peeid) references employee (eid)
);

create table attendance
(
apid int,
aeid int,
adate date,
present_absent boolean,
foreign key (apid) references project (pid),
foreign key (aeid) references employee (eid)
);