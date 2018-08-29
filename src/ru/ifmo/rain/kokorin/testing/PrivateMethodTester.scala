package ru.ifmo.rain.kokorin.testing

trait PrivateMethodTester {
  implicit def objectWithPrivateMethod[T](targetObject: T): ClassWithPrivateMethod[T] =
    new ClassWithPrivateMethod[T](targetObject)
}

object PrivateMethodTester extends PrivateMethodTester
