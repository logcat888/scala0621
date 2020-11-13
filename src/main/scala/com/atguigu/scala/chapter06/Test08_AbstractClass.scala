package com.atguigu.scala.chapter06

/**
 * 1. 子类实现抽象属性和抽象方法，可以省略override，但是对于抽象属性不能省略var / val，可以给默认值
 * 2. 子类重写父类非抽象属性，对于var 类型的，直接赋值即可（不能重写，否则编译不通过），对于val 类型，不能省略override
 * 3. 子类重写父类非抽象方法，必须使用override
 * 4. super只能调用调用父类方法，不能调用属性
 *
 * @author chenhuiup
 * @create 2020-09-16 8:09
 */
object Test08_AbstractClass {
  def main(args: Array[String]): Unit = {
    val student = new Student8()
    println(student.name)
  }
}


//定义抽象类
abstract class Person8 {
  //非抽象属性
  val idCradNo: String = "000001"
  var name: String = "alice"

  //抽象属性
  val age: Int
  var sex: String

  //非抽象方法
  def eat(): Unit = {
    println("person eat by mouth")
  }

  //抽象方法
  def Sleep(): Unit
}

class Student8 extends Person8 {
  //非抽象属性
  //  override val idCradNo: String = "000001"
  override val idCradNo: String = "000001"
//  override var name: String = "bob" //error,idea不报错，但是编译报错
  //   var name: String = "alice"  //error
    name = "bob"

  //抽象属性
  //  override val age: Int = 123456  //ok
  //  override var sex: String = _   //ok
  val age: Int = 123456
  //  var sex: String = _ //ok
  var sex = "15623"
  //  sex = "15623" //error

  //非抽象方法
  override def eat(): Unit = super.eat()

  //  def eat(): Unit = super.eat()  //error


  //抽象方法
  //  override def Sleep(): Unit = ??? //ok
  def Sleep(): Unit = ???
}