import random

text =  open("tolstoy.txt").read()
#text = "I love to read my book and then to talk to my friend."

#split text into a list
textList  = text.split()
#print("List of words: " +str(textList))

#create an empty dictionary which will contain the model
model ={}
key = textList[0] + " " + textList[1]
value = textList[2]
for i in range(0, len(textList) - 2):
    word = textList[i] + " " + textList[i+1];
    if word not in model.keys():
        model[word] = []
    if i == len(textList) - 3:
        nextWord = textList[i+2]
    else:
        nextWord = textList[i+2] + " " + textList[i+3]
    model[word].append(nextWord)
print("Bigram Model + \n" + str(list(model)[:5]))
word = random.choice(list(model.keys()))
newSentence = word + " "
while word in model.keys() and word[len(word) - 1] != ".":
    #print(newSentence)
    word = random.choice(model[word])
    newSentence += word + " "
#print("new sentence: \n" + newSentence)
