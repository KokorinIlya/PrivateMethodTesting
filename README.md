# PrivateMethodTesting
Scala application for simplification of private method testing 

The code for testing looks like

```scala
object Main extends App with PrivateMethodTester {
  val obj = new TestClass
  val method = PrivateMethod[String]("sayHello")

  val result: String = obj invoke method("World")
  require(result == "Hello, World!")
}

class TestClass {
  private def sayHello(name: String): String = s"Hello, $name!"
}
```
It is quite simple to test private methods. Where you write ```obj.method(params)``` for method invocation, now you should write ```obj invoke method(params)```.

Definition for ```method``` object should look like the following: 

```scala
val method = PrivateMethod[T](methodName)
```
, where ```T``` is a return type of the method, that should be tested and  ```methodName``` is a name of the method that should be tested.
