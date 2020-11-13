package com.atguigu.scala.chapter04

import scala.io.StdIn

/**
 * @author chenhuiup
 * @create 2020-09-14 18:23
 */
object Test01_IfElse {
  def main(args: Array[String]): Unit = {
    println("请输入你的芳龄：")
    val age = StdIn.readInt()
    if( age >= 18 ){
      println("成年")
      age + 1
      (age * 3).toDouble
    } else if( age >= 12 ){
      println("少年")
    } else {
      println("童年")
    }

    //条件分支语句是有返回值的，不同分支如果有不同类型的返回值，返回值类型应该统一为公共父类
    val description = if ( age >= 18 ){
      "成年"
    }else{
      "少年"
      age
    }

    // 条件分支赋值的简写(三元运算符 ()?a:b)
    val desc = if(age >= 18) "成年" else "少年"

    // 嵌套分支
    if( age >= 18 ){
      println("成年")
      if( age > 60 ){
        println("老年")
      } else {
        println("中青年")
        if( age < 30 ){
          println("青年")
        } else {
          println("中年")
        }
      }
    } else {
      println("青少年")
      if( age >= 12 ){
        println("少年")
      } else {
        println("童年")
      }
    }

    println(description)

  }


}
