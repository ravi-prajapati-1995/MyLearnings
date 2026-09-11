import numpy as np
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

df = pd.read_csv('training_data/tip.csv')
print(df.sample(10))

# Bi variant analysis using scatterplot
# sns.scatterplot(x = df['total_bill'], y = df['tip'])



# With this we can see male and female on graph in different color
# sns.scatterplot(x = df['total_bill'], y = df['tip'], hue=df['sex'])
# plt.show()

# With this we can see male and female on graph in different color, in addition we can see
# if customer is smoker or non smoker
# With this we have 4 parameters analysis total_bill, tip, sex, smoker/non-smoker
# sns.scatterplot(x = df['total_bill'], y = df['tip'], hue=df['sex'], style=df['smoker'])
# plt.show()

# With this we have 5 parameters analysis total_bill, tip, sex, smoker/non-smoker, size
sns.scatterplot(x = df['total_bill'], y = df['tip'], hue=df['sex'], style=df['smoker'], size=df['size'])
plt.show()