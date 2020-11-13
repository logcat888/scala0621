package com.atguigu.scala.chapter06

/**
 * @author chenhuiup
 * @create 2020-09-15 21:19
 */
object Test04_ClassForAccess {
  def main(args: Array[String]): Unit = {

  }

}

class Person{
  private var idCardNo: String = "123456"
  protected var name: String = "alice"
  private [chapter06] var age :Int = 18
  var sex: String = "女"

  def printInfo(): Unit ={
    println(s"this is a person: $idCardNo $name $age $sex")
  }
}
