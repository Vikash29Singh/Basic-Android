"""
import csv
import numpy as np

with open("GroceryStoreDataSet.csv", 'r') as f:
    Grocery = list(csv.reader(f, delimiter=";"))

Grocery = np.array(Grocery[1:])
print(Grocery)
"""

import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
from apyori import apriori

dataset = pd.read_csv('GroceryStoreDataSet1.csv', header = None)
#print(dataset.head())


records = []
for i in range(0, 20):
    records.append([str(dataset.values[i,j]) for j in range(0, 4)])

association_rules=apriori(records, min_support=0.05,min_confidence=0.8, min_lift=2, min_length=2)
association_results = list(association_rules)
print(len(association_results))
for i in range(0,5):
    print('----------------------------------------------------')
    print(association_results[i])

print("=====================================")

for item in association_results:
    pair = item[0]
    items = [x for x in pair]
print("Rule: " + items[0] + "-->" + items[1])

print("Support: " + str(item[1]))


print("Confidence: " + str(item[2][0][2]))
print("Lift: " + str(item[2][0][3]))
print("=====================================")