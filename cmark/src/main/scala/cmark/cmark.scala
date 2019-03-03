package cmark

import scala.scalanative.native._

@link("cmark")
@extern
object cmark {
  /** Convert 'text' (assumed to be a UTF-8 encoded string with length
    * 'len') from CommonMark Markdown to HTML, returning a null-terminated,
    * UTF-8-encoded string. It is the caller's responsibility
    * to free the returned buffer.
    */
  @name("cmark_markdown_to_html")
  def markdownToHtml(text: CString, len: CSize, options: CInt): CString = extern

  /**
    * ## Version information
    */

  /** The library version as integer for runtime checks.
    *
    * * Bits 16-23 contain the major version.
    * * Bits 8-15 contain the minor version.
    * * Bits 0-7 contain the patchlevel.
    *
    * In hexadecimal format, the number 0x010203 represents version 1.2.3.
    */
  @name("cmark_version")
  def version(): CInt = extern

  /** The library version string for runtime checks. */
  @name("cmark_version_string")
  def versionString(): CString = extern
}

