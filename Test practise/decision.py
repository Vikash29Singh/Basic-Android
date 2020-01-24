import pandas as pd
# Read a csv file to a dataframe with custom delimiter
usersDf =  pd.read_csv('users.csv', sep='__'  , engine='python')
print('Contents of Dataframe : ')
print(usersDf)

# Read a csv file to a dataframe with custom delimiter
usersDf =  pd.read_csv('users.csv', sep='__'  , engine='python')
 
print('Contents of Dataframe : ')
print(usersDf)