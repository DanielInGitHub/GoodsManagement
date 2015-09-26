# 加事务，保证数据库结构的完整
START TRANSACTION;

DROP DATABASE IF EXISTS CommodityManagement;
CREATE DATABASE CommodityManagement DEFAULT CHARACTER SET utf8;
USE CommodityManagement;

-- 部门信息表（部门编号、部门名称）
CREATE TABLE Department
(
  id   INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(16)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

-- 用户表（用户id、用户名、用户密码）
CREATE TABLE User
(
  id       INT PRIMARY KEY  AUTO_INCREMENT,
  username VARCHAR(16) NOT NULL,
  password VARCHAR(20) NOT NULL
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

-- 物品信息表（ 物品编号、物品名、物品单位、存货数量、物品类型 ）
CREATE TABLE Good
(
  id     INT PRIMARY KEY  AUTO_INCREMENT,
  name   VARCHAR(20) NOT NULL,
  unit   VARCHAR(5)  NOT NULL,
  number INT         NOT NULL,
  type   VARCHAR(20)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

-- 人员表（员工编号、人员姓名、性别、部门id）
CREATE TABLE Staff
(
  id     INT PRIMARY KEY AUTO_INCREMENT,
  name   VARCHAR(16)    NOT NULL,
  gender ENUM('男', '女') NOT NULL,
  deptid INT            NOT NULL,
  CONSTRAINT FK_STAFF_DEPT_ID FOREIGN KEY (deptid) REFERENCES Department (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

-- 领用信息表（编号、员工编号、物品编号、数量） 
CREATE TABLE GoodsConsume
(
  id      INT PRIMARY KEY NOT NULL,
  staffid INT             NOT NULL,
  goodid  INT             NOT NULL,
  number  INT             NOT NULL,
  CONSTRAINT FK_ID_STAFF FOREIGN KEY (staffid) REFERENCES Staff (id),
  CONSTRAINT FK_ID_GOODS FOREIGN KEY (goodid) REFERENCES Good (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

-- 入库信息表（入库id、入库时间、物品编号、入库物品数量、供应商、联系人、联系电话、操作员、备注、入库单号）
CREATE TABLE Storage
(
  id            INT PRIMARY KEY  AUTO_INCREMENT,
  time          DATE        NOT NULL,
  goodid        INT         NOT NULL,
  number        INT         NOT NULL,
  supplycompany VARCHAR(20) NOT NULL,
  supplier      VARCHAR(16) NOT NULL,
  phone         VARCHAR(11),
  operatorid    INT         NOT NULL,
  comments      VARCHAR(40),
  storageid     VARCHAR(20) NOT NULL,
  CONSTRAINT FK_ID_STAFF_IN FOREIGN KEY (goodid) REFERENCES Good (id),
  CONSTRAINT FK_ID_OPERATOR_IN FOREIGN KEY (operatorid) REFERENCES User (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

-- 出库信息表（出库id、出库时间、物品编号、出库物品数量、操作员、部门编号、部门分发给员工标准数量、备注、出库单号）
CREATE TABLE Delivery
(
  id         INT PRIMARY KEY  AUTO_INCREMENT,
  time       DATE        NOT NULL,
  goodid     INT         NOT NULL,
  number     INT         NOT NULL,
  operatorid INT         NOT NULL,
  deptid     INT         NOT NULL,
  defaultnum INT              DEFAULT 1,
  comments   VARCHAR(40),
  deliveryid VARCHAR(20) NOT NULL,
  CONSTRAINT FK_ID_STAFF_OUT FOREIGN KEY (goodid) REFERENCES Good (id),
  CONSTRAINT FK_ID_OPERATOR_OUT FOREIGN KEY (operatorid) REFERENCES User (id),
  CONSTRAINT FK_ID_DEPT_OUT FOREIGN KEY (deptid) REFERENCES Department (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

COMMIT;

