package com.zjh.tccdemo.db130.model;

import java.math.BigDecimal;

public class AccountB {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_b.id
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_b.name
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_b.blance
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    private BigDecimal blance;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_b.id
     *
     * @return the value of account_b.id
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_b.id
     *
     * @param id the value for account_b.id
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_b.name
     *
     * @return the value of account_b.name
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_b.name
     *
     * @param name the value for account_b.name
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_b.blance
     *
     * @return the value of account_b.blance
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    public BigDecimal getBlance() {
        return blance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_b.blance
     *
     * @param blance the value for account_b.blance
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    public void setBlance(BigDecimal blance) {
        this.blance = blance;
    }
}