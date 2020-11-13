

/**
 * 1. 在同一个文件中定义多个包
 * 2. 可以在任意位置导包，分为局部导包和全局导包
 * 3. 包对象名与包名保持一致
 * 4. scala语法的灵活性，任何语法可以在任意位置书写，但是方法，属性还是应该写在类或对象内，这样才能被调用。
 * 5. 在同一个源文件中，包对象需放在当前包的父目录下，与当前包同级。
 * 6. 包对象的属性、方法是被包下（包括子包）的所有对象、类同享。
 *
 * @author chenhuiup
 * @create 2020-09-15 20:47
 */

package com{

  // 定义一个外层包内的对象
  object Outer{
    var out = "out"

    def main(args: Array[String]): Unit = {
      println("out main")
      println()
    }
  }

  package atguigu{
    package scala{
      package chapter06{

        // 定义一个内层包内的对象
        object Inner{
          val in = "in"

          def main(args: Array[String]): Unit = {
            Outer.main(args)
            Outer.out
            println(Outer.out)


          }
        }

      }
    }
  }
}


// 在同一个文件中定义多个包
package aaa{
object AAAA{
  AAA
}

  package bbb{

    import com.Outer

    object Test{
      def main(args: Array[String]): Unit = {
        Outer.main(args)

        import com.atguigu.scala.chapter06.Inner
        println(Inner.in)
      }
    }
  }
}

package object aaa{
  val AAA = "aaa"
}