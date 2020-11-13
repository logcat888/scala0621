package com.atguigu.scala.chapter06

/**
 * @author chenhuiup
 * @create 2020-09-16 18:49
 */
object Test09_AnonymousClass {
  def main(args: Array[String]): Unit = {
    val person = new Person9 {
      override var name: String = "赵丽颖"
      age = 15

      override def eat(): Unit = println(s"$name 是个好演员")
    }
    person.eat()
  }
}

//定义抽象类
abstract class Person9 {
  var name: String
  var age: Int = 18

  def eat(): Unit
}
