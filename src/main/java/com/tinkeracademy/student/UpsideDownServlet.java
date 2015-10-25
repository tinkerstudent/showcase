package com.tinkeracademy.student;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;

/**
 * Form Handling Servlet
 * Most of the action for this sample is in webapp/guestbook.jsp, which displays the
 * {@link Greeting}'s. This servlet has one method
 * {@link #doPost(<#HttpServletRequest req#>, <#HttpServletResponse resp#>)} which takes the form
 * data and saves it.
 */
public class UpsideDownServlet extends HttpServlet {

  protected String user = null;

  /**
   * Array of all possible alphabet inputs
   */
  public static char[] alphabets = new char[] { 'a',      'b',    'c',    'd', 
                          'e',      'f',    'g',    'h', 
                          'i',      'j',    'k',    'l', 
                          'm',      'n',    'o',    'p', 
                          'q',      'r',    's',    't',
                            'u',      'v',    'w',    'x', 
                            'y',      'z',    
                            'A',      'B',    'C',    'D',
                            'E',      'F',    'G',    'H',
                            'I',      'J',    'K',    'L',
                            'M',      'N',    'O',    'P',
                            'Q',      'R',    'S',    'T',
                            'U',      'V',    'W',    'X',
                            'W',      'Z',
                            '0',      '1',    '2',    '3',    
                            '4',      '5',    '6',    '7',    
                            '8',      '9',      
                            ',',      '.',    '?',    '!',
                            '"',      '\'',   '`',
                            '(',      ')',    '[',    ']',
                            '{',      '}',    '<',    '>',
                            '&',      '_',    ' ', 
                          '\u0250',   'q',    '\u0254',   'p',
                                          '\u01DD',   '\u025F',   '\u0183',   '\u0265', 
                                          '\u1D09',   '\u027E', '\u029E',   '1',
                                          '\u026F',   'u',    'o',    'd',
                                          'b',      '\u0279', 's',    '\u0287',
                        'n',      '\u028C', '\u028D', 'x',
                        '\u028E',     'z',  
                        '\u2200',   'B',    '\u0186', 'D',
                        '\u018E',   '\u2132', '\u05E4',   'H',
                        'I',      '\u017F', 'K',    '\u02E5',
                        'W',      'N',    'O',    '\u0500',
                        'Q',      'R',    'S',    '\u2534',
                        '\u2229',   '\u039B', 'M',    'X',
                        '\u2144',   'Z',
                        '0',      '\u0196',   '\u1105', '\u0190',   
                        '\u3123',   '\u03DB',     '9',  '\u3125',   
                        '8',      '6',    
                        '\'',     '\u02D9', '\u00BF',   '\u00A1',
                        '\u201E',   ',',    ',',
                        ')',      '(',    ']',    '[',
                        '}',      '{',    '>',    '<',
                        '\u214B',   '\u203E', ' '
                            };
  
  public static char[] reverseAlphabets = new char[] {
                                          '\u0250',   'q',    '\u0254',   'p',
                                          '\u01DD',   '\u025F',   '\u0183',   '\u0265', 
                                          '\u1D09',   '\u027E', '\u029E',   '1',
                                          '\u026F',   'u',    'o',    'd',
                                          'b',      '\u0279', 's',    '\u0287',
                        'n',      '\u028C', '\u028D', 'x',
                        '\u028E',     'z',  
                        '\u2200',   'B',    '\u0186', 'D',
                        '\u018E',   '\u2132', '\u05E4',   'H',
                        'I',      '\u017F', 'K',    '\u02E5',
                        'W',      'N',    'O',    '\u0500',
                        'Q',      'R',    'S',    '\u2534',
                        '\u2229',   '\u039B', 'M',    'X',
                        '\u2144',   'Z',
                        '0',      '\u0196',   '\u1105', '\u0190',   
                        '\u3123',   '\u03DB',     '9',  '\u3125',   
                        '8',      '6',    
                        '\'',     '\u02D9', '\u00BF',   '\u00A1',
                        '\u201E',   ',',    ',',
                        ')',      '(',    ']',    '[',
                        '}',      '{',    '>',    '<',
                        '\u214B',   '\u203E', ' ',
                        'a',      'b',    'c',    'd', 
                        'e',      'f',    'g',    'h', 
                        'i',      'j',    'k',    'l', 
                        'm',      'n',    'o',    'p', 
                        'q',      'r',    's',    't',
                          'u',      'v',    'w',    'x', 
                          'y',      'z',    
                          'A',      'B',    'C',    'D',
                          'E',      'F',    'G',    'H',
                          'I',      'J',    'K',    'L',
                          'M',      'N',    'O',    'P',
                          'Q',      'R',    'S',    'T',
                          'U',      'V',    'W',    'X',
                          'W',      'Z',
                          '0',      '1',    '2',    '3',    
                          '4',      '5',    '6',    '7',    
                          '8',      '9',      
                          ',',      '.',    '?',    '!',
                          '"',      '\'',   '`',
                          '(',      ')',    '[',    ']',
                          '{',      '}',    '<',    '>',
                          '&',      '_',    ' '
                        };

  public void init(ServletConfig servletConfig) throws ServletException{
    this.user = servletConfig.getInitParameter("user");
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    req.setAttribute("user", user);
    RequestDispatcher rs = req.getRequestDispatcher("/WEB-INF/upsidedowntext.jsp");
    rs.forward(req,resp);
  }

  // Process the http POST of the form
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    String input = (String) req.getParameter("inputtext");
    String output = getReverse(input);
    req.setAttribute("user", user);
    req.setAttribute("input", input);
    req.setAttribute("output", output);
    RequestDispatcher rs = req.getRequestDispatcher("/WEB-INF/upsidedowntext.jsp");
    rs.forward(req,resp);
  }

  public static String getReverse(String input) {
    String output = "";
    for (int i = input.length() - 1; i >= 0; i--) {
      char in = input.charAt(i);
      int index = findCharInAlphabetsArray(in);
      char out = reverseAlphabets[index];
      output = output + out;
    }
    return output;
  }

  public static int findCharInAlphabetsArray(char in) {
    for (int i = 0; i < alphabets.length; i++) {
      if (alphabets[i] == in) {
        return i;
      }
    }
    System.out.println("cannot find char for " + in);
    return -1;
  }
}