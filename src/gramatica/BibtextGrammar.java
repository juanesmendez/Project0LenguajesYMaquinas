/* Generated By:JavaCC: Do not edit this line. BibtextGrammar.java */
package gramatica;

public class BibtextGrammar implements BibtextGrammarConstants {
  public static void main(String args []) throws ParseException
  {
    BibtextGrammar parser = new BibtextGrammar(System.in);
    while (true)
    {
      System.out.println("Reading from standard input...");
      System.out.print("Enter an expression like \u005c"1+(2+3)*4;\u005c" :");
      try
      {
        switch (parser.one_line())
        {
          case 0 :
          System.out.println("OK.");
          break;
          case 1 :
          System.out.println("Goodbye.");
          break;
          default :
          break;
        }
      }
      catch (Exception e)
      {
        System.out.println("NOK.");
        System.out.println(e.getMessage());
        break;
      }
      catch (Error e)
      {
        System.out.println("Oops.");
        System.out.println(e.getMessage());
        break;
      }
    }
  }

  final public int one_line() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 56:
      symbol();
      jj_consume_token(RB);
    {if (true) return 0;}
      break;
    case RB:
      jj_consume_token(RB);
    {if (true) return 1;}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public void symbol() throws ParseException {
    jj_consume_token(56);
    e();
  }

  final public void e() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ARTICLE:
      jj_consume_token(ARTICLE);
      jj_consume_token(LB);
      jj_consume_token(ID);
      art();
      break;
    case BOOK:
      jj_consume_token(BOOK);
      jj_consume_token(LB);
      jj_consume_token(ID);
      book();
      break;
    case BOOKLET:
      jj_consume_token(BOOKLET);
      jj_consume_token(LB);
      jj_consume_token(ID);
      booklet();
      break;
    case CONFERENCE:
      jj_consume_token(CONFERENCE);
      jj_consume_token(LB);
      jj_consume_token(ID);
      conference();
      break;
    case INBOOK:
      jj_consume_token(INBOOK);
      jj_consume_token(LB);
      jj_consume_token(ID);
      inbook();
      break;
    case INCOLLECTION:
      jj_consume_token(INCOLLECTION);
      jj_consume_token(LB);
      jj_consume_token(ID);
      incollection();
      break;
    case INPROCEEDINGS:
      jj_consume_token(INPROCEEDINGS);
      jj_consume_token(LB);
      jj_consume_token(ID);
      inproceedings();
      break;
    case MANUAL:
      jj_consume_token(MANUAL);
      jj_consume_token(LB);
      jj_consume_token(ID);
      manual();
      break;
    case MASTERSTHESIS:
      jj_consume_token(MASTERSTHESIS);
      jj_consume_token(LB);
      jj_consume_token(ID);
      mastersthesis();
      break;
    case MISC:
      jj_consume_token(MISC);
      jj_consume_token(LB);
      jj_consume_token(ID);
      misc();
      break;
    case PHDTHESIS:
      jj_consume_token(PHDTHESIS);
      jj_consume_token(LB);
      jj_consume_token(ID);
      phdthesis();
      break;
    case PROCEEDINGS:
      jj_consume_token(PROCEEDINGS);
      jj_consume_token(LB);
      jj_consume_token(ID);
      proceedings();
      break;
    case TECHREPORT:
      jj_consume_token(TECHREPORT);
      jj_consume_token(LB);
      jj_consume_token(ID);
      techreport();
      break;
    case UNPUBLISHED:
      jj_consume_token(UNPUBLISHED);
      jj_consume_token(LB);
      jj_consume_token(ID);
      unpublished();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
void a() :
{}
{
  < LB > < ID >
  (    art()
	)
}*/
  final public void number() throws ParseException {
    jj_consume_token(NUMBER);
    jj_consume_token(57);
    jj_consume_token(LB);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case WORD:
      jj_consume_token(WORD);
      jj_consume_token(58);
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
    jj_consume_token(CONSTANT);
    jj_consume_token(RB);
  }

