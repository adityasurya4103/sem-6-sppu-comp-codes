# Social Network Ads Data Analysis

This code performs exploratory data analysis and logistic regression modeling on the Social Network Ads dataset. The dataset contains information about users' age, estimated salary, and whether they purchased a product after seeing an ad.

## Code Overview

The code does the following:

1. Imports necessary libraries like pandas, numpy, matplotlib, seaborn, sklearn

2. Loads the dataset into a pandas dataframe

3. Prints information about the dataframe like shape, columns, statistical summary

4. Splits the data into training and test sets

5. Scales the features using StandardScaler

6. Fits a logistic regression model on the training set

7. Makes predictions on the test set

8. Calculates model evaluation metrics like confusion matrix, classification report

9. Visualizes the model performance on training and test set

## Running the Code

To run this code, you need to have Python installed along with the required libraries mentioned in the imports section.

The dataset 'Social_Network_Ads.csv' also needs to be downloaded into the same folder as this code file.

Then simply run this file in a Python interpreter or IDE like Spyder, Jupyter Notebook, etc.

The visualizations will be displayed inline when running in Jupyter Notebook. For other IDEs, plt.show() will need to be called explicitly to display the plots.

The output will contain various dataframe information, model evaluation metrics, and two visualization plots for training and test set model performance.

## Explanation

The code first loads and explores the dataset. The categorical target variable 'Purchased' and numerical features 'Age', 'EstimatedSalary' are extracted.

The data is split into 75% training and 25% test sets. The features are standardized using StandardScaler to normalize the range.

Logistic regression is fit on the training data. This model is suitable for binary classification problems.

The trained model is used to predict on the unseen test data. Model performance metrics are calculated by comparing predictions to true labels.

The decision boundary is visualized for both training and test set. This gives a sense of how well the model fits each dataset.

Overall the model achieves ~90% accuracy, showing decent performance on this binary classification task. The visualizations also indicate the logistic regression line separating the two classes fairly well.
