# Cipher Class

ABSTRACT CLASS Employee

  // Declarations
  PRIVATE name
  PRIVATE plainText
  PRIVATE cipheredText

  // Constructor
  PUBLIC PROCEDURE NEW(givenName, givenPlainText)
    name = givenName
    plainText = givenPlainText
  ENDPROCEDURE

  // Functions
  ABSTRACT FUNCTION encrypt(text)

  // Getters
  FUNCTION getName()
    RETURN name
  ENDFUNCTION

  FUNCTION getPlainText()
    RETURN plainText
  ENDFUNCTION
  
  FUNCTION getCipheredText()
    RETURN cipheredText
  ENDFUNCTION

ENDCLASS


  