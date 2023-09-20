    method encrypt() 
        encryptedText = ""
        alphabet = "abcdefghijklmnopqrstuvwxyz"
        keyIndex = 0
        
        for each i in the length of plainText 
            Letter = get Letter in plaintext at index i
            
            if Letter is a letter 
                letterIndex = find(Letter)
                keywordIndex = find(get Letter in key at index keyIndex)
                newIndex = (letterIndex + keywordIndex) % 26
                encryptedLetter = get Letter in alphabet at index newIndex
                set encryptedText = concatenate encryptedText and encryptedLetter
                keyIndex = (keyIndex + 1) % the length of key
             else 
                encryptedText = concatenate encryptedText and encryptedLetter
    
    
    method decrypt(cypheredText)
        plainText = ""
        alphabet = "abcdefghijklmnopqrstuvwxyz"
        keyIndex = 0
        
        for each i in the length of encryptedText 
            Letter = get Letter in encryptedText at index i
            
            if Letter is a letter 
                letterIndex = find(Letter)
                keywordIndex = find(get Letter in key at index keyIndex)
                newIndex = (letterIndex - keywordIndex + 26) % 26
                decryptedLetter = get Letter in alphabet at index newIndex
                set plainText = concatenate plainText and decryptedLetter
                keyIndex = (keyIndex + 1) % lengthOf(key)
             else 
                plainText = concatenate plainText and Letter

    
    
    private method find(letter) 
        alphabet = "abcdefghijklmnopqrstuvwxyz"
        return index of letter in alphabet
    
