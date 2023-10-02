method encrypt()
    encryptedText = ""
    initialize  textWithoutSpace = plainText without space
    while (textWithoutSpace length % 4 != 0)
        textWithoutSpace = concatenate textWithoutSpace and z
    initialize splittedPlainText = split(textWithoutSpace)
    for each i in splittedPlainText length
        initialize tempArray = splittedPlainText{i} to char array
        initialize j = 0
        while (j != 2)
            char temp = tempArray{key{j} - 1}
            tempArray{key{j} - 1} = tempArray{j}
            tempArray{j} = temp
            j = j + 1
        splittedPlainText{i} = String(tempArray{0}) + String(tempArray{1}) + String(tempArray{2}) + String(tempArray{3})
    for each i in splittedPlainText length
        encryptedText = concatenate encryptedText and splittedPlainText{i}

method split(textWithoutSpace)
    initialize div = textWithoutSpace length / 4
    initialize array with length of div
    initialize count = 0
    initialize numOfElements = 0
    while(count < textWithoutSpace length)
        count = count + 4
        array{numOfElements++} = textWithoutSpace substring from count - 4 to count
    return array
    
