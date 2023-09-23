    method encrypt() 
        encryptedText = ""
        alphabet = "abcdefghijklmnopqrstuvwxyz"
        keyIndex = 0
        
        for each i in the length of plainText 
            character = get character in plaintext at index i
            
            if character is a character 
                characterIndex = find(character)
                keywordIndex = find(get character in key at index keyIndex)
                newIndex = (characterIndex + keywordIndex) % 26
                encryptedCharacter = get character in alphabet at index newIndex
                set encryptedText = concatenate encryptedText and encryptedCharacter
                keyIndex = (keyIndex + 1) % the length of key
             else 
                encryptedText = concatenate encryptedText and encryptedCharacter
    
    
    method decrypt(cypheredText)
        plainText = ""
        alphabet = "abcdefghijklmnopqrstuvwxyz"
        keyIndex = 0
        
        for each i in the length of encryptedText 
            character = get character in encryptedText at index i
            
            if character is a character 
                characterIndex = find(character)
                keywordIndex = find(get character in key at index keyIndex)
                newIndex = (characterIndex - keywordIndex + 26) % 26
                decryptedCharacter = get character in alphabet at index newIndex
                set plainText = concatenate plainText and decryptedCharacter
                keyIndex = (keyIndex + 1) % lengthOf(key)
             else 
                plainText = concatenate plainText and character

    
    
    private method find(character) 
        alphabet = "abcdefghijklmnopqrstuvwxyz"
        return index of character in alphabet
    
