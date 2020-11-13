package com.atguigu.scala.chapter06



/**
 * @author chenhuiup
 * @create 2020-09-16 22:07
 */
object Test14_TraitMixin {
  def main(args: Array[String]): Unit = {
    val student = new Student14
    student.study()
    student.increase()
    student.play()
    student.increase()
    student.dating()
    student.increase()

    println("===========================")

    //动态混入特征
    val studentWithTalent = new Student14 with Talent {
      override def singing(): String = s"$name 在唱歌，她$age 岁"

      override def dancing(): String = s"$name 在跳舞，她$age 岁"
    }
    studentWithTalent.sayHello()
    studentWithTalent.study()
    println(studentWithTalent.singing())

  }

}

// 再定义一个特征
trait Knowledge {
  var amount: Int = 0

  def increase(): Unit

  def play() = println("knowledge is palying")

  //  def increase(): Unit ={
  //    println("knowledge increase")
  //  }
}

// 天赋技能
trait Talent {
  def singing(): String

  def dancing(): String

  //  def increase(): Unit ={
  //    println("talent increase")
  //  }
}

//实现一个子类，混入特质
class Student14 extends Person13 with Young with Knowledge {
  override val name: String = "student"
  age = 18

  override def sayHello(): Unit = println(s"hello from student $name")

  override def dating(): Unit = println(s"student $name is dating")

  def study(): Unit = println(s"student $name is studying")

  override def play(): Unit = super.play()



  override def increase(): Unit = {
    amount += 2
    println(s"student knowledge increased: $amount")
  }
}