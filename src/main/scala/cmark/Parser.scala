package cmark

import scala.scalanative.native._
import scala.scalanative.native.stdio.FILE

/**
  * ## Parsing
  *
  * Simple interface:
  *
  *   val document = Parser.parseDocument(c"Hello *world*", 13, Options.Default)
  *
  * Streaming interface:
  *
  *   val parser = Parser.create(Options.Default)
  *   Parser.feed(parser, buffer, bytes)
  *   val document = Parser.finish(parser)
  *   Parser.free(parser)
  */
@link("cmark")
@extern
object Parser {
  /** Creates a new parser object. */
  @name("cmark_parser_new")
  def create(options: CInt): Ptr[Parser] = extern

  /** Creates a new parser object with the given memory allocator */
  @name("cmark_parser_new_with_mem")
  def createWithMem(options: CInt, mem: Ptr[Memory]): Ptr[Parser] = extern

  /** Frees memory allocated for a parser object. */
  @name("cmark_parser_free")
  def free(parser: Ptr[Parser]): Unit = extern

  /** Feeds a string of length 'len' to 'parser'. */
  @name("cmark_parser_feed")
  def feed(parser: Ptr[Parser], buffer: CString, bytes: CSize): Unit = extern

  /** Finish parsing and return a pointer to a tree of nodes. */
  @name("cmark_parser_finish")
  def finish(parser: Ptr[Parser]): Ptr[Node] = extern

  /** Parse a CommonMark document in 'buffer' of length 'len'.
    * Returns a pointer to a tree of nodes.  The memory allocated for
    * the node tree should be released using [[Node.free]]
    * when it is no longer needed.
    */
  @name("cmark_parse_document")
  def parseDocument(buffer: CString, len: CSize, options: CInt): Ptr[Node] = extern

  /** Parse a CommonMark document in file 'file', returning a pointer to
    * a tree of nodes.  The memory allocated for the node tree should be
    * released using [[Node.free]] when it is no longer needed.
    */
  @name("cmark_parse_file")
  def parseFile(file: Ptr[FILE], options: CInt): Ptr[Node] = extern
}
