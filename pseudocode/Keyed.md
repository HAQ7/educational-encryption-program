method encrypt()
    encryptedText = ""
    initialize  textWithoutSpace = plainText without space
    initialize splittedPlainText = split(textWithoutSpace)
    for each i in splittedPlainText length
        tempArray = splittedPlainText{i} to char array
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
    initialize size = div
    if (plainText length % 4 != 0)
        size = div + 1
    initialize array with length of size
    initialize count = 0
    initialize numOfElements = 0
    while(count != textWithoutSpace length - (plainText length - (div * 4)))
        count = count + 4
        array{numOfElements++} = textWithoutSpace substring from count - 4 to count
    while(plainText substring from count length != 4)
        textWithoutSpace = concatenate textWithoutSpace and z
    array{numOfElements} = textWithoutSpace substring from count
    return array
    
