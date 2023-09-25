method encrypt()
  copyText = ""
  encryptedText = ""
  count = 0
  countR = 0
  CountC = 0

  for every two steps i in the (length of plainText - 1)
    if i + 1 < length of plainText
      if character in copyText at index i == character in copyText at index i + 1
        concatenate (plainText character at index i) + (letter x) + (plainText character at index i + 1) to copyText
  
  if length of plainText % 2 != 0 then concatenate (copyText) + (plainText last letter)

  if length of copyText % 2 != 0
    concatenate (copyText) + (letter z)


  while count is less than the length of copyText
    firstLetter = character in copyText at index count
    firstR = 0
    FirstC = 0

    secondLetter = character in copyText at index (count + 1)
    secondR = 0
    secondC = 0

    while true
      if length of the array key at index [countR][countC] == 2
        if character in the array key at index [countR][countC] at index 0 or index 1 == firstLetter
          firstR = countR
          firstC = countC
          countR = 0
          countC = 0
          break from the loop
        
      else if character in the array key at index [countR][countC] == firstLetter
        firstR = countR
          firstC = countC
          countR = 0
          countC = 0
          break from the loop

      else if countC == (length of array key - 1)
        add one to countR
        countC = 0
      
      else add one to countC
    
    while true
      if length of the array key at index [countR][countC] == 2
        if character in the array key at index [countR][countC] at index 0 == secondLetter
          secondR = countR
          secondC = countC
          countR = 0
          countC = 0
          break from the loop
        
      else if character in the array key at index [countR][countC] == secondLetter
         secondR = countR
         secondC = countC
         countR = 0
         countC = 0
         break from the loop

      else if countC == (length of array key - 1)
          add one to countR
          countC = 0
        
      else add one to countC

    
    if firstR == Second R 
      temp1 = firstC
      temp2 = secondC

      if temp1 == (length of array key - 1) then temp1 = 0
      else add one to temp1

      if temp2 == (length of array key - 1) then temp2 = 0
      else add one to temp2

      concatenate (encryptedText) + (character in the array key at index [firstR][temp1]) + (character in the array key at index [secondR][temp2])
    
    else if firstC == Second C 
      temp1 = firstR
      temp2 = secondR

      if temp1 == (length of array key - 1) then temp1 = 0
      else add one to temp1

      if temp2 == (length of array key - 1) then temp2 = 0
      else add one to temp2

      concatenate (encryptedText) + (character in the array key at index [temp1][firstC]) + (character in the array key at index [temp2][secondC])
    
    else
      concatenate (encryptedText) + (character in the array key at index [firstR][secondC]) + (character in the array key at index [secondR][firstC])
    
    add 2 to count

end method encrypt


method decrypt()
  copyText = ""
  count = 0
  countR = 0
  CountC = 0

  while count is less than the length of encryptedText
    firstLetter = character in encryptedText at index count
    firstR = 0
    FirstC = 0

    secondLetter = character in encryptedText at index (count + 1)
    secondR = 0
    secondC = 0

    while true
      if character in the array key at index [countR][countC] == firstLetter
        firstR = countR
        firstC = countC
        countR = 0
        countC = 0
        break from the loop

      else if countC == (length of array key - 1)
        add one to countR
        countC = 0
      
      else add one to countC
    
    while true
      if character in the array key at index [countR][countC] == secondLetter
        secondR = countR
        secondC = countC
        countR = 0
        countC = 0
        break from the loop

      else if countC == (length of array key - 1)
        add one to countR
        countC = 0
      
      else add one to countC

    
    if firstR == Second R 
      temp1 = firstC
      temp2 = secondC

      if temp1 == 0 then temp1 = 4
      else subtract one to temp1

      if temp2 == 0 then temp2 = 4
      else subtract one to temp2

      concatenate (copyText) + (character in the array key at index [firstR][temp1]) + (character in the array key at index [secondR][temp2])
    
    else if firstC == Second C 
      temp1 = firstR
      temp2 = secondR

      if temp1 == 0 then temp1 = 4
      else subtract one to temp1

      if temp2 == 0 then temp2 = 4
      else subtract one to temp2

      concatenate (copyText) + (character in the array key at index [temp1][firstC]) + (character in the array key at index [temp2][secondC])
    
    else
      concatenate (copyText) + (character in the array key at index [firstR][secondC]) + (character in the array key at index [secondR][firstC])
    
    add 2 to count

  plainText = copyText
end method encrypt