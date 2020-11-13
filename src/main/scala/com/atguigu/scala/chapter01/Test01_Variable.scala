package com.atguigu.scala.chapter01

/**
 * @author chenhuiup
 * @create 2020-09-12 8:20
 */
object Test01_Variable {
  def main(args: Array[String]): Unit = {
    //(1)声明变量时，类型可以省略，编译器自动推导，即类型推导
    val a1 = 10
    val b1 = 20

    //（2）类型确定后，就不能修改，说明scala是强数据类型语言
    var a2 = 23
//    a2 = "hello"

    //(3) 变量声明时，必须要有初始值
//    var a3 :Int  //error
//    println(a3)

    //(4) 在声明/定义一个变量时，可以使用var或者val来修饰，var修饰的变量可改变，val修饰的变量不可改变
    val a4 = 13
    var b4 = 35
//    a4 = 25  //error
    b4 = 25

    //(5)var 修饰的对象引用可以改变，val修饰的对象则不可改变，但对象的状态（值）却是可以改变的
    val stu1 = new Student
    var stu2 = new Student

    //    stu1 = new Student()    // 不能对val类型的引用重新赋值

    stu1.name = "dongliang"
//    stu1.age = 20

    stu2 = new Student
  }

}


// 定义一个类
class Student {
  var name: String = ""
  val age: Int = 18
}