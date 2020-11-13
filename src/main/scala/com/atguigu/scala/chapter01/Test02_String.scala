package com.atguigu.scala.chapter01

import scala.collection.immutable.StringOps

/**
 * @author chenhuiup
 * @create 2020-09-12 8:29
 */
object Test02_String {
  def main(args: Array[String]): Unit = {
    //(1) 字符串，通过+号连接
    val name = "xiaohong"
    var age: Int = 18
    print(age + "岁的" + name + "在学校\n")

    println(name * 10)

    //(2) printf用法：字符串，通过%传值
    printf("%d岁的%s在吃饭", age, name * 3)

    //(3)字符串模板（插值字符串）：通过$获取变量值
    println(s"${age}岁的${name}在学习")
    val avgScore = 87.123456789
    //格式化
    print(f"平均分是$avgScore%.2f")
    //原样显示
    println(raw"${age}岁的${name}在学习") //平均分是87.1218岁的xiaohong在学习
    println(raw"${age}岁的${name}在\t学\n习") //18岁的xiaohong在\t学\n习

    //去边界多行字符串
    println(age + "岁的\n" + name + "\n在学校学习")
    println(
      s"""
         |${age}岁的
         |$name
         |""".stripMargin)

    println(
      s"""
${age}岁的
$name
在0621班级学习
         """)

    val sql: String =
      s"""
         |select *
         |from student
         |where
         |  name = $name
         |""".stripMargin

    //String是java中的引用数据类型，在scala中是AnyRef
    val s :String  = "hello"

    //StringOps是scala中的AnyVal类型
    val s1 :StringOps  = "hello"

//    s = s1 //报错 值类型不能转换为AnyRef类型

    //
//    val s2 : AnyVal = "hello" //报错，“hello”是String类型，AnyRef不能转换成AnyVal类型

    //
    val s3 : AnyRef = "hello"




  }
}
