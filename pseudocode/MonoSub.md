    method encrypt() 
        set encryptedText = ""
        
        for each i in the length of plainText
            letter = get letter in plainText at i
            encryptedLetter = moveLetter(letter, key, true)
            set encryptedText = concatenate encryptedText and encryptedLetter
        
    
    
    method decrypt() 
        plainText = ""
        
        for each i in the length of encryptedText 
            letter = get letter in encryptedText at i
            decryptedLetter = moveLetter(letter, key, false)
            set plainText = concatenate plainText and decryptedLetter
        
        
    
    
    method moveLetter(letter, key, check)
        alphabet = "abcdefghijklmnopqrstuvwxyz"
        if check is true 
            if letter is whitespace
                return whitespace
            index = get index in alphabet at letter
            newIndex = (index + key) % 26     
            return letter in alphabet at newIndex
         else 
            if letter is whitespace
                return whitespace
            index = get index in alphabet at letter
            newIndex = (index - key)
            
            if newIndex < 0 
                newIndex = newIndex + 26
            
            return letter in alphabet at newIndex

    
    

    
    