  final public void pages() throws ParseException {
    jj_consume_token(PAGES);
    jj_consume_token(57);
    jj_consume_token(LB);
    jj_consume_token(CONSTANT);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 58:
      label_1:
      while (true) {
        jj_consume_token(58);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 58:
          ;
          break;
        default:
          jj_la1[3] = jj_gen;
          break label_1;
        }
      }
      jj_consume_token(CONSTANT);
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    jj_consume_token(RB);
  }

  final public void month() throws ParseException {
    jj_consume_token(MONTH);
    jj_consume_token(57);
    jj_consume_token(LB);
    jj_consume_token(WORD);
    jj_consume_token(RB);
  }

  final public void doi() throws ParseException {
    jj_consume_token(DOI);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONSTANT:
      case 59:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONSTANT:
        jj_consume_token(CONSTANT);
        break;
      case 59:
        jj_consume_token(59);
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(RB);
  }

  final public void note() throws ParseException {
    jj_consume_token(NOTE);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_3:
    while (true) {
      jj_consume_token(WORD);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_3;
      }
    }
    jj_consume_token(RB);
  }

  final public void author() throws ParseException {
    jj_consume_token(AUTHOR);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_4:
    while (true) {
      jj_consume_token(WORD);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 59:
      case 60:
      case 61:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 59:
          jj_consume_token(59);
          break;
        case 60:
          jj_consume_token(60);
          break;
        case 61:
          jj_consume_token(61);
          break;
        default:
          jj_la1[8] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[9] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_4;
      }
    }
    jj_consume_token(RB);
  }

  final public void title() throws ParseException {
    jj_consume_token(TITLE);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_5:
    while (true) {
      jj_consume_token(WORD);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 58:
      case 60:
      case 62:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 58:
          jj_consume_token(58);
          break;
        case 60:
          jj_consume_token(60);
          break;
        case 62:
          jj_consume_token(62);
          break;
        default:
          jj_la1[11] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[12] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_5;
      }
    }
    jj_consume_token(RB);
  }

  final public void journal() throws ParseException {
    jj_consume_token(JOURNAL);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        jj_consume_token(WORD);
        break;
      case JOURNAL:
        jj_consume_token(JOURNAL);
        break;
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 58:
      case 59:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 59:
          jj_consume_token(59);
          break;
        case 58:
          jj_consume_token(58);
          break;
        default:
          jj_la1[15] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[16] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case JOURNAL:
      case WORD:
        ;
        break;
      default:
        jj_la1[17] = jj_gen;
        break label_6;
      }
    }
    jj_consume_token(RB);
  }

  final public void year() throws ParseException {
    jj_consume_token(YEAR);
    jj_consume_token(57);
    jj_consume_token(LB);
    jj_consume_token(CONSTANT);
    jj_consume_token(RB);
  }

  final public void volume() throws ParseException {
    jj_consume_token(VOLUME);
    jj_consume_token(57);
    jj_consume_token(LB);
    jj_consume_token(CONSTANT);
    jj_consume_token(RB);
  }

  final public void editor() throws ParseException {
    jj_consume_token(EDITOR);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_7:
    while (true) {
      jj_consume_token(WORD);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 59:
      case 60:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 59:
          jj_consume_token(59);
          break;
        case 60:
          jj_consume_token(60);
          break;
        default:
          jj_la1[18] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[19] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_7;
      }
    }
    jj_consume_token(RB);
  }

  final public void publisher() throws ParseException {
    jj_consume_token(PUBLISHER);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_8:
    while (true) {
      jj_consume_token(WORD);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 58:
        jj_consume_token(58);
        break;
      default:
        jj_la1[21] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_8;
      }
    }
    jj_consume_token(RB);
  }

  final public void series() throws ParseException {
    jj_consume_token(SERIES);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        jj_consume_token(WORD);
        break;
      case 61:
        jj_consume_token(61);
        break;
      case CONSTANT:
        jj_consume_token(CONSTANT);
        break;
      default:
        jj_la1[23] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
      case CONSTANT:
      case 61:
        ;
        break;
      default:
        jj_la1[24] = jj_gen;
        break label_9;
      }
    }
    jj_consume_token(RB);
  }

  final public void address() throws ParseException {
    jj_consume_token(ADDRESS);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        jj_consume_token(WORD);
        break;
      case CONSTANT:
        jj_consume_token(CONSTANT);
        break;
      case 60:
        jj_consume_token(60);
        break;
      default:
        jj_la1[25] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
      case CONSTANT:
      case 60:
        ;
        break;
      default:
        jj_la1[26] = jj_gen;
        break label_10;
      }
    }
    jj_consume_token(RB);
  }

  final public void edition() throws ParseException {
    jj_consume_token(EDITION);
    jj_consume_token(57);
    jj_consume_token(LB);
    jj_consume_token(CONSTANT);
    jj_consume_token(RB);
  }

  final public void key() throws ParseException {
    jj_consume_token(KEY);
    jj_consume_token(57);
    jj_consume_token(LB);
    jj_consume_token(CONSTANT);
    jj_consume_token(RB);
  }

  final public void url() throws ParseException {
    jj_consume_token(URL);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        jj_consume_token(WORD);
        break;
      case CONSTANT:
        jj_consume_token(CONSTANT);
        break;
      case 63:
        jj_consume_token(63);
        break;
      case 62:
        jj_consume_token(62);
        break;
      default:
        jj_la1[27] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
      case CONSTANT:
      case 62:
      case 63:
        ;
        break;
      default:
        jj_la1[28] = jj_gen;
        break label_11;
      }
    }
    jj_consume_token(RB);
  }

  final public void howpublished() throws ParseException {
    jj_consume_token(HOWPUBLISHED);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_12:
    while (true) {
      jj_consume_token(WORD);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        ;
        break;
      default:
        jj_la1[29] = jj_gen;
        break label_12;
      }
    }
    jj_consume_token(RB);
  }

  final public void booktitle() throws ParseException {
    jj_consume_token(BOOKTITLE);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_13:
    while (true) {
      jj_consume_token(WORD);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONFERENCE:
      case CONSTANT:
      case ID:
      case 58:
      case 60:
      case 62:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ID:
          jj_consume_token(ID);
          break;
        case 60:
          jj_consume_token(60);
          break;
        case 58:
          jj_consume_token(58);
          break;
        case 62:
          jj_consume_token(62);
          break;
        case CONSTANT:
          jj_consume_token(CONSTANT);
          break;
        case CONFERENCE:
          jj_consume_token(CONFERENCE);
          break;
        default:
          jj_la1[30] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[31] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        ;
        break;
      default:
        jj_la1[32] = jj_gen;
        break label_13;
      }
    }
    jj_consume_token(RB);
  }

  final public void organization() throws ParseException {
    jj_consume_token(ORGANIZATION);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_14:
    while (true) {
      jj_consume_token(WORD);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 59:
      case 60:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 59:
          jj_consume_token(59);
          break;
        case 60:
          jj_consume_token(60);
          break;
        default:
          jj_la1[33] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[34] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        ;
        break;
      default:
        jj_la1[35] = jj_gen;
        break label_14;
      }
    }
    jj_consume_token(RB);
  }

  final public void chapter() throws ParseException {
    jj_consume_token(CHAPTER);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_15:
    while (true) {
      jj_consume_token(CONSTANT);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 58:
        jj_consume_token(58);
        break;
      default:
        jj_la1[36] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONSTANT:
        ;
        break;
      default:
        jj_la1[37] = jj_gen;
        break label_15;
      }
    }
    jj_consume_token(RB);
  }

  final public void type() throws ParseException {
    jj_consume_token(TYPE);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_16:
    while (true) {
      jj_consume_token(WORD);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        ;
        break;
      default:
        jj_la1[38] = jj_gen;
        break label_16;
      }
    }
    jj_consume_token(RB);
  }

  final public void school() throws ParseException {
    jj_consume_token(SCHOOL);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_17:
    while (true) {
      jj_consume_token(WORD);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 58:
      case 59:
      case 60:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 60:
          jj_consume_token(60);
          break;
        case 59:
          jj_consume_token(59);
          break;
        case 58:
          jj_consume_token(58);
          break;
        default:
          jj_la1[39] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[40] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        ;
        break;
      default:
        jj_la1[41] = jj_gen;
        break label_17;
      }
    }
    jj_consume_token(RB);
  }

  final public void institution() throws ParseException {
    jj_consume_token(INSTITUTION);
    jj_consume_token(57);
    jj_consume_token(LB);
    label_18:
    while (true) {
      jj_consume_token(WORD);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 58:
      case 59:
      case 60:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 60:
          jj_consume_token(60);
          break;
        case 59:
          jj_consume_token(59);
          break;
        case 58:
          jj_consume_token(58);
          break;
        default:
          jj_la1[42] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[43] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        ;
        break;
      default:
        jj_la1[44] = jj_gen;
        break label_18;
      }
    }
    jj_consume_token(RB);
  }

  final public void art() throws ParseException {
    label_19:
    while (true) {
      jj_consume_token(60);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AUTHOR:
        author();
        break;
      case TITLE:
        title();
        break;
      case JOURNAL:
        journal();
        break;
      case YEAR:
        year();
        break;
      case VOLUME:
        volume();
        break;
      case NUMBER:
        number();
        break;
      case PAGES:
        pages();
        break;
      case MONTH:
        month();
        break;
      case DOI:
        doi();
        break;
      case NOTE:
        note();
        break;
      default:
        jj_la1[45] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        ;
        break;
      default:
        jj_la1[46] = jj_gen;
        break label_19;
      }
    }
  }

  final public void book() throws ParseException {
    label_20:
    while (true) {
      jj_consume_token(60);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AUTHOR:
        author();
        break;
      case EDITOR:
        editor();
        break;
      case TITLE:
        title();
        break;
      case PUBLISHER:
        publisher();
        break;
      case YEAR:
        year();
        break;
      case VOLUME:
        volume();
        break;
      case NUMBER:
        number();
        break;
      case SERIES:
        series();
        break;
      case ADDRESS:
        address();
        break;
      case EDITION:
        edition();
        break;
      case MONTH:
        month();
        break;
      case NOTE:
        note();
        break;
      case KEY:
        key();
        break;
      case URL:
        url();
        break;
      default:
        jj_la1[47] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        ;
        break;
      default:
        jj_la1[48] = jj_gen;
        break label_20;
      }
    }
  }

  final public void booklet() throws ParseException {
    label_21:
    while (true) {
      jj_consume_token(60);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TITLE:
        title();
        break;
      case AUTHOR:
        author();
        break;
      case HOWPUBLISHED:
        howpublished();
        break;
      case ADDRESS:
        address();
        break;
      case MONTH:
        month();
        break;
      case YEAR:
        year();
        break;
      case NOTE:
        note();
        break;
      case KEY:
        key();
        break;
      default:
        jj_la1[49] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        ;
        break;
      default:
        jj_la1[50] = jj_gen;
        break label_21;
      }
    }
  }

  final public void conference() throws ParseException {
    label_22:
    while (true) {
      jj_consume_token(60);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AUTHOR:
        author();
        break;
      case TITLE:
        title();
        break;
      case BOOKTITLE:
        booktitle();
        break;
      case YEAR:
        year();
        break;
      case EDITOR:
        editor();
        break;
      case VOLUME:
        volume();
        break;
      case NUMBER:
        number();
        break;
      case SERIES:
        series();
        break;
      case PAGES:
        pages();
        break;
      case ADDRESS:
        address();
        break;
      case MONTH:
        month();
        break;
      case ORGANIZATION:
        organization();
        break;
      case PUBLISHER:
        publisher();
        break;
      case NOTE:
        note();
        break;
      case KEY:
        key();
        break;
      default:
        jj_la1[51] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        ;
        break;
      default:
        jj_la1[52] = jj_gen;
        break label_22;
      }
    }
  }

  final public void inbook() throws ParseException {
    label_23:
    while (true) {
      jj_consume_token(60);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AUTHOR:
        author();
        break;
      case EDITOR:
        editor();
        break;
      case TITLE:
        title();
        break;
      case CHAPTER:
        chapter();
        break;
      case PAGES:
        pages();
        break;
      case PUBLISHER:
        publisher();
        break;
      case YEAR:
        year();
        break;
      case VOLUME:
        volume();
        break;
      case NUMBER:
        number();
        break;
      case SERIES:
        series();
        break;
      case TYPE:
        type();
        break;
      case ADDRESS:
        address();
        break;
      case EDITION:
        edition();
        break;
      case MONTH:
        month();
        break;
      case NOTE:
        note();
        break;
      case KEY:
        key();
        break;
      default:
        jj_la1[53] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        ;
        break;
      default:
        jj_la1[54] = jj_gen;
        break label_23;
      }
    }
  }

  final public void incollection() throws ParseException {
    label_24:
    while (true) {
      jj_consume_token(60);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AUTHOR:
        author();
        break;
      case TITLE:
        title();
        break;
      case BOOKTITLE:
        booktitle();
        break;
      case PUBLISHER:
        publisher();
        break;
      case YEAR:
        year();
        break;
      case EDITOR:
        editor();
        break;
      case VOLUME:
        volume();
        break;
      case NUMBER:
        number();
        break;
      case SERIES:
        series();
        break;
      case TYPE:
        type();
        break;
      case CHAPTER:
        chapter();
        break;
      case PAGES:
        pages();
        break;
      case ADDRESS:
        address();
        break;
      case EDITION:
        edition();
        break;
      case MONTH:
        month();
        break;
      case NOTE:
        note();
        break;
      case KEY:
        key();
        break;
      default:
        jj_la1[55] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        ;
        break;
      default:
        jj_la1[56] = jj_gen;
        break label_24;
      }
    }
  }

  final public void inproceedings() throws ParseException {
    label_25:
    while (true) {
      jj_consume_token(60);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AUTHOR:
        author();
        break;
      case TITLE:
        title();
        break;
      case BOOKTITLE:
        booktitle();
        break;
      case YEAR:
        year();
        break;
      case EDITOR:
        editor();
        break;
      case VOLUME:
        volume();
        break;
      case NUMBER:
        number();
        break;
      case SERIES:
        series();
        break;
      case PAGES:
        pages();
        break;
      case ADDRESS:
        address();
        break;
      case MONTH:
        month();
        break;
      case ORGANIZATION:
        organization();
        break;
      case PUBLISHER:
        publisher();
        break;
      case NOTE:
        note();
        break;
      case KEY:
        key();
        break;
      default:
        jj_la1[57] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        ;
        break;
      default:
        jj_la1[58] = jj_gen;
        break label_25;
      }
    }
  }

  final public void manual() throws ParseException {
    label_26:
    while (true) {
      jj_consume_token(60);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TITLE:
        title();
        break;
      case AUTHOR:
        author();
        break;
      case ORGANIZATION:
        organization();
        break;
      case ADDRESS:
        address();
        break;
      case EDITION:
        edition();
        break;
      case MONTH:
        month();
        break;
      case YEAR:
        year();
        break;
      case NOTE:
        note();
        break;
      case KEY:
        key();
        break;
      default:
        jj_la1[59] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        ;
        break;
      default:
        jj_la1[60] = jj_gen;
        break label_26;
      }
    }
  }

  final public void mastersthesis() throws ParseException {
    label_27:
    while (true) {
      jj_consume_token(60);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AUTHOR:
        author();
        break;
      case TITLE:
        title();
        break;
      case SCHOOL:
        school();
        break;
      case YEAR:
        year();
        break;
      case TYPE:
        type();
        break;
      case ADDRESS:
        address();
        break;
      case MONTH:
        month();
        break;
      case NOTE:
        note();
        break;
      case KEY:
        key();
        break;
      default:
        jj_la1[61] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        ;
        break;
      default:
        jj_la1[62] = jj_gen;
        break label_27;
      }
    }
  }

  final public void misc() throws ParseException {
    label_28:
    while (true) {
      jj_consume_token(60);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AUTHOR:
        author();
        break;
      case TITLE:
        title();
        break;
      case HOWPUBLISHED:
        howpublished();
        break;
      case MONTH:
        month();
        break;
      case YEAR:
        year();
        break;
      case NOTE:
        note();
        break;
      case KEY:
        key();
        break;
      default:
        jj_la1[63] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        ;
        break;
      default:
        jj_la1[64] = jj_gen;
        break label_28;
      }
    }
  }

  final public void phdthesis() throws ParseException {
    label_29:
    while (true) {
      jj_consume_token(60);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AUTHOR:
        author();
        break;
      case TITLE:
        title();
        break;
      case SCHOOL:
        school();
        break;
      case YEAR:
        year();
        break;
      case TYPE:
        type();
        break;
      case ADDRESS:
        address();
        break;
      case MONTH:
        month();
        break;
      case NOTE:
        note();
        break;
      case KEY:
        key();
        break;
      default:
        jj_la1[65] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        ;
        break;
      default:
        jj_la1[66] = jj_gen;
        break label_29;
      }
    }
  }

  final public void proceedings() throws ParseException {
    label_30:
    while (true) {
      jj_consume_token(60);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TITLE:
        title();
        break;
      case YEAR:
        year();
        break;
      case EDITOR:
        editor();
        break;
      case VOLUME:
        volume();
        break;
      case NUMBER:
        number();
        break;
      case SERIES:
        series();
        break;
      case ADDRESS:
        address();
        break;
      case MONTH:
        month();
        break;
      case PUBLISHER:
        publisher();
        break;
      case ORGANIZATION:
        organization();
        break;
      case NOTE:
        note();
        break;
      case KEY:
        key();
        break;
      default:
        jj_la1[67] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        ;
        break;
      default:
        jj_la1[68] = jj_gen;
        break label_30;
      }
    }
  }

  final public void techreport() throws ParseException {
    label_31:
    while (true) {
      jj_consume_token(60);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AUTHOR:
        author();
        break;
      case TITLE:
        title();
        break;
      case INSTITUTION:
        institution();
        break;
      case YEAR:
        year();
        break;
      case TYPE:
        type();
        break;
      case NUMBER:
        number();
        break;
      case ADDRESS:
        address();
        break;
      case MONTH:
        month();
        break;
      case NOTE:
        note();
        break;
      case KEY:
        key();
        break;
      default:
        jj_la1[69] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        ;
        break;
      default:
        jj_la1[70] = jj_gen;
        break label_31;
      }
    }
  }

  final public void unpublished() throws ParseException {
    label_32:
    while (true) {
      jj_consume_token(60);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AUTHOR:
        author();
        break;
      case TITLE:
        title();
        break;
      case NOTE:
        note();
        break;
      case MONTH:
        month();
        break;
      case YEAR:
        year();
        break;
      case KEY:
        key();
        break;
      default:
        jj_la1[71] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        ;
        break;
      default:
        jj_la1[72] = jj_gen;
        break label_32;
      }
    }
  }

  /** Generated Token Manager. */
  public BibtextGrammarTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[73];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x40,0x1fff80,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x400000,0x0,0x0,0x400000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x400,0x400,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0xdfe00000,0x0,0xb7a00000,0x0,0x83a00000,0x0,0xbfa00000,0x0,0xbfa00000,0x0,0xbfa00000,0x0,0xbfa00000,0x0,0x83a00000,0x0,0x83a00000,0x0,0x83a00000,0x0,0x83a00000,0x0,0xb7800000,0x0,0x87a00000,0x0,0x83a00000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x1000000,0x0,0x2000,0x4000000,0x4000000,0x8004000,0x8004000,0x2000,0x38000000,0x38000000,0x2000,0x54000000,0x54000000,0x2000,0x2000,0xc000000,0xc000000,0x2000,0x18000000,0x18000000,0x2000,0x4000000,0x2000,0x20006000,0x20006000,0x10006000,0x10006000,0xc0006000,0xc0006000,0x2000,0x5400c000,0x5400c000,0x2000,0x18000000,0x18000000,0x2000,0x4000000,0x4000,0x2000,0x1c000000,0x1c000000,0x2000,0x1c000000,0x1c000000,0x2000,0x0,0x10000000,0x3f,0x10000000,0x49,0x10000000,0x50f,0x10000000,0x29f,0x10000000,0x39f,0x10000000,0x50f,0x10000000,0x419,0x10000000,0xa09,0x10000000,0x41,0x10000000,0xa09,0x10000000,0x40f,0x10000000,0x1209,0x10000000,0x1,0x10000000,};
   }

  /** Constructor with InputStream. */
  public BibtextGrammar(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public BibtextGrammar(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new BibtextGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 73; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 73; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public BibtextGrammar(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new BibtextGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 73; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 73; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public BibtextGrammar(BibtextGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 73; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(BibtextGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 73; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[64];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 73; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 64; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
