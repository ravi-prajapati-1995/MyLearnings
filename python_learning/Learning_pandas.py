# In pandas to get information about the columns we have df.info() which will give information about the columns
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

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
plt.show()

print(df.shape)



