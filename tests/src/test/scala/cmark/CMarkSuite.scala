package cmark

import scalanative.native._

object CMarkSuite extends tests.Suite {
  test("Print version string of cmark") {
    stdio.printf(cmark.versionString())
  }

  test("Example") {
    var level = -1
    def onNode(eventType: EventType, node: Ptr[Node]): Unit = {
      eventType match {
        case EventType.Enter => level += 1
        case EventType.Exit  => level -= 1
      }

      val levelStr = "  " * level
      val startLine = Node.getStartLine(node)
      val endLine   = Node.getEndLine(node)

      Node.getType(node) match {
        case NodeType.Text =>
          val text = fromCString(Node.getLiteral(node))
          println(s"${levelStr}text node @ line $startLine-$endLine: $text")

        case _ =>
          val nodeTypeStr = fromCString(Node.getTypeString(node))
          println(s"$levelStr$nodeTypeStr node @ $startLine-$endLine")
      }
    }

    val test =
      """# Chapter
        |## Section
        |### Sub-section
        |
        |Hello World from *cmark-scala*!
      """.stripMargin

    Zone { implicit z =>
      val docNode = Parser.parseDocument(
        toCString(test), test.length, Options.SourcePosition)
      val iter = Iter.create(docNode)
      var evType = Iter.next(iter)
      while (evType != EventType.Done) {
        onNode(evType, Iter.getNode(iter))
        evType = Iter.next(iter)
      }
      Iter.free(iter)

      val html = fromCString(Render.html(docNode, Options.Default))
      Node.free(docNode)

      println()
      println(html)
    }
  }
}
