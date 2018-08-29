# PrivateMethodTesting
Scala application for simplification of private method testing 

```scala
val obj = new TestClass
val method = PrivateMethod[String]("sayHello")

val result: String = obj invoke method("World")
println(result)
```
