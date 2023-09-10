# CipherList Class

CLASS CipherList

  // Declarations
  PRIVATE ARRAY arrCipher[]
  PRIVATE numOfCiphers

  // Constructor
  PUBLIC PROCEDURE NEW(size)
    arrCipher = NEW Cipher[size]
    numOfCiphers = 0

  // Functions
  PUBLIC FUNCTION findCipher(cipher:ByRef)
    FOR I = 0 to (numOfCiphers - 1)
      IF arrCipher[I].getName().EQUALS(cipher.getName()) == TRUE
        RETURN I
    
    RETURN -1
  ENDFUNCTION

  PUBLIC PROCEDURE add(cipher:ByRef)
    IF numOfCiphers == arrCipher.LENGTH() THEN
      PRINT("The List is full!")

    ELSEIF findCipher(cipher) != -1 THEN
      PRINT("Already added!")
    
    ELSE
      arrCipher[numOfCiphers] = cipher
      numOfCipher = numOfcipher + 1 
  ENDPROCEDURE

  PUBLIC PROCEDURE remove(index)
    FOR I = index to (numOfCiphers - 2)
      p[I] = p[I+1]
    
    numOfCiphers = numOfCiphers - 1
    arrCipher[numOfCiphers] = NULL
  ENDPROCEDURE

  PUBLIC PROCEDURE display()
    FOR I = 0 to (numOfCiphers - 1)
      PRINT((I+1) + ": " + arrCipher[I].getName())
    
    PRINT("--------------------------------------------------")
  ENDPROCEDURE

  PUBLIC FUNCTION getCipher(index)
    RETURN arrCipher[index]
  ENDFUNCTION

ENDCLASS
