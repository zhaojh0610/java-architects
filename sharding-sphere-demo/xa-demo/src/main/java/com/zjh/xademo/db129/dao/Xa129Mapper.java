package com.zjh.xademo.db129.dao;

import com.zjh.xademo.model.Xa129;
import com.zjh.xademo.model.Xa129Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Xa129Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_129
     *
     * @mbg.generated Sun Nov 08 14:13:00 CST 2020
     */
    long countByExample(Xa129Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_129
     *
     * @mbg.generated Sun Nov 08 14:13:00 CST 2020
     */
    int deleteByExample(Xa129Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_129
     *
     * @mbg.generated Sun Nov 08 14:13:00 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_129
     *
     * @mbg.generated Sun Nov 08 14:13:00 CST 2020
     */
    int insert(Xa129 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_129
     *
     * @mbg.generated Sun Nov 08 14:13:00 CST 2020
     */
    int insertSelective(Xa129 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_129
     *
     * @mbg.generated Sun Nov 08 14:13:00 CST 2020
     */
    List<Xa129> selectByExample(Xa129Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_129
     *
     * @mbg.generated Sun Nov 08 14:13:00 CST 2020
     */
    Xa129 selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_129
     *
     * @mbg.generated Sun Nov 08 14:13:00 CST 2020
     */
    int updateByExampleSelective(@Param("record") Xa129 record, @Param("example") Xa129Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_129
     *
     * @mbg.generated Sun Nov 08 14:13:00 CST 2020
     */
    int updateByExample(@Param("record") Xa129 record, @Param("example") Xa129Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_129
     *
     * @mbg.generated Sun Nov 08 14:13:00 CST 2020
     */
    int updateByPrimaryKeySelective(Xa129 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_129
     *
     * @mbg.generated Sun Nov 08 14:13:00 CST 2020
     */
    int updateByPrimaryKey(Xa129 record);
}