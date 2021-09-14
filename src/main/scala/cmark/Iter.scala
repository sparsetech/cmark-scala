package cmark

import scalanative.unsafe._

/**
  * ## Iterator
  *
  * An iterator will walk through a tree of nodes, starting from a root
  * node, returning one node at a time, together with information about
  * whether the node is being entered or exited.  The iterator will
  * first descend to a child node, if there is one.  When there is no
  * child, the iterator will go to the next sibling.  When there is no
  * next sibling, the iterator will return to the parent (but with
  * an [[EventType]] of [[EventType.Exit]]).  The iterator will
  * return [[EventType.Done]] when it reaches the root node again. One natural
  * application is an HTML renderer, where an [[EventType.Enter]] event
  * outputs an open tag and an [[EventType.Exit]] event outputs a close tag.
  * An iterator might also be used to transform an AST in some systematic
  * way, for example, turning all level-3 headings into regular paragraphs.
  *
  *   def usageExample(root: Ptr[Node]) {
  *     val iter   = Iter.create(root)
  *     var evType = Iter.next(iter)
  *
  *     while (evType != EventType.Done) {
  *       val cur = Iter.getNode(iter)
  *       // Do something with `cur` and `evType`
  *       evType = Iter.next(iter)
  *     }
  *
  *     Iter.free(iter)
  *   }
  *
  * Iterators will never return `EXIT` events for leaf nodes, which are nodes
  * of type:
  *
  *   - [[NodeType.HtmlBlock]]
  *   - [[NodeType.ThematicBreak]]
  *   - [[NodeType.CodeBlock]]
  *   - [[NodeType.Text]]
  *   - [[NodeType.SoftBreak]]
  *   - [[NodeType.LineBreak]]
  *   - [[NodeType.Code]]
  *   - [[NodeType.HtmlInline]]
  *
  * Nodes must only be modified after an [[EventType.Exit]] event, or an
  * [[EventType.Enter]] event for leaf nodes.
  */

@link("cmark")
@extern
object Iter {
  /** Creates a new iterator starting at 'root'.  The current node and event
    * type are undefined until [[Iter.next]] is called for the first time.
    * The memory allocated for the iterator should be released using
    * [[Iter.free]] when it is no longer needed.
    */
  @name("cmark_iter_new")
  def create(root: Ptr[Node]): Ptr[Iter] = extern

  /** Frees the memory allocated for an iterator. */
  @name("cmark_iter_free")
  def free(iter: Ptr[Iter]): Unit = extern

  /** Advances to the next node and returns the event type ([[EventType.Enter]],
    * [[EventType.Exit]] or [[EventType.Done]]).
    */
  @name("cmark_iter_next")
  def next(iter: Ptr[Iter]): EventType = extern

  /** Returns the current node. */
  @name("cmark_iter_get_node")
  def getNode(iter: Ptr[Iter]): Ptr[Node] = extern

  /** Returns the current event type. */
  @name("cmark_iter_get_event_type")
  def getEventType(iter: Ptr[Iter]): EventType = extern

  /** Returns the root node. */
  @name("cmark_iter_get_root")
  def getRoot(iter: Ptr[Iter]): Ptr[Node] = extern

  /** Resets the iterator so that the current node is 'current' and
    * the event type is [[EventType]].  The new current node must be a
    * descendant of the root node or the root node itself.
    */
  @name("cmark_iter_reset")
  def reset(iter: Ptr[Iter], current: Ptr[Node], eventType: EventType): Unit = extern
}
