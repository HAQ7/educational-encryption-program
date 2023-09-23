method decrypt()
    plainText = encryptedText without space
    createFreqMatrixOfText()
    sortFreqMatrixOfText()
    plainText replace all freqMatrixOfText row 0 col 0 to e
    plainText replace all freqMatrixOfText row 1 col 0 to t
    plainText replace all freqMatrixOfText row 2 col 0 to a
    plainText replace all freqMatrixOfText row 3 col 0 to o
    


method createFreqMatrixOfText()
   uniqueCharacters = ""
   for each character in encryptedText
        if(uniqueCharacters does not contain character)
            uniqueCharacters = concatenate uniqueCharacters and character
    set freqMatrixOfText's number of row to uniqueCharacters'length and number of col to 2
    for each i in uniqueCharacters's length
        freqMatrixOfText row i and col 0 = get character in uniqueCharacters at index i
        initialize count = 0
        for each j in encryptedText's length
            if character at index i in uniqueCharacters == character at index j in encryptedText
                count = count + 1
        freqMatrixOfText row i and col 1 = freqMatrixOfText row i and col 1 + count


method sortFreqMatrixOfText()
    initialize temp
    for each i in freqMatrixOfText's length - 1
        for j = i + 1 in freqMatrixOfText's length
            if (freqMatrixOfText row j col 1 > freqMatrixOfText row i col 1)
                temp = freqMatrixOfText row i
                freqMatrixOfText row i = freqMatrixOfText row j
                freqMatrixOfText row j = temp