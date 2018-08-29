package ru.ifmo.rain.kokorin.testing

object Main extends App with PrivateMethodTester {
  val obj = new TestClass
  val method = PrivateMethod[String]("sayHello")

  val result: String = obj invoke method("World")
  println(result)
}

class TestClass {
  private def sayHello(name: String): String = s"Hello, $name!"
}
