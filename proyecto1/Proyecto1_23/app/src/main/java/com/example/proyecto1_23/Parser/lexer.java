/* The following code was generated by JFlex 1.7.0 */

package com.example.proyecto1_23.Parser;

      import java_cup.runtime.Symbol;
      import java.util.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>lexer.jflex</tt>
 */
public class lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\10\0\2\1\1\23\1\24\1\23\1\23\22\0\1\1\1\0\1\2"+
    "\1\22\4\0\1\14\1\15\1\12\1\10\1\3\1\11\1\4\1\13"+
    "\1\53\11\7\1\0\1\5\5\0\2\6\1\47\1\6\1\50\1\43"+
    "\2\6\1\51\2\6\1\44\2\6\1\45\2\6\1\46\10\6\1\20"+
    "\1\0\1\21\3\0\3\6\1\27\1\34\1\35\1\41\1\42\1\40"+
    "\2\6\1\33\1\6\1\32\1\30\1\26\1\6\1\37\1\52\1\36"+
    "\1\25\1\6\1\31\3\6\1\16\1\0\1\17\7\0\1\24\u1fa2\0"+
    "\1\24\1\24\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\1\1\3\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\2\7\1\1\6\1\0\1\21\2\0"+
    "\1\22\10\0\1\6\1\0\1\23\7\0\1\23\1\6"+
    "\1\24\1\25\1\26\2\0\1\27\2\0\2\23\1\0"+
    "\1\30\1\31\2\32\2\23\2\0\2\33";

  private static int [] zzUnpackAction() {
    int [] result = new int[73];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\54\0\54\0\130\0\54\0\54\0\54\0\204"+
    "\0\54\0\54\0\54\0\54\0\54\0\54\0\54\0\54"+
    "\0\54\0\54\0\260\0\334\0\u0108\0\u0134\0\u0160\0\u018c"+
    "\0\u01b8\0\u01e4\0\u0210\0\130\0\54\0\u023c\0\u0268\0\54"+
    "\0\u0294\0\u02c0\0\u02ec\0\u0318\0\u0344\0\u0370\0\u039c\0\u03c8"+
    "\0\u03f4\0\u0420\0\u0268\0\u044c\0\u0478\0\u04a4\0\u04d0\0\u04fc"+
    "\0\u0528\0\u0554\0\u0580\0\u05ac\0\54\0\54\0\54\0\u05d8"+
    "\0\u0604\0\54\0\u0630\0\u065c\0\u0688\0\u06b4\0\u0688\0\54"+
    "\0\54\0\u06e0\0\u070c\0\u0738\0\u0764\0\u0790\0\u07bc\0\u0790"+
    "\0\u07e8";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[73];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\2\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\3\1\2\1\24\1\25\1\26"+
    "\3\2\1\27\3\2\1\30\3\2\1\31\3\2\1\32"+
    "\3\2\1\33\55\0\1\34\1\35\3\0\1\34\1\36"+
    "\13\0\1\34\1\0\26\34\1\36\4\0\1\37\2\0"+
    "\1\10\43\0\1\10\23\23\2\0\27\23\26\0\1\40"+
    "\52\0\1\41\56\0\1\42\57\0\1\43\57\0\1\44"+
    "\57\0\1\45\57\0\1\46\3\0\4\47\1\50\2\47"+
    "\1\51\13\47\2\0\26\47\1\51\1\0\1\34\1\35"+
    "\1\0\1\52\1\0\1\34\1\36\13\0\1\34\1\0"+
    "\26\34\1\36\7\0\1\53\43\0\1\53\52\0\1\54"+
    "\32\0\1\55\57\0\1\56\57\0\1\57\57\0\1\60"+
    "\57\0\1\61\55\0\1\62\7\0\1\53\43\0\1\63"+
    "\4\0\1\37\2\0\1\10\43\0\1\64\7\0\1\34"+
    "\43\0\1\34\42\0\1\65\43\0\1\66\57\0\1\67"+
    "\57\0\1\70\56\0\1\71\52\0\1\72\7\0\23\73"+
    "\2\0\26\73\1\74\7\73\1\75\13\73\2\0\26\73"+
    "\1\76\4\73\1\77\2\73\1\10\13\73\2\0\26\73"+
    "\1\64\36\0\1\100\63\0\1\101\14\0\1\102\43\0"+
    "\1\102\7\73\1\102\13\73\2\0\26\73\1\103\7\0"+
    "\1\104\43\0\1\104\7\73\1\104\13\73\2\0\26\73"+
    "\1\105\4\0\1\106\2\0\1\102\43\0\1\102\4\73"+
    "\1\107\2\73\1\102\13\73\2\0\26\73\1\103\4\0"+
    "\1\106\2\0\1\104\43\0\1\104\4\73\1\107\2\73"+
    "\1\104\13\73\2\0\26\73\1\105\7\0\1\110\43\0"+
    "\1\110\7\0\1\111\43\0\1\111\4\0\1\106\2\0"+
    "\1\111\43\0\1\111";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2068];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\1\1\3\11\1\1\12\11\11\1\1\0"+
    "\1\11\2\0\1\11\10\0\1\1\1\0\1\1\7\0"+
    "\2\1\3\11\2\0\1\11\2\0\2\1\1\0\2\11"+
    "\4\1\2\0\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[73];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
  //  private ReporteErrores tabla = new ReporteErrores();

   // public void setTabla(ReporteErrores tabla){
  //      this.tabla = tabla;
  //  }



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 178) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { /*tabla.agregarError(yytext(), yyline+1, yycolumn+1, "ERROR LEXICO");*/
            return new Symbol(sym.ERROR, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 28: break;
          case 2: 
            { /*NADA*/
            } 
            // fall through
          case 29: break;
          case 3: 
            { return new Symbol(sym.COMA,yyline+1,yycolumn+1, yytext());
            } 
            // fall through
          case 30: break;
          case 4: 
            { return new Symbol(sym.PUNTO, yyline+1,yycolumn+1, yytext());
            } 
            // fall through
          case 31: break;
          case 5: 
            { return new Symbol(sym.PUNTOCOMA,yyline+1,yycolumn+1, yytext());
            } 
            // fall through
          case 32: break;
          case 6: 
            { return new Symbol(sym.ENTEROS, yyline+1,yycolumn+1, new Double(yytext()));
            } 
            // fall through
          case 33: break;
          case 7: 
            { return new Symbol(sym.SUMA, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 34: break;
          case 8: 
            { return new Symbol(sym.RESTA, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 35: break;
          case 9: 
            { return new Symbol(sym.MULTIPLICACION, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 36: break;
          case 10: 
            { return new Symbol(sym.DIVISION, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 37: break;
          case 11: 
            { return new Symbol(sym.PARENTESISABIERTO, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 38: break;
          case 12: 
            { return new Symbol(sym.PARENTESISCERRADO, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 39: break;
          case 13: 
            { return new Symbol(sym.LLAVESABIERTO, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 40: break;
          case 14: 
            { return new Symbol(sym.LLAVESCERRADO, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 41: break;
          case 15: 
            { return new Symbol(sym.CORCHETESABIERTO, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 42: break;
          case 16: 
            { return new Symbol(sym.CORCHETESCERRADO, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 43: break;
          case 17: 
            { return new Symbol(sym.CADENAS ,yyline+1,yycolumn+1,yytext());
            } 
            // fall through
          case 44: break;
          case 18: 
            { return new Symbol(sym.UP, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 45: break;
          case 19: 
            { return new Symbol(sym.DECIMAL, yyline+1,yycolumn+1, new Double(yytext()));
            } 
            // fall through
          case 46: break;
          case 20: 
            { return new Symbol(sym.PUSH, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 47: break;
          case 21: 
            { return new Symbol(sym.DOWN, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 48: break;
          case 22: 
            { return new Symbol(sym.LEFT, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 49: break;
          case 23: 
            { return new Symbol(sym.CEIL, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 50: break;
          case 24: 
            { return new Symbol(sym.RIGHT, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 51: break;
          case 25: 
            { return new Symbol(sym.FLOOR, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 52: break;
          case 26: 
            { /*tabla.agregarError(yytext(), yyline, yycolumn, "Lexico");*/
                       return new Symbol(sym.ERROR, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 53: break;
          case 27: 
            { /*tabla.agregarError(yytext(), yyline, yycolumn, "Lexico");*/
                        return new Symbol(sym.ERROR, yyline+1, yycolumn+1, yytext());
            } 
            // fall through
          case 54: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Converts an int token code into the name of the
   * token by reflection on the cup symbol class/interface sym
   *
   * This code was contributed by Karl Meissner <meissnersd@yahoo.com>
   */
  private String getTokenName(int token) {
    try {
      java.lang.reflect.Field [] classFields = sym.class.getFields();
      for (int i = 0; i < classFields.length; i++) {
        if (classFields[i].getInt(null) == token) {
          return classFields[i].getName();
        }
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return "UNKNOWN TOKEN";
  }

  /**
   * Same as next_token but also prints the token to standard out
   * for debugging.
   *
   * This code was contributed by Karl Meissner <meissnersd@yahoo.com>
   */
  public java_cup.runtime.Symbol debug_next_token() throws java.io.IOException {
    java_cup.runtime.Symbol s = next_token();
    System.out.println( "line:" + (yyline+1) + " col:" + (yycolumn+1) + " --"+ yytext() + "--" + getTokenName(s.sym) + "--");
    return s;
  }

  /**
   * Runs the scanner on input files.
   *
   * This main method is the debugging routine for the scanner.
   * It prints debugging information about each returned token to
   * System.out until the end of file is reached, or an error occured.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java lexer [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          java.nio.charset.Charset.forName(encodingName); // Side-effect: is encodingName valid? 
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        lexer scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new lexer(reader);
          while ( !scanner.zzAtEOF ) scanner.debug_next_token();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
