package com.atguigu.scala

/**
 * 1.包对象名与包名保持一致
 *
 * @author chenhuiup
 * @create 2020-09-15 20:42
 */
package object chapter06 {
 //定义共享的属性和方法
  val commonValue = "atguigu"
  def commonMetthod():Unit = {
    println("we study at " + commonValue)
  }
}
