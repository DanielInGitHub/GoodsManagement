# 加事务，保证数据库结构的完整
SET AUTOCOMMIT = 0;
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
CREATE TABLE Commodity
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
  CONSTRAINT FK_ID_GOODS FOREIGN KEY (goodid) REFERENCES Commodity (id)
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
  CONSTRAINT FK_ID_STAFF_IN FOREIGN KEY (goodid) REFERENCES Commodity (id),
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
  CONSTRAINT FK_ID_STAFF_OUT FOREIGN KEY (goodid) REFERENCES Commodity (id),
  CONSTRAINT FK_ID_OPERATOR_OUT FOREIGN KEY (operatorid) REFERENCES User (id),
  CONSTRAINT FK_ID_DEPT_OUT FOREIGN KEY (deptid) REFERENCES Department (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

COMMIT;

START TRANSACTION ;

-- 插入测试数据
USE CommodityManagement;

INSERT INTO Department (name) VALUE ("无线事业部");
INSERT INTO Department (name) VALUE ("技术服务部");
INSERT INTO Department (name) VALUE ("运维支持部");
INSERT INTO Department (name) VALUE ("后台服务部");
INSERT INTO Department (name) VALUE ("软件开发部");

INSERT INTO User  VALUES (1, "admin", "admin");
INSERT INTO User  VALUES (2, "user", "user");

INSERT INTO Commodity VALUES (1, "衣服", "件", 30, "大码");
INSERT INTO Commodity VALUES (2, "裤子", "件", 20, "超大码");
INSERT INTO Commodity VALUES (3, "袜子", "双", 50, "小码");
INSERT INTO Commodity VALUES (4, "鞋子", "双", 20, "中码");
INSERT INTO Commodity VALUES (5, "月饼", "个", 80, "豆沙");
INSERT INTO Commodity VALUES (6, "月饼", "个", 20, "莲蓉");

INSERT INTO Staff VALUES (1, "小黑狗", "女", 1);
INSERT INTO Staff VALUES (2, "大黄狗", "男", 2);
INSERT INTO Staff VALUES (3, "牛羊新", "男", 3);
INSERT INTO Staff VALUES (4, "汉子", "女", 1);

INSERT INTO GoodsConsume VALUES (1, 1, 1, 20);
INSERT INTO GoodsConsume VALUES (2, 2, 2, 10);
INSERT INTO GoodsConsume VALUES (4, 3, 6, 20);
INSERT INTO GoodsConsume VALUES (5, 4, 4, 40);

INSERT INTO Storage (id, time, goodid, number, supplycompany, supplier, phone, operatorid, comments, storageid)  VALUES (1, 20150919, 1, 20, "卖衣服的", "黄衣党", 12345678901, 1, "买了几件衣服和裤子", "1111");
INSERT INTO Storage (id, time, goodid, number, supplycompany, supplier, phone, operatorid, comments, storageid)  VALUES (2, 20150919, 2, 30, "卖裤子的", "酷酷党", 12345678901, 1, "买了几件破裤子", "2222");
INSERT INTO Storage (id, time, goodid, number, supplycompany, supplier, phone, operatorid, comments, storageid)  VALUES (3, 20150919, 4, 30, "卖鞋的", "飞鞋党", 12345678901, 1, "买了几件破鞋", "XIEZI");
INSERT INTO Storage (id, time, goodid, number, supplycompany, supplier, phone, operatorid, comments, storageid)  VALUES (4, 20150919, 5, 30, "卖月饼的", "咸蛋超人", 12345678901, 1, "可以吃月饼咯", "yuebing");
INSERT INTO Storage (id, time, goodid, number, supplycompany, supplier, phone, operatorid, comments, storageid)  VALUES (5, 20150919, 2, 30, "卖裤子的", "酷酷党", 12345678901, 1, "买了几件衣服和裤子", "1111");

INSERT INTO Delivery (time, goodid, number, operatorid, deptid, defaultnum, comments, deliveryid)  VALUES (20150920, 1, 10, 1, 1, 3, "发衣服咯", "YIFU");
INSERT INTO Delivery (time, goodid, number, operatorid, deptid, defaultnum, comments, deliveryid)  VALUES (20150920, 2, 10, 1, 1, 3, "发裤子咯", "KUZI");
INSERT INTO Delivery (time, goodid, number, operatorid, deptid, defaultnum, comments, deliveryid)  VALUES (20150920, 5, 10, 1, 5, 3, "发月饼咯", "YUEBING");
INSERT INTO Delivery (time, goodid, number, operatorid, deptid, defaultnum, comments, deliveryid)  VALUES (20150921, 5, 10, 1, 1, 3, "发衣服咯", "YIFU");

COMMIT;
