package com.yayao.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 商品折扣类
 * @author yy
 *
 */
@Entity
@Table(name="merDiscount_tb",catalog="YaYaoMall_db")
@JsonIgnoreProperties({"merchandises"})
public class MerDiscount {

}
