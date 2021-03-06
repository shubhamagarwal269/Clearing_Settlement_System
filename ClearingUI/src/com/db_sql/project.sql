use master
drop database ClearingSettlement

create database ClearingSettlement

use ClearingSettlement;

CREATE TABLE MEMBER(
memberId NUMERIC(20) NOT NULL CONSTRAINT MEMBER_ID_PK PRIMARY KEY,
memberName VARCHAR(20) NOT NULL,
memberPassword VARCHAR(20),
memberEmail VARCHAR(50) NOT NULL,
bankAcNo NUMERIC(20) NOT NULL,
dematAcNo NUMERIC(20) NOT NULL
);


CREATE TABLE FUNDBORROW(
fundBorrowingRate NUMERIC(20,4) NOT NULL
);

CREATE TABLE SECURITY(
ISIN NUMERIC(20) NOT NULL CONSTRAINT SECURITY_ISIN_PK PRIMARY KEY,
securityName VARCHAR(20) NOT NULL,
marketPrice NUMERIC(20,2) NOT NULL,
borrowingRate NUMERIC(20,2) NOT NULL
);

CREATE TABLE TRADE(
tradeId NUMERIC(20) NOT NULL CONSTRAINT TRADE_ID_PK PRIMARY KEY,
ISIN NUMERIC(20) NOT NULL CONSTRAINT TRADE_ISIN_FK FOREIGN KEY  REFERENCES SECURITY(ISIN),
quantity NUMERIC(10) NOT NULL,
price NUMERIC(20,4) NOT NULL,
buyerMemberId NUMERIC(20) NOT NULL CONSTRAINT TRADE_BID_FK FOREIGN KEY REFERENCES MEMBER(memberId),
sellerMemberId NUMERIC(20) NOT NULL CONSTRAINT TRADE_SID_FK FOREIGN KEY REFERENCES MEMBER(memberId),
batchNum NUMERIC(20) NOT NULL
);


CREATE TABLE BANK_DETAILS(
bankAcNo NUMERIC(20) NOT NULL,
memberId NUMERIC(20) CONSTRAINT BA_MEMBER_ID_FK PRIMARY KEY REFERENCES MEMBER(memberId),
balance NUMERIC(20,2) NOT NULL
);

CREATE TABLE DEMAT_DETAILS(
dematAcNo NUMERIC(20) NOT NULL,
memberId NUMERIC(20) CONSTRAINT DA_MEMBER_ID_FK FOREIGN KEY REFERENCES MEMBER(memberId),
ISIN NUMERIC(20) NOT NULL CONSTRAINT DA_DETAILS_ISIN_FK FOREIGN KEY REFERENCES SECURITY(ISIN),
quantity NUMERIC(20) NOT NULL,
PRIMARY KEY (memberId, ISIN) 
);

CREATE TABLE OBG_REPORT(
memberId NUMERIC(20) NOT NULL CONSTRAINT OBG_REPORT_MEM_ID_FK FOREIGN KEY REFERENCES MEMBER(memberId),
batchNum NUMERIC(20) NOT NULL,
fundAmt NUMERIC (20,4) NOT NULL,
ISIN NUMERIC (20) NOT NULL CONSTRAINT PAY_IN_SEC_ISIN_FK FOREIGN KEY REFERENCES SECURITY(ISIN),
Quantity NUMERIC (20) NOT NULL,
PRIMARY KEY (memberId, batchNum, ISIN)
);

CREATE TABLE TEMPPASSLIST(
MEMBERMAIL VARCHAR(50) NOT NULL CONSTRAINT MEMBER_MAIL_PK PRIMARY KEY,
TEMPPASS VARCHAR(20) NOT NULL
);


insert into SECURITY values(0,'Apple', 101.1, 7);
insert into SECURITY values(1,'GE', 45.4, 8);
insert into SECURITY values(2,'Facebook', 76.5, 7);
insert into SECURITY values(3,'LinkedIn', 45.5, 11);
insert into SECURITY values(4,'Walmart', 155, 6);

insert into MEMBER values(0,'Citi','citi@123','citi@gmail.com',123456,123456);
insert into MEMBER values(1,'Detusche Bank','db@123','db@gmail.com',234567,234567);
insert into MEMBER values(2,'Goldman Sachs','gs@123','gs@gmail.com',345678,345678);
insert into MEMBER values(3,'JP Morgan','jp@123','jp@gmail.com',456789,456789);

insert into BANK_DETAILS values(123456,0,1000000);
insert into BANK_DETAILS values(234567,1,1000000);
insert into BANK_DETAILS values(345678,2,1000000);
insert into BANK_DETAILS values(456789,3,1000000);

insert into DEMAT_DETAILS values(123456,0,0,1000);
insert into DEMAT_DETAILS values(123456,0,1,1000);
insert into DEMAT_DETAILS values(123456,0,2,1000);
insert into DEMAT_DETAILS values(123456,0,3,1000);
insert into DEMAT_DETAILS values(123456,0,4,1000);

insert into DEMAT_DETAILS values(234567,1,0,1000);
insert into DEMAT_DETAILS values(234567,1,1,1000);
insert into DEMAT_DETAILS values(234567,1,2,1000);
insert into DEMAT_DETAILS values(234567,1,3,1000);
insert into DEMAT_DETAILS values(234567,1,4,1000);

insert into DEMAT_DETAILS values(345678,2,0,1000);
insert into DEMAT_DETAILS values(345678,2,1,1000);
insert into DEMAT_DETAILS values(345678,2,2,1000);
insert into DEMAT_DETAILS values(345678,2,3,1000);
insert into DEMAT_DETAILS values(345678,2,4,1000);

insert into DEMAT_DETAILS values(456789,3,0,1000);
insert into DEMAT_DETAILS values(456789,3,1,1000);
insert into DEMAT_DETAILS values(456789,3,2,1000);
insert into DEMAT_DETAILS values(456789,3,3,1000);
insert into DEMAT_DETAILS values(456789,3,4,1000);

select * from MEMBER;
select * from BANK_DETAILS;
select * from DEMAT_DETAILS;
select * from SECURITY;
select * from trade;
select * from OBG_REPORT;
select * from FUNDBORROW;

insert into FUNDBORROW values(.0125);
