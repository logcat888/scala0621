package com.atguigu.scala.chapter09plus

/**
 * @author chenhuiup
 * @create 2020-09-20 14:41
 */
/*
1. scala中的异常都是非受检异常，所有的异常都是在运行时捕获，减少了程序员的负担
 */
object Test01_Exception {
  def main(args: Array[String]): Unit = {
    try {
      val n = 1 / 0
    } catch {
      case e:ArithmeticException => println("算术异常")
      case e:RuntimeException => println("其他异常")
      case _ =>
    } finally {
      println("异常处理结束")
    }
    println("核心代码")

  }
  @throws(classOf[NumberFormatException])
  def J20()={
    "abc".toInt
  }
}
