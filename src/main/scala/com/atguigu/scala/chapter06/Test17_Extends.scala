package com.atguigu.scala.chapter06

/**
 * 1. 子类对象肯定是父类类型，判断一个对象是否是某一个类型，就看该对象是否具有该类型的所有属性、方法
 * 2.  造型(asInstanceOf[T]) 造型有风险，用时先判断（isInstanceof），造型后就可以使用子类的方法
 * 3.  造型前后对象的地址值不变，还是对空间的同一个地址
 * 4.  应用类需要继承App，可以直接执行代码，不需要写main，相当于封装了一层
 * 5.  Enumeration类为抽象类，枚举类需要继承Enumeration类，同时使用Value为枚举对象赋值
 * 6.   Enumeration类源码的第一行  thisenum =>   thisenum相当于给当前对象起个别名，因为this有其它用途
 *
 * @author chenhuiup
 * @create 2020-09-16 22:58
 */
object Test17_Extends {
  def main(args: Array[String]): Unit = {
    // 1. 类型的检查和转换
    val student1: Student17 = new Student17("alice", 18)
    student1.study()
    val student2: Person17 = new Student17("bob", 25)
    student2.sayHi()

    val isPerson1: Boolean = student1.isInstanceOf[Person17]
    val isPerson2: Boolean = student2.isInstanceOf[Person17]
    val isStudent: Boolean = student2.isInstanceOf[Student17]

    val person: Person17 = new Person17("cary", 36)
    println(person.isInstanceOf[Student17]) //false

    println("student1 is person: " + isPerson1) //true
    println("student2 is person: " + isPerson2) //true
    println("student2 is student: " + isStudent) //true

    if (isStudent){
     val newStudent =  student2.asInstanceOf[Student17]
      newStudent.study()
      //造型前后对象的地址值不变
      println(student2 == newStudent) //true
      println(student2.eq(newStudent)) //true
    }

    println(classOf[Student17])

    // 2. 测试枚举类
    println(WorkDay.MONDAY)
  }

}

// 定义父子类型
class Person17(var name: String, var age: Int){
  def sayHi(): Unit ={
    println("hi from person " + name)
  }
}
class Student17(name: String, age: Int) extends Person17(name, age){
  def study(): Unit ={
    println("student is studying")
  }

  override def sayHi(): Unit = println("hi from student " + name)
}

//枚举类
object WorkDay extends Enumeration {
  private val Monday: WorkDay.Value = Value(2, "星期一")
  val MONDAY = Monday
  val TUESDAY = Value(1,"星期二")
}

// 应用类
object TestApp extends App{
  println("app start")

  //给类起别名
  type MyString = String
  val a:MyString = "赵丽颖"
  println(a)
}