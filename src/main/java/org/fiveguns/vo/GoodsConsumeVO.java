package org.fiveguns.vo;

/**
 * 所有需要显示的信息的封装类
 * Created by johnny on 15-9-23.
 */
public class GoodsConsumeVo {
    private int number;
    private String staffname;
    private int id;
    private String gender;
    private String deptname;
    private String commodityname;
    private String type;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(String commodityname) {
        this.commodityname = commodityname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "GoodsConsumeVo{" +
                "number=" + number +
                ", name='" + staffname + '\'' +
                ", id=" + id +
                ", gender='" + gender + '\'' +
                ", deptname='" + deptname + '\'' +
                ", commodityname='" + commodityname + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
