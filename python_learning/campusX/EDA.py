import numpy as np
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

df = pd.read_csv('training_data/train.csv')
print(df.sample(10))

# Using countplot we can see the distribution of the survived column
# sns.countplot(df, x='Survived', palette='Set2', hue='Survived')
# plt.show()
# sns.countplot(df, x='Pclass', palette='Set2', hue='Pclass')
# plt.show()
#
# sns.countplot(df, x='Embarked', palette='Set2', hue='Embarked')
# plt.show()

# Pie Chart
# print(df['Sex'].value_counts())
# df['Sex'].value_counts().plot(kind='pie', autopct='%1.1f%%', subplots=True)
# plt.show()

# Histogram: It will tell us about the numerical data distribution
# plt.hist(df['Age'], bins=20)
# plt.show()

# Distplot: It will tell us about the numerical data distribution
# sns.distplot(df['Age'], bins=20)
# plt.show()

# Boxplot: This plot will help us to find the outliers, mean, median, and range of the numerical data
sns.boxplot(df, x = 'Age' )
plt.show()