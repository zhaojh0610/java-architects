package com.zjh.shardingjdbcdemo.model;

public class Order {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_1.id
     *
     * @mbg.generated Sat Nov 07 12:01:38 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_1.order_amount
     *
     * @mbg.generated Sat Nov 07 12:01:38 CST 2020
     */
    private Long orderAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_1.order_status
     *
     * @mbg.generated Sat Nov 07 12:01:38 CST 2020
     */
    private Integer orderStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_1.user_id
     *
     * @mbg.generated Sat Nov 07 12:01:38 CST 2020
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_1.id
     *
     * @return the value of t_order_1.id
     *
     * @mbg.generated Sat Nov 07 12:01:38 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_1.id
     *
     * @param id the value for t_order_1.id
     *
     * @mbg.generated Sat Nov 07 12:01:38 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_1.order_amount
     *
     * @return the value of t_order_1.order_amount
     *
     * @mbg.generated Sat Nov 07 12:01:38 CST 2020
     */
    public Long getOrderAmount() {
        return orderAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_1.order_amount
     *
     * @param orderAmount the value for t_order_1.order_amount
     *
     * @mbg.generated Sat Nov 07 12:01:38 CST 2020
     */
    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_1.order_status
     *
     * @return the value of t_order_1.order_status
     *
     * @mbg.generated Sat Nov 07 12:01:38 CST 2020
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_1.order_status
     *
     * @param orderStatus the value for t_order_1.order_status
     *
     * @mbg.generated Sat Nov 07 12:01:38 CST 2020
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_1.user_id
     *
     * @return the value of t_order_1.user_id
     *
     * @mbg.generated Sat Nov 07 12:01:38 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_1.user_id
     *
     * @param userId the value for t_order_1.user_id
     *
     * @mbg.generated Sat Nov 07 12:01:38 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}