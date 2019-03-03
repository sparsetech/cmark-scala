package cmark

import scala.scalanative.native._

/**
  * ## Node
  */
@link("cmark")
@extern
object Node {
  /** Creates a new node of type 'type'.  Note that the node may have
    * other required properties, which it is the caller's responsibility
    * to assign.
    */
  @name("cmark_node_new")
  def create(nodeType: NodeType): Ptr[Node] = extern

  /** Frees the memory allocated for a node and any children. */
  @name("cmark_node_free")
  def free(doc: Ptr[Node]): Unit = extern

  /**
    *  ## Tree Traversal
    */

  /** @return The next node in the sequence after 'node', or null if
    * there is none.
    */
  @name("cmark_node_next")
  def nodeNext(node: Ptr[Node]): Ptr[Node] = extern

  /** @return The previous node in the sequence after 'node', or null if
    * there is none.
    */
  @name("cmark_node_previous")
  def nodePrevious(node: Ptr[Node]): Ptr[Node] = extern

  /** @return The parent of 'node', or null if there is none. */
  @name("cmark_node_parent")
  def parent(node: Ptr[Node]): Ptr[Node] = extern

  /** @return The first child of 'node', or null if 'node' has no children.
    */
  @name("cmark_node_first_child")
  def firstChild(node: Ptr[Node]): Ptr[Node] = extern

  /** @return The last child of 'node', or null if 'node' has no children.
    */
  @name("cmark_node_last_child")
  def lastChild(node: Ptr[Node]): Ptr[Node] = extern

  /**
    * ## Accessors
    */

  /** @return The user data of 'node'. */
  @name("cmark_node_get_user_data")
  def getUserData(node: Ptr[Node]): Ptr[Byte] = extern

  /** Sets arbitrary user data for 'node'.
    * @return 1 on success, 0 on failure.
    */
  @name("cmark_node_set_user_data")
  def setUserData(node: Ptr[Node], userData: Ptr[Byte]): CInt = extern

  /** @return The type of 'node', or [[NodeType.None]] on error. */
  @name("cmark_node_get_type")
  def getType(node: Ptr[Node]): NodeType = extern

  /** Like 'cmark_node_get_type', but returns a string representation
    of the type, or `"<unknown>"`.
    */
  @name("cmark_node_get_type_string")
  def getTypeString(node: Ptr[Node]): CString = extern

  /** @return The string contents of 'node', or an empty string if none
    *         is set.
    */
  @name("cmark_node_get_literal")
  def getLiteral(node: Ptr[Node]): CString = extern

  /** Sets the string contents of 'node'.
    * @return 1 on success, 0 on failure.
    */
  @name("cmark_node_set_literal")
  def setLiteral(node: Ptr[Node], content: CString): CInt = extern

  /** @return The heading level of 'node', or 0 if 'node' is not a heading.
    */
  @name("cmark_node_get_heading_level")
  def getHeadingLevel(node: Ptr[Node]): CInt = extern

  /** Sets the heading level of 'node'
    * @return 1 on success and 0 on error.
    */
  @name("cmark_node_set_heading_level")
  def setHeadingLevel(node: Ptr[Node], level: CInt): CInt = extern

  /** @return The list type of 'node', or [[ListType.None]] if 'node'
    * is not a list.
    */
  @name("cmark_node_get_list_type")
  def getListType(node: Ptr[Node]): ListType = extern

  /** Sets the list type of 'node'
    * @return 1 on success and 0 on error.
    */
  @name("cmark_node_set_list_type")
  def setListType(node: Ptr[Node], tpe: ListType): CInt = extern

  /** @return The list delimiter type of 'node', or [[DelimType.None]] if 'node'
    * is not a list.
    */
  @name("cmark_node_get_list_delim")
  def getListDelim(node: Ptr[Node]): DelimType = extern

  /** Sets the list delimiter type of 'node'
    * @return 1 on success and 0 on error.
    */
  @name("cmark_node_set_list_delim")
  def setListDelim(node: Ptr[Node], delim: DelimType): CInt = extern

  /** @return starting number of 'node', if it is an ordered list, otherwise 0. */
  @name("cmark_node_get_list_start")
  def getListStart(node: Ptr[Node]): CInt = extern

  /** Sets starting number of 'node', if it is an ordered list.
    * @return 1 on success, 0 on failure.
    */
  @name("cmark_node_set_list_start")
  def setListStart(node: Ptr[Node], start: CInt): CInt = extern

  /** @return 1 if 'node' is a tight list, 0 otherwise. */
  @name("cmark_node_get_list_tight")
  def getListTight(node: Ptr[Node]): CInt = extern

