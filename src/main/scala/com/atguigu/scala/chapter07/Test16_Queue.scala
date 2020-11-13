package com.atguigu.scala.chapter07

import scala.collection.immutable.Queue
import scala.collection.mutable

/**
 * @author chenhuiup
 * @create 2020-09-19 23:51
 */
/*
1.(1 to 100).par ， par方法将集合转变成并行集合
 */
object Test16_Queue {
  def main(args: Array[String]): Unit = {
    // 1. 可变队列
    val que = new mutable.Queue[String]()
    val queue = mutable.Queue("abc", "def", "hello")

    println(que)
    que.enqueue("scala")
    println(que)
    queue.enqueue("spark")
    println(queue)
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue)

    // 2. 不可变队列
    val que2 = Queue("a", "b", "c")
    val que3 = que2.enqueue("d") //会产生一个新Queue
    println(que2)
    println(que3)

    println("========================================")

    // 并行集合
    //使用偏函数的写法
    val result = (1 to 100).map{ case _ => Thread.currentThread().getName }
    val parResult = (1 to 100).par.map( { case _ => Thread.currentThread().getName } )
    println(result)
    println(parResult)
  }
}
