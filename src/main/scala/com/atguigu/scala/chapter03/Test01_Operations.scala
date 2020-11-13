package com.atguigu.scala.chapter03

/**
 *  1.scala中 String 的 == 和 equals 都是比较的对象的内容，即 == 和 equals相等，对==方法进行了重写，与java不同
 *  2.scala中如果想比较两个对象的地址值，使用 eq（）方法
 *  3.scala中如果自定义的类没有重写 == 和 equals，依然沿用java中的 == ，比较的是地址值
 *  4.scala中 String 沿用java的String，属于AnyRef类型，字符串赋值默认是String类型。而StringOps属于AnyVal类型
 *  5.scala中String 类型 通过 new的方式  和字面量赋值的方式赋值，使用 == 或 equals比较都是一样的。
 *  6.scala中AnyRef默认是Null类型，Null类型只有一个单例对象null。AnyVal默认是Unit类型，Unit的对象被封装成BoxedUnit，
 *    其toString方法的返回值是()
 *  7.scala中运算符的本质是对象调用方法，万事万物皆对象，数值、运算符都是对象。
 *
 * @author chenhuiup
 * @create 2020-09-14 17:46
 */
object Test01_Operations {
  def main(args: Array[String]): Unit = {
    //1.算术运算符
    //2.关系运算符
    val st1:String = new String("hello")
    val st2 = "hello"  //st2为String类型
    println(st1 == st2) //ture
    println(st1.equals(st2)) //true
    println(st1.eq(st2)) //false

    println("-------------------")
    val stu1 = new Student
    val stu2 = new Student
    println(st1.==(st2)) //false
    println(stu1 equals stu2) //false
    println(stu1 eq stu2) //false

    //3.逻辑运算符
    def isNotEmpty(str:String):Boolean = {
      //防止空指针
      str != null && "".equals(str.trim)
    }
    println(isNotEmpty(null)) //false
  }

  //4.运算符的本质
  val a = 10.+(20)
  10 + 20
  "10.35".toDouble.toInt
  10.35 toString

}

class Student{
  var name : String = _
}
