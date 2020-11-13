package com.atguigu.scala.chapter06

/**
 *  1. lazy关键字只能用于值定义，不能使用与属性的定义
 *  2. 可以使用lazy关键字使饿汉式变成懒汉式
 *
 * @author chenhuiup
 * @create 2020-09-16 20:47
 */
object Test12_Singleton {
  def main(args: Array[String]): Unit = {
    val student = Person12.getInstance()

    //使用lazy关键字使饿汉式变成懒汉式
    lazy val student1 = Person12.getInstance()

    println(student == student1) //true

  }

}

// 定义类，构造方法私有化
class Person12 private(var name: String, var age: Int) {
  def printinfo(): Unit = {
    println(s"student12: $name $age")
  }
}

// 定义伴生对象
// 1.懒汉式
//object Person12 {
// 声明出单例对象
//  private var person: Person12 = _
//
//  def getInstance():Person12 = {
//    if (person == null)
//    // 判断student是否为null，如果是，创建一个；如果不是，直接返回
//      person = new Person12("default",0)
//    person
//  }
//}


// 2.饿汉式
object Person12 {
  private var person: Person12 = new Person12("default", 0)

  def getInstance(): Person12 = person
}

