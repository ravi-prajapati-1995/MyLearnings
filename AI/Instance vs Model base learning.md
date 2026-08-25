As an human we can learn in two ways:
1. Memorizing: We can memorize thing to learn, like chemistry formula
2. Generalizing: By going into the concept depth to understand things, like Physics


Instance Base Learning: This is the learning like memorizing, we give the data i.e IQ and CGPA and placement to the model
 Model will keep the data with him, when new query came it will check the nearest point of that data, i.e KNN(k nearest neighbours)
 If it has neighbours with Yes it will give result in Yes, otherwise no

Modal Base learning: In this Learning like generalizing, when we give data points to modal, This algo will create a methamatical
formula between the dataset which are placed and which not, once it generate the formula, when we give it new data point
using generated formula it will decide if person will be placed or not
example: Linear Regression, Logistic Regression, Decision Tree


Challenges in Machine Learning:
1. Data Collection: ML is purely based on the the data, if we don't have data our model will not perform well and will not
    give the correct output, we can get data via API and webscrapper
2. Insufficient Data/ Labelled Data: If we have two algo A and B, alog A is trained on 100 data record and Algo B trained on 10000000 data
    In above case Algo B will be preferred as it is trained on huge data, so we need huge amount of data so that our model perform well
3. Non representative Data: If we don't collect the data from all the resources in that case model will be biased.
    i.e If we do a survey in india who will win the Cricket world cup, then result will be india, Instead survey should be
    each country that is participating in the world cup, this problem is known as Sampling Noise.
    Sampling Biase: We did the survey on the 200 fans accross the world, but still result india, and as indian lives around
    the world so they will say india only

4. Poor Quality Data
5. Irrelevant Features; Garbage In , Garbage Out
6. OverFitting: Overfitting occurs when a model learns the training data too well, including its random noise,
    outliers, and irrelevant fluctuations. It will not give the good output on the new data
7. Underfitting: Underfitting occurs when a model is too simplistic to capture the underlying structure of the data.
    The model fails to learn the actual relationships between the inputs and outputs. It will not give good output on
    training data also on new data
8. Software integration
9. Offline Learning / Deployment
10. Cost Involved
