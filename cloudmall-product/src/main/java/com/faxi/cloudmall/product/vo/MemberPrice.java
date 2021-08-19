package com.faxi.cloudmall.product.vo;

import lombok.Data;

import java.math.BigDecimal;

/** faxi
 * @date 2021-08-09 21:54
 */

@Data
public class MemberPrice {

  private Long id;
  private String name;
  private BigDecimal price;

}
