package com.atguigu.scala.chapter06

/**
 * @author chenhuiup
 * @create 2020-09-16 22:34
 */
object Test15_TraitOverlying {
  def main(args: Array[String]): Unit = {
    val studentTest = new Student15
    studentTest.increase()

    println("====================")

    // 钻石问题特征叠加
    val myBall = new MyFootBall
    println(myBall.describe())
  }
}

// Ball特征叠加示例
trait Ball {
  def describe(): String = "ball"
}

trait ColorBall extends Ball {
  override def describe(): String = "red-" + super.describe()
}

trait CategoryBall extends Ball {
  override def describe(): String = "foot-" + super.describe()
}

// 定义一个类，实现特征的混入
class MyFootBall extends CategoryBall with ColorBall {
  //  override def describe(): String = "my ball is a " + super[CategoryBall].describe()
  override def describe(): String = "my ball is a " + super.describe()
}

// Student特征叠加示例
trait Knowledge15 {
  var amount: Int = 0
  //  def increase(): Unit
  def increase(): Unit ={
    println("knowledge increase")
  }
}

// 天赋技能
trait Talent15 {
  def singing(): String
  def dancing(): String
  def increase(): Unit ={
    println("talent increase")
  }
}

class Student15 extends Talent15 with Knowledge15{
  override def singing(): String = ""

  override def dancing(): String = ""

  override def increase(): Unit = {
    super.increase()
  }
}