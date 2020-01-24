
import pandas as pd
import numpy as np
import pyfpgrowth

df = pd.read_csv('GroceryStoreDataSet.csv')
  
# initialize list of lists 
#data = [['Apple,Orange,Grape'], ['Apple,Orange'],['Mango,Pineapple,Papaya'],['Apple,Papaya'],['Grape,Orange,Pineapple']] 
  
# Create the pandas DataFrame 
#df = pd.DataFrame(data, columns = ['Transaction ID', 'Items']) 
Products_list1=df.head()

print(Products_list1)
#df.groupby('receipt').receipt.count()


Products_list = Products_list1.values.tolist()

#print(Products_list)

val=int(input("Enter the Minimum Support Count :"))

patterns = pyfpgrowth.find_frequent_patterns(Products_list,val)

print("Expected pattern \n\t",patterns)
'''
val=float(input("Enter the confidence value :"))
rules = pyfpgrowth.generate_association_rules(patterns, val)

print("Rules : ",rules)

print("Conclusion \nThe item with the maximum confidence is usually sold together")
'''

"""


import pandas as pd
import numpy as np
import pyfpgrowth

df = pd.read_csv('GroceryStoreDataSet.csv')

#df = df.drop('ID', axis=1)

#df = df.TRANSACTION

#df=df.tolist()

print("Data Set :",df)

df = [line.split(',') for line in df]

print("Individual Items : ",df)

val=int(input("Enter the Minimum Support Count :"))
patterns = pyfpgrowth.find_frequent_patterns(df, val)

print("Expected patterns :",patterns)

val=float(input("Enter the confidence value :"))
rules = pyfpgrowth.generate_association_rules(patterns, val)

print("Rules : ",rules)

print("Conclusion \nThe item with the maximum confidence is usually sold together")
"""
