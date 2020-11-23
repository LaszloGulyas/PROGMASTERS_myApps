CREATE DATABASE BurgerDB;
USE BurgerDB;

#create basic Customer table
create table CUSTOMER
(
    `Customer Id` int auto_increment,
    `name`        varchar(30),
    constraint CUSTOMER_pk primary key (`Customer Id`)
);

#create basic Order table
create table `ORDER`
(
    `Order Id` int auto_increment,
    constraint ORDER_pk primary key (`Order Id`)
);

#setting foreign key + relation with Customer table
alter table `ORDER`
    add `Customer Id` int not null;
alter table `ORDER`
    add constraint `ORDER_CUSTOMER_Customer Id_fk`
        foreign key (`Customer Id`) references CUSTOMER (`Customer Id`);


#create burger table without relations
create table BURGER
(
    `Burger Id`   int auto_increment,
    `Burger Name` varchar(30) null,
    constraint BURGER_pk primary key (`Burger Id`)
);

#Create basic LineItem w/o relations
create table LINEITEM
(
    `Order Id`     int not null,
    `Burger Id`    int not null,
    `Burger count` int not null,
    primary key (`Order Id`, `Burger Id`)
);

#set up relations between Burger-LineItem & Order-LineItem (many to many)
alter table LINEITEM
    add constraint `LINEITEM_BURGER_Burger Id_fk`
        foreign key (`Burger Id`) references BURGER (`Burger Id`);
alter table LINEITEM
    add constraint `LINEITEM_ORDER_Order Id_fk`
        foreign key (`Order Id`) references `ORDER` (`Order Id`);


# Query: burger count by burger name by customer name
SELECT name, `Burger Name`, `Burger count`
FROM CUSTOMER
         JOIN `ORDER` O on CUSTOMER.`Customer Id` = O.`Customer Id`
         JOIN LINEITEM L on O.`Order Id` = L.`Order Id`
         JOIN BURGER B on L.`Burger Id` = B.`Burger Id`;