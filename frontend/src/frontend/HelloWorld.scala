package frontend

import com.raquo.laminar.api.L.{*, given}
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom
import typings.tauriAppsApi.coreMod

import scala.scalajs.js

def tauriCall[Res](name: String, args: StringDictionary[Any] = StringDictionary.empty) =
  coreMod.invoke[Res](name, args)

object HelloWorld:
  def example: HtmlElement =
    val nameVar  = Var(initial = "world")
    val tauriVar = Var("")
    div(
      label("Your name: "),
      input(
        placeholder := "Enter your name here",
        onInput.mapToValue --> nameVar
      ),
      p(
        "Hello, ",
        text <-- nameVar.signal.map(_.toUpperCase)
      ),
      button(
        tpe := "button",
        "Tauri?",
        onClick.compose(
          _.mapToUnit
            .withCurrentValueOf(nameVar.signal)
            .flatMapSwitch(name => EventStream.fromJsPromise(tauriCall[String]("greet", StringDictionary("name" -> name))))
        ) --> tauriVar
      ),
      p(text <-- tauriVar)
    )

  def main(args: Array[String]) =
    renderOnDomContentLoaded(dom.document.querySelector("#appcontainer"), HelloWorld.example)
