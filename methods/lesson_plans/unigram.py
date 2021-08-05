import random

text =  "Type your sentence in here"

#split text into a list
textList  = text.split()
#print("List of words: " +str(textList))

#create an empty dictionary which will contain the model
model ={}

for i in range(len(textList)):
    word  = textList[i]
    try:
        nextWord = textList[i+1]
        if word not in model.keys():
            model[word] = []
        model[word].append(nextWord)
    except IndexError:
        pass

#print("Model: " + str(model))

word = random.choice(list(model.keys()))
newSentence = word + " "
while word in model.keys() and word[len(word) - 1] != ".":
    #print(newSentence)
    word = random.choice(model[word])
    newSentence += word + " "
print("new sentence: \n" + newSentence)
