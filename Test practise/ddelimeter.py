import pandas as pd
# Read a csv file to a dataframe with custom delimiter
usersDf =  pd.read_csv('users.csv', sep='__'  , engine='python')
print('Contents of Dataframe : ')
print(usersDf)

# Read a csv file to a dataframe with custom delimiter
usersDf =  pd.read_csv('users.csv', sep='__'  , engine='python')
 

#unique value per column
pd.value_counts(df.Account_Type)


##unique value per column
df = df.groupby('domain')['ID'].nunique()

print (df)


print('Contents of Dataframe : ')
print(usersDf)