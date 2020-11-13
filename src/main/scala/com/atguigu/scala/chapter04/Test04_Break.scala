package com.atguigu.scala.chapter04

import scala.util.control.Breaks
import scala.util.control.Breaks._

/**
 * 1. scala使用异常捕获的方式实现循环的中断，从而避免了使用break，break关键字不属于面向对象。
 * 2. 用Breaks类的中的break() 抛出异常 def break(): Nothing = { throw breakException }
 * 3. 用Breaks类中的breakable()方法捕获异常
 * 4. 通过import scala.util.control.Breaks._ 方式导入Breaks下的所有方法对象， _代表导入所有，就可以直接使用Breaks对象的方法
 * 5. object Breaks extends Breaks，伴生对象Breaks继承了Breaks类，就具有Breaks类的所有方法
 *
 * @author chenhuiup
 * @create 2020-09-14 19:10
 */
object Test04_Break {
  def main(args: Array[String]): Unit = {
    // 1. 用异常实现中断
    try {
      for (i <- 1 to 10) {
        if (i == 5) {
          throw new Exception
        }
        println(i + "~~~")
      }
    } catch {
      //什么都不做连{}都可以省略
      case exception: Exception =>
    }
    println("退出循环")

    // 2.用Breaks类的方法调用实现退出循环
    Breaks.breakable(
      for (i <- 1 to 10) {
        if (i == 5) {
          Breaks.break()
        }
        println(i + "~~~")
      }
    )
    println("退出循环")

    breakable{
      for( i <- 1 to 10 ){
        println(i)
        if( i == 5 )
          break
      }
    }
    println("退出循环")

  }

}

/*
  def breakable(op: => Unit) {
    try {
      op
    } catch {
      case ex: BreakControl =>
        if (ex ne breakException) throw ex
    }
  }
 */