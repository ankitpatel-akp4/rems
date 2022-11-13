-- REMS Database Structure.
-- drop database masai_rems;
create database masai_rems;
use masai_rems;


create table department (
did int primary key auto_increment,
dname varchar(15)
);

-- initial values
insert into department values (1, 'admin');
insert into department values (2, 'bdo');
insert into department values (3, 'gpm');

create table users 
(
uid int not null,
did int not null,
password varchar(30) not null,
foreign key (did) references department (did),
constraint unique (uid,did)
);


-- initial values
insert into users values (1, 2,'123');
insert into users values (2, 2,'123');
insert into users values (3, 2,'123');





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
bid int,
gname varchar(25),
gemail varchar(25),
gmobile varchar(15),
gpin_code varchar(10),
foreign key (bid) references bdo (bid)
);


create table employee
( 
eid int primary key auto_increment,
gid int, 
ename varchar(40),
eemail varchar(25),
emobile varchar(15),
edob date,
e_registration_date  date,
gender enum('male','female','other'),
aadhar varchar(12) unique not null,
bank_account varchar(20),
ifsc varchar(15),
foreign key (gid) references gpm (gid)
);


create table project
(
pid int primary key auto_increment,
gid int,
bid int,
pname varchar(50),
pdescription varchar(1000),
budget int not null,
pstart_date date not null,
pexpected_end_date date not null,
pend_date date,
total_amount_expended int,
foreign key (gid)  references gpm (gid),
foreign key (bid)  references bdo (bid)
);


create table project_employee_payment
(
pid int,
eid int,
daily_wage int,
foreign key (pid) references project (pid),
foreign key (eid) references employee (eid),
constraint unique (pid,eid)
);

create table attendance
(
pid int,
eid int,
adate date,
present_absent boolean,
foreign key (pid) references project (pid),
foreign key (eid) references employee (eid)
);



-- show tables;

-- queries used

-- to log in
-- select * from users where uid=? and did=2 and password=?
-- select * from gpm where gid=?"
-- select * from users where uid=? and did=1 and password=?
-- select * from bdo where bid=?"

-- to insert 
-- insert into project (bid,pname, pdescription, budget, pstart_date,pexpected_end_date) values (?,?,?,?,?,?)
-- insert into gpm (bid,gname,gemail,gmobile,gpin_code) values (?,?,?,?,?)
-- insert into users values (?,'gpm',?)
-- insert into employee (gid, ename, eemail, emobile, edob, e_registration_date, gender, aadhar, bank_account, ifsc) values (?,?,?,?,?,?,?,?,?,?)")
-- insert into project_employee_payment values(?,?,?)
-- insert into attendance values(?,?,?,?)
--
-- to update 
-- update project set gid=? where pid=?
-- update project set pend_date=?,total_amount_expended=? where pid=?
--
-- te retrieve data 
-- select * from project
-- select gid from gpm where bid=? and gname=? and gemail=? and gmobile=? and gpin_code=?
-- select * from employee
-- select p.pid, p.eid, count(p.eid), daily_wage from project_employee_payment p inner join attendance a on p.pid=a.pid and p.eid=a.eid where a.pid=? and present_absent=1 group by p.pid, p.eid, daily_wage order by p.pid, p.eid
--




