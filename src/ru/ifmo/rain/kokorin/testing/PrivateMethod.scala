package ru.ifmo.rain.kokorin.testing

class PrivateMethod[T] private(val name: String) {
  def apply(args: Any*): MethodInvocation[T] = new MethodInvocation[T](name, args: _*)
}

object PrivateMethod {
  def apply[T](name: String): PrivateMethod[T] = new PrivateMethod[T](name)
}
