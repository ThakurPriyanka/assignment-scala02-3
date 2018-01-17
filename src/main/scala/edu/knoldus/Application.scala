package edu.knoldus

import org.apache.log4j.Logger

object Application {

  def main(args: Array[String]): Unit = {
    val log = Logger.getLogger(this.getClass)
    val operationObject = new Operation
    val num1 = 1
    val num2 = 2
    val num3 = 3
    val num4 = 4
    val num5 = 1
    val num6 = 2
    val list1 = List(num1, num2, num3, num4)
    val list2 = List(num5, num6)

    log.info(s"${operationObject.length(list1)}")

    log.info(s"${operationObject.concateList(list1, list2)}")

    log.info(s"${operationObject.hasSubsequence[Int](list1, list2)}")

    log.info(s"${operationObject.splitList[Int](list1, (x) =>  x % 2 == 0 )}")
  }
}


