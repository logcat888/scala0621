package com.atguigu.scala.chapter05

/**
 * @author chenhuiup
 * @create 2020-09-15 20:24
 */
object Test13_Lazy {
  def main(args: Array[String]): Unit = {
    lazy val result = sum(10, 25)
    println("******************")
    println(s"res ----- $result")
    println(s"res ----- $result")
  }

  def sum(a: Int, b: Int): Int = {
    println("-------------------")
    a + b
  }
}
