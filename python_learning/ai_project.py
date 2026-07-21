# In pandas to get information about the columns we have df.info() which will give information about the columns
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score
from mlxtend.plotting import plot_decision_regions

df = pd.read_csv("placement.csv")
print(df)
df.info()

# df.iloc[row_position, column_position] : df.iloc is a property in the Python Pandas library used for purely
# integer-location based indexing to select specific rows and columns from a DataFrame by their numerical position (starting from 0).
# The name stands for "integer location". Unlike df.loc (which selects data using text names or labels), df.iloc only
# cares about the numerical position of your data, completely ignoring any text headers or index names.

df = df.iloc[:, 1:]
print(df)
df.info()

# matplotlib: Matplotlib is the most popular, foundational data visualization library in Python.
# It is used to create static, animated, and interactive graphs, charts, and plots
plt.scatter(df['cgpa'], df['iq'], c=df['placement'])


print(df.shape)
x = df.iloc[:, 0:2]
y = df.iloc[:,-1]

print("----------------------------------")
# Here we will provide the independent variables and dependent variables and size of test data we want to keep to train
# and percentage of data that we want to keep to test our model here 0.1 means we want 10% data to test model
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.1)
print(x_train)
print(x_test)
print(y_train)
print(y_test)

# fit(): Analyzes the data to calculate the mathematical state (like finding the min/max or the mean/standard deviation).
# It stores these as internal instance variables.
# transform(): Applies the mathematical formula to the data using those stored variables and returns a new dataset.

scalar = StandardScaler()
x_train = scalar.fit_transform(x_train)
print(x_train)

# Because we did fit in x_train, we only need to do transform for the x_test
x_test = scalar.transform(x_test)

clf = LogisticRegression()
clf_fit = clf.fit(x_train, y_train)
print(clf_fit)

y_predict = clf.predict(x_test)
print(y_predict)
print(y_test)

# To get accuracy score how our modal is accurate
score = accuracy_score(y_test, y_predict)
print(score)

regions = plot_decision_regions(x_train, y_train.values, clf=clf, legend=2)
plt.show()

