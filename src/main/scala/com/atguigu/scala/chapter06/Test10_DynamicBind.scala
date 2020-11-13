package com.atguigu.scala.chapter06

/**
 *  1.scala中属性和方法都能动态绑定，Java的动态绑定只针对于方法
 *
 * @author chenhuiup
 * @create 2020-09-16 19:00
 */
object Test10_DynamicBind{
  def main(args: Array[String]): Unit = {
    val person:Person10 = new Student10
    println(person.name)  // 赵丽颖
    println(person.sayHello) // hello student  ()   打印出来是括号是因为值调用，返回结果是Unit
  }

}

class Person10{
  val name = "张三"
  def sayHello = println("hello person")
}

class Student10 extends Person10{
  override val name: String = "赵丽颖"

  override def sayHello: Unit = println("hello student")
}