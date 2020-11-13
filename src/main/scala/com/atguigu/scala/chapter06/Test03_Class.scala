package com.atguigu.scala.chapter06

import scala.beans.BeanProperty

/**
 * 1. 局部变量不能设置默认值
 * 2. val 修饰的属性不能通过 _ 给默认值，使用_说明以后肯定修改，底层只提供类型的get方法，不能修改
 * 3. scala属性默认值是public，底层java实现是private的，他会提供类似的get或set方法。
 * 因此可以通过对象.的方式修改
 * 4. 当我们给属性设置为private后，new出的对象就不可见这些属性。
 *
 * @author chenhuiup
 * @create 2020-09-15 21:08
 */
object Test03_Class {
  def main(args: Array[String]): Unit = {
//    val a: String = _ //error

    //创建对象
    val student = new Student
    //    student.name     // error
    println(student.age)
    println(student.sex)
    student.sex = "男"
    println(student.sex)

  }

}

//定义一个Student类
class Student {
  private var name: String = "DongLiang"

  @BeanProperty
  var age: Int = _
  var sex: String = _
}