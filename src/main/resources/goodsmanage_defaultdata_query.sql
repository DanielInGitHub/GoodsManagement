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

