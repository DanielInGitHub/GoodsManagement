package org.fiveguns.po;

public class CommodityDto {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.id
     *
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.name
     *
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.unit
     *
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    private String unit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.number
     *
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    private Integer number;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.type
     *
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    private String type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.id
     *
     * @return the value of commodity.id
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.id
     *
     * @param id the value for commodity.id
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.name
     *
     * @return the value of commodity.name
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.name
     *
     * @param name the value for commodity.name
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.unit
     *
     * @return the value of commodity.unit
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.unit
     *
     * @param unit the value for commodity.unit
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.number
     *
     * @return the value of commodity.number
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.number
     *
     * @param number the value for commodity.number
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.type
     *
     * @return the value of commodity.type
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.type
     *
     * @param type the value for commodity.type
     * @mbggenerated Sat Sep 26 15:34:39 CST 2015
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}