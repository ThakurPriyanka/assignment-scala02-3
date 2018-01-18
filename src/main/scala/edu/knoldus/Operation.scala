package edu.knoldus

class Operation {

  def length[A](list: List[A]): Int = {
    list.foldRight(0)((_, sum) => sum + 1)
  }

    def hasSubsequence[A](list: List[A], subList: List[A]): Boolean = {

      def subSequence(list: List[A], subList: List[A], count: Int, size: Int): Boolean = {
        list match {
          case Nil => false
          case head1 :: tail1 => {
            subList match  {

              case head2 :: tail2 =>
                if ( head1 == head2 ) {
                  subSequence(tail1, tail2, count + 1, size)
                }
                else {
                  subSequence(tail1, subList, count, size)
                }
              case Nil if count == size => true
              case Nil if count != size => false
            }
          }
        }
      }
      subSequence(list, subList, 0, subList.size)
    }

  def concateList[A](list1: List[A], list2: List[A]): List[A] = {

    list2 match {
      case head :: tail => concateList(list1 ::: List(head), tail)
      case _ => list1
    }
  }

  def splitList[A](list: List[A], f: A => Boolean): (List[A], List[A]) = {

    def generatingOfList(list: List[A], subList1: List[A], subList2: List[A]): (List[A], List[A]) = {
      list match {
        case head :: tail => {
          if (f(head)) {
            generatingOfList(tail, head :: subList1, subList2)
          }
          else {
            generatingOfList(tail, subList1, head :: subList2)
          }
        }
        case Nil => (subList1, subList2)
      }
    }

    generatingOfList(list, List(), List())
  }

}
