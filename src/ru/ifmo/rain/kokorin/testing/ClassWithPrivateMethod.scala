package ru.ifmo.rain.kokorin.testing

import java.lang.reflect.InvocationTargetException

class ClassWithPrivateMethod[T] private[testing] (targetObject: T) {
  def invoke[U](methodInvocation: MethodInvocation[U]): U = {
    val targetClass = targetObject.getClass

    val method = try {
      targetClass.getDeclaredMethod (
        methodInvocation.methodName,
        methodInvocation.args.map(argument => argument.getClass).toArray: _*
      )
    } catch {
      case ex: NoSuchMethodException => throw new IllegalArgumentException("Cannot find a method to invoke", ex)
    }

    method.setAccessible(true)

    val result = try {
      val anyRefArgs =
        for (arg <- methodInvocation.args) yield arg match {
          case anyRef: AnyRef => anyRef
          case any: Any => any.asInstanceOf[AnyRef]
          case null => null
        }

      method.invoke(targetObject, anyRefArgs: _*)
    } catch {
      case e: InvocationTargetException =>
        val cause = Option(e.getCause)
        throw cause.getOrElse(e)
    } finally {
      method.setAccessible(false)
    }

    result.asInstanceOf[U]
  }
}

