package com.faxi.cloudmall.product.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/** faxi
 * @date 2021-08-09 21:51
 */

@Data
public class Skus {

  private List<AttrVo2> attr;
  private String skuName;
  private BigDecimal price;
  private String skuTitle;
  private String skuSubtitle;
  private List<Images> images;
  private List<String> descar;
  private int fullCount;
  private BigDecimal discount;
  private int countStatus;
  private BigDecimal fullPrice;
  private BigDecimal reducePrice;
  private int priceStatus;
  private List<MemberPrice> memberPrice;

}
