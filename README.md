# <img src="http://sparse.tech/opensource/icons/cmark.svg" width="50%">
cmark-scala provides [Scala Native](http://www.scala-native.org/) bindings for [cmark](https://github.com/jgm/cmark). cmark allows to parse, manipulate and render CommonMark documents.

The bindings were directly derived from [cmark.h](https://github.com/jgm/cmark/blob/master/src/cmark.h). Comments were retained and adapted if necessary. The naming of functions and their encapsulation follows Scala's conventions. Note that `*_new` functions were renamed to `create` as to prevent name collisions with the eponymous Scala keyword.

## Example
```scala
import cmark._

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

println("cmark version: " + fromCString(cmark.versionString()))
println()

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
println()
println(html)

Node.free(docNode)
```

**Output:**

```
cmark version: 0.27.1

document node @ 1-6
  heading node @ 1-1
    text node @ line 0-0: Chapter
  heading node @ 1-1
    heading node @ 2-2
      text node @ line 0-0: Section
    heading node @ 2-2
      heading node @ 3-3
        text node @ line 0-0: Sub-section
      heading node @ 3-3
        paragraph node @ 5-5
          text node @ line 0-0: Hello World from 
            emph node @ 0-0
              text node @ line 0-0: cmark-scala
            emph node @ 0-0
              text node @ line 0-0: !
            paragraph node @ 5-5
          document node @ 1-6

<h1>Chapter</h1>
<h2>Section</h2>
<h3>Sub-section</h3>
<p>Hello World from <em>cmark-scala</em>!</p>
```

## Dependency
```scala
libraryDependencies += "tech.sparse" %%  "cmark-scala" % "0.1.0-SNAPSHOT"
```

## License
cmark-scala is licensed under the terms of the Apache v2.0 license. Its function interfaces and comments were derived from `cmark.h`, which is licensed under BSD-2-Clause.

## Authors
* Tim Nieradzik
