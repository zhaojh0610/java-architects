package com.zjh.tccdemo.db129.dao;

import com.zjh.tccdemo.db129.model.PaymentMsg;
import com.zjh.tccdemo.db129.model.PaymentMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentMsgMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Mon Nov 09 19:51:52 CST 2020
     */
    long countByExample(PaymentMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Mon Nov 09 19:51:52 CST 2020
     */
    int deleteByExample(PaymentMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Mon Nov 09 19:51:52 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Mon Nov 09 19:51:52 CST 2020
     */
    int insert(PaymentMsg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Mon Nov 09 19:51:52 CST 2020
     */
    int insertSelective(PaymentMsg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Mon Nov 09 19:51:52 CST 2020
     */
    List<PaymentMsg> selectByExample(PaymentMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Mon Nov 09 19:51:52 CST 2020
     */
    PaymentMsg selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Mon Nov 09 19:51:52 CST 2020
     */
    int updateByExampleSelective(@Param("record") PaymentMsg record, @Param("example") PaymentMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Mon Nov 09 19:51:52 CST 2020
     */
    int updateByExample(@Param("record") PaymentMsg record, @Param("example") PaymentMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Mon Nov 09 19:51:52 CST 2020
     */
    int updateByPrimaryKeySelective(PaymentMsg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Mon Nov 09 19:51:52 CST 2020
     */
    int updateByPrimaryKey(PaymentMsg record);
}