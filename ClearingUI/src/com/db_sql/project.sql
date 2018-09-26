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
price NUMERIC(20,2) NOT NULL,
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
batchNum NUMERIC(20) NOT NULL CONSTRAINT OBG_REPORT_BATCH_NUM_FK FOREIGN KEY REFERENCES TRADE(batchNum),
fundAmt NUMERIC (20,2) NOT NULL,
ISIN NUMERIC (20) NOT NULL CONSTRAINT PAY_IN_SEC_ISIN_FK FOREIGN KEY REFERENCES SECURITY(ISIN),
Quantity NUMERIC (20) NOT NULL,
PRIMARY KEY (memberId, batchNum)
);



