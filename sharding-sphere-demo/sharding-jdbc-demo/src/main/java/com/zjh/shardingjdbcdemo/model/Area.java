package com.zjh.shardingjdbcdemo.model;

public class Area {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area.id
     *
     * @mbg.generated Sat Nov 07 15:46:23 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column area.name
     *
     * @mbg.generated Sat Nov 07 15:46:23 CST 2020
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area.id
     *
     * @return the value of area.id
     *
     * @mbg.generated Sat Nov 07 15:46:23 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area.id
     *
     * @param id the value for area.id
     *
     * @mbg.generated Sat Nov 07 15:46:23 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column area.name
     *
     * @return the value of area.name
     *
     * @mbg.generated Sat Nov 07 15:46:23 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column area.name
     *
     * @param name the value for area.name
     *
     * @mbg.generated Sat Nov 07 15:46:23 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}