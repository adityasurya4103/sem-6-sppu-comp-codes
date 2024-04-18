# Boston Housing Data Analysis

## Overview

This code loads the Boston housing dataset, explores it, splits the data into training and test sets, trains a linear regression model to predict housing prices, evaluates the model performance, and provides visualizations.

## Instructions to run

To run this code, you need the following libraries installed:

- numpy
- pandas
- matplotlib
- sklearn

You also need the boston.csv dataset in the same folder as this code.

Simply run this Python file to execute the code from start to finish.

## Code explanation

The code first imports the necessary libraries:

- numpy and pandas for data manipulation
- matplotlib for visualization
- sklearn for machine learning

It then loads the Boston housing dataset into a pandas DataFrame and explores it by printing information, statistics, and a sample of rows.

The data is split into training and test sets using sklearn's train_test_split.

A linear regression model is trained on the training set and predictions are made on the test set.

The model is evaluated by calculating the Mean Squared Error and R^2 Score.

Visualizations are created before and after fitting the model to provide insights.

## Conclusion

The linear regression model achieves a decent performance on this dataset based on the MSE and R^2 values. The visualizations also show the model is able to fit the general trend in the data. This provides a simple example of training and evaluating a machine learning model for a regression problem.
