package cmark

/**
  * ## Parsing
  */
object Options {
  /** Default options. */
  val Default = 0

  /**
    * ## Options affecting rendering
    */

  /** Include a `data-sourcepos` attribute on all block elements. */
  val SourcePosition = 1 << 1

  /** Render `softbreak` elements as hard line breaks. */
  val HardBreaks = 1 << 2

  /** Suppress raw HTML and unsafe links (`javascript:`, `vbscript:`,
    * `file:`, and `data:`, except for `image/png`, `image/gif`,
    * `image/jpeg`, or `image/webp` mime types).  Raw HTML is replaced
    * by a placeholder HTML comment. Unsafe links are replaced by
    * empty strings.
    */
  val Safe = 1 << 3

  /** Render `softbreak` elements as spaces. */
  val NoBreaks = 1 << 4

  /**
    * ## Options affecting parsing
    */

  /** Validate UTF-8 in the input before parsing, replacing illegal
    * sequences with the replacement character U+FFFD.
    */
  val ValidateUtf8 = 1 << 9

  /** Convert straight quotes to curly, --- to em dashes, -- to en dashes. */
  val Smart = 1 << 10
}
