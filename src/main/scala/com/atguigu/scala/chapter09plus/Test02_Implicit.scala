package com.atguigu.scala.chapter09plus

/**
 * @author chenhuiup
 * @create 2020-09-20 16:25
 */
/*
一、隐式函数：
1. 使用implicit关键字声明的函数称之为隐式函数
2. 当想调用对象功能时，如果编译错误，那么编译器会尝试在当前作用域范围内查找能调用对应功能的转换规则，
   这个调用过程是由编译器完成的，所以称之为隐式转换。也称之为自动转换

二、隐式类
1. 隐式类方便了类功能的扩展，可以直接在代码中定义一个隐式类，定义一个独特的方法，当某个类的功能有限，想扩展该类的功能时，在不改变源码时，
   可以直接在当前环境中定义一个隐式类，将需要的实现的逻辑写在方法中，这样之前的对象就能够使用该方法了。
2. 隐式类主构造器有且只有一个参数。目的就是为了让对象从一种类型转换成另一种类型，拥有新的方法。多个参数或者无参，没有任何意义
3. 隐式类必须被定义在“类”或“伴生对象”或“包对象”里，即隐式类不能是顶级的。意思就是隐式类不能独立存在，必须在当前环境中为需要扩增共的对象做服务。

三、隐式参数
1. 隐式参数不能与非隐式参数放在同一个括号中(否则报错)，相当于函数柯里化。
2. 隐式参数需要和隐式变量一起定义。同一类型的隐式变量有且只有一个，相当于提供一个默认值。匹配规则是根据变量类型匹配，与变量名无关。
3. 隐式参数必须要有默认值，要么是在参数定义时给默认值，要么是定义隐式变量。当同时定义时，优先使用隐式变量的默认值。
4. 同一类型的隐式变量有且只有一个，相当于提供一个默认值。如果提供多个，编译器就不知道如何选择了。
5. 声明了隐式参数的方法，相当于函数柯里化，对于隐式参数可以写，也可以不写，因为有默认值

四、隐式解析机制
1. 隐式转换的目的就是编译器想尽一切方法让编译通过，通过方法是：
1）隐式实体：在当前环境中寻找隐式实体（隐式方法，隐式变量，隐式类） ，都是根据类型进行匹配
2）隐式参数的类型的作用域：与当前类该类型相关联的全部伴生对象以及该类型所在包的包对象，看看这些区域有没有隐式实体可以做隐式转换，从而调用方法。

总结：隐式转换的目的就是为了在不改变原有对象代码的前体下，增强该对象的功能，相当于外挂。前体是类型匹配。
 */
object Test02_Implicit {
  def main(args: Array[String]): Unit = {
    // 1. 隐式函数
//    implicit def convert(num:Int):MyRichInt = new MyRichInt(num)

    val a :Int = 23
    // Int中没有myMax方法，第一次编译不通过，编译器就在当前环境寻找能让a调用myMax的方式，
    // 发现有一个隐式函数convert，可以让a转变成MyRichInt类型
    println(a myMax 15)

    // 2. 隐式类
    implicit class MyRichInt(val self:Int){
      // 定义一个独特的方法
      def myMax(n: Int): Int = {
        if(self > n) self else n
      }
    }

    // 3.隐式参数
    implicit val str: String = "hello world"
//    implicit val str2: String = "hello world 2" //error

    def sayHello(name:String)(implicit arg:String = "goodbye"):Unit = {
      println(name + " " + arg)
    }
    sayHello("alice")
  }

}

//自定义一个RichInt类
//class MyRichInt (val self:Int){
//  //定义一个独特的方法
//  def myMax(n:Int):Int = {
//    if (self > n) self else n
//  }
//}
