package com.atguigu.scala.chapter06

/**
 *
 * 1. 主构造器中直接指定var类型，就定义了可变属性,scala推荐的方式，如果只有属性，
 * 没有方法可以省略类体{},相当于通过类管理多种不同类型的数据
 * 2. 在主构造器中定义属性，可以不给默认值，而在类体中定义属性必须给默认值。
 * 3. 主构造器属性没有加var/val，只是一个局部变量，对外不可见
 *
 * @author chenhuiup
 * @create 2020-09-15 23:23
 */
object Test06_ConstructorParameters {
  def main(args: Array[String]): Unit = {
    val student2 = new Student2()

    val student4 = new Student4("alice", 18)
    //    student4.name  //error ,主构造定义的局部变量，对外不可见

    val student5 = new Student5("张三", 18)

    val student6 = new Student6(age = 18)
    println(student6.school)
    student6.school = "atguigu"
    student6.printInfo()

  }

}

// 定义类

//1. 主构造器无参，定义可变属性，赋默认值
class Student2() {
  var name: String = _
  var age: Int = _
}

//2. 主构造器中直接指定var类型，就就定义了可变属性,scala推荐的方式
class Student3(var name: String, var age: Int)

class Student4(name: String, age: Int) {
  def printInfo(): Unit = {
    println(s"student4: $name $age")
  }
}

//scala 不推荐这样给属性赋值
//class Student5(_name: String, _age: Int){
//  var name = _name
//  var age = _age
//}

class Student5(val name: String, var age: Int)

// 同时提供主、辅构造方法
class Student6(var name: String = "alice", var age: Int) {
  var school: String = _

  def this(name: String, age: Int, school: String) {
    this(name, age)
    this.school = school
  }

  def printInfo(): Unit = {
    println(s"student6: $name $age $school")
  }
}