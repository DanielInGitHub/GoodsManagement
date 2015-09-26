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

-- 显示所有表数据
SELECT * FROM user;
SELECT * FROM dept;
SELECT * FROM goods;
SELECT * FROM staff;
SELECT * FROM getgoods;
SELECT * FROM inrepository;
SELECT * FROM outrepository;

-- 常用查询语句

# 物品信息管理页展示数据
SELECT id, goodname, goodunit FROM goods;

SELECT * FROM goods;

# 库房盘存
SELECT id, goodname, sum(numbers) FROM goods GROUP BY goodname;

# 人员物品领用明细
SELECT getgoods.id, staff.staffname, goods.goodname, getgoods.getnumber
FROM getgoods
  LEFT JOIN staff ON getgoods.staffid = staff.id
  LEFT JOIN goods ON getgoods.goodid = goods.id
WHERE getgoods.id = 1;

# 入库信息明细
SELECT inr.goodid, time, goods.goodname, goodtype, number, supplycompany, supplier, phone, username,comments, storageid
FROM inrepository inr
  LEFT JOIN goods ON goods.id = inr.goodid
  LEFT JOIN user ON user.id = inr.operatorid;

# 出库信息明细
SELECT deliveryid, outr.id, time, goodname, goodtype, number, username, name, comments
FROM outrepository outr
  LEFT JOIN goods ON goods.id = goodid
  LEFT JOIN user ON user.id = operatorid
  LEFT JOIN dept ON dept.id = deptid;
  # GROUP BY deliveryid;

