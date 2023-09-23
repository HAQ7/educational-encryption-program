    method encrypt() 
        set encryptedText = ""
        
        for each i in the length of plainText
            character = get character in plainText at i
            encryptedCharacter = moveCharacter(character, key, true)
            set encryptedText = concatenate encryptedText and encryptedCharacter
        
    
    
    method decrypt() 
        plainText = ""
        
        for each i in the length of encryptedText 
            character = get character in encryptedText at i
            decryptedCharacter = moveCharacter(character, key, false)
            set plainText = concatenate plainText and decryptedCharacter
        
        
    
    
    method moveCharacter(character, key, check)
        alphabet = "abcdefghijklmnopqrstuvwxyz"
        if check is true 
            if character is whitespace
                return whitespace
            index = get index in alphabet at character
            newIndex = (index + key) % 26     
            return character in alphabet at newIndex
         else 
            if character is whitespace
                return whitespace
            index = get index in alphabet at character
            newIndex = (index - key)
            
            if newIndex < 0 
                newIndex = newIndex + 26
            
            return character in alphabet at newIndex

    
    

    
    

