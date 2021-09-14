import scalanative.unsafe._

/**
  * ## Constants
  */
package object cmark {
  type Node   = Byte
  type Parser = Byte
  type Iter   = Byte
  type Memory = Byte

  type EventType = CInt
  object EventType {
    val None  = 0
    val Done  = 1
    val Enter = 2
    val Exit  = 3
  }

  type NodeType = CInt
  object NodeType {
    /* Error status */
    val None = 0

    /* Block */
    val Document = 1
    val BlockQuote = 2
    val List = 3
    val Item = 4
    val CodeBlock = 5
    val HtmlBlock = 6
    val CustomBlock = 7
    val Paragraph = 8
    val Heading = 9
    val ThematicBreak = 10

    val FirstBlock = Document
    val LastBlock = ThematicBreak

    /* Inline */
    val Text = 11
    val SoftBreak = 12
    val LineBreak = 13
    val Code = 14
    val HtmlInline = 15
    val CustomInline = 16
    val Emphasis = 17
    val Strong = 18
    val Link = 19
    val Image = 20

    val FirstInline = Text
    val LastInline = Image
  }

  type ListType = CInt
  object ListType {
    val None    = 0
    val Bullet  = 1
    val Ordered = 2
  }

  type DelimType = CInt
  object DelimType {
    val None        = 0
    val Period      = 1
    val Parenthesis = 2
  }
}
