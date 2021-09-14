package cmark

import scalanative.unsafe._

/**
  * ## Rendering
  */
@link("cmark")
@extern
object Render {
  /** Render a 'node' tree as XML.  It is the caller's responsibility to free
    * the returned buffer.
    */
  @name("cmark_render_xml")
  def xml(root: Ptr[Node], options: CInt): CString = extern

  /** Render a 'node' tree as an HTML fragment.  It is up to the user
    * to add an appropriate header and footer. It is the caller's
    * responsibility to free the returned buffer.
    */
  @name("cmark_render_html")
  def html(root: Ptr[Node], options: CInt): CString = extern

  /** Render a 'node' tree as a groff man page, without the header.
    * It is the caller's responsibility to free the returned buffer.
    */
  @name("cmark_render_man")
  def man(root: Ptr[Node], options: CInt, width: CInt): CString = extern

  /** Render a 'node' tree as a commonmark document.
    * It is the caller's responsibility to free the returned buffer.
    */
  @name("cmark_render_commonmark")
  def commonMark(root: Ptr[Node], options: CInt, width: CInt): CString = extern

  /** Render a 'node' tree as a LaTeX document.
    * It is the caller's responsibility to free the returned buffer.
    */
  @name("cmark_render_latex")
  def laTeX(root: Ptr[Node], options: CInt, width: CInt): CString = extern
}
