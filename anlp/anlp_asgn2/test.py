import spacy
from sklearn.preprocessing import OneHotEncoder
import numpy as np

spacy.tokens.token.Token.set_extension("bio_slot_label", default="O")
nlp=spacy.load("en_core_web_sm")

validation_sentence="I want to book a room on behalf of shaida sharon, from Jan the 12th."
train_sentence="I want to cancel my dinner reservation, the name is emelda cerezo."
doc_val=nlp(validation_sentence)
doc_train=nlp(train_sentence)

tagger = nlp.get_pipe("tagger")
length=len(list(tagger.labels))

#question1
for token in doc_val:
    if token.text=='shaida':
        shaida_token=token
for token in doc_train:
    if token.text=='reservation':
        kaytie_token=token
    print(token,token.dep_, token.tag_,token.pos_, token.ent_type_,token.head,token.head.dep_, token.head.pos_)
score=shaida_token.similarity(kaytie_token)
print('Score:',score)
# print(tagger.labels)
# print(length)
# print(POS)
# for token in doc:
#     if token.ent_type==0:
#         print(int_to_one_hot(12,13))
#     else:
#         print(int_to_one_hot(token.ent_type-380,13))
    # print(token,token.dep_, token.tag_,token.pos_,token.head,token.head.dep_, token.head.pos_)
    # print(token.pos,token.pos_)
    # print(int_to_one_hot(token.pos-84,18))
    # enc.fit(list(tagger.labels))
    # pass

# def int_to_one_hot(integer, num_classes):
#     """
#     Convert an integer to one-hot encoding.

#     Parameters:
#     - integer (int): The integer to be encoded.
#     - num_classes (int): The total number of classes.

#     Returns:
#     - one_hot_encoding (list): The one-hot encoded array.
#     """
#     one_hot_encoding = [0] * num_classes
#     print(integer,len(one_hot_encoding))
#     one_hot_encoding[integer] = 1
#     return one_hot_encoding