# -*- coding: utf-8 -*-
"""
Created on Mon Nov 25 14:25:31 2019

@author: idont
"""

import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
from apyori import apriori


dataset = pd.read_csv('Market_Basket_Optimisation.csv', header = None)
print(dataset.head())

records = []
for i in range(0, 7501):
    records.append([str(dataset.values[i,j]) for j in range(0, 20)])


association_rules=apriori(records, min_support=0.0045,min_confidence=0.2, min_lift=3, min_length=2)
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