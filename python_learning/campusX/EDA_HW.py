import pandas as pd
import seaborn as sns
from matplotlib import pyplot as plt

df = pd.read_csv('training_data/movies_updated.csv')

print(df.sample(5))
print(df.info())

# sns.countplot(df, y='score', palette='Set2')
# plt.show()
#
# sns.ecdfplot(data=df, x="score", color="crimson", linewidth=2)
# plt.show()

# Set a clean theme
sns.set_theme(style="whitegrid")


# fill=True creates a beautiful shaded area under the curve
# sns.kdeplot(data=df, x="score", fill=True, color="#2b5c8f", linewidth=2.5)
# plt.show()

# Getting all the movies which have rating more than 8.5
highly_rated_movies = df[(df['score'] > 5) & (df['score'] <= 8.5)]
print(highly_rated_movies.info())
sns.countplot(highly_rated_movies, x='score', palette='Set2', hue='score')
plt.show()