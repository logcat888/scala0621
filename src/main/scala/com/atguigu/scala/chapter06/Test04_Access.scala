package com.atguigu.scala.chapter06

/**
 * 1. 局部变量不能设置默认值
 * 2. val 修饰的属性不能通过 _ 给默认值，使用_说明以后肯定修改，底层只提供类型的get方法，不能修改
 * 3. scala属性默认值是public，底层java实现是private的，他会提供类似的get或set方法。
 * 因此可以通过对象.的方式修改
 * 4. 当我们给属性设置为private后，new出的对象就不可见这些属性。
 * 5. protected 只在继承关系（类/伴生对象）中，对象new 出来的对象不可见
 * 6. 在java中包访问权限是默认的
 * 7. private只在类和伴生对象可用
 * 8. 包访问权限,是通过 private [包名] ,当前包内new出来的对象是可用的，包名不能写全名，必须是当前包名。
 * 9. 使用@BeanProperty为属性自动生成兼容java的getXXX()和setXXX(),与scala为属性自动 xxx_$（）方法互不影响
 *
 * @author chenhuiup
 * @create 2020-09-15 21:17
 */
object Test04_Access {
  def main(args: Array[String]): Unit = {
    val person = new Person()
    //name属性为protected修饰
//    person.name = "sss" //error
    println(person.sex)
    println(person.age)

    person.printInfo()

    val worker = new Worker
    worker.age
  }

}

class Worker extends Person {
  override def printInfo(): Unit = {
    //    idCardNo    // error
    name = "赵丽颖"
    age = 18
    sex = "女"

    println(s"this is a worker: $name $age $sex")
  }
}
