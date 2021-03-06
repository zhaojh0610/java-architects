package com.zjh.tccdemo.db130.dao;

import com.zjh.tccdemo.db130.model.AccountB;
import com.zjh.tccdemo.db130.model.AccountBExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountBMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    long countByExample(AccountBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    int deleteByExample(AccountBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    int insert(AccountB record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    int insertSelective(AccountB record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    List<AccountB> selectByExample(AccountBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    AccountB selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    int updateByExampleSelective(@Param("record") AccountB record, @Param("example") AccountBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    int updateByExample(@Param("record") AccountB record, @Param("example") AccountBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    int updateByPrimaryKeySelective(AccountB record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_b
     *
     * @mbg.generated Mon Nov 09 16:42:12 CST 2020
     */
    int updateByPrimaryKey(AccountB record);
}