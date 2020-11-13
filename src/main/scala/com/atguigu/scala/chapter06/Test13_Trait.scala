package com.atguigu.scala.chapter06

/**
 * 1. 子类重写了父类的属性，当调用父类方法(super.),则父类方法使用到的属性是被重写后的属性。
 * 2. 不管是类还是特质，在继承/实现多个时，有同名的方法，必须重写，解决冲突问题。
 * 3. 特质叠加时，在子类中调用父类方法，如果叠加的特质之间没有关系，按照叠加执行顺序调用。
 *    比如 class student extends person with talent ，我们可以将person称为主特质，
 *    那么作为最本质的特质执行时放到后面，辅助特质talent写在后面，执行时放在前面，因此
 *    student通过super.方法，最先调用的就是talent中的方法，由于person与talent之间没有关系，
 *    所以不会继续往下调用（不同于钻石问题）。
 * 4. 钻石问题，文档写的很好，由具体到抽象，由一般到本质
 *
 * @author chenhuiup
 * @create 2020-09-16 21:34
 */
object Test13_Trait {
  def main(args: Array[String]): Unit = {
    val student = new Student13()
    student.sayHello()
    student.study()
    student.play()
    student.dating()
  }

}

//定义一个类
class Person13 {
  val name: String = "person"
  var age: Int = 20

  def sayHello() = println("hello from person " + name + " , 他" + age + "岁")

  def play() = println("父类 is playing")
}

class Student13 extends Person13 with Young {
  age = 15
  override val name: String = "赵丽颖"

  override def sayHello(): Unit = {
    super.sayHello()
    println(s"hello from student $name ，她$age 岁")
  }

  override def dating(): Unit = println(s"我在和$name 约会")

 override def play() = {
   super.play()
   println("子类 is playing")
 }

  def study(): Unit = println(s"student $name is studying")
}

//定义一个特质
trait Young {
  // 声明抽象属性
  var age: Int
  val name: String = "young"

  //声明抽象和非抽象方法
  def play() = println("young people is playing")

  def dating(): Unit
}