  /** Sets the "tightness" of a list.
    * @return 1 on success, 0 on failure.
    */
  @name("cmark_node_set_list_tight")
  def setListTight(node: Ptr[Node], tight: CInt): CInt = extern

  /** @return The info string from a fenced code block. */
  @name("cmark_node_get_fence_info")
  def getFenceInfo(node: Ptr[Node]): CString = extern

  /** Sets the info string in a fenced code block
    * @return 1 on success and 0 on failure.
    */
  @name("cmark_node_set_fence_info")
  def setFenceInfo(node: Ptr[Node], info: CString): CInt = extern

  /** @return The URL of a link or image 'node', or an empty string if no URL
    *         is set.
    */
  @name("cmark_node_get_url")
  def getUrl(node: Ptr[Node]): CString = extern

  /** Sets the URL of a link or image 'node'.
    * @return 1 on success, 0 on failure.
    */
  @name("cmark_node_set_url")
  def setUrl(node: Ptr[Node], url: CString): CInt = extern

  /** @return The title of a link or image 'node', or an empty string if no
    *         title is set.
    */
  @name("cmark_node_get_title")
  def getTitle(node: Ptr[Node]): CString = extern

  /** Sets the title of a link or image 'node'.
    * @return 1 on success, 0 on failure.
    */
  @name("cmark_node_set_title")
  def setTitle(node: Ptr[Node], title: CString): CInt = extern

  /** @return The literal "on enter" text for a custom 'node', or
    an empty string if no onEnter is set.
    */
  @name("cmark_node_get_on_enter")
  def getOnEnter(node: Ptr[Node]): CString = extern

  /** Sets the literal text to render "on enter" for a custom 'node'. Any
    * children of the node will be rendered after this text.
    * @return 1 on success 0 on failure.
    */
  @name("cmark_node_set_on_enter")
  def setOnEnter(node: Ptr[Node], onEnter: CString): CInt = extern

  /** @return The literal "on exit" text for a custom 'node', or an empty string
    *         if no on_exit is set.
    */
  @name("cmark_node_get_on_exit")
  def getOnExit(node: Ptr[Node]): CString = extern

  /** Sets the literal text to render "on exit" for a custom 'node'.
    * Any children of the node will be rendered before this text.
    * @return 1 on success 0 on failure.
    */
  @name("cmark_node_set_on_exit")
  def setOnExit(node: Ptr[Node], onExit: CString): CInt = extern

  /** @return The line on which 'node' begins. */
  @name("cmark_node_get_start_line")
  def getStartLine(node: Ptr[Node]): CInt = extern

  /** @return The column at which 'node' begins. */
  @name("cmark_node_get_start_column")
  def getStartColumn(node: Ptr[Node]): CInt = extern

  /** @return The line on which 'node' ends. */
  @name("cmark_node_get_end_line")
  def getEndLine(node: Ptr[Node]): CInt = extern

  /** @return The column at which 'node' ends. */
  @name("cmark_node_get_end_column")
  def getEndColumn(node: Ptr[Node]): CInt = extern

  /**
    * ## Tree Manipulation
    */

  /** Unlinks a 'node', removing it from the tree, but not freeing its
    * memory.  (Use [[Node.free]] for that.)
    */
  @name("cmark_node_unlink")
  def unlink(node: Ptr[Node]): Unit = extern

  /** Inserts 'sibling' before 'node'.
    * @return 1 on success, 0 on failure.
    */
  @name("cmark_node_insert_before")
  def insertBefore(node: Ptr[Node], sibling: Ptr[Node]): CInt = extern

  /** Inserts 'sibling' after 'node'.
    * @return 1 on success, 0 on failure.
    */
  @name("cmark_node_insert_after")
  def insertAfter(node: Ptr[Node], sibling: Ptr[Node]): CInt = extern

  /** Replaces 'oldNode' with 'newNode' and unlinks 'oldNode' (but does
    * not free its memory).
    * @return 1 on success, 0 on failure.
    */
  @name("cmark_node_replace")
  def nodeReplace(oldNode: Ptr[Node], newNode: Ptr[Node]): CInt = extern

  /** Adds 'child' to the beginning of the children of 'node'.
    * @return 1 on success, 0 on failure.
    */
  @name("cmark_node_prepend_child")
  def prependChild(node: Ptr[Node], child: Ptr[Node]): CInt = extern

  /** Adds 'child' to the end of the children of 'node'.
    * @return 1 on success, 0 on failure.
    */
  @name("cmark_node_append_child")
  def appendChild(node: Ptr[Node], child: Ptr[Node]): CInt = extern

  /** Consolidates adjacent text nodes. */
  @name("cmark_consolidate_text_nodes")
  def consolidateTextNodes(root: Ptr[Node]): Unit = extern
}
